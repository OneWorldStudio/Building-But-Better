package com.starfish_studios.bbb.registry;

import com.starfish_studios.bbb.BuildingButBetter;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;


import static com.starfish_studios.bbb.registry.BBBItems.*;

public class BBBCreativeModeTab {

    public static DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(BuildingButBetter.MOD_ID, Registries.CREATIVE_MODE_TAB);

    @SuppressWarnings("unused")
    public static final RegistrySupplier<CreativeModeTab> MAIN = TABS.register("main",
            () -> CreativeTabRegistry.create(builder -> {
                builder.title(Component.translatable("itemGroup.bbb.tab"));
                builder.icon(() -> CORNERSTONE.get().getDefaultInstance());
                builder.displayItems((params, output) -> {
                    output.accept(HAMMER.get());
                    output.accept(CHISEL.get());
                    output.accept(ROPE.get());
                    output.accept(BRAZIER.get());
                    output.accept(SOUL_BRAZIER.get());
                    output.accept(IRON_FENCE.get());

                    output.accept(STONE_FRAME.get());
                    output.accept(BLACKSTONE_FRAME.get());
                    output.accept(SANDSTONE_FRAME.get());
                    output.accept(RED_SANDSTONE_FRAME.get());
                    output.accept(QUARTZ_FRAME.get());
                    output.accept(DEEPSLATE_FRAME.get());
                    output.accept(NETHER_BRICK_FRAME.get());

                    output.accept(POLISHED_STONE.get());
                    output.accept(POLISHED_STONE_STAIRS.get());
                    output.accept(POLISHED_STONE_SLAB.get());
                    output.accept(STONE_TILES.get());
                    output.accept(STONE_TILE_STAIRS.get());
                    output.accept(STONE_TILE_SLAB.get());
                    output.accept(STONE_COLUMN.get());
                    output.accept(STONE_URN.get());
                    output.accept(STONE_FENCE.get());
                    output.accept(STONE_MOULDING.get());
                    output.accept(STONE_BLOCK.get());

                    output.accept(BLACKSTONE_COLUMN.get());
                    output.accept(BLACKSTONE_URN.get());
                    output.accept(BLACKSTONE_FENCE.get());
                    output.accept(BLACKSTONE_MOULDING.get());
                    output.accept(BLACKSTONE_BLOCK.get());

                    output.accept(SANDSTONE_COLUMN.get());
                    output.accept(SANDSTONE_URN.get());
                    output.accept(SANDSTONE_FENCE.get());
                    output.accept(SANDSTONE_MOULDING.get());
                    output.accept(SANDSTONE_BLOCK.get());

                    output.accept(RED_SANDSTONE_COLUMN.get());
                    output.accept(RED_SANDSTONE_URN.get());
                    output.accept(RED_SANDSTONE_FENCE.get());
                    output.accept(RED_SANDSTONE_MOULDING.get());
                    output.accept(RED_SANDSTONE_BLOCK.get());

                    output.accept(QUARTZ_COLUMN.get());
                    output.accept(QUARTZ_URN.get());
                    output.accept(QUARTZ_FENCE.get());
                    output.accept(QUARTZ_MOULDING.get());
                    output.accept(QUARTZ_BLOCK.get());

                    output.accept(DEEPSLATE_COLUMN.get());
                    output.accept(DEEPSLATE_URN.get());
                    output.accept(DEEPSLATE_FENCE.get());
                    output.accept(DEEPSLATE_MOULDING.get());
                    output.accept(DEEPSLATE_BLOCK.get());

                    output.accept(NETHER_BRICK_COLUMN.get());
                    output.accept(NETHER_BRICK_URN.get());
                    output.accept(NETHER_BRICK_FENCE.get());
                    output.accept(NETHER_BRICK_MOULDING.get());
                    output.accept(NETHER_BRICK_BLOCK.get());


                    // output.accept(BIG_DOOR.get());


                    // Oak, Spruce, Birch, Jungle, Acacia, Dark Oak, Crimson, Warped, Mangrove, Bamboo, Cherry

                    for (BBBWoodType woodType : BBBWoodType.values()) {
                        for (RegistrySupplier<Item> item : BBBItems.getItems(woodType)) {
                            output.accept(item.get());
                        }
                    }

                    output.accept(MOSS_LAYER.get());
                    output.accept(STONE_LAYER.get());
                    output.accept(COBBLESTONE_LAYER.get());
                    output.accept(MOSSY_COBBLESTONE_LAYER.get());
                    output.accept(SMOOTH_STONE_LAYER.get());
                    output.accept(POLISHED_STONE_LAYER.get());
                    output.accept(STONE_TILE_LAYER.get());
                    output.accept(STONE_BRICK_LAYER.get());
                    output.accept(MOSSY_STONE_BRICK_LAYER.get());
                    output.accept(GRANITE_LAYER.get());
                    output.accept(POLISHED_GRANITE_LAYER.get());
                    output.accept(DIORITE_LAYER.get());
                    output.accept(POLISHED_DIORITE_LAYER.get());
                    output.accept(ANDESITE_LAYER.get());
                    output.accept(POLISHED_ANDESITE_LAYER.get());
                    output.accept(COBBLED_DEEPSLATE_LAYER.get());
                    output.accept(POLISHED_DEEPSLATE_LAYER.get());
                    output.accept(DEEPSLATE_BRICK_LAYER.get());
                    output.accept(DEEPSLATE_TILE_LAYER.get());
                    output.accept(BRICK_LAYER.get());
                    output.accept(MUD_BRICK_LAYER.get());
                    output.accept(SANDSTONE_LAYER.get());
                    output.accept(SMOOTH_SANDSTONE_LAYER.get());
                    output.accept(RED_SANDSTONE_LAYER.get());
                    output.accept(SMOOTH_RED_SANDSTONE_LAYER.get());
                    output.accept(PRISMARINE_LAYER.get());
                    output.accept(PRISMARINE_BRICK_LAYER.get());
                    output.accept(DARK_PRISMARINE_LAYER.get());
                    output.accept(NETHER_BRICK_LAYER.get());
                    output.accept(RED_NETHER_BRICK_LAYER.get());
                    output.accept(BLACKSTONE_LAYER.get());
                    output.accept(POLISHED_BLACKSTONE_LAYER.get());
                    output.accept(POLISHED_BLACKSTONE_BRICK_LAYER.get());
                    output.accept(END_STONE_BRICK_LAYER.get());
                    output.accept(PURPUR_LAYER.get());
                    output.accept(QUARTZ_LAYER.get());
                    output.accept(CUT_COPPER_LAYER.get());
                    output.accept(EXPOSED_CUT_COPPER_LAYER.get());
                    output.accept(WEATHERED_CUT_COPPER_LAYER.get());
                    output.accept(OXIDIZED_CUT_COPPER_LAYER.get());
                    output.accept(WAXED_CUT_COPPER_LAYER.get());
                    output.accept(WAXED_EXPOSED_CUT_COPPER_LAYER.get());
                    output.accept(WAXED_WEATHERED_CUT_COPPER_LAYER.get());
                    output.accept(WAXED_OXIDIZED_CUT_COPPER_LAYER.get());
                    // endregion
                });
            })
    );
}
