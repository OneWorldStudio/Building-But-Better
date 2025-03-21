package com.starfish_studios.bbb.registry;

import com.starfish_studios.bbb.BuildingButBetter;
import com.starfish_studios.bbb.block.*;
import com.starfish_studios.bbb.item.DescriptionBlockItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static com.starfish_studios.bbb.registry.BBBItems.*;
import static net.minecraft.world.level.material.PushReaction.DESTROY;

public class BBBBlocks {
    // Stone, Blackstone, Deepslate, Nether Brick, Sandstone, Red Sandstone, Quartz

    // Write a list of every wood block.
    // Trim, Beam, Beam Stairs, Beam Slab, Pallets, Supports, Balustrades, Walls, Frames, Lanterns, Ladders, Lattices
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuildingButBetter.MOD_ID, Registries.BLOCK);

    public static final Map<BBBWoodType, RegistrySupplier<Block>> BALUSTRADES = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Block>> LATTICE = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Block>> WALL = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Block>> BEAM = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Block>> BEAM_STAIRS = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Block>> BEAM_SLAB = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Block>> SUPPORT = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Block>> PALLET = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Block>> LADDER = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Block>> FRAMES = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Block>> LANTERN = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Block>> TRIM = new EnumMap<>(BBBWoodType.class);
    public static final Map<BBBWoodType, RegistrySupplier<Block>> LAYER = new EnumMap<>(BBBWoodType.class);

    static AtomicInteger ladderId = new AtomicInteger();

    public static void register() {

        for (BBBWoodType type : BBBWoodType.values()) {

            RegistrySupplier<Block> balustrade = BLOCKS.register(
                    type.name().toLowerCase() + "_balustrade",
                    () -> new BalustradeBlock(BlockBehaviour.Properties.ofFullCopy(type.getBasePlank()).noOcclusion())
            );
            BALUSTRADES.put(type, balustrade);
            BALUSTRADE_ITEMS.put(type, BBBItems.ITEMS.register(
                    type.name().toLowerCase() + "_balustrade",
                    () -> new DescriptionBlockItem(balustrade.get(), new Item.Properties())
            ));

            RegistrySupplier<Block>  lattice = BLOCKS.register(
                    type.name().toLowerCase() + "_lattice",
                    () -> new LatticeBlock(BlockBehaviour.Properties.ofFullCopy(type.getBasePlank()).noOcclusion().pushReaction(DESTROY))
            );
            LATTICE.put(type, lattice);
            LATTICE_ITEMS.put(type, BBBItems.ITEMS.register(
                    type.name().toLowerCase() + "_lattice",
                    () -> new DescriptionBlockItem(lattice.get(), new Item.Properties())
            ));

            RegistrySupplier<Block> wall = BLOCKS.register(
                    type.name().toLowerCase() + "_wall",
                    () -> new WoodenWallBlock(BlockBehaviour.Properties.ofFullCopy(type.getBasePlank()))
            );
            WALL.put(type, wall);
            WALL_ITEMS.put(type, BBBItems.ITEMS.register(
                    type.name().toLowerCase() + "_wall",
                    () -> new BlockItem(wall.get(), new Item.Properties())
            ));

            RegistrySupplier<Block> beam = BLOCKS.register(
                    type.name().toLowerCase() + "_beam",
                    () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG))
            );
            BEAM.put(type, beam);
            BEAM_ITEMS.put(type, BBBItems.ITEMS.register(
                    type.name().toLowerCase() + "_beam",
                    () -> new BlockItem(beam.get(), new Item.Properties())
            ));

            RegistrySupplier<Block> beamStair = BLOCKS.register(
                    type.name().toLowerCase() + "_beam_stairs",
                    () -> new StairBlock(type.getBasePlank().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(type.getBasePlank()))
            );
            BEAM_STAIRS.put(type, beamStair);
            BEAM_STAIR_ITEMS.put(type, BBBItems.ITEMS.register(
                    type.name().toLowerCase() + "_beam_stairs",
                    () -> new BlockItem(beamStair.get(), new Item.Properties())
            ));

            RegistrySupplier<Block> beamSlab = BLOCKS.register(
                    type.name().toLowerCase() + "_beam_slab",
                    () -> new FacingSlabBlock(BlockBehaviour.Properties.ofFullCopy(type.getBasePlank()))
            );
            BEAM_SLAB.put(type, beamSlab);
            BEAM_SLAB_ITEMS.put(type, BBBItems.ITEMS.register(
                    type.name().toLowerCase() + "_beam_slab",
                    () -> new BlockItem(beamSlab.get(), new Item.Properties())
            ));

            RegistrySupplier<Block> support = BLOCKS.register(
                    type.name().toLowerCase() + "_support",
                    () -> new SupportBlock(BlockBehaviour.Properties.ofFullCopy(type.getBasePlank()).noOcclusion())
            );
            SUPPORT.put(type, support);
            SUPPORT_ITEMS.put(type, BBBItems.ITEMS.register(
                    type.name().toLowerCase() + "_support",
                    () -> new DescriptionBlockItem(support.get(), new Item.Properties())
            ));

            RegistrySupplier<Block> pallet = BLOCKS.register(
                    type.name().toLowerCase() + "_pallet",
                    () -> new PalletBlock(BlockBehaviour.Properties.ofFullCopy(type.getBasePlank()).noOcclusion())
            );
            PALLET.put(type, pallet);
            PALLET_ITEMS.put(type, BBBItems.ITEMS.register(
                    type.name().toLowerCase() + "_pallet",
                    () -> new DescriptionBlockItem(pallet.get(), new Item.Properties())
            ));

            RegistrySupplier<Block> frame = BLOCKS.register(
                    type.name().toLowerCase() + "_frame",
                    () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy(type.getBasePlank()).noOcclusion().noCollission().pushReaction(DESTROY))
            );
            FRAMES.put(type, frame);
            FRAME_ITEMS.put(type, BBBItems.ITEMS.register(
                    type.name().toLowerCase() + "_frame",
                    () -> new DescriptionBlockItem(frame.get(), new Item.Properties())
            ));

            RegistrySupplier<Block> lantern = BLOCKS.register(
                    type.name().toLowerCase() + "_lantern",
                    () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(type.getBasePlank()).lightLevel((blockStatex) -> 15).noOcclusion().pushReaction(DESTROY).strength(0.3F))
            );
            LANTERN.put(type, lantern);
            LANTERN_ITEMS.put(type, BBBItems.ITEMS.register(
                    type.name().toLowerCase() + "_lantern",
                    () -> new DescriptionBlockItem(lantern.get(), new Item.Properties())
            ));

            RegistrySupplier<Block> trim = BLOCKS.register(
                    type.name().toLowerCase() + "_trim",
                    () -> new FacingConnectingBlock(BlockBehaviour.Properties.ofFullCopy(type.getBasePlank()))
            );
            TRIM.put(type, trim);
            TRIM_ITEMS.put(type, BBBItems.ITEMS.register(
                    type.name().toLowerCase() + "_trim",
                    () -> new BlockItem(trim.get(), new Item.Properties())
            ));

            RegistrySupplier<Block> layer = BLOCKS.register(
                    type.name().toLowerCase() + "_layer",
                    () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy(type.getBasePlank()))
            );
            LAYER.put(type, layer);
            LAYER_ITEMS.put(type, BBBItems.ITEMS.register(
                    type.name().toLowerCase() + "_layer",
                    () -> new DescriptionBlockItem(layer.get(), new Item.Properties())
            ));

            if (type != BBBWoodType.BAMBOO) {
                RegistrySupplier<Block> ladder = BLOCKS.register(
                        type.name().toLowerCase() + "_ladder",
                        () -> new BBBLadderBlock(ladderId.getAndIncrement() + 1, BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER))
                );
                LADDER.put(type, ladder);
                LADDER_ITEMS.put(type, BBBItems.ITEMS.register(
                        type.name().toLowerCase() + "_ladder",
                        () -> new DescriptionBlockItem(ladder.get(), new Item.Properties())
                ));
            } else {
                RegistrySupplier<Block> ladder = BLOCKS.register("bamboo_ladder", () -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
                LADDER.put(type, ladder);
                LADDER_ITEMS.put(type, BBBItems.ITEMS.register(
                        "bamboo_ladder",
                        () -> new DescriptionBlockItem(ladder.get(), new Item.Properties())
                ));
            }
        }
    }

    // region BLOCKS
    public static final RegistrySupplier<Block> STONE_BLOCK = BLOCKS.register("stone_block", () -> new BlockBlock(BlockBlock.Types.STONE, BlockBehaviour.Properties.ofFullCopy((Blocks.STONE)).pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> WALL_STONE_BLOCK = BLOCKS.register("wall_stone_block", () -> new WallBlockBlock(BlockBlock.Types.STONE, BlockBehaviour.Properties.ofFullCopy((Blocks.STONE)).pushReaction(DESTROY).dropsLike(STONE_BLOCK.get())));
    public static final RegistrySupplier<Block> BLACKSTONE_BLOCK = BLOCKS.register("blackstone_block", () -> new BlockBlock(BlockBlock.Types.BLACKSTONE, BlockBehaviour.Properties.ofFullCopy((Blocks.BLACKSTONE)).pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> WALL_BLACKSTONE_BLOCK = BLOCKS.register("wall_blackstone_block", () -> new WallBlockBlock(BlockBlock.Types.BLACKSTONE, BlockBehaviour.Properties.ofFullCopy((Blocks.BLACKSTONE)).pushReaction(DESTROY).dropsLike(BLACKSTONE_BLOCK.get())));
    public static final RegistrySupplier<Block> DEEPSLATE_BLOCK = BLOCKS.register("deepslate_block", () -> new BlockBlock(BlockBlock.Types.DEEPSLATE, BlockBehaviour.Properties.ofFullCopy((Blocks.DEEPSLATE)).pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> WALL_DEEPSLATE_BLOCK = BLOCKS.register("wall_deepslate_block", () -> new WallBlockBlock(BlockBlock.Types.DEEPSLATE, BlockBehaviour.Properties.ofFullCopy((Blocks.DEEPSLATE)).pushReaction(DESTROY).dropsLike(DEEPSLATE_BLOCK.get())));
    public static final RegistrySupplier<Block> NETHER_BRICK_BLOCK = BLOCKS.register("nether_brick_block", () -> new BlockBlock(BlockBlock.Types.NETHER_BRICK, BlockBehaviour.Properties.ofFullCopy((Blocks.NETHER_BRICKS)).pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> WALL_NETHER_BRICK_BLOCK = BLOCKS.register("wall_nether_brick_block", () -> new WallBlockBlock(BlockBlock.Types.NETHER_BRICK, BlockBehaviour.Properties.ofFullCopy((Blocks.NETHER_BRICKS)).pushReaction(DESTROY).dropsLike(NETHER_BRICK_BLOCK.get())));
    public static final RegistrySupplier<Block> SANDSTONE_BLOCK = BLOCKS.register("sandstone_block", () -> new BlockBlock(BlockBlock.Types.SANDSTONE, BlockBehaviour.Properties.ofFullCopy((Blocks.SANDSTONE)).pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> WALL_SANDSTONE_BLOCK = BLOCKS.register("wall_sandstone_block", () -> new WallBlockBlock(BlockBlock.Types.SANDSTONE, BlockBehaviour.Properties.ofFullCopy((Blocks.SANDSTONE)).pushReaction(DESTROY).dropsLike(SANDSTONE_BLOCK.get())));
    public static final RegistrySupplier<Block> RED_SANDSTONE_BLOCK = BLOCKS.register("red_sandstone_block", () -> new BlockBlock(BlockBlock.Types.RED_SANDSTONE, BlockBehaviour.Properties.ofFullCopy((Blocks.RED_SANDSTONE)).pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> WALL_RED_SANDSTONE_BLOCK = BLOCKS.register("wall_red_sandstone_block", () -> new WallBlockBlock(BlockBlock.Types.RED_SANDSTONE, BlockBehaviour.Properties.ofFullCopy((Blocks.RED_SANDSTONE)).pushReaction(DESTROY).dropsLike(RED_SANDSTONE_BLOCK.get())));
    public static final RegistrySupplier<Block> QUARTZ_BLOCK = BLOCKS.register("quartz_block", () -> new BlockBlock(BlockBlock.Types.QUARTZ, BlockBehaviour.Properties.ofFullCopy((Blocks.QUARTZ_BLOCK)).pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> WALL_QUARTZ_BLOCK = BLOCKS.register("wall_quartz_block", () -> new WallBlockBlock(BlockBlock.Types.QUARTZ, BlockBehaviour.Properties.ofFullCopy((Blocks.QUARTZ_BLOCK)).pushReaction(DESTROY).dropsLike(QUARTZ_BLOCK.get())));
    // endregion

    // region COLUMNS
    public static final RegistrySupplier<Block> STONE_COLUMN = BLOCKS.register("stone_column", () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.STONE_BRICKS)).noOcclusion()));
    public static final RegistrySupplier<Block> BLACKSTONE_COLUMN = BLOCKS.register("blackstone_column", () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.BLACKSTONE)).noOcclusion()));
    public static final RegistrySupplier<Block> DEEPSLATE_COLUMN = BLOCKS.register("deepslate_column", () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.DEEPSLATE_BRICKS)).noOcclusion()));
    public static final RegistrySupplier<Block> NETHER_BRICK_COLUMN = BLOCKS.register("nether_brick_column", () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.NETHER_BRICKS)).noOcclusion()));
    public static final RegistrySupplier<Block> SANDSTONE_COLUMN = BLOCKS.register("sandstone_column", () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.SANDSTONE)).noOcclusion()));
    public static final RegistrySupplier<Block> RED_SANDSTONE_COLUMN = BLOCKS.register("red_sandstone_column", () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.RED_SANDSTONE)).noOcclusion()));
    public static final RegistrySupplier<Block> QUARTZ_COLUMN = BLOCKS.register("quartz_column", () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.QUARTZ_BLOCK)).noOcclusion()));
    // endregion

    // region URNS
    public static final RegistrySupplier<Block> STONE_URN = BLOCKS.register("stone_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.STONE)).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> BLACKSTONE_URN = BLOCKS.register("blackstone_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.BLACKSTONE)).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> DEEPSLATE_URN = BLOCKS.register("deepslate_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.DEEPSLATE_BRICKS)).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> NETHER_BRICK_URN = BLOCKS.register("nether_brick_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.NETHER_BRICKS)).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> SANDSTONE_URN = BLOCKS.register("sandstone_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.SANDSTONE)).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> RED_SANDSTONE_URN = BLOCKS.register("red_sandstone_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.RED_SANDSTONE)).noOcclusion().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> QUARTZ_URN = BLOCKS.register("quartz_urn", () -> new UrnBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.QUARTZ_BLOCK)).noOcclusion().pushReaction(DESTROY)));
    // endregion

    // region MOULDINGS
    public static final RegistrySupplier<Block> STONE_MOULDING = BLOCKS.register("stone_moulding", () -> new MouldingBlock((Blocks.STONE_BRICKS.defaultBlockState()), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).noOcclusion()));
    public static final RegistrySupplier<Block> BLACKSTONE_MOULDING = BLOCKS.register("blackstone_moulding", () -> new MouldingBlock((Blocks.BLACKSTONE.defaultBlockState()), BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).noOcclusion()));
    public static final RegistrySupplier<Block> DEEPSLATE_MOULDING = BLOCKS.register("deepslate_moulding", () -> new MouldingBlock((Blocks.DEEPSLATE_BRICKS.defaultBlockState()), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).noOcclusion()));
    public static final RegistrySupplier<Block> NETHER_BRICK_MOULDING = BLOCKS.register("nether_brick_moulding", () -> new MouldingBlock((Blocks.NETHER_BRICKS.defaultBlockState()), BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS).noOcclusion()));
    public static final RegistrySupplier<Block> SANDSTONE_MOULDING = BLOCKS.register("sandstone_moulding", () -> new MouldingBlock((Blocks.SANDSTONE.defaultBlockState()), BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).noOcclusion()));
    public static final RegistrySupplier<Block> RED_SANDSTONE_MOULDING = BLOCKS.register("red_sandstone_moulding", () -> new MouldingBlock((Blocks.RED_SANDSTONE.defaultBlockState()), BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE).noOcclusion()));
    public static final RegistrySupplier<Block> QUARTZ_MOULDING = BLOCKS.register("quartz_moulding", () -> new MouldingBlock((Blocks.QUARTZ_BLOCK.defaultBlockState()), BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion()));
    // endregion

    // region STONE FENCES
    public static final RegistrySupplier<Block> STONE_FENCE = BLOCKS.register("stone_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.STONE_BRICKS)).noOcclusion()));
    public static final RegistrySupplier<Block> BLACKSTONE_FENCE = BLOCKS.register("blackstone_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.BLACKSTONE)).noOcclusion()));
    public static final RegistrySupplier<Block> DEEPSLATE_FENCE = BLOCKS.register("deepslate_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.DEEPSLATE_BRICKS)).noOcclusion()));
    public static final RegistrySupplier<Block> NETHER_BRICK_FENCE = BLOCKS.register("nether_brick_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.NETHER_BRICKS)).noOcclusion()));
    public static final RegistrySupplier<Block> SANDSTONE_FENCE = BLOCKS.register("sandstone_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.SANDSTONE)).noOcclusion()));
    public static final RegistrySupplier<Block> RED_SANDSTONE_FENCE = BLOCKS.register("red_sandstone_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.RED_SANDSTONE)).noOcclusion()));
    public static final RegistrySupplier<Block> QUARTZ_FENCE = BLOCKS.register("quartz_fence", () -> new StoneFenceBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.QUARTZ_BLOCK)).noOcclusion()));
    // endregion

    // region LAYERS

    public static final RegistrySupplier<Block> MOSS_LAYER = BLOCKS.register("moss_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.MOSS_BLOCK))));
    public static final RegistrySupplier<Block> STONE_LAYER = BLOCKS.register("stone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.STONE))));
    public static final RegistrySupplier<Block> COBBLESTONE_LAYER = BLOCKS.register("cobblestone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.COBBLESTONE))));
    public static final RegistrySupplier<Block> MOSSY_COBBLESTONE_LAYER = BLOCKS.register("mossy_cobblestone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.MOSSY_COBBLESTONE))));
    public static final RegistrySupplier<Block> SMOOTH_STONE_LAYER = BLOCKS.register("smooth_stone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.SMOOTH_STONE))));
    public static final RegistrySupplier<Block> POLISHED_STONE_LAYER = BLOCKS.register("polished_stone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.SMOOTH_STONE))));
    public static final RegistrySupplier<Block> STONE_TILE_LAYER = BLOCKS.register("stone_tile_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.STONE_BRICKS))));
    public static final RegistrySupplier<Block> STONE_BRICK_LAYER = BLOCKS.register("stone_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.STONE_BRICKS))));
    public static final RegistrySupplier<Block> MOSSY_STONE_BRICK_LAYER = BLOCKS.register("mossy_stone_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.MOSSY_STONE_BRICKS))));
    public static final RegistrySupplier<Block> GRANITE_LAYER = BLOCKS.register("granite_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.GRANITE))));
    public static final RegistrySupplier<Block> POLISHED_GRANITE_LAYER = BLOCKS.register("polished_granite_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.POLISHED_GRANITE))));
    public static final RegistrySupplier<Block> DIORITE_LAYER = BLOCKS.register("diorite_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.DIORITE))));
    public static final RegistrySupplier<Block> POLISHED_DIORITE_LAYER = BLOCKS.register("polished_diorite_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.POLISHED_DIORITE))));
    public static final RegistrySupplier<Block> ANDESITE_LAYER = BLOCKS.register("andesite_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.ANDESITE))));
    public static final RegistrySupplier<Block> POLISHED_ANDESITE_LAYER = BLOCKS.register("polished_andesite_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.POLISHED_ANDESITE))));
    public static final RegistrySupplier<Block> COBBLED_DEEPSLATE_LAYER = BLOCKS.register("cobbled_deepslate_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.COBBLED_DEEPSLATE))));
    public static final RegistrySupplier<Block> POLISHED_DEEPSLATE_LAYER = BLOCKS.register("polished_deepslate_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.POLISHED_DEEPSLATE))));
    public static final RegistrySupplier<Block> DEEPSLATE_BRICK_LAYER = BLOCKS.register("deepslate_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.DEEPSLATE_BRICKS))));
    public static final RegistrySupplier<Block> DEEPSLATE_TILE_LAYER = BLOCKS.register("deepslate_tile_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.DEEPSLATE_TILES))));
    public static final RegistrySupplier<Block> BRICK_LAYER = BLOCKS.register("brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.BRICKS))));
    public static final RegistrySupplier<Block> MUD_BRICK_LAYER = BLOCKS.register("mud_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.MUD_BRICKS))));
    public static final RegistrySupplier<Block> SANDSTONE_LAYER = BLOCKS.register("sandstone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.SANDSTONE))));
    public static final RegistrySupplier<Block> SMOOTH_SANDSTONE_LAYER = BLOCKS.register("smooth_sandstone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.SMOOTH_SANDSTONE))));
    public static final RegistrySupplier<Block> RED_SANDSTONE_LAYER = BLOCKS.register("red_sandstone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.RED_SANDSTONE))));
    public static final RegistrySupplier<Block> SMOOTH_RED_SANDSTONE_LAYER = BLOCKS.register("smooth_red_sandstone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.SMOOTH_RED_SANDSTONE))));
    public static final RegistrySupplier<Block> PRISMARINE_LAYER = BLOCKS.register("prismarine_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.PRISMARINE))));
    public static final RegistrySupplier<Block> PRISMARINE_BRICK_LAYER = BLOCKS.register("prismarine_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.PRISMARINE_BRICKS))));
    public static final RegistrySupplier<Block> DARK_PRISMARINE_LAYER = BLOCKS.register("dark_prismarine_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.DARK_PRISMARINE))));
    public static final RegistrySupplier<Block> NETHER_BRICK_LAYER = BLOCKS.register("nether_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.NETHER_BRICKS))));
    public static final RegistrySupplier<Block> RED_NETHER_BRICK_LAYER = BLOCKS.register("red_nether_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.RED_NETHER_BRICKS))));
    public static final RegistrySupplier<Block> BLACKSTONE_LAYER = BLOCKS.register("blackstone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.BLACKSTONE))));
    public static final RegistrySupplier<Block> POLISHED_BLACKSTONE_LAYER = BLOCKS.register("polished_blackstone_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.POLISHED_BLACKSTONE))));
    public static final RegistrySupplier<Block> POLISHED_BLACKSTONE_BRICK_LAYER = BLOCKS.register("polished_blackstone_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.POLISHED_BLACKSTONE_BRICKS))));
    public static final RegistrySupplier<Block> END_STONE_BRICK_LAYER = BLOCKS.register("end_stone_brick_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.END_STONE_BRICKS))));
    public static final RegistrySupplier<Block> PURPUR_LAYER = BLOCKS.register("purpur_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.PURPUR_BLOCK))));
    public static final RegistrySupplier<Block> QUARTZ_LAYER = BLOCKS.register("quartz_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.QUARTZ_BLOCK))));
    public static final RegistrySupplier<Block> CUT_COPPER_LAYER = BLOCKS.register("cut_copper_layer", () -> new WeatheringCopperLayerBlock(WeatheringCopperLayerBlock.WeatherState.UNAFFECTED, BlockBehaviour.Properties.ofFullCopy((Blocks.CUT_COPPER))));
    public static final RegistrySupplier<Block> EXPOSED_CUT_COPPER_LAYER = BLOCKS.register("exposed_cut_copper_layer", () -> new WeatheringCopperLayerBlock(WeatheringCopperLayerBlock.WeatherState.EXPOSED, BlockBehaviour.Properties.ofFullCopy((Blocks.EXPOSED_CUT_COPPER))));
    public static final RegistrySupplier<Block> WEATHERED_CUT_COPPER_LAYER = BLOCKS.register("weathered_cut_copper_layer", () -> new WeatheringCopperLayerBlock(WeatheringCopperLayerBlock.WeatherState.WEATHERED, BlockBehaviour.Properties.ofFullCopy((Blocks.WEATHERED_CUT_COPPER))));
    public static final RegistrySupplier<Block> OXIDIZED_CUT_COPPER_LAYER = BLOCKS.register("oxidized_cut_copper_layer", () -> new WeatheringCopperLayerBlock(WeatheringCopperLayerBlock.WeatherState.OXIDIZED, BlockBehaviour.Properties.ofFullCopy((Blocks.OXIDIZED_CUT_COPPER))));
    public static final RegistrySupplier<Block> WAXED_CUT_COPPER_LAYER = BLOCKS.register("waxed_cut_copper_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.WAXED_CUT_COPPER))));
    public static final RegistrySupplier<Block> WAXED_EXPOSED_CUT_COPPER_LAYER = BLOCKS.register("waxed_exposed_cut_copper_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.WAXED_EXPOSED_CUT_COPPER))));
    public static final RegistrySupplier<Block> WAXED_WEATHERED_CUT_COPPER_LAYER = BLOCKS.register("waxed_weathered_cut_copper_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.WAXED_WEATHERED_CUT_COPPER))));
    public static final RegistrySupplier<Block> WAXED_OXIDIZED_CUT_COPPER_LAYER = BLOCKS.register("waxed_oxidized_cut_copper_layer", () -> new LayerBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.WAXED_OXIDIZED_CUT_COPPER))));
    // endregion

    // region FRAMES
    public static final RegistrySupplier<Block> STONE_FRAME = BLOCKS.register("stone_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.STONE)).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> BLACKSTONE_FRAME = BLOCKS.register("blackstone_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.BLACKSTONE)).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> DEEPSLATE_FRAME = BLOCKS.register("deepslate_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.DEEPSLATE_BRICKS)).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> NETHER_BRICK_FRAME = BLOCKS.register("nether_brick_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.NETHER_BRICKS)).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> SANDSTONE_FRAME = BLOCKS.register("sandstone_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.SANDSTONE)).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> RED_SANDSTONE_FRAME = BLOCKS.register("red_sandstone_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.RED_SANDSTONE)).noOcclusion().noCollission().pushReaction(DESTROY)));
    public static final RegistrySupplier<Block> QUARTZ_FRAME = BLOCKS.register("quartz_frame", () -> new FrameBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.QUARTZ_BLOCK)).noOcclusion().noCollission().pushReaction(DESTROY)));
    // endregion

    public static final RegistrySupplier<Block> POLISHED_STONE = BLOCKS.register("polished_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy((Blocks.SMOOTH_STONE))));
    public static final RegistrySupplier<Block> POLISHED_STONE_STAIRS = BLOCKS.register("polished_stone_stairs", () -> new StairBlock((Blocks.SMOOTH_STONE.defaultBlockState()), BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final RegistrySupplier<Block> POLISHED_STONE_SLAB = BLOCKS.register("polished_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final RegistrySupplier<Block> STONE_TILES = BLOCKS.register("stone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy((Blocks.STONE_BRICKS))));
    public static final RegistrySupplier<Block> STONE_TILE_STAIRS = BLOCKS.register("stone_tile_stairs", () -> new StairBlock((Blocks.STONE_BRICKS.defaultBlockState()), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final RegistrySupplier<Block> STONE_TILE_SLAB = BLOCKS.register("stone_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));

    public static final RegistrySupplier<Block> BRAZIER = BLOCKS.register("brazier", () -> new BrazierBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.IRON_BLOCK)).lightLevel(lit -> 15).noOcclusion().pushReaction(DESTROY).strength(1.0F, 1.5F)));
    public static final RegistrySupplier<Block> SOUL_BRAZIER = BLOCKS.register("soul_brazier", () -> new BrazierBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.IRON_BLOCK)).lightLevel(lit -> 10).noOcclusion().pushReaction(DESTROY).strength(1.0F, 1.5F)));

    public static final RegistrySupplier<Block> ROPE = BLOCKS.register("rope", () -> new ChainBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.OAK_PLANKS)).forceSolidOn().strength(0.1F).sound(SoundType.WOOL).noOcclusion()));

    public static final RegistrySupplier<Block> IRON_FENCE = BLOCKS.register("iron_fence", () -> new IronFenceBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.IRON_BARS)).noOcclusion()));

    //public static final Block TALL_OAK_DOOR = BLOCKS.register("tall_oak_door", () -> new TallDoorBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.OAK_PLANKS)).noOcclusion(), BlockSetType.OAK));

    // public static final Block COPPER_GATEWAY = BLOCKS.register("copper_gateway", () -> new GatewayBlock(BlockBehaviour.Properties.ofFullCopy((Blocks.OAK_DOOR)).noOcclusion()));

}
