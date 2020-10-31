package com.ferriolli.xtragems.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class AmethystBlock extends BlockBase{
    public AmethystBlock(String name, Material material) {
        super(name, material);
        setSoundType(SoundType.METAL);
        setHardness(5f);
        setResistance(15f);
        setHarvestLevel("pickaxe", 2);
    }
}
