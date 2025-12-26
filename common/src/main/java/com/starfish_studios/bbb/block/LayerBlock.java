package com.starfish_studios.bbb.block;

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
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class LayerBlock extends Block implements SimpleWaterloggedBlock {
    // region PROPERTIES
    public static final IntegerProperty LAYERS = IntegerProperty.create("layers", 1, 4);
    public static final DirectionProperty FACING = DirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final VoxelShape LAYER_1_UP = Block.box(0, 0, 0, 16, 4, 16);
    public static final VoxelShape LAYER_2_UP = Block.box(0, 0, 0, 16, 8, 16);
    public static final VoxelShape LAYER_3_UP = Block.box(0, 0, 0, 16, 12, 16);
    public static final VoxelShape LAYER_4_UP = Block.box(0, 0, 0, 16, 16, 16);
    public static final VoxelShape LAYER_1_DOWN = Block.box(0, 12, 0, 16, 16, 16);
    public static final VoxelShape LAYER_2_DOWN = Block.box(0, 8, 0, 16, 16, 16);
    public static final VoxelShape LAYER_3_DOWN = Block.box(0, 4, 0, 16, 16, 16);
    public static final VoxelShape LAYER_4_DOWN = Block.box(0, 0, 0, 16, 16, 16);
    public static final VoxelShape LAYER_1_NORTH = Block.box(0, 0, 12, 16, 16, 16);
    public static final VoxelShape LAYER_2_NORTH = Block.box(0, 0, 8, 16, 16, 16);
    public static final VoxelShape LAYER_3_NORTH = Block.box(0, 0, 4, 16, 16, 16);
    public static final VoxelShape LAYER_4_NORTH = Block.box(0, 0, 0, 16, 16, 16);
    public static final VoxelShape LAYER_1_SOUTH = Block.box(0, 0, 0, 16, 16, 4);
    public static final VoxelShape LAYER_2_SOUTH = Block.box(0, 0, 0, 16, 16, 8);
    public static final VoxelShape LAYER_3_SOUTH = Block.box(0, 0, 0, 16, 16, 12);
    public static final VoxelShape LAYER_4_SOUTH = Block.box(0, 0, 0, 16, 16, 16);
    public static final VoxelShape LAYER_1_EAST = Block.box(0, 0, 0, 4, 16, 16);
    public static final VoxelShape LAYER_2_EAST = Block.box(0, 0, 0, 8, 16, 16);
    public static final VoxelShape LAYER_3_EAST = Block.box(0, 0, 0, 12, 16, 16);
    public static final VoxelShape LAYER_4_EAST = Block.box(0, 0, 0, 16, 16, 16);
    public static final VoxelShape LAYER_1_WEST = Block.box(12, 0, 0, 16, 16, 16);
    public static final VoxelShape LAYER_2_WEST = Block.box(8, 0, 0, 16, 16, 16);
    public static final VoxelShape LAYER_3_WEST = Block.box(4, 0, 0, 16, 16, 16);
    public static final VoxelShape LAYER_4_WEST = Block.box(0, 0, 0, 16, 16, 16);
    // endregion

    public LayerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(
            this.stateDefinition.any()
                .setValue(WATERLOGGED, false)
                .setValue(FACING, Direction.UP)
                .setValue(LAYERS, 1)
        );
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        if (player.getItemInHand(hand).is(BBBTags.BBBItemTags.HAMMERS)) {
            if (state.getValue(LAYERS) > 1) {
                level.setBlock(pos, state.setValue(LAYERS, state.getValue(LAYERS) - 1), 3);
                Block.popResource(level, pos, this.asItem().getDefaultInstance());
                player.getItemInHand(hand).hurtAndBreak(1, player, (playerEntity) -> {
                    playerEntity.broadcastBreakEvent(hand);
                });
                level.playSound(player, pos, level.getBlockState(pos).getBlock().getSoundType(level.getBlockState(pos)).getBreakSound(), player.getSoundSource(), 1.0F, 1.0F);
                return InteractionResult.SUCCESS;
            } else if (state.getValue(LAYERS) == 1) {
                level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                Block.popResource(level, pos, this.asItem().getDefaultInstance());
                player.getItemInHand(hand).hurtAndBreak(1, player, (playerEntity) -> {
                    playerEntity.broadcastBreakEvent(hand);
                });
                level.playSound(player, pos, level.getBlockState(pos).getBlock().getSoundType(level.getBlockState(pos)).getBreakSound(), player.getSoundSource(), 1.0F, 1.0F);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return switch (state.getValue(LAYERS)) {
            case 1 -> switch (state.getValue(FACING)) {
                case NORTH -> LAYER_1_NORTH;
                case SOUTH -> LAYER_1_SOUTH;
                case EAST -> LAYER_1_EAST;
                case WEST -> LAYER_1_WEST;
                case UP -> LAYER_1_UP;
                case DOWN -> LAYER_1_DOWN;
            };
            case 2 -> switch (state.getValue(FACING)) {
                case NORTH -> LAYER_2_NORTH;
                case SOUTH -> LAYER_2_SOUTH;
                case EAST -> LAYER_2_EAST;
                case WEST -> LAYER_2_WEST;
                case UP -> LAYER_2_UP;
                case DOWN -> LAYER_2_DOWN;
            };
            case 3 -> switch (state.getValue(FACING)) {
                case NORTH -> LAYER_3_NORTH;
                case SOUTH -> LAYER_3_SOUTH;
                case EAST -> LAYER_3_EAST;
                case WEST -> LAYER_3_WEST;
                case UP -> LAYER_3_UP;
                case DOWN -> LAYER_3_DOWN;
            };
            case 4 -> switch (state.getValue(FACING)) {
                case NORTH -> LAYER_4_NORTH;
                case SOUTH -> LAYER_4_SOUTH;
                case EAST -> LAYER_4_EAST;
                case WEST -> LAYER_4_WEST;
                case UP -> LAYER_4_UP;
                case DOWN -> LAYER_4_DOWN;
            };
            default -> throw new IllegalStateException("Unexpected value: " + state.getValue(LAYERS));
        };
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        if (state.getValue(FACING) != context.getClickedFace()) return false;
        return context.getItemInHand().is(this.asItem()) && state.getValue(LAYERS) < 4 || super.canBeReplaced(state, context);
    }


    private static boolean isFull(BlockState state) {
        return state.getValue(LAYERS) == 4;
    }

    private static BlockState removeWaterIfFull(BlockState state) {
        return isFull(state) ? state.setValue(WATERLOGGED, false) : state;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockPos pos = ctx.getClickedPos();
        FluidState fluid = ctx.getLevel().getFluidState(pos);
        BlockState existing = ctx.getLevel().getBlockState(pos);

        if (existing.is(this)) {
            BlockState stacked = existing.setValue(LAYERS, Math.min(4, existing.getValue(LAYERS) + 1));
            return removeWaterIfFull(stacked);
        }

        BlockState placed;
        if (ctx.getPlayer() != null && ctx.getPlayer().isShiftKeyDown()) {
            Direction[] lookDirs = ctx.getNearestLookingDirections();
            for (Direction d : lookDirs) {
                if (d.getAxis() == Direction.Axis.Y) {
                    placed = this.defaultBlockState()
                            .setValue(FACING, ctx.getNearestLookingVerticalDirection().getOpposite())
                            .setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
                } else {
                    placed = this.defaultBlockState()
                            .setValue(FACING, d.getOpposite())
                            .setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
                }
                return removeWaterIfFull(placed);
            }
            placed = this.defaultBlockState()
                    .setValue(FACING, Direction.UP)
                    .setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
            return removeWaterIfFull(placed);
        } else {
            BlockState base = this.defaultBlockState()
                    .setValue(FACING, Direction.UP)
                    .setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
            Direction face = ctx.getClickedFace();
            if (face == Direction.DOWN || (face != Direction.UP && ctx.getClickLocation().y - pos.getY() > 0.5)) {
                base = base.setValue(FACING, Direction.DOWN);
            }
            return removeWaterIfFull(base);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean placeLiquid(@NotNull LevelAccessor level, @NotNull BlockPos pos, BlockState state, @NotNull FluidState fluidState) {
        return state.getValue(LAYERS) != 4 && SimpleWaterloggedBlock.super.placeLiquid(level, pos, state, fluidState);
    }
    
    @SuppressWarnings("deprecation")
    @Override
    public @NotNull BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public boolean canPlaceLiquid(@NotNull BlockGetter level, @NotNull BlockPos pos, BlockState state, @NotNull Fluid fluid) {
        return state.getValue(LAYERS) != 4 && SimpleWaterloggedBlock.super.canPlaceLiquid(level, pos, state, fluid);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull BlockState updateShape(BlockState state, @NotNull Direction direction, @NotNull BlockState state2, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos pos2) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, direction, state2, level, pos, pos2);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING, LAYERS);
    }



}
