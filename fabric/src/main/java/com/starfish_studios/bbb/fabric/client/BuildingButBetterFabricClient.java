package com.starfish_studios.bbb.fabric.client;

import com.google.common.reflect.Reflection;
import com.starfish_studios.bbb.BuildingButBetterClient;
import com.starfish_studios.bbb.client.model.BBBModelLayers;
import net.fabricmc.api.ClientModInitializer;

public final class BuildingButBetterFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BuildingButBetterClient.init();
        BBBModelLayers.register();
    }
}
