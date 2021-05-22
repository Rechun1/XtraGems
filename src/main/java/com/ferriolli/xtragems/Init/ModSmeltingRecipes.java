package com.ferriolli.xtragems.Init;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModSmeltingRecipes {

    public static void Init(){
        GameRegistry.addSmelting(ModBlocks.RUBY_ORE, new ItemStack(ModItems.RUBY, 1), 5f);
        GameRegistry.addSmelting(ModBlocks.AMETHYST_ORE, new ItemStack(ModItems.AMETHYST, 1), 5f);
        GameRegistry.addSmelting(ModBlocks.TOPAZ_ORE, new ItemStack(ModItems.TOPAZ, 1), 5f);
        GameRegistry.addSmelting(ModBlocks.TURQUOISE_ORE, new ItemStack(ModItems.TURQUOISE, 1),5F);
        GameRegistry.addSmelting(ModItems.GLASS_SHARD, new ItemStack(ModItems.REINFORCED_GLASS_SHARD, 1), 5F);
        GameRegistry.addSmelting(ModItems.ANIMAL_FAT_BOTTLE, new ItemStack(ModItems.OIL_BOTTLE, 1), 10F);
        GameRegistry.addSmelting(ModBlocks.ENDERITE_ORE, new ItemStack(ModItems.ENDERITE_INGOT, 1), 5F);
    }
}
