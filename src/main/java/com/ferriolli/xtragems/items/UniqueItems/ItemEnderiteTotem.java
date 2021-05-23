package com.ferriolli.xtragems.items.UniqueItems;

import com.ferriolli.xtragems.Init.ModItems;
import com.ferriolli.xtragems.Main;
import com.ferriolli.xtragems.util.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemEnderiteTotem extends Item implements IHasModel {
    public ItemEnderiteTotem(String name){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.TOOLS);
        this.setMaxStackSize(1);
        this.setMaxDamage(463);
        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.clientProxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(TextFormatting.DARK_BLUE + "Special armor required!");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if(playerIn.inventory.armorItemInSlot(0).getItem() == ModItems.ENDERITE_BOOTS && playerIn.inventory.armorItemInSlot(1).getItem() == ModItems.ENDERITE_LEGGINGS
        && playerIn.inventory.armorItemInSlot(2).getItem() == ModItems.ENDERITE_CHESTPLATE && playerIn.inventory.armorItemInSlot(3).getItem() == ModItems.ENDERITE_HELMET){
            if(!playerIn.isPotionActive(MobEffects.LEVITATION)){
                playerIn.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 999999, 19));
                playerIn.fallDistance = -1000;
                stack.damageItem(1, playerIn);
            }
            else{
                playerIn.removeActivePotionEffect(Potion.getPotionById(25));
                playerIn.fallDistance = -1000;
            }
            return new ActionResult<>(EnumActionResult.SUCCESS, stack);
        }
        return new ActionResult<>(EnumActionResult.FAIL, stack);
    }
}