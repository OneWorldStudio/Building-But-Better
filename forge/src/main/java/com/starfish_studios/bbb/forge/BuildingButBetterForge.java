package com.starfish_studios.bbb.forge;

import com.starfish_studios.bbb.BuildingButBetterClient;
import com.starfish_studios.bbb.client.model.BlockModel;
import com.starfish_studios.bbb.registry.BBBBlocks;
import dev.architectury.platform.forge.EventBuses;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.starfish_studios.bbb.BuildingButBetter;
import net.minecraftforge.fml.loading.FMLEnvironment;

import static com.starfish_studios.bbb.client.model.BBBModelLayers.*;

@Mod(BuildingButBetter.MOD_ID)
public final class BuildingButBetterForge {
    public BuildingButBetterForge() {

        var bus = FMLJavaModLoadingContext.get().getModEventBus();

        EventBuses.registerModEventBus(BuildingButBetter.MOD_ID, bus);

        BuildingButBetter.init();
        if (FMLEnvironment.dist.isClient()) {
            bus.addListener(BBBClientEventForge::registerLayerDefinitions);
        }
        bus.addListener(BuildingButBetterForge::onClientSetup);
    }
    private static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(BuildingButBetterClient::init);
    }


}
