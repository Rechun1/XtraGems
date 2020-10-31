package com.ferriolli.xtragems.blocks;

import com.ferriolli.xtragems.Init.ModItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class RubyOre extends BlockBase{
    public RubyOre(String name, Material material) {
        super(name, material);
        setSoundType(SoundType.STONE);
        setHardness(5);
        setResistance(30f);
        setHarvestLevel("pickaxe", 2);
    }
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ModItems.RUBY;
    }

    public int quantityDropped(IBlockState state, int fortune, Random random) {
        return 1;
    }
}
