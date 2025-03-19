package com.starfish_studios.bbb.fabric.datagen;

import com.starfish_studios.bbb.registry.BBBBlocks;
import com.starfish_studios.bbb.registry.BBBItems;
import com.starfish_studios.bbb.registry.BBBWoodType;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;

public class BBBModelProvider extends FabricModelProvider {
    public BBBModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createGenericCube(BBBBlocks.STONE_TILES.get());
        blockStateModelGenerator.createGenericCube(BBBBlocks.POLISHED_STONE.get());

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(BBBItems.FRAME_ITEMS.get(BBBWoodType.OAK).get(), ModelTemplates.FLAT_HANDHELD_ITEM);
    }
}
