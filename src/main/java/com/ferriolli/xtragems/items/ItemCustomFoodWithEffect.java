package com.ferriolli.xtragems.items;

import com.ferriolli.xtragems.Init.ModItems;
import com.ferriolli.xtragems.Main;
import com.ferriolli.xtragems.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

import java.util.ArrayList;
import java.util.List;

public class ItemCustomFoodWithEffect extends ItemFood implements IHasModel {
    //PotionEffect effect;
    //public final int itemUseDuration;

    public ItemCustomFoodWithEffect(String name, int amount, boolean isWolfFood/*, PotionEffect effect*/){
        super(amount, isWolfFood);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.FOOD);

        //this.effect = effect;
        //this.itemUseDuration = 32;

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.clientProxy.registerItemRenderer(this, 0, "inventory");
    }

    /*@Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if(!worldIn.isRemote){
            player.addPotionEffect(new PotionEffect(effect));
            System.out.println("aplicou efeito");
        }
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 32;
    }*/
}