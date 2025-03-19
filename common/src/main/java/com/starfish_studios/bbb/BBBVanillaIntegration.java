package com.starfish_studios.bbb;

import com.starfish_studios.bbb.client.renderer.blockentity.BlockBlockRenderer;
import com.starfish_studios.bbb.registry.BBBBlockEntityType;
import com.starfish_studios.bbb.registry.BBBBlocks;
import com.starfish_studios.bbb.registry.BBBWoodType;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

public class BBBVanillaIntegration {

    public static class Client {

        public static void clientInit() {
            registerBlockRenderLayers();
            registerBlockEntityRenderers();
            registerBlockColors();
        }

        //client methods
        private static void registerBlockEntityRenderers() {
            BlockEntityRendererRegistry.register(BBBBlockEntityType.BLOCK.get(), context -> new BlockBlockRenderer());
        }

        private static void registerBlockColors() {

            for(Map.Entry<BBBWoodType, RegistrySupplier<Block>> block : BBBBlocks.LATTICE.entrySet()) {
                ColorHandlerRegistry.registerBlockColors((state, world, pos, tintIndex) -> {
                            if (world == null || pos == null) {
                                return FoliageColor.getDefaultColor();
                            }
                            return BiomeColors.getAverageFoliageColor(world, pos);
                        },
                        block.getValue().get()
                );
            }
        }

        private static void registerBlockRenderLayers() {

            for(Map.Entry<BBBWoodType, RegistrySupplier<Block>> block : BBBBlocks.LATTICE.entrySet()) {
                RenderTypeRegistry.register(RenderType.cutout(), block.getValue().get());
            }

            for(Map.Entry<BBBWoodType, RegistrySupplier<Block>> block : BBBBlocks.LADDER.entrySet()) {
                RenderTypeRegistry.register(RenderType.cutout(), block.getValue().get());
            }

            RenderTypeRegistry.register(RenderType.cutout(),
                    BBBBlocks.IRON_FENCE.get(),
                    BBBBlocks.ROPE.get(),
                    BBBBlocks.BRAZIER.get(),
                    BBBBlocks.SOUL_BRAZIER.get(),
                    BBBBlocks.STONE_URN.get(),
                    BBBBlocks.BLACKSTONE_URN.get(),
                    BBBBlocks.DEEPSLATE_URN.get(),
                    BBBBlocks.NETHER_BRICK_URN.get(),
                    BBBBlocks.SANDSTONE_URN.get(),
                    BBBBlocks.RED_SANDSTONE_URN.get(),
                    BBBBlocks.QUARTZ_URN.get()
            );
        }
    }
}
