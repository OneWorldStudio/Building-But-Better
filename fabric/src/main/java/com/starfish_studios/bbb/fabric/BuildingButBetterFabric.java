package com.starfish_studios.bbb.fabric;

import com.starfish_studios.bbb.event.BlockUseEvent;
import dev.architectury.event.events.common.InteractionEvent;
import net.fabricmc.api.ModInitializer;

import com.starfish_studios.bbb.BuildingButBetter;

public final class BuildingButBetterFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        BuildingButBetter.init();
    }
}
