package com.starfish_studios.bbb.event;

import com.starfish_studios.bbb.block.BalustradeBlock;
import com.starfish_studios.bbb.block.MouldingBlock;
import com.starfish_studios.bbb.block.StoneFenceBlock;
import com.starfish_studios.bbb.registry.BBBTags;
import dev.architectury.event.EventResult;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class BlockUseEvent {

    public static EventResult interact(Player player, InteractionHand hand, BlockPos blockPos, Direction direction) {
        final Level level = player.level();
        final boolean isHammer = player.getItemInHand(hand).is(BBBTags.BBBItemTags.HAMMERS);
        BlockState blockState = level.getBlockState(blockPos);

        // TODO : HAMMER + BALUSTRADE
        if (isHammer && level.getBlockState(blockPos).is(BBBTags.BBBBlockTags.BALUSTRADES) && player.isShiftKeyDown()) {
            if (level.getBlockState(blockPos).getValue(BalustradeBlock.TILTED)) {
                level.setBlock(blockPos, level.getBlockState(blockPos).setValue(BalustradeBlock.TILTED, false), 3);
            } else {
                level.setBlock(blockPos, level.getBlockState(blockPos).setValue(BalustradeBlock.TILTED, true), 3);
            }
            level.playSound(player, blockPos, blockState.getSoundType().getPlaceSound(), player.getSoundSource(), 1.0F, 1.0F);
            return EventResult.interruptTrue();
        }


        //TODO : HAMMER + MOULDINGS
        final boolean isMoulding = level.getBlockState(blockPos).is(BBBTags.BBBBlockTags.MOULDINGS);
        if (isHammer && isMoulding) {
            if (level.getBlockState(blockPos).getValue(MouldingBlock.DENTIL)) {
                level.setBlock(blockPos, level.getBlockState(blockPos).setValue(MouldingBlock.DENTIL, false), 3);
                level.playSound(player, blockPos, level.getBlockState(blockPos).getSoundType().getBreakSound(), player.getSoundSource(), 1.0F, 1.0F);
            } else {
                level.setBlock(blockPos, level.getBlockState(blockPos).setValue(MouldingBlock.DENTIL, true), 3);
                level.playSound(player, blockPos, level.getBlockState(blockPos).getSoundType().getPlaceSound(), player.getSoundSource(), 1.0F, 1.0F);
            }
            return EventResult.interruptTrue();
        }

        //TODO : HAMMER + STONE FENCES
        final boolean isStoneFence = level.getBlockState(blockPos).is(BBBTags.BBBBlockTags.STONE_FENCES);
        if (isHammer && isStoneFence) {
            if (!level.getBlockState(blockPos).getValue(StoneFenceBlock.NORTH) &&
                    !level.getBlockState(blockPos).getValue(StoneFenceBlock.EAST) &&
                    !level.getBlockState(blockPos).getValue(StoneFenceBlock.SOUTH) &&
                    !level.getBlockState(blockPos).getValue(StoneFenceBlock.WEST)) {
                return EventResult.pass();
            } else if (player.isShiftKeyDown()) {
                if (!level.getBlockState(blockPos).getValue(StoneFenceBlock.NORTH) &&
                        !level.getBlockState(blockPos).getValue(StoneFenceBlock.EAST) &&
                        !level.getBlockState(blockPos).getValue(StoneFenceBlock.SOUTH) &&
                        !level.getBlockState(blockPos).getValue(StoneFenceBlock.WEST)) {
                    return EventResult.pass();
                } else if (level.getBlockState(blockPos).getValue(StoneFenceBlock.PILLAR)) {
                    level.setBlock(blockPos, level.getBlockState(blockPos).setValue(StoneFenceBlock.PILLAR, false), 3);
                } else {
                    level.setBlock(blockPos, level.getBlockState(blockPos).setValue(StoneFenceBlock.PILLAR, true), 3);
                }
            } else {
                if (level.getBlockState(blockPos).getValue(StoneFenceBlock.SIDE_FILL)) {
                    level.setBlock(blockPos, level.getBlockState(blockPos).setValue(StoneFenceBlock.SIDE_FILL, false), 3);
                } else {
                    level.setBlock(blockPos, level.getBlockState(blockPos).setValue(StoneFenceBlock.SIDE_FILL, true), 3);
                }
            }
            level.playSound(player, blockPos, level.getBlockState(blockPos).getSoundType().getPlaceSound(), player.getSoundSource(), 1.0F, 1.0F);
            return EventResult.interruptTrue();

        }
        return EventResult.pass();
    }
}
