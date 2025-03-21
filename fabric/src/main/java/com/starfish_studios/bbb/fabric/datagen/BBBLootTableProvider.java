package com.starfish_studios.bbb.fabric.datagen;

import com.starfish_studios.bbb.registry.BBBBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class BBBLootTableProvider extends FabricBlockLootTableProvider {

    public BBBLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
       // dropSelf(BBBBlocks.OAK_FRAME);
    }
}
