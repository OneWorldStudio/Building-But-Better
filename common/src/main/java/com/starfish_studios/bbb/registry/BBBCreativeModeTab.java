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

                    output.accept(OAK_BALUSTRADE.get());
                    output.accept(SPRUCE_BALUSTRADE.get());
                    output.accept(BIRCH_BALUSTRADE.get());
                    output.accept(JUNGLE_BALUSTRADE.get());
                    output.accept(ACACIA_BALUSTRADE.get());
                    output.accept(DARK_OAK_BALUSTRADE.get());
                    output.accept(CRIMSON_BALUSTRADE.get());
                    output.accept(WARPED_BALUSTRADE.get());
                    output.accept(MANGROVE_BALUSTRADE.get());
                    output.accept(BAMBOO_BALUSTRADE.get());
                    output.accept(CHERRY_BALUSTRADE.get());

                    output.accept(OAK_LATTICE.get());
                    output.accept(SPRUCE_LATTICE.get());
                    output.accept(BIRCH_LATTICE.get());
                    output.accept(JUNGLE_LATTICE.get());
                    output.accept(ACACIA_LATTICE.get());
                    output.accept(DARK_OAK_LATTICE.get());
                    output.accept(CRIMSON_LATTICE.get());
                    output.accept(WARPED_LATTICE.get());
                    output.accept(MANGROVE_LATTICE.get());
                    output.accept(BAMBOO_LATTICE.get());
                    output.accept(CHERRY_LATTICE.get());

                    output.accept(OAK_WALL.get());
                    output.accept(SPRUCE_WALL.get());
                    output.accept(BIRCH_WALL.get());
                    output.accept(JUNGLE_WALL.get());
                    output.accept(ACACIA_WALL.get());
                    output.accept(DARK_OAK_WALL.get());
                    output.accept(CRIMSON_WALL.get());
                    output.accept(WARPED_WALL.get());
                    output.accept(MANGROVE_WALL.get());
                    output.accept(BAMBOO_WALL.get());
                    output.accept(CHERRY_WALL.get());


                    output.accept( OAK_BEAM.get());
                    output.accept(SPRUCE_BEAM.get());
                    output.accept(BIRCH_BEAM .get());
                    output.accept(JUNGLE_BEAM.get());
                    output.accept(ACACIA_BEAM.get());
                    output.accept(DARK_OAK_BEAM.get());
                    output.accept(CRIMSON_BEAM.get());
                    output.accept(WARPED_BEAM.get());
                    output.accept(MANGROVE_BEAM.get());
                    output.accept(BAMBOO_BEAM.get());
                    output.accept(CHERRY_BEAM.get());


                    output.accept(OAK_BEAM_STAIRS.get());
                    output.accept(SPRUCE_BEAM_STAIRS.get());
                    output.accept(BIRCH_BEAM_STAIRS.get());
                    output.accept(JUNGLE_BEAM_STAIRS.get());
                    output.accept(ACACIA_BEAM_STAIRS.get());
                    output.accept(DARK_OAK_BEAM_STAIRS.get());
                    output.accept(CRIMSON_BEAM_STAIRS.get());
                    output.accept(WARPED_BEAM_STAIRS.get());
                    output.accept(MANGROVE_BEAM_STAIRS.get());
                    output.accept(BAMBOO_BEAM_STAIRS.get());
                    output.accept(CHERRY_BEAM_STAIRS.get());

                    output.accept(OAK_BEAM_SLAB.get());
                    output.accept(SPRUCE_BEAM_SLAB.get());
                    output.accept(BIRCH_BEAM_SLAB.get());
                    output.accept(JUNGLE_BEAM_SLAB.get());
                    output.accept(ACACIA_BEAM_SLAB.get());
                    output.accept(DARK_OAK_BEAM_SLAB.get());
                    output.accept(CRIMSON_BEAM_SLAB.get());
                    output.accept(WARPED_BEAM_SLAB.get());
                    output.accept(MANGROVE_BEAM_SLAB.get());
                    output.accept(BAMBOO_BEAM_SLAB.get());
                    output.accept(CHERRY_BEAM_SLAB.get());

                    output.accept(OAK_SUPPORT.get());
                    output.accept(SPRUCE_SUPPORT.get());
                    output.accept(BIRCH_SUPPORT.get());
                    output.accept(JUNGLE_SUPPORT.get());
                    output.accept(ACACIA_SUPPORT.get());
                    output.accept(DARK_OAK_SUPPORT.get());
                    output.accept(CRIMSON_SUPPORT.get());
                    output.accept(WARPED_SUPPORT.get());
                    output.accept(MANGROVE_SUPPORT.get());
                    output.accept(BAMBOO_SUPPORT.get());
                    output.accept(CHERRY_SUPPORT.get());

                    output.accept(OAK_PALLET.get());
                    output.accept(SPRUCE_PALLET.get());
                    output.accept(BIRCH_PALLET.get());
                    output.accept(JUNGLE_PALLET.get());
                    output.accept(ACACIA_PALLET.get());
                    output.accept(DARK_OAK_PALLET.get());
                    output.accept(CRIMSON_PALLET.get());
                    output.accept(WARPED_PALLET.get());
                    output.accept(MANGROVE_PALLET.get());
                    output.accept(BAMBOO_PALLET.get());
                    output.accept(CHERRY_PALLET.get());

                    output.accept(OAK_FRAME.get());
                    output.accept(SPRUCE_FRAME.get());
                    output.accept(BIRCH_FRAME.get());
                    output.accept(JUNGLE_FRAME.get());
                    output.accept(ACACIA_FRAME.get());
                    output.accept(DARK_OAK_FRAME.get());
                    output.accept(CRIMSON_FRAME.get());
                    output.accept(WARPED_FRAME.get());
                    output.accept(MANGROVE_FRAME.get());
                    output.accept(BAMBOO_FRAME.get());
                    output.accept(CHERRY_FRAME.get());


                    output.accept(OAK_LANTERN.get());
                    output.accept(SPRUCE_LANTERN.get());
                    output.accept(BIRCH_LANTERN.get());
                    output.accept(JUNGLE_LANTERN.get());
                    output.accept(ACACIA_LANTERN.get());
                    output.accept(DARK_OAK_LANTERN.get());
                    output.accept(CRIMSON_LANTERN.get());
                    output.accept(WARPED_LANTERN.get());
                    output.accept(MANGROVE_LANTERN.get());
                    output.accept(BAMBOO_LANTERN.get());
                    output.accept(CHERRY_LANTERN.get());

                    output.accept(OAK_TRIM.get());
                    output.accept(SPRUCE_TRIM.get());
                    output.accept(BIRCH_TRIM .get());
                    output.accept(JUNGLE_TRIM.get());
                    output.accept(ACACIA_TRIM.get());
                    output.accept(DARK_OAK_TRIM.get());
                    output.accept(CRIMSON_TRIM.get());
                    output.accept(WARPED_TRIM.get());
                    output.accept(MANGROVE_TRIM.get());
                    output.accept(BAMBOO_TRIM.get());
                    output.accept(CHERRY_TRIM.get());

                    output.accept(OAK_LAYER.get());
                    output.accept(SPRUCE_LAYER.get());
                    output.accept(BIRCH_LAYER.get());
                    output.accept(JUNGLE_LAYER.get());
                    output.accept(ACACIA_LAYER.get());
                    output.accept(DARK_OAK_LAYER.get());
                    output.accept(CRIMSON_LAYER.get());
                    output.accept(WARPED_LAYER.get());
                    output.accept(MANGROVE_LAYER.get());
                    output.accept(BAMBOO_LAYER.get());
                    output.accept(BAMBOO_MOSAIC_LAYER.get());
                    output.accept(CHERRY_LAYER.get());

                    output.accept(OAK_LADDER.get());
                    output.accept(SPRUCE_LADDER.get());
                    output.accept(BIRCH_LADDER.get());
                    output.accept(JUNGLE_LADDER.get());
                    output.accept(ACACIA_LADDER.get());
                    output.accept(DARK_OAK_LADDER.get());
                    output.accept(CRIMSON_LADDER.get());
                    output.accept(WARPED_LADDER.get());
                    output.accept(MANGROVE_LADDER.get());
                    output.accept(BAMBOO_LADDER.get());
                    output.accept(CHERRY_LADDER.get());

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
