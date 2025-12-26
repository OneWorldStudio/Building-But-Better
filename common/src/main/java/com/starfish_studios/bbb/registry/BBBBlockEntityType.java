package com.starfish_studios.bbb.registry;

import com.starfish_studios.bbb.BuildingButBetter;
import com.starfish_studios.bbb.block.entity.BlockBlockEntity;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class BBBBlockEntityType {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuildingButBetter.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<BlockBlockEntity>> BLOCK =
            BLOCK_ENTITY_TYPES.register("block", () ->
                    BlockEntityType.Builder.of(
                            BlockBlockEntity::new,
                            BBBBlocks.STONE_BLOCK.get(),
                            BBBBlocks.WALL_STONE_BLOCK.get(),
                            BBBBlocks.BLACKSTONE_BLOCK.get(),
                            BBBBlocks.WALL_BLACKSTONE_BLOCK.get(),
                            BBBBlocks.DEEPSLATE_BLOCK.get(),
                            BBBBlocks.WALL_DEEPSLATE_BLOCK.get(),
                            BBBBlocks.NETHER_BRICK_BLOCK.get(),
                            BBBBlocks.WALL_NETHER_BRICK_BLOCK.get(),
                            BBBBlocks.SANDSTONE_BLOCK.get(),
                            BBBBlocks.WALL_SANDSTONE_BLOCK.get(),
                            BBBBlocks.RED_SANDSTONE_BLOCK.get(),
                            BBBBlocks.WALL_RED_SANDSTONE_BLOCK.get(),
                            BBBBlocks.QUARTZ_BLOCK.get(),
                            BBBBlocks.WALL_QUARTZ_BLOCK.get()
                    ).build(null)
            );
}
