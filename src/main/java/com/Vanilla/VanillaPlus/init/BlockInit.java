package com.Vanilla.VanillaPlus.init;

import com.Vanilla.VanillaPlus.VanillaPlus;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = VanillaPlus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(VanillaPlus.MOD_ID)
public class BlockInit {
    public static final Block example_block = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f,15.0f).sound(SoundType.SAND)).setRegistryName("example_block"));
    }

    @SubscribeEvent
    public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new BlockItem(example_block, new Item.Properties().group(ItemGroup.FOOD)).setRegistryName("example_block"));
    }
}
