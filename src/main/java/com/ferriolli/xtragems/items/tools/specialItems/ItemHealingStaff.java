package com.ferriolli.xtragems.items.tools.specialItems;

import com.ferriolli.xtragems.Init.ModItems;
import com.ferriolli.xtragems.Main;
import com.ferriolli.xtragems.util.IHasModel;
import net.minecraft.block.BlockFurnace;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import java.util.List;

public class ItemHealingStaff extends Item implements IHasModel {
    public ItemHealingStaff(String name){
        this.setMaxStackSize(1);
        this.setMaxDamage(100);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(CreativeTabs.COMBAT);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        //Main.proxy.registerItemRenderer(this, 0, "inventory");
        Main.clientProxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced){
        tooltip.add("\u00A7a" + "Right click an entity to heal it");
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, EnumHand handIn) {
        ItemStack itemStack = playerIn.getHeldItem(handIn);
        World worldIn = playerIn.getEntityWorld();
        if(!worldIn.isRemote && target.getHealth() < target.getMaxHealth()){
            target.heal(2);
            playerIn.getEntityWorld().playSound(null, playerIn.getPosition(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.HOSTILE, 1.0F, 2F);
            itemStack.damageItem(1, playerIn);
            return true;
        }
        return false;
    }

}
