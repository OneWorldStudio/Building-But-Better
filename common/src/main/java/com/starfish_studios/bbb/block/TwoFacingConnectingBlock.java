package com.starfish_studios.bbb.block;

import com.starfish_studios.bbb.block.properties.BBBBlockStateProperties;
import com.starfish_studios.bbb.block.properties.ColumnType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class TwoFacingConnectingBlock extends Block {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    public static final EnumProperty<ColumnType> TYPE = BBBBlockStateProperties.COLUMN_TYPE;

    public TwoFacingConnectingBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(TYPE, ColumnType.NONE));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction.Axis axis = context.getClickedFace().getAxis();

        if (context.getPlayer() != null && context.getPlayer().isShiftKeyDown()) {
            return this.defaultBlockState()
                    .setValue(AXIS, axis)
                    .setValue(TYPE, ColumnType.NONE);
        }

        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        BlockState above = getRelativeBlockState(level, pos, axis, Direction.AxisDirection.POSITIVE);
        BlockState below = getRelativeBlockState(level, pos, axis, Direction.AxisDirection.NEGATIVE);

        boolean aboveIsNone = above.is(this)
                && above.getValue(TYPE) == ColumnType.NONE
                && above.getValue(AXIS) == axis;
        boolean belowIsNone = below.is(this)
                && below.getValue(TYPE) == ColumnType.NONE
                && below.getValue(AXIS) == axis;

        if (aboveIsNone) {
            return this.defaultBlockState()
                    .setValue(AXIS, axis)
                    .setValue(TYPE, ColumnType.BOTTOM);
        } else if (belowIsNone) {
            return this.defaultBlockState()
                    .setValue(AXIS, axis)
                    .setValue(TYPE, ColumnType.TOP);
        }

        return this.defaultBlockState()
                .setValue(AXIS, axis)
                .setValue(TYPE, ColumnType.NONE);
    }


    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos,
                                Block block, BlockPos fromPos, boolean isMoving) {
        if (level.isClientSide) return;

        ColumnType type = state.getValue(TYPE);
        Direction.Axis axis = state.getValue(AXIS);

        BlockPos abovePos = pos.relative(Direction.fromAxisAndDirection(axis, Direction.AxisDirection.POSITIVE));
        BlockPos belowPos = pos.relative(Direction.fromAxisAndDirection(axis, Direction.AxisDirection.NEGATIVE));

        BlockState aboveState = level.getBlockState(abovePos);
        BlockState belowState = level.getBlockState(belowPos);

        if (type == ColumnType.NONE) {
            BlockState fromState = level.getBlockState(fromPos);
            if (fromState.is(this)
                    && fromState.getValue(TYPE) == ColumnType.NONE
                    && fromState.getValue(AXIS) == axis) {
                return;
            }

            if (aboveState.is(this)
                    && aboveState.getValue(TYPE) == ColumnType.TOP
                    && aboveState.getValue(AXIS) == axis) {
                level.setBlock(pos, state.setValue(TYPE, ColumnType.BOTTOM), 3);
                return;
            }
            if (belowState.is(this)
                    && belowState.getValue(TYPE) == ColumnType.BOTTOM
                    && belowState.getValue(AXIS) == axis) {
                level.setBlock(pos, state.setValue(TYPE, ColumnType.TOP), 3);
            }

        } else if (type == ColumnType.BOTTOM) {
            if (!(aboveState.is(this)
                    && aboveState.getValue(TYPE) == ColumnType.TOP
                    && aboveState.getValue(AXIS) == axis)) {
                level.setBlock(pos, state.setValue(TYPE, ColumnType.NONE), 3);
            }

        } else if (type == ColumnType.TOP) {
            if (!(belowState.is(this)
                    && belowState.getValue(TYPE) == ColumnType.BOTTOM
                    && belowState.getValue(AXIS) == axis)) {
                level.setBlock(pos, state.setValue(TYPE, ColumnType.NONE), 3);
            }
        }
    }



    private BlockState getRelativeBlockState(Level level, BlockPos pos, Direction.Axis axis, Direction.AxisDirection direction) {
        Direction relativeDir = Direction.fromAxisAndDirection(axis, direction);
        return level.getBlockState(pos.relative(relativeDir));
    }

    public ColumnType getType(BlockState state, BlockState above, BlockState below) {
        boolean shapeAboveSame = above.is(state.getBlock()) && state.getValue(AXIS) == above.getValue(AXIS);
        boolean shapeBelowSame = below.is(state.getBlock()) && state.getValue(AXIS) == below.getValue(AXIS);

        if (shapeAboveSame && shapeBelowSame) {
            return ColumnType.NONE;
        } else if (shapeAboveSame) {
            return ColumnType.BOTTOM;
        } else if (shapeBelowSame) {
            return ColumnType.TOP;
        }
        return ColumnType.NONE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE, AXIS);
    }
}
