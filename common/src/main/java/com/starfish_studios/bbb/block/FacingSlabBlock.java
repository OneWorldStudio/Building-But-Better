package com.starfish_studios.bbb.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class FacingSlabBlock extends SlabBlock implements SimpleWaterloggedBlock {
    public static final EnumProperty<SlabType> TYPE = BlockStateProperties.SLAB_TYPE;
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;


    public static final VoxelShape SLAB_BOTTOM_UP = Block.box(0, 0, 0, 16, 8, 16);
    public static final VoxelShape SLAB_BOTTOM_DOWN = Block.box(0, 8, 0, 16, 16, 16);
    public static final VoxelShape SLAB_BOTTOM_NORTH = Block.box(0, 0, 8, 16, 16, 16);
    public static final VoxelShape SLAB_BOTTOM_EAST = Block.box(0, 0, 0, 8, 16, 16);
    public static final VoxelShape SLAB_BOTTOM_SOUTH = Block.box(0, 0, 0, 16, 16, 8);
    public static final VoxelShape SLAB_BOTTOM_WEST = Block.box(8, 0, 0, 16, 16, 16);

    public static final VoxelShape SLAB_TOP_UP = Block.box(0, 8, 0, 16, 16, 16);
    public static final VoxelShape SLAB_TOP_DOWN = Block.box(0, 0, 0, 16, 8, 16);
    public static final VoxelShape SLAB_TOP_NORTH = Block.box(0, 0, 8, 16, 16, 16);
    public static final VoxelShape SLAB_TOP_EAST = Block.box(8, 0, 0, 16, 16, 16);
    public static final VoxelShape SLAB_TOP_SOUTH = Block.box(0, 0, 0, 16, 16, 8);
    public static final VoxelShape SLAB_TOP_WEST = Block.box(0, 0, 0, 8, 16, 16);

    public static final VoxelShape SLAB_DOUBLE = Block.box(0, 0, 0, 16, 16, 16);


    public FacingSlabBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(TYPE, SlabType.BOTTOM)
                .setValue(FACING, Direction.UP)
                .setValue(WATERLOGGED, false));
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return switch (state.getValue(TYPE)) {
            case BOTTOM -> switch (state.getValue(FACING)) {
                case NORTH -> SLAB_BOTTOM_NORTH;
                case SOUTH -> SLAB_BOTTOM_SOUTH;
                case EAST -> SLAB_BOTTOM_EAST;
                case WEST -> SLAB_BOTTOM_WEST;
                case UP -> SLAB_BOTTOM_UP;
                case DOWN -> SLAB_BOTTOM_DOWN;
            };
            case TOP -> switch (state.getValue(FACING)) {
                case NORTH -> SLAB_TOP_NORTH;
                case SOUTH -> SLAB_TOP_SOUTH;
                case EAST -> SLAB_TOP_EAST;
                case WEST -> SLAB_TOP_WEST;
                case UP -> SLAB_TOP_UP;
                case DOWN -> SLAB_TOP_DOWN;
            };
            case DOUBLE -> SLAB_DOUBLE;
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getClickedFace();
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());

        if (state.is(this) && state.getValue(TYPE) != SlabType.DOUBLE) {
            return state.setValue(TYPE, SlabType.DOUBLE).setValue(WATERLOGGED, false);
        } else {
            FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
            return this.defaultBlockState().setValue(FACING, direction).setValue(TYPE, SlabType.BOTTOM).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        }
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        if (state.getValue(FACING) != context.getClickedFace()) return false;
        return context.getItemInHand().is(this.asItem()) && state.getValue(TYPE) != SlabType.DOUBLE || super.canBeReplaced(state, context);
    }

    @Override
    public @NotNull FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean placeLiquid(@NotNull LevelAccessor level, @NotNull BlockPos blockPos, BlockState state, @NotNull FluidState fluidState) {
        return state.getValue(TYPE) != SlabType.DOUBLE;
    }

    @Override
    public boolean canPlaceLiquid(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, BlockState state, @NotNull Fluid fluid) {
        return state.getValue(TYPE) != SlabType.DOUBLE;
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, @NotNull Direction direction, @NotNull BlockState state2, @NotNull LevelAccessor level, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, direction, state2, level, blockPos, blockPos2);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE, FACING, WATERLOGGED);
    }
}
