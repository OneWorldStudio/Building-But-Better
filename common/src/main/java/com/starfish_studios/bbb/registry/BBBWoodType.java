package com.starfish_studios.bbb.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public enum BBBWoodType {
    OAK(Blocks.OAK_PLANKS),
    SPRUCE(Blocks.SPRUCE_PLANKS),
    BIRCH(Blocks.BIRCH_PLANKS),
    JUNGLE(Blocks.JUNGLE_PLANKS),
    ACACIA(Blocks.ACACIA_PLANKS),
    DARK_OAK(Blocks.DARK_OAK_PLANKS),
    CRIMSON(Blocks.CRIMSON_PLANKS),
    WARPED(Blocks.WARPED_PLANKS),
    MANGROVE(Blocks.MANGROVE_PLANKS),
    BAMBOO(Blocks.BAMBOO_PLANKS),
    CHERRY(Blocks.CHERRY_PLANKS);

    private final Block basePlank;

    BBBWoodType(Block basePlank) {
        this.basePlank = basePlank;
    }

    public Block getBasePlank() {
        return basePlank;
    }
}

