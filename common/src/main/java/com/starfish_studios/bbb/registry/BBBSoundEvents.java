package com.starfish_studios.bbb.registry;

import com.starfish_studios.bbb.BuildingButBetter;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class BBBSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuildingButBetter.MOD_ID, Registries.SOUND_EVENT);

    public static RegistrySupplier<SoundEvent> LAYER_HAMMER = register("block.layer.hammer");

    public static RegistrySupplier<SoundEvent>  register(String name) {
        ResourceLocation id = BuildingButBetter.id(name);
        return SOUNDS.register(id, () -> SoundEvent.createVariableRangeEvent(id));
    }
}
