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
        GameRegistry.addSmelting(ModBlocks.BLACK_GEM_ORE, new ItemStack(ModItems.BLACK_GEM, 1), 5f);
        GameRegistry.addSmelting(ModBlocks.BLOODSTONE_ORE, new ItemStack(ModItems.BLOODSTONE, 1), 5f);
        GameRegistry.addSmelting(ModBlocks.TOPAZ_ORE, new ItemStack(ModItems.TOPAZ, 1), 5f);
        GameRegistry.addSmelting(ModItems.GLASS_SHARD, new ItemStack(ModItems.REINFORCED_GLASS_SHARD, 1), 5F);
        GameRegistry.addSmelting(ModItems.ANIMAL_FAT_BOTTLE, new ItemStack(ModItems.OIL_BOTTLE, 1), 10F);
    }
}
