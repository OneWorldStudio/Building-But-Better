package com.starfish_studios.bbb.forge;

import com.starfish_studios.bbb.client.model.BlockModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.starfish_studios.bbb.client.model.BBBModelLayers.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BBBClientEventForge {

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(STONE_BLOCK, BlockModel::createBlockModel);
        event.registerLayerDefinition(BLACKSTONE_BLOCK, BlockModel::createBlockModel);
        event.registerLayerDefinition(DEEPSLATE_BLOCK, BlockModel::createBlockModel);
        event.registerLayerDefinition(NETHER_BRICK_BLOCK, BlockModel::createBlockModel);
        event.registerLayerDefinition(SANDSTONE_BLOCK, BlockModel::createBlockModel);
        event.registerLayerDefinition(RED_SANDSTONE_BLOCK, BlockModel::createBlockModel);
        event.registerLayerDefinition(QUARTZ_BLOCK, BlockModel::createBlockModel);
    }
}
