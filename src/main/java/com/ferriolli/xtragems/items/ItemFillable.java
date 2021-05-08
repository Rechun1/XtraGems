package com.ferriolli.xtragems.items;


import com.ferriolli.xtragems.Init.ModItems;
import com.ferriolli.xtragems.Main;
import com.ferriolli.xtragems.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemFillable extends Item implements IHasModel {

    public ItemFillable(String name) {
        this.setMaxStackSize(16);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(CreativeTabs.MISC);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.clientProxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, EnumHand hand) {
        World worldIn = playerIn.getEntityWorld();
        ItemStack itemstack = playerIn.getHeldItemMainhand();
        if(!worldIn.isRemote){
            if(target instanceof EntityHorse){
                this.fillItem(itemstack, playerIn, ModItems.FILLED_POTENAY_BOTTLE);
                return true;
            }
        }
        return false;
    }

    private ItemStack fillItem(ItemStack emptyItems, EntityPlayer player, Item fullItem)
    {
        if (player.capabilities.isCreativeMode)
        {
            return emptyItems;
        }
        else
        {
            emptyItems.shrink(1);
            player.getEntityWorld().playSound(null, player.getPosition(), SoundEvents.ENTITY_COW_MILK, SoundCategory.HOSTILE, 1.0F, 1.0F);
            if (emptyItems.isEmpty())
            {
                player.inventory.addItemStackToInventory(new ItemStack(fullItem));
                return new ItemStack(fullItem);
            }
            else
            {
                if (!player.inventory.addItemStackToInventory(new ItemStack(fullItem)))
                {
                    player.dropItem(new ItemStack(fullItem), false);
                }

                return emptyItems;
            }
        }
    }
}
