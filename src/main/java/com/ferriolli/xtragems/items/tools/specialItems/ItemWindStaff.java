package com.ferriolli.xtragems.items.tools.specialItems;

import com.ferriolli.xtragems.Init.ModItems;
import com.ferriolli.xtragems.Main;
import com.ferriolli.xtragems.blocks.gemrefiner.GemRefinerRecipes;
import com.ferriolli.xtragems.util.IHasModel;
import com.ferriolli.xtragems.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.Sys;

import java.util.List;

@Mod.EventBusSubscriber(value = { Side.CLIENT })
public class ItemWindStaff extends Item implements IHasModel {
    public boolean cancelDamage;
    public ItemWindStaff() {
        this.setMaxStackSize(1);
        this.setMaxDamage(256);
        this.setUnlocalizedName("wind_staff");
        this.setRegistryName("wind_staff");
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
            this.cancelDamage = true;
            playerIn.getEntityWorld().playSound(null, playerIn.getPosition(), SoundEvents.ENTITY_FIREWORK_LAUNCH, SoundCategory.HOSTILE, 1.0F, 1F);
            playerIn.addVelocity(vec.x * 2, vec.y * 2, vec.z * 2);
            playerIn.velocityChanged = true;
            playerIn.fallDistance = -1000;
            System.out.println(playerIn.fallDistance);
            //System.out.println(this.cancelDamage);
            //TODO: corrigir player tomando dano após uso único do staff -> TESTAR
            stack.damageItem(1, playerIn);
            return new ActionResult(EnumActionResult.SUCCESS, stack);
        }
        return new ActionResult(EnumActionResult.FAIL, stack);
    }

    public void setCancelDamage(){
        this.cancelDamage = false;
    }

    public boolean getCancelDamage(){
        return this.cancelDamage;
    }

    public ItemWindStaff getInstance(){
        return this;
    }
}