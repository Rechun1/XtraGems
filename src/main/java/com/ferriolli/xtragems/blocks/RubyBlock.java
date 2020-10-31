package com.ferriolli.xtragems.blocks;

import com.ferriolli.xtragems.Init.ModItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class RubyBlock extends BlockBase{
    public RubyBlock(String name, Material material) {
        super(name, material);
        setSoundType(SoundType.METAL);
        setHardness(5f);
        setResistance(15f);
        setHarvestLevel("pickaxe", 2);
        setLightLevel(10);
    }
}
