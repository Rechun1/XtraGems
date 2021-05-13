package com.ferriolli.xtragems.items.tools;

import com.ferriolli.xtragems.Init.ModItems;
import com.ferriolli.xtragems.Main;
import com.ferriolli.xtragems.items.ItemBase;
import com.ferriolli.xtragems.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToolEnderitePickaxe extends ItemPickaxe implements IHasModel {
    public ToolEnderitePickaxe(String name, ToolMaterial material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.TOOLS);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.clientProxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        Random rand = new Random();
        if(!worldIn.isRemote){
            BlockPos pos = rayTrace(playerIn, 5, 1.0F).getBlockPos();
            IBlockState state = worldIn.getBlockState(pos);
            Block blockIn = state.getBlock();
            if(blockIn == Blocks.STONE|| blockIn == Blocks.GRASS || blockIn == Blocks.DIRT){
                InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Item.getItemFromBlock(state.getBlock())));
                worldIn.setBlockToAir(pos);
                System.out.println("***" + Item.getItemFromBlock(state.getBlock()));
                worldIn.playSound(null, pos, SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.BLOCKS, 1, 1);
                stack.damageItem(1, playerIn);
                return new ActionResult(EnumActionResult.SUCCESS, stack);
            }
        }
        return new ActionResult(EnumActionResult.FAIL, stack);
    }

    public RayTraceResult rayTrace(EntityPlayer playerIn, double blockReachDistance, float partialTicks) {
        Vec3d vec3d = playerIn.getPositionEyes(partialTicks);
        Vec3d vec3d1 = playerIn.getLook(partialTicks);
        Vec3d vec3d2 = vec3d.addVector(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        return playerIn.world.rayTraceBlocks(vec3d, vec3d2, false, false, true);
    }
}