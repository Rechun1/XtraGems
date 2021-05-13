package com.ferriolli.xtragems.blocks;

import com.ferriolli.xtragems.Init.ModBlocks;
import com.ferriolli.xtragems.Init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class EnderiteOre extends BlockBase {
    public EnderiteOre(String name, Material material) {
        super(name, material);
        setSoundType(SoundType.STONE);
        setHardness(3);
        setResistance(30f);
        setHarvestLevel("pickaxe", 3);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(ModBlocks.ENDERITE_ORE);
    }

    public int quantityDropped(IBlockState state, int fortune, Random random) {
        return 1;
    }

    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
    {
        return 0;
    }
}