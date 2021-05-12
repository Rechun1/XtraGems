package com.ferriolli.xtragems.items.tools.specialItems;

import com.ferriolli.xtragems.Init.ModBlocks;
import com.ferriolli.xtragems.Init.ModItems;
import com.ferriolli.xtragems.Main;
import com.ferriolli.xtragems.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.List;
import java.util.Random;

public class ItemMidasStaff extends Item implements IHasModel {
    public ItemMidasStaff(String name) {
        this.setMaxStackSize(1);
        this.setMaxDamage(100);
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
        tooltip.add("\u00A7a" + "Right click stone or dirt");
        tooltip.add("\u00A7a" + "to create ore");
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if(!worldIn.isRemote){
            BlockPos pos = rayTrace(playerIn, 8, 1.0F).getBlockPos();
            IBlockState state = worldIn.getBlockState(pos);
            Block blockIn = state.getBlock();
            Random random = new Random();
            if(blockIn == Blocks.STONE || blockIn == Blocks.DIRT){
                int randomNum = random.nextInt(100);
                System.out.println(randomNum);
                if(randomNum <= 4){
                    worldIn.setBlockState(pos,Blocks.DIAMOND_ORE.getDefaultState());
                }
                if(randomNum >= 6 && randomNum <= 10){
                    worldIn.setBlockState(pos, ModBlocks.RUBY_ORE.getDefaultState());
                }
                if(randomNum >= 11 && randomNum <= 20){
                    worldIn.setBlockState(pos, ModBlocks.AMETHYST_ORE.getDefaultState());
                }
                if(randomNum >= 21 && randomNum <= 30){
                    worldIn.setBlockState(pos,Blocks.EMERALD_ORE.getDefaultState());
                }
                if(randomNum >= 31 && randomNum <= 45){
                    worldIn.setBlockState(pos, ModBlocks.TOPAZ_ORE.getDefaultState());
                }
                if(randomNum >= 46 && randomNum <= 60){
                    worldIn.setBlockState(pos, ModBlocks.TURQUOISE_ORE.getDefaultState());
                }
                if(randomNum >= 61 && randomNum <= 80){
                    worldIn.setBlockState(pos,Blocks.GOLD_ORE.getDefaultState());
                }
                if(randomNum >= 81){
                    worldIn.setBlockState(pos,Blocks.IRON_ORE.getDefaultState());
                }

                playerIn.getEntityWorld().playSound(null, playerIn.getPosition(), SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.HOSTILE, 1.0F, 0F);
                stack.damageItem(1, playerIn);
            }
            return new ActionResult(EnumActionResult.SUCCESS, stack);
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
