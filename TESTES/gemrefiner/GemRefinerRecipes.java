package com.ferriolli.xtragems.blocks.gemrefiner;

import com.ferriolli.xtragems.Init.ModBlocks;
import com.ferriolli.xtragems.Init.ModItems;
import it.unimi.dsi.fastutil.Maps;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Map;

public class GemRefinerRecipes{
    private static final GemRefinerRecipes REFINING_BASE = new GemRefinerRecipes();

    private final Map<ItemStack, ItemStack> refiningList = Maps.<ItemStack, ItemStack>newHashMap();
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    public static GemRefinerRecipes instance(){
        return (REFINING_BASE);
    }

    public GemRefinerRecipes(){
        this.addRefiningRecipeForBlock(ModBlocks.FIRITE_ORE, new ItemStack(ModItems.FIRITE_GEM), 0.6f);
    }

    public void addRefiningRecipeForBlock(Block input, ItemStack stack, float experience){
        this.addRefiningRecipeForBlock(Item.getItemFromBlock(input), stack, experience);
    }

    public void addRefining(Item input, ItemStack stack, float experience){
        this.addRefiningRecipeForBlock(new ItemStack(input, 1, 32767), stack, experience);
    }

    public void addRefiningRecipe(ItemStack input, ItemStack stack, float experience){
        if(getRefiningResult(input) != ItemStack.EMPTY){
            net.minecraftforge.fml.common.FMLLog.info("Ignored recipe with conflicting input : () = ()", input, stack) return;
        }
        this.refiningList.put(input, stack);
        this.experienceList.put(stack, Float.valueOf(experience));
    }

    public ItemStack getRefiningResult(ItemStack stack)
    {
        for (Map.Entry<ItemStack, ItemStack> entry : this.refiningList.entrySet())
        {
            if (this.compareItemStacks(stack, entry.getKey()))
            {
                return entry.getValue();
            }
        }

        return ItemStack.EMPTY;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<ItemStack, ItemStack> getCookingList()
    {
        return this.refiningList;
    }

    public float getCookingExperience(ItemStack stack)
    {
        float ret = stack.getItem().getSmeltingExperience(stack);
        if (ret != -1) return ret;
        for (Map.Entry<ItemStack, Float> entry : this.experienceList.entrySet())
        {
            if (this.compareItemStacks(stack, entry.getKey()))
            {
                return ((Float)entry.getValue()).floatValue();
            }
        }
        return 0.0F;
    }


}
