package com.ferriolli.xtragems.items.tools.specialItems;

import com.ferriolli.xtragems.Init.ModItems;
import com.ferriolli.xtragems.Main;
import com.ferriolli.xtragems.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.lwjgl.Sys;

import java.util.List;

public class ItemWindStaff extends Item implements IHasModel {
    public ItemWindStaff(String name) {
        this.setMaxStackSize(1);
        this.setMaxDamage(256);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(CreativeTabs.COMBAT);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.clientProxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced){
        tooltip.add("\u00A7a" + "Right click to fly");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        Vec3d vec = playerIn.getLookVec().normalize();
        if(!worldIn.isRemote){
            playerIn.getEntityWorld().playSound(null, playerIn.getPosition(), SoundEvents.ENTITY_FIREWORK_LAUNCH, SoundCategory.HOSTILE, 1.0F, 1F);
            playerIn.addVelocity(vec.x * 2, vec.y * 2, vec.z * 2);
            playerIn.velocityChanged = true;
            //TODO: corrigir player tomando dano após uso único do staff
            playerIn.fallDistance = -1000;
            stack.damageItem(1, playerIn);
            return new ActionResult(EnumActionResult.SUCCESS, stack);
        }
        return new ActionResult(EnumActionResult.FAIL, stack);
    }
}