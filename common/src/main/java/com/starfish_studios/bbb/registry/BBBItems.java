package com.starfish_studios.bbb.registry;

import com.starfish_studios.bbb.BuildingButBetter;
import com.starfish_studios.bbb.item.DescriptionBlockItem;
import com.starfish_studios.bbb.item.HammerItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class BBBItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuildingButBetter.MOD_ID, Registries.ITEM);
    /// Oak, Spruce, Birch, Jungle, Acacia, Dark Oak, Crimson, Warped, Mangrove, Bamboo, Cherry
    public static final Map<BBBWoodType, RegistrySupplier<Item>> BALUSTRADE_ITEMS = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Item>> LATTICE_ITEMS = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Item>> WALL_ITEMS = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Item>> BEAM_ITEMS = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Item>> BEAM_STAIR_ITEMS = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Item>> BEAM_SLAB_ITEMS = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Item>> SUPPORT_ITEMS = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Item>> LADDER_ITEMS = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Item>> PALLET_ITEMS = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Item>> FRAME_ITEMS = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Item>> LANTERN_ITEMS = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Item>> TRIM_ITEMS = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Item>> LAYER_ITEMS = new EnumMap<>(BBBWoodType.class);

    public static List<RegistrySupplier<Item>> getItems(BBBWoodType type){
        return List.of(
                BALUSTRADE_ITEMS.get(type),
                LATTICE_ITEMS.get(type),
                WALL_ITEMS.get(type),
                BEAM_ITEMS.get(type),
                BEAM_STAIR_ITEMS.get(type),
                BEAM_SLAB_ITEMS.get(type),
                SUPPORT_ITEMS.get(type),
                PALLET_ITEMS.get(type),
                FRAME_ITEMS.get(type),
                LADDER_ITEMS.get(type),
                LANTERN_ITEMS.get(type),
                TRIM_ITEMS.get(type),
                LAYER_ITEMS.get(type)
        );
    }

    public static final RegistrySupplier<Item> CORNERSTONE = ITEMS.register("bbb", () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).fireResistant()));
    public static final RegistrySupplier<Item> HAMMER = ITEMS.register("hammer", () -> new HammerItem(new Item.Properties().stacksTo(1).durability(256)));
    public static final RegistrySupplier<Item> CHISEL = ITEMS.register("chisel", () -> new Item(new Item.Properties().stacksTo(1).durability(256)));
    

    public static final RegistrySupplier<Item> STONE_BLOCK = ITEMS.register("stone_block", () -> new StandingAndWallBlockItem(BBBBlocks.STONE_BLOCK.get(), BBBBlocks.WALL_STONE_BLOCK.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistrySupplier<Item> BLACKSTONE_BLOCK = ITEMS.register("blackstone_block", () -> new StandingAndWallBlockItem(BBBBlocks.BLACKSTONE_BLOCK.get(), BBBBlocks.WALL_BLACKSTONE_BLOCK.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistrySupplier<Item> DEEPSLATE_BLOCK = ITEMS.register("deepslate_block", () -> new StandingAndWallBlockItem(BBBBlocks.DEEPSLATE_BLOCK.get(), BBBBlocks.WALL_DEEPSLATE_BLOCK.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistrySupplier<Item> NETHER_BRICK_BLOCK = ITEMS.register("nether_brick_block", () -> new StandingAndWallBlockItem(BBBBlocks.NETHER_BRICK_BLOCK.get(), BBBBlocks.WALL_NETHER_BRICK_BLOCK.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistrySupplier<Item> SANDSTONE_BLOCK = ITEMS.register("sandstone_block", () -> new StandingAndWallBlockItem(BBBBlocks.SANDSTONE_BLOCK.get(), BBBBlocks.WALL_SANDSTONE_BLOCK.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistrySupplier<Item> RED_SANDSTONE_BLOCK = ITEMS.register("red_sandstone_block", () -> new StandingAndWallBlockItem(BBBBlocks.RED_SANDSTONE_BLOCK.get(), BBBBlocks.WALL_RED_SANDSTONE_BLOCK.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistrySupplier<Item> QUARTZ_BLOCK = ITEMS.register("quartz_block", () -> new StandingAndWallBlockItem(BBBBlocks.QUARTZ_BLOCK.get(), BBBBlocks.WALL_QUARTZ_BLOCK.get(), new Item.Properties(), Direction.DOWN));
    

    public static final RegistrySupplier<Item> STONE_URN = ITEMS.register("stone_urn", () -> new DescriptionBlockItem(BBBBlocks.STONE_URN.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> BLACKSTONE_URN = ITEMS.register("blackstone_urn", () -> new DescriptionBlockItem(BBBBlocks.BLACKSTONE_URN.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> DEEPSLATE_URN = ITEMS.register("deepslate_urn", () -> new DescriptionBlockItem(BBBBlocks.DEEPSLATE_URN.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> NETHER_BRICK_URN = ITEMS.register("nether_brick_urn", () -> new DescriptionBlockItem(BBBBlocks.NETHER_BRICK_URN.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> SANDSTONE_URN = ITEMS.register("sandstone_urn", () -> new DescriptionBlockItem(BBBBlocks.SANDSTONE_URN.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> RED_SANDSTONE_URN = ITEMS.register("red_sandstone_urn", () -> new DescriptionBlockItem(BBBBlocks.RED_SANDSTONE_URN.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> QUARTZ_URN = ITEMS.register("quartz_urn", () -> new DescriptionBlockItem(BBBBlocks.QUARTZ_URN.get(), new Item.Properties()));


    public static final RegistrySupplier<Item> STONE_MOULDING = ITEMS.register("stone_moulding", () -> new DescriptionBlockItem(BBBBlocks.STONE_MOULDING.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> BLACKSTONE_MOULDING = ITEMS.register("blackstone_moulding", () -> new DescriptionBlockItem(BBBBlocks.BLACKSTONE_MOULDING.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> DEEPSLATE_MOULDING = ITEMS.register("deepslate_moulding", () -> new DescriptionBlockItem(BBBBlocks.DEEPSLATE_MOULDING.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> NETHER_BRICK_MOULDING = ITEMS.register("nether_brick_moulding", () -> new DescriptionBlockItem(BBBBlocks.NETHER_BRICK_MOULDING.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> SANDSTONE_MOULDING = ITEMS.register("sandstone_moulding", () -> new DescriptionBlockItem(BBBBlocks.SANDSTONE_MOULDING.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> RED_SANDSTONE_MOULDING = ITEMS.register("red_sandstone_moulding", () -> new DescriptionBlockItem(BBBBlocks.RED_SANDSTONE_MOULDING.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> QUARTZ_MOULDING = ITEMS.register("quartz_moulding", () -> new DescriptionBlockItem(BBBBlocks.QUARTZ_MOULDING.get(), new Item.Properties()));


    public static final RegistrySupplier<Item> STONE_COLUMN = ITEMS.register("stone_column", () -> new DescriptionBlockItem(BBBBlocks.STONE_COLUMN.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> DEEPSLATE_COLUMN = ITEMS.register("deepslate_column", () -> new DescriptionBlockItem(BBBBlocks.DEEPSLATE_COLUMN.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> SANDSTONE_COLUMN = ITEMS.register("sandstone_column", () -> new DescriptionBlockItem(BBBBlocks.SANDSTONE_COLUMN.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> RED_SANDSTONE_COLUMN = ITEMS.register("red_sandstone_column", () -> new DescriptionBlockItem(BBBBlocks.RED_SANDSTONE_COLUMN.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> NETHER_BRICK_COLUMN = ITEMS.register("nether_brick_column", () -> new DescriptionBlockItem(BBBBlocks.NETHER_BRICK_COLUMN.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> BLACKSTONE_COLUMN = ITEMS.register("blackstone_column", () -> new DescriptionBlockItem(BBBBlocks.BLACKSTONE_COLUMN.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> QUARTZ_COLUMN = ITEMS.register("quartz_column", () -> new DescriptionBlockItem(BBBBlocks.QUARTZ_COLUMN.get(), new Item.Properties()));



    public static final RegistrySupplier<Item> STONE_FENCE = ITEMS.register("stone_fence", () -> new DescriptionBlockItem(BBBBlocks.STONE_FENCE.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> BLACKSTONE_FENCE = ITEMS.register("blackstone_fence", () -> new DescriptionBlockItem(BBBBlocks.BLACKSTONE_FENCE.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> DEEPSLATE_FENCE = ITEMS.register("deepslate_fence", () -> new DescriptionBlockItem(BBBBlocks.DEEPSLATE_FENCE.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> NETHER_BRICK_FENCE = ITEMS.register("nether_brick_fence", () -> new DescriptionBlockItem(BBBBlocks.NETHER_BRICK_FENCE.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> SANDSTONE_FENCE = ITEMS.register("sandstone_fence", () -> new DescriptionBlockItem(BBBBlocks.SANDSTONE_FENCE.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> RED_SANDSTONE_FENCE = ITEMS.register("red_sandstone_fence", () -> new DescriptionBlockItem(BBBBlocks.RED_SANDSTONE_FENCE.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> QUARTZ_FENCE = ITEMS.register("quartz_fence", () -> new DescriptionBlockItem(BBBBlocks.QUARTZ_FENCE.get(), new Item.Properties()));

    
    // region LAYERS
    public static final RegistrySupplier<Item> MOSS_LAYER = ITEMS.register("moss_layer", () -> new DescriptionBlockItem(BBBBlocks.MOSS_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> STONE_LAYER = ITEMS.register("stone_layer", () -> new DescriptionBlockItem(BBBBlocks.STONE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> COBBLESTONE_LAYER = ITEMS.register("cobblestone_layer", () -> new DescriptionBlockItem(BBBBlocks.COBBLESTONE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> MOSSY_COBBLESTONE_LAYER = ITEMS.register("mossy_cobblestone_layer", () -> new DescriptionBlockItem(BBBBlocks.MOSSY_COBBLESTONE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> SMOOTH_STONE_LAYER = ITEMS.register("smooth_stone_layer", () -> new DescriptionBlockItem(BBBBlocks.SMOOTH_STONE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> POLISHED_STONE_LAYER = ITEMS.register("polished_stone_layer", () -> new DescriptionBlockItem(BBBBlocks.POLISHED_STONE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> STONE_TILE_LAYER = ITEMS.register("stone_tile_layer", () -> new DescriptionBlockItem(BBBBlocks.STONE_TILE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> STONE_BRICK_LAYER = ITEMS.register("stone_brick_layer", () -> new DescriptionBlockItem(BBBBlocks.STONE_BRICK_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> MOSSY_STONE_BRICK_LAYER = ITEMS.register("mossy_stone_brick_layer", () -> new DescriptionBlockItem(BBBBlocks.MOSSY_STONE_BRICK_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> GRANITE_LAYER = ITEMS.register("granite_layer", () -> new DescriptionBlockItem(BBBBlocks.GRANITE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> POLISHED_GRANITE_LAYER = ITEMS.register("polished_granite_layer", () -> new DescriptionBlockItem(BBBBlocks.POLISHED_GRANITE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> DIORITE_LAYER = ITEMS.register("diorite_layer", () -> new DescriptionBlockItem(BBBBlocks.DIORITE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> POLISHED_DIORITE_LAYER = ITEMS.register("polished_diorite_layer", () -> new DescriptionBlockItem(BBBBlocks.POLISHED_DIORITE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> ANDESITE_LAYER = ITEMS.register("andesite_layer", () -> new DescriptionBlockItem(BBBBlocks.ANDESITE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> POLISHED_ANDESITE_LAYER = ITEMS.register("polished_andesite_layer", () -> new DescriptionBlockItem(BBBBlocks.POLISHED_ANDESITE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> COBBLED_DEEPSLATE_LAYER = ITEMS.register("cobbled_deepslate_layer", () -> new DescriptionBlockItem(BBBBlocks.COBBLED_DEEPSLATE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> POLISHED_DEEPSLATE_LAYER = ITEMS.register("polished_deepslate_layer", () -> new DescriptionBlockItem(BBBBlocks.POLISHED_DEEPSLATE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> DEEPSLATE_BRICK_LAYER = ITEMS.register("deepslate_brick_layer", () -> new DescriptionBlockItem(BBBBlocks.DEEPSLATE_BRICK_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> DEEPSLATE_TILE_LAYER = ITEMS.register("deepslate_tile_layer", () -> new DescriptionBlockItem(BBBBlocks.DEEPSLATE_TILE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> BRICK_LAYER = ITEMS.register("brick_layer", () -> new DescriptionBlockItem(BBBBlocks.BRICK_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> MUD_BRICK_LAYER = ITEMS.register("mud_brick_layer", () -> new DescriptionBlockItem(BBBBlocks.MUD_BRICK_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> SANDSTONE_LAYER = ITEMS.register("sandstone_layer", () -> new DescriptionBlockItem(BBBBlocks.SANDSTONE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> SMOOTH_SANDSTONE_LAYER = ITEMS.register("smooth_sandstone_layer", () -> new DescriptionBlockItem(BBBBlocks.SMOOTH_SANDSTONE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> RED_SANDSTONE_LAYER = ITEMS.register("red_sandstone_layer", () -> new DescriptionBlockItem(BBBBlocks.RED_SANDSTONE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> SMOOTH_RED_SANDSTONE_LAYER = ITEMS.register("smooth_red_sandstone_layer", () -> new DescriptionBlockItem(BBBBlocks.SMOOTH_RED_SANDSTONE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> PRISMARINE_LAYER = ITEMS.register("prismarine_layer", () -> new DescriptionBlockItem(BBBBlocks.PRISMARINE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> PRISMARINE_BRICK_LAYER = ITEMS.register("prismarine_brick_layer", () -> new DescriptionBlockItem(BBBBlocks.PRISMARINE_BRICK_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> DARK_PRISMARINE_LAYER = ITEMS.register("dark_prismarine_layer", () -> new DescriptionBlockItem(BBBBlocks.DARK_PRISMARINE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> NETHER_BRICK_LAYER = ITEMS.register("nether_brick_layer", () -> new DescriptionBlockItem(BBBBlocks.NETHER_BRICK_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> RED_NETHER_BRICK_LAYER = ITEMS.register("red_nether_brick_layer", () -> new DescriptionBlockItem(BBBBlocks.RED_NETHER_BRICK_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> BLACKSTONE_LAYER = ITEMS.register("blackstone_layer", () -> new DescriptionBlockItem(BBBBlocks.BLACKSTONE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> POLISHED_BLACKSTONE_LAYER = ITEMS.register("polished_blackstone_layer", () -> new DescriptionBlockItem(BBBBlocks.POLISHED_BLACKSTONE_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> POLISHED_BLACKSTONE_BRICK_LAYER = ITEMS.register("polished_blackstone_brick_layer", () -> new DescriptionBlockItem(BBBBlocks.POLISHED_BLACKSTONE_BRICK_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> END_STONE_BRICK_LAYER = ITEMS.register("end_stone_brick_layer", () -> new DescriptionBlockItem(BBBBlocks.END_STONE_BRICK_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> PURPUR_LAYER = ITEMS.register("purpur_layer", () -> new DescriptionBlockItem(BBBBlocks.PURPUR_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> QUARTZ_LAYER = ITEMS.register("quartz_layer", () -> new DescriptionBlockItem(BBBBlocks.QUARTZ_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> CUT_COPPER_LAYER = ITEMS.register("cut_copper_layer", () -> new DescriptionBlockItem(BBBBlocks.CUT_COPPER_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> EXPOSED_CUT_COPPER_LAYER = ITEMS.register("exposed_cut_copper_layer", () -> new DescriptionBlockItem(BBBBlocks.EXPOSED_CUT_COPPER_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> WEATHERED_CUT_COPPER_LAYER = ITEMS.register("weathered_cut_copper_layer", () -> new DescriptionBlockItem(BBBBlocks.WEATHERED_CUT_COPPER_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> OXIDIZED_CUT_COPPER_LAYER = ITEMS.register("oxidized_cut_copper_layer", () -> new DescriptionBlockItem(BBBBlocks.OXIDIZED_CUT_COPPER_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> WAXED_CUT_COPPER_LAYER = ITEMS.register("waxed_cut_copper_layer", () -> new DescriptionBlockItem(BBBBlocks.WAXED_CUT_COPPER_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> WAXED_EXPOSED_CUT_COPPER_LAYER = ITEMS.register("waxed_exposed_cut_copper_layer", () -> new DescriptionBlockItem(BBBBlocks.WAXED_EXPOSED_CUT_COPPER_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> WAXED_WEATHERED_CUT_COPPER_LAYER = ITEMS.register("waxed_weathered_cut_copper_layer", () -> new DescriptionBlockItem(BBBBlocks.WAXED_WEATHERED_CUT_COPPER_LAYER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> WAXED_OXIDIZED_CUT_COPPER_LAYER = ITEMS.register("waxed_oxidized_cut_copper_layer", () -> new DescriptionBlockItem(BBBBlocks.WAXED_OXIDIZED_CUT_COPPER_LAYER.get(), new Item.Properties()));

    // endregion
    

    public static final RegistrySupplier<Item> POLISHED_STONE = ITEMS.register("polished_stone", () -> new BlockItem(BBBBlocks.POLISHED_STONE.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> POLISHED_STONE_STAIRS = ITEMS.register("polished_stone_stairs", () -> new BlockItem(BBBBlocks.POLISHED_STONE_STAIRS.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> POLISHED_STONE_SLAB = ITEMS.register("polished_stone_slab", () -> new BlockItem(BBBBlocks.POLISHED_STONE_SLAB.get(), new Item.Properties()));

    public static final RegistrySupplier<Item> STONE_TILES = ITEMS.register("stone_tiles", () -> new BlockItem(BBBBlocks.STONE_TILES.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> STONE_TILE_STAIRS = ITEMS.register("stone_tile_stairs", () -> new BlockItem(BBBBlocks.STONE_TILE_STAIRS.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> STONE_TILE_SLAB = ITEMS.register("stone_tile_slab", () -> new BlockItem(BBBBlocks.STONE_TILE_SLAB.get(), new Item.Properties()));

    public static final RegistrySupplier<Item> BRAZIER = ITEMS.register("brazier", () -> new BlockItem(BBBBlocks.BRAZIER.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> SOUL_BRAZIER = ITEMS.register("soul_brazier", () -> new BlockItem(BBBBlocks.SOUL_BRAZIER.get(), new Item.Properties()));


    // public static final Item ROOFING = ITEMS.register("roofing", () -> new BlockItem(BBBBlocks.ROOFING, new Item.Properties()));
    
    public static final RegistrySupplier<Item> STONE_FRAME = ITEMS.register("stone_frame", () -> new DescriptionBlockItem(BBBBlocks.STONE_FRAME.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> BLACKSTONE_FRAME = ITEMS.register("blackstone_frame", () -> new DescriptionBlockItem(BBBBlocks.BLACKSTONE_FRAME.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> DEEPSLATE_FRAME = ITEMS.register("deepslate_frame", () -> new DescriptionBlockItem(BBBBlocks.DEEPSLATE_FRAME.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> NETHER_BRICK_FRAME = ITEMS.register("nether_brick_frame", () -> new DescriptionBlockItem(BBBBlocks.NETHER_BRICK_FRAME.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> SANDSTONE_FRAME = ITEMS.register("sandstone_frame", () -> new DescriptionBlockItem(BBBBlocks.SANDSTONE_FRAME.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> RED_SANDSTONE_FRAME = ITEMS.register("red_sandstone_frame", () -> new DescriptionBlockItem(BBBBlocks.RED_SANDSTONE_FRAME.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> QUARTZ_FRAME = ITEMS.register("quartz_frame", () -> new DescriptionBlockItem(BBBBlocks.QUARTZ_FRAME.get(), new Item.Properties()));
    // endregion
    
    public static final RegistrySupplier<Item> ROPE = ITEMS.register("rope", () -> new BlockItem(BBBBlocks.ROPE.get(), new Item.Properties()));

    // region TRIMS

    public static final RegistrySupplier<Item> IRON_FENCE = ITEMS.register("iron_fence", () -> new BlockItem(BBBBlocks.IRON_FENCE.get(), new Item.Properties()));


    //public static final Item TALL_OAK_DOOR = ITEMS.register("tall_oak_door", () -> new TallDoorItem(BBBBlocks.TALL_OAK_DOOR, new Item.Properties()));

//    public static final Item COPPER_GATEWAY = ITEMS.register("copper_gateway", () -> new BlockItem(BBBBlocks.COPPER_GATEWAY, new Item.Properties()));
    
}
