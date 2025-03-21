package com.starfish_studios.bbb.forge;

import com.starfish_studios.bbb.client.model.BlockModel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import static com.starfish_studios.bbb.client.model.BBBModelLayers.*;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
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
