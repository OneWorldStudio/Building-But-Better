package com.starfish_studios.bbb.block;

import com.starfish_studios.bbb.block.properties.ColumnType;
import com.starfish_studios.bbb.block.properties.BBBBlockStateProperties;
import com.starfish_studios.bbb.registry.BBBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.*;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.Map;

public class ColumnBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty LAYER_1_AABB = BBBBlockStateProperties.LAYER_1;
    public static final BooleanProperty LAYER_2_AABB = BBBBlockStateProperties.LAYER_2;
    public static final BooleanProperty LAYER_3_AABB = BBBBlockStateProperties.LAYER_3;
    public static final BooleanProperty LAYER_4_AABB = BBBBlockStateProperties.LAYER_4;

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    public static final EnumProperty<ColumnType> TYPE = BBBBlockStateProperties.COLUMN_TYPE;

    private static final Map<Direction.Axis, VoxelShape> CENTER_AABB = new EnumMap<>(Direction.Axis.class);
    private static final Map<Direction.Axis, VoxelShape[]> LAYER_AABB = new EnumMap<>(Direction.Axis.class);

    static {
        CENTER_AABB.put(Direction.Axis.Y, Block.box(2, 0, 2, 14, 16, 14));
        CENTER_AABB.put(Direction.Axis.X, Block.box(0, 2, 2, 16, 14, 14));
        CENTER_AABB.put(Direction.Axis.Z, Block.box(2, 2, 0, 14, 14, 16));

        LAYER_AABB.put(Direction.Axis.Y, new VoxelShape[] {
                Block.box(0, 0, 0, 16, 4, 16),
                Block.box(0, 4, 0, 16, 8, 16),
                Block.box(0, 8, 0, 16, 12, 16),
                Block.box(0, 12, 0, 16, 16, 16),
        });
        LAYER_AABB.put(Direction.Axis.X, new VoxelShape[] {
                Block.box(0, 0, 0, 4, 16, 16),
                Block.box(4, 0, 0, 8, 16, 16),
                Block.box(8, 0, 0, 12, 16, 16),
                Block.box(12, 0, 0, 16, 16, 16),
        });
        LAYER_AABB.put(Direction.Axis.Z, new VoxelShape[] {
                Block.box(0, 0, 12, 16, 16, 16),
                Block.box(0, 0, 8, 16, 16, 12),
                Block.box(0, 0, 4, 16, 16, 8),
                Block.box(0, 0, 0, 16, 16, 4),
        });
    }

    public ColumnBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.defaultBlockState()
                        .setValue(AXIS, Direction.Axis.Y)
                        .setValue(TYPE, ColumnType.NONE)
                        .setValue(LAYER_1_AABB, true)
                        .setValue(LAYER_2_AABB, true)
                        .setValue(LAYER_3_AABB, true)
                        .setValue(LAYER_4_AABB, true)
                        .setValue(WATERLOGGED, false)
        );
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        BlockState state = defaultBlockState()
                .setValue(AXIS, context.getClickedFace().getAxis())
                .setValue(TYPE, ColumnType.NONE)
                .setValue(LAYER_1_AABB, true)
                .setValue(LAYER_2_AABB, true)
                .setValue(LAYER_3_AABB, true)
                .setValue(LAYER_4_AABB, true)
                .setValue(WATERLOGGED, fluidState.is(Fluids.WATER));
        return removeWaterIfFull(state);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Direction.Axis axis = state.getValue(AXIS);
        VoxelShape shape = CENTER_AABB.get(axis);
        VoxelShape[] layers = LAYER_AABB.get(axis);

        if (state.getValue(LAYER_1_AABB)) shape = Shapes.or(shape, layers[0]);
        if (state.getValue(LAYER_2_AABB)) shape = Shapes.or(shape, layers[1]);
        if (state.getValue(LAYER_3_AABB)) shape = Shapes.or(shape, layers[2]);
        if (state.getValue(LAYER_4_AABB)) shape = Shapes.or(shape, layers[3]);

        return shape;
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull BlockState updateShape(BlockState state, Direction direction, @NotNull BlockState neighbor, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        if (direction.getAxis() == state.getValue(AXIS)) {
            Direction.Axis axis = state.getValue(AXIS);
            BlockState above = level.getBlockState(pos.relative(Direction.fromAxisAndDirection(axis, Direction.AxisDirection.POSITIVE)));
            BlockState below = level.getBlockState(pos.relative(Direction.fromAxisAndDirection(axis, Direction.AxisDirection.NEGATIVE)));
            state = state.setValue(TYPE, determineColumnType(state, above, below));
        }

        state = removeWaterIfFull(state);
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return state;
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        if (!player.getItemInHand(hand).is(BBBTags.BBBItemTags.HAMMERS)) return InteractionResult.PASS;

        Direction.Axis axis = state.getValue(AXIS);
        double hitFraction = hit.getLocation().get(axis) - pos.get(axis);
        if (axis == Direction.Axis.Z) hitFraction = 1 - hitFraction;

        int layerIndex = Math.min(3, (int)(hitFraction * 4));
        BooleanProperty[] layers = {LAYER_1_AABB, LAYER_2_AABB, LAYER_3_AABB, LAYER_4_AABB};
        state = state.cycle(layers[layerIndex]);
        state = removeWaterIfFull(state);

        level.setBlock(pos, state, 3);
        level.playSound(player, pos, state.getSoundType().getPlaceSound(), player.getSoundSource(), 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean canPlaceLiquid(@NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Fluid fluid) {
        return !isFull(state) && SimpleWaterloggedBlock.super.canPlaceLiquid(level, pos, state, fluid);
    }

    @Override
    public boolean placeLiquid(@NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull FluidState fluidState) {
        return !isFull(state) && SimpleWaterloggedBlock.super.placeLiquid(level, pos, state, fluidState);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED)
                ? Fluids.WATER.getSource(false)
                : super.getFluidState(state);
    }

    private static boolean isFull(BlockState state) {
        return state.getValue(LAYER_1_AABB)
                && state.getValue(LAYER_2_AABB)
                && state.getValue(LAYER_3_AABB)
                && state.getValue(LAYER_4_AABB);
    }

    private static BlockState removeWaterIfFull(BlockState state) {
        return isFull(state) ? state.setValue(WATERLOGGED, false) : state;
    }

    private static ColumnType determineColumnType(BlockState state, BlockState up, BlockState down) {
        boolean connectsAbove = canConnect(state, up);
        boolean connectsBelow = canConnect(state, down);
        if (connectsAbove && !connectsBelow) return ColumnType.BOTTOM;
        if (!connectsAbove && connectsBelow) return ColumnType.TOP;
        if (connectsAbove) return ColumnType.MIDDLE;
        return ColumnType.NONE;
    }

    private static boolean canConnect(BlockState state, BlockState other) {
        if (!(other.getBlock() instanceof ColumnBlock)) {
            return false;
        }
        if (state.getValue(AXIS) != other.getValue(AXIS)) {
            return false;
        }
        boolean thisFull = isFull(state);
        boolean otherFull = isFull(other);
        return thisFull == otherFull;
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LAYER_1_AABB, LAYER_2_AABB, LAYER_3_AABB, LAYER_4_AABB, WATERLOGGED, AXIS, TYPE);
    }
}
