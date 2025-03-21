package com.starfish_studios.bbb.client.model;

import com.starfish_studios.bbb.BuildingButBetter;
import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

import static com.starfish_studios.bbb.BuildingButBetter.MOD_ID;

@Environment(value= EnvType.CLIENT)
public class BBBModelLayers {

    public static final ModelLayerLocation STONE_BLOCK = new ModelLayerLocation(BuildingButBetter.id("stone_block"), "main");
    public static final ModelLayerLocation BLACKSTONE_BLOCK = new ModelLayerLocation(BuildingButBetter.id("blackstone_block"), "main");
    public static final ModelLayerLocation DEEPSLATE_BLOCK = new ModelLayerLocation(BuildingButBetter.id("deepslate_block"), "main");
    public static final ModelLayerLocation NETHER_BRICK_BLOCK = new ModelLayerLocation(BuildingButBetter.id("nether_brick_block"), "main");
    public static final ModelLayerLocation SANDSTONE_BLOCK = new ModelLayerLocation(BuildingButBetter.id("sandstone_block"), "main");
    public static final ModelLayerLocation RED_SANDSTONE_BLOCK = new ModelLayerLocation(BuildingButBetter.id("red_sandstone_block"), "main");
    public static final ModelLayerLocation QUARTZ_BLOCK = new ModelLayerLocation(BuildingButBetter.id("quartz_block"), "main");


    public static void register() {
        EntityModelLayerRegistry.register(STONE_BLOCK, BlockModel::createBlockModel);
        EntityModelLayerRegistry.register(BLACKSTONE_BLOCK, BlockModel::createBlockModel);
        EntityModelLayerRegistry.register(DEEPSLATE_BLOCK, BlockModel::createBlockModel);
        EntityModelLayerRegistry.register(NETHER_BRICK_BLOCK, BlockModel::createBlockModel);
        EntityModelLayerRegistry.register(SANDSTONE_BLOCK, BlockModel::createBlockModel);
        EntityModelLayerRegistry.register(RED_SANDSTONE_BLOCK, BlockModel::createBlockModel);
        EntityModelLayerRegistry.register(QUARTZ_BLOCK, BlockModel::createBlockModel);
    }
}
