package com.ferriolli.xtragems.Init;

import com.ferriolli.xtragems.Main;
import com.ferriolli.xtragems.util.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemCustomFood extends ItemFood implements IHasModel {
    int healAmount;

    public ItemCustomFood(String name, int hungerAmount, int healAmount, boolean isWolfFood) {
        super(hungerAmount, isWolfFood);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.FOOD);

        this.healAmount = healAmount;

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.clientProxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if(!worldIn.isRemote){
            player.heal(healAmount);
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        if(stack.getItem() == ModItems.HAMBURGER){
            tooltip.add(TextFormatting.GOLD + "Uhh, tastes like oil");
        }
    }
}
