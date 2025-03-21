package com.starfish_studios.bbb.registry;

import com.starfish_studios.bbb.BuildingButBetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;

import static com.starfish_studios.bbb.BuildingButBetter.MOD_ID;

public interface BBBTags {

    // region BLOCK TAGS
    interface BBBBlockTags {
        TagKey<Block> CHISEL_STONE = TagKey.create(Registries.BLOCK, BuildingButBetter.id("chisel_stone"));
        TagKey<Block> URNS = TagKey.create(Registries.BLOCK, BuildingButBetter.id("urns"));

        TagKey<Block> BALUSTRADES = TagKey.create(Registries.BLOCK, BuildingButBetter.id("balustrades"));


        TagKey<Block> METAL_FENCES = TagKey.create(Registries.BLOCK, BuildingButBetter.id("metal_fences"));
        TagKey<Block> MOULDINGS = TagKey.create(Registries.BLOCK, BuildingButBetter.id("mouldings"));
        TagKey<Block> HEDGES = TagKey.create(Registries.BLOCK, BuildingButBetter.id("hedges"));
        TagKey<Block> STONE_BALUSTRADES = TagKey.create(Registries.BLOCK, BuildingButBetter.id("stone_balustrades"));

        TagKey<Block> STONE_FENCES = TagKey.create(Registries.BLOCK, BuildingButBetter.id("stone_fences"));
        TagKey<Block> FRAMES = TagKey.create(Registries.BLOCK, BuildingButBetter.id("frames"));
        TagKey<Block> STONE_FRAMES = TagKey.create(Registries.BLOCK, BuildingButBetter.id("stone_frames"));
        TagKey<Block> SUPPORTS = TagKey.create(Registries.BLOCK, BuildingButBetter.id("supports"));
        TagKey<Block> PALLETS = TagKey.create(Registries.BLOCK, BuildingButBetter.id("pallets"));
        TagKey<Block> COLUMNS = TagKey.create(Registries.BLOCK, BuildingButBetter.id("columns"));
        TagKey<Block> LAYERS = TagKey.create(Registries.BLOCK, BuildingButBetter.id("layers"));
    }
    // endregion

    // region ITEM TAGS
    interface BBBItemTags {

        TagKey<Item> BALUSTRADES = TagKey.create(Registries.ITEM, BuildingButBetter.id("balustrades"));
        TagKey<Item> URNS = TagKey.create(Registries.ITEM, BuildingButBetter.id("urns"));
        TagKey<Item> LATTICES = TagKey.create(Registries.ITEM, BuildingButBetter.id("lattices"));

        TagKey<Item> CHISEL_STONE = TagKey.create(Registries.ITEM, BuildingButBetter.id("chisel/stone"));

        TagKey<Item> LANTERNS = TagKey.create(Registries.ITEM, BuildingButBetter.id("lanterns"));
        TagKey<Item> MOULDINGS = TagKey.create(Registries.ITEM, BuildingButBetter.id("mouldings"));
        TagKey<Item> FRAMES = TagKey.create(Registries.ITEM, BuildingButBetter.id("frames"));
        TagKey<Item> STONE_FRAMES = TagKey.create(Registries.ITEM, BuildingButBetter.id("stone_frames"));
        TagKey<Item> SUPPORTS = TagKey.create(Registries.ITEM, BuildingButBetter.id("supports"));
        TagKey<Item> PALLETS = TagKey.create(Registries.ITEM, BuildingButBetter.id("pallets"));
        TagKey<Item> COLUMNS = TagKey.create(Registries.ITEM, BuildingButBetter.id("columns"));
        TagKey<Item> LAYERS = TagKey.create(Registries.ITEM, BuildingButBetter.id("layers"));
        TagKey<Item> LADDERS = TagKey.create(Registries.ITEM, BuildingButBetter.id("ladders"));
        TagKey<Item> HAMMERS = TagKey.create(Registries.ITEM, BuildingButBetter.id("hammers"));
        TagKey<Item> STONE_FENCES = TagKey.create(Registries.ITEM, BuildingButBetter.id("stone_fences"));
    }

    interface BBBEnchantmentTags {
        TagKey<Enchantment> PREVENTS_BRAZIER_DAMAGE = TagKey.create(Registries.ENCHANTMENT, BuildingButBetter.id("prevents_brazier_damage"));
    }

}
