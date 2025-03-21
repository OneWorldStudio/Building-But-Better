package com.starfish_studios.bbb.fabric.datagen;

import com.starfish_studios.bbb.registry.BBBBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.block.Blocks;
import org.intellij.lang.annotations.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class BBBRecipeProvider extends FabricRecipeProvider {

    public BBBRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        smeltingResultFromBase(exporter, Blocks.SMOOTH_STONE, BBBBlocks.POLISHED_STONE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BBBBlocks.STONE_TILES.get(), 4)
                .pattern("##")
                .pattern("##")
                .define('#', Blocks.STONE_BRICKS)
                .unlockedBy("has_stone", has(Blocks.STONE))
                .save(exporter);

    }
}
