package com.starfish_studios.bbb.event;

import com.starfish_studios.bbb.block.BalustradeBlock;
import com.starfish_studios.bbb.block.FrameBlock;
import com.starfish_studios.bbb.block.MouldingBlock;
import com.starfish_studios.bbb.block.StoneFenceBlock;
import com.starfish_studios.bbb.block.properties.FrameStickDirection;
import com.starfish_studios.bbb.registry.BBBTags;
import dev.architectury.event.EventResult;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;

import static com.starfish_studios.bbb.block.FrameBlock.FRAME_CENTER;

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
                level.playSound(player, blockPos, level.getBlockState(blockPos).getBlock().getSoundType(level.getBlockState(blockPos)).getBreakSound(), player.getSoundSource(), 1.0F, 1.0F);
            } else {
                level.setBlock(blockPos, level.getBlockState(blockPos).setValue(MouldingBlock.DENTIL, true), 3);
                level.playSound(player, blockPos, level.getBlockState(blockPos).getBlock().getSoundType(level.getBlockState(blockPos)).getPlaceSound(), player.getSoundSource(), 1.0F, 1.0F);
            }
            return EventResult.interruptTrue();
        }

        //TODO : HAMMER + STONE FENCES
        final boolean isStoneFence = level.getBlockState(blockPos).is(BBBTags.BBBBlockTags.STONE_FENCES);
        if (isHammer && isStoneFence) {
            BlockState state = level.getBlockState(blockPos);
            boolean north = state.getValue(StoneFenceBlock.NORTH);
            boolean east = state.getValue(StoneFenceBlock.EAST);
            boolean south = state.getValue(StoneFenceBlock.SOUTH);
            boolean west = state.getValue(StoneFenceBlock.WEST);

            if (!north && !east && !south && !west) {
                return EventResult.pass();
            }

            if (player.isShiftKeyDown()) {
                boolean isNS = north && south;
                boolean isEW = east && west;
                if (isNS || isEW) {
                    boolean currentPillar = state.getValue(StoneFenceBlock.PILLAR);
                    level.setBlock(blockPos,
                            state.setValue(StoneFenceBlock.PILLAR, !currentPillar), 3);
                } else {
                    return EventResult.pass();
                }
            } else {
                boolean fill = state.getValue(StoneFenceBlock.SIDE_FILL);
                level.setBlock(blockPos,
                        state.setValue(StoneFenceBlock.SIDE_FILL, !fill), 3);
            }
            level.playSound(player, blockPos,
                    state.getBlock().getSoundType(state).getPlaceSound(),
                    player.getSoundSource(), 1.0F, 1.0F);
            return EventResult.interruptTrue();
        }
        return EventResult.pass();
    }
}
