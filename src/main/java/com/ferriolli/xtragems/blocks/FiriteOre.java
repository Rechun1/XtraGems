package com.ferriolli.xtragems.blocks;

import com.ferriolli.xtragems.Init.ModBlocks;
import com.ferriolli.xtragems.Init.ModItems;
import com.ferriolli.xtragems.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import org.lwjgl.Sys;

public class FiriteOre extends BlockBase{
    public FiriteOre(String name, Material material) {
        super(name, material);
        setSoundType(SoundType.STONE);
        setHardness(10);
        setResistance(30f);
        setHarvestLevel("pickaxe", 3);
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        EntityItem item = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.FIRITE_GEM));
        if(!worldIn.isRemote) {
            for (EnumFacing direction : EnumFacing.VALUES) {
                fromPos = pos.offset(direction);
                state = worldIn.getBlockState(fromPos);
                blockIn = state.getBlock();
                if (blockIn == Blocks.LAVA || blockIn == Blocks.FLOWING_LAVA) {
                    //breakBlock(worldIn, pos, worldIn.getBlockState(pos));
                    worldIn.setBlockToAir(pos);
                    worldIn.playSound(null, pos, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 1, 1);
                    worldIn.spawnEntity(item);
                }
            }
        }
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        EntityItem item = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.FIRITE_GEM));
        if (!worldIn.isRemote){
            for (EnumFacing direction : EnumFacing.VALUES){
                BlockPos fromPos = pos.offset(direction);
                state = worldIn.getBlockState(fromPos);
                Block blockIn = state.getBlock();
                if(blockIn == Blocks.LAVA || blockIn == Blocks.FLOWING_LAVA){
                    worldIn.setBlockToAir(pos);
                    worldIn.playSound(null, pos, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 1, 1);
                    worldIn.spawnEntity(item);
                    break;
                }
            }
            return;
        }

    }
}