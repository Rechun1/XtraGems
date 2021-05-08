package com.ferriolli.xtragems.blocks.gemrefiner;

import com.ferriolli.xtragems.Init.ModBlocks;
import com.ferriolli.xtragems.Init.ModItems;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Map;

public class GemRefinerRecipes {
    private static final GemRefinerRecipes INSTANCE = new GemRefinerRecipes();
    private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    public static GemRefinerRecipes getInstance(){
        return INSTANCE;
    }

    private GemRefinerRecipes(){
        addRefiningRecipe(new ItemStack(ModItems.AMETHYST), new ItemStack(Items.QUARTZ), new ItemStack(ModItems.VIOLET_QUARTZ), 5.0F);
        addRefiningRecipe(new ItemStack(ModItems.RUBY), new ItemStack(Items.DIAMOND), new ItemStack(ModItems.BLOODY_DIAMOND), 5.0F);
        addRefiningRecipe(new ItemStack(ModItems.TOPAZ), new ItemStack(Items.ENDER_PEARL), new ItemStack(ModItems.AMBER_PEARL), 5.0F);
        addRefiningRecipe(new ItemStack(ModItems.TURQUOISE), new ItemStack(Items.EMERALD), new ItemStack(ModItems.AZURE_EMERALD), 5.0F);
        addRefiningRecipe(new ItemStack(ModBlocks.BLACK_GEM_ORE), new ItemStack(Items.BLAZE_POWDER), new ItemStack(ModItems.BLACK_GEM), 5.0F);
        addRefiningRecipe(new ItemStack(ModItems.BLACK_GEM), new ItemStack(ModItems.UNREFINED_FIRITE_GEM), new ItemStack(ModItems.FIRITE_GEM), 5.0F);
        addRefiningRecipe(new ItemStack(ModItems.BLACK_GEM), new ItemStack(Items.ENDER_PEARL), new ItemStack(ModItems.INFUSED_BLACK_GEM), 5.0F);
        addRefiningRecipe(new ItemStack(ModItems.INFUSED_BLACK_GEM), new ItemStack(ModItems.BLOODY_DIAMOND), new ItemStack(ModItems.RUBY_INFUSED_BLACK_GEM), 5.0F);
        addRefiningRecipe(new ItemStack(ModItems.INFUSED_BLACK_GEM), new ItemStack(ModItems.VIOLET_QUARTZ), new ItemStack(ModItems.AMETHYST_INFUSED_BLACK_GEM), 5.0F);
        addRefiningRecipe(new ItemStack(ModItems.INFUSED_BLACK_GEM), new ItemStack(ModItems.AZURE_EMERALD), new ItemStack(ModItems.TURQUOISE_INFUSED_BLACK_GEM), 5.0F);
        addRefiningRecipe(new ItemStack(ModItems.INFUSED_BLACK_GEM), new ItemStack(ModItems.AMBER_PEARL), new ItemStack(ModItems.TOPAZ_INFUSED_BLACK_GEM), 5.0F);
    }

    public void addRefiningRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience){
        if(getRefiningResult(input1, input2) != ItemStack.EMPTY) return;
        this.smeltingList.put(input1, input2, result);
        this.smeltingList.put(input2, input1, result);
        this.experienceList.put(result, Float.valueOf(experience));
    }

    public ItemStack getRefiningResult(ItemStack input1, ItemStack input2){
        for(Map.Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()){
            if(this.compareItemStacks(input1, (ItemStack)entry.getKey())){
                for(Map.Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()){
                    if(this.compareItemStacks(input2, (ItemStack)ent.getKey())){
                        return(ItemStack)ent.getValue();
                    }
                }
            }
        }
        return ItemStack.EMPTY;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2){
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Table<ItemStack, ItemStack, ItemStack>getDualSmeltingList(){
        return this.smeltingList;
    }

    public float GetRefiningExperience(ItemStack stack){
        for(Map.Entry<ItemStack, Float> entry : this.experienceList.entrySet()){
            if(this.compareItemStacks(stack, (ItemStack)entry.getKey())){
                return((Float)entry.getValue()).floatValue();
            }
        }
        return 0.0F;
    }
}
