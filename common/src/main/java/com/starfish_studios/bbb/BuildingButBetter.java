package com.starfish_studios.bbb;

import com.google.common.reflect.Reflection;
import com.starfish_studios.bbb.event.BlockUseEvent;
import com.starfish_studios.bbb.registry.*;
import dev.architectury.event.events.common.InteractionEvent;
import eu.midnightdust.lib.config.MidnightConfig;
import net.minecraft.resources.ResourceLocation;

public final class BuildingButBetter {
    public static final String MOD_ID = "bbb";

    public static ResourceLocation id(String name){
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }

    public static void init() {
        MidnightConfig.init(MOD_ID, BBBConfig.class);

        //if(FabricLoader.getInstance().isModLoaded("everycomp")){
          //  EveryCompat.ACTIVE_MODULES.put(MOD_ID, new BBBModule(MOD_ID));
        //}

        //BlockUseEvent.EVENT.register(new BlockUseEvent());


        InteractionEvent.RIGHT_CLICK_BLOCK.register(BlockUseEvent::interact);

        BBBBlocks.register();
        BBBBlocks.BLOCKS.register();
        BBBItems.ITEMS.register();
        BBBBlockEntityType.BLOCK_ENTITY_TYPES.register();
        BBBCreativeModeTab.TABS.register();
        Reflection.initialize(
                BBBSoundEvents.class
        );
    }
}
