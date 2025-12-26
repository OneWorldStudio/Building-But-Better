package com.starfish_studios.bbb.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

import static com.starfish_studios.bbb.BuildingButBetter.MOD_ID;

@Environment(value= EnvType.CLIENT)
public class BBBModelLayers {

    public static final ModelLayerLocation STONE_BLOCK = new ModelLayerLocation(new ResourceLocation(MOD_ID, "stone_block"), "main");
    public static final ModelLayerLocation BLACKSTONE_BLOCK = new ModelLayerLocation(new ResourceLocation(MOD_ID, "blackstone_block"), "main");
    public static final ModelLayerLocation DEEPSLATE_BLOCK = new ModelLayerLocation(new ResourceLocation(MOD_ID, "deepslate_block"), "main");
    public static final ModelLayerLocation NETHER_BRICK_BLOCK = new ModelLayerLocation(new ResourceLocation(MOD_ID, "nether_brick_block"), "main");
    public static final ModelLayerLocation SANDSTONE_BLOCK = new ModelLayerLocation(new ResourceLocation(MOD_ID, "sandstone_block"), "main");
    public static final ModelLayerLocation RED_SANDSTONE_BLOCK = new ModelLayerLocation(new ResourceLocation(MOD_ID, "red_sandstone_block"), "main");
    public static final ModelLayerLocation QUARTZ_BLOCK = new ModelLayerLocation(new ResourceLocation(MOD_ID, "quartz_block"), "main");


    public static void register() {
        EntityModelLayerRegistry.registerModelLayer(STONE_BLOCK, BlockModel::createBlockModel);
        EntityModelLayerRegistry.registerModelLayer(BLACKSTONE_BLOCK, BlockModel::createBlockModel);
        EntityModelLayerRegistry.registerModelLayer(DEEPSLATE_BLOCK, BlockModel::createBlockModel);
        EntityModelLayerRegistry.registerModelLayer(NETHER_BRICK_BLOCK, BlockModel::createBlockModel);
        EntityModelLayerRegistry.registerModelLayer(SANDSTONE_BLOCK, BlockModel::createBlockModel);
        EntityModelLayerRegistry.registerModelLayer(RED_SANDSTONE_BLOCK, BlockModel::createBlockModel);
        EntityModelLayerRegistry.registerModelLayer(QUARTZ_BLOCK, BlockModel::createBlockModel);
    }
}
