package com.starfish_studios.bbb.forge;

import com.starfish_studios.bbb.BuildingButBetterClient;

import com.starfish_studios.bbb.BuildingButBetter;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(BuildingButBetter.MOD_ID)
public final class BuildingButBetterForge {

    public BuildingButBetterForge(IEventBus modEventBus, ModContainer modContainer) {
        BuildingButBetter.init();
        if (FMLEnvironment.dist.isClient()) {
            modEventBus.addListener(BBBClientEventForge::registerLayerDefinitions);
        }
        modEventBus.addListener(BuildingButBetterForge::onClientSetup);
    }
    private static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(BuildingButBetterClient::init);
    }
}
