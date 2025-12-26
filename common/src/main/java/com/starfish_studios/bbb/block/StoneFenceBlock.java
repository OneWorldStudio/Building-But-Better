package com.starfish_studios.bbb.block;

import com.starfish_studios.bbb.registry.BBBTags;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;

public class StoneFenceBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION =
            PipeBlock.PROPERTY_BY_DIRECTION.entrySet().stream().filter((entry) -> entry.getKey().getAxis().isHorizontal()).collect(Util.toMap());
    public static final BooleanProperty SIDE_FILL = BooleanProperty.create("side_fill");
    public static final BooleanProperty PILLAR = BooleanProperty.create("pillar");


    public VoxelShape PILLAR_AABB = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    public VoxelShape NORTH_AABB = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 16.0D, 4.0D);
    public VoxelShape EAST_AABB = Block.box(12.0D, 0.0D, 4.0D, 16.0D, 16.0D, 12.0D);
    public VoxelShape SOUTH_AABB = Block.box(4.0D, 0.0D, 12.0D, 12.0D, 16.0D, 16.0D);
    public VoxelShape WEST_AABB = Block.box(0.0D, 0.0D, 4.0D, 4.0D, 16.0D, 12.0D);

    public VoxelShape PILLAR_COLLISION = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 24.0D, 12.0D);
    public VoxelShape NORTH_COLLISION = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 24.0D, 4.0D);
    public VoxelShape EAST_COLLISION = Block.box(12.0D, 0.0D, 4.0D, 16.0D, 24.0D, 12.0D);
    public VoxelShape SOUTH_COLLISION = Block.box(4.0D, 0.0D, 12.0D, 12.0D, 24.0D, 16.0D);
    public VoxelShape WEST_COLLISION = Block.box(0.0D, 0.0D, 4.0D, 4.0D, 24.0D, 12.0D);

    public StoneFenceBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((this.stateDefinition.any()
                .setValue(NORTH, false)).setValue(EAST, false)
                .setValue(SOUTH, false).setValue(WEST, false)
                .setValue(WATERLOGGED, false)
                .setValue(SIDE_FILL, false)
                .setValue(PILLAR, true));
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        VoxelShape shape = PILLAR_AABB;
        if (state.getValue(NORTH)) shape = Shapes.or(shape, NORTH_AABB);
        if (state.getValue(EAST)) shape = Shapes.or(shape, EAST_AABB);
        if (state.getValue(SOUTH)) shape = Shapes.or(shape, SOUTH_AABB);
        if (state.getValue(WEST)) shape = Shapes.or(shape, WEST_AABB);
        return shape;
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull VoxelShape getCollisionShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        VoxelShape shape = PILLAR_COLLISION;
        if (state.getValue(NORTH)) shape = Shapes.or(shape, NORTH_COLLISION);
        if (state.getValue(EAST)) shape = Shapes.or(shape, EAST_COLLISION);
        if (state.getValue(SOUTH)) shape = Shapes.or(shape, SOUTH_COLLISION);
        if (state.getValue(WEST)) shape = Shapes.or(shape, WEST_COLLISION);
        return shape;
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull VoxelShape getVisualShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return this.getShape(state, level, pos, context);
    }

    @SuppressWarnings("deprecation")
    public boolean isPathfindable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull PathComputationType path) {
        return false;
    }

    public boolean connectsTo(BlockState state, boolean bl, Direction direction) {
        Block block = state.getBlock();
        boolean bl2 = this.isSameFence(state);
        boolean bl3 = block instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(state, direction);
        return !isExceptionForConnection(state) && bl || bl2 || bl3;
    }

    public static boolean isExceptionForConnection(BlockState state) {
        return state.getBlock() instanceof LeavesBlock || state.is(Blocks.BARRIER) || state.is(Blocks.CARVED_PUMPKIN) || state.is(Blocks.JACK_O_LANTERN) || state.is(Blocks.MELON) || state.is(Blocks.PUMPKIN) || state.is(BlockTags.SHULKER_BOXES)
                || state.getBlock() instanceof ColumnBlock;
    }

    private boolean isSameFence(BlockState state) {
        return state.is(BBBTags.BBBBlockTags.STONE_FENCES) || state.is(BlockTags.WALLS);
    }

    private static boolean anyNS(BlockState state) {
        return state.getValue(NORTH) || state.getValue(SOUTH);
    }
    private static boolean anyEW(BlockState state) {
        return state.getValue(EAST) || state.getValue(WEST);
    }
    private static boolean isCorner(BlockState state) {
        return anyNS(state) && anyEW(state);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockGetter level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        FluidState fluid = level.getFluidState(pos);

        BlockState state = Objects.requireNonNull(super.getStateForPlacement(context))
                .setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);

        for (var entry : PROPERTY_BY_DIRECTION.entrySet()) {
            Direction direction = entry.getKey();
            BooleanProperty prop = entry.getValue();
            BlockState neighbor = level.getBlockState(pos.relative(direction));
            boolean connects = connectsTo(
                    neighbor,
                    neighbor.isFaceSturdy(level, pos.relative(direction), direction.getOpposite()),
                    direction.getOpposite()
            );
            state = state.setValue(prop, connects);
        }

        if (isCorner(state)) {
            state = state.setValue(PILLAR, true);
        }
        return state;
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull BlockState updateShape(BlockState state, @NotNull Direction direction, @NotNull BlockState neighbor, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        if (!direction.getAxis().isHorizontal()) {
            return super.updateShape(state, direction, neighbor, level, pos, neighborPos);
        }

        BooleanProperty prop = PROPERTY_BY_DIRECTION.get(direction);
        boolean connects = connectsTo(
                neighbor,
                neighbor.isFaceSturdy(level, neighborPos, direction.getOpposite()),
                direction.getOpposite()
        );
        BlockState corner = state.setValue(prop, connects);

        if (isCorner(corner)) {
            return corner.setValue(PILLAR, true);
        }

        if (!anyNS(corner) && !anyEW(corner)) {
            BlockState updated = corner;
            if (!updated.getValue(PILLAR)) {
                updated = updated.setValue(PILLAR, true);
            }
            updated = updated.setValue(SIDE_FILL, false);
            return updated;
        }

        return corner;
    }


    @SuppressWarnings("deprecation")
    public @NotNull BlockState rotate(@NotNull BlockState state, Rotation rotation) {
        return switch (rotation) {
            case CLOCKWISE_180 ->
                    state
                            .setValue(NORTH, state.getValue(SOUTH))
                            .setValue(EAST, state.getValue(WEST))
                            .setValue(SOUTH, state.getValue(NORTH))
                            .setValue(WEST, state.getValue(EAST));
            case COUNTERCLOCKWISE_90 ->
                    state
                            .setValue(NORTH, state.getValue(EAST))
                            .setValue(EAST, state.getValue(SOUTH))
                            .setValue(SOUTH, state.getValue(WEST))
                            .setValue(WEST, state.getValue(NORTH));
            case CLOCKWISE_90 ->
                    state
                            .setValue(NORTH, state.getValue(WEST))
                            .setValue(EAST, state.getValue(NORTH))
                            .setValue(SOUTH, state.getValue(EAST))
                            .setValue(WEST, state.getValue(SOUTH));
            default -> state;
        };
    }

    @SuppressWarnings("deprecation")
    public @NotNull BlockState mirror(@NotNull BlockState state, Mirror mirror) {
        return switch (mirror) {
            case LEFT_RIGHT -> state.setValue(NORTH, state.getValue(SOUTH)).setValue(SOUTH, state.getValue(NORTH));
            case FRONT_BACK -> state.setValue(EAST, state.getValue(WEST)).setValue(WEST, state.getValue(EAST));
            default -> super.mirror(state, mirror);
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, WATERLOGGED, SIDE_FILL, PILLAR);
    }
}
