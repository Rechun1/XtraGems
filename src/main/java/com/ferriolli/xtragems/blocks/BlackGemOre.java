package com.ferriolli.xtragems.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlackGemOre extends BlockBase{
    public BlackGemOre(String name, Material material) {
        super(name, material);
        setSoundType(SoundType.STONE);
        setHardness(5);
        setResistance(30f);
        setHarvestLevel("pickaxe", 3);
    }

    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
    {
        return 30;
    }
}
