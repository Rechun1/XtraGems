package com.ferriolli.xtragems.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class FiriteOre extends BlockBase{
    public FiriteOre(String name, Material material) {
        super(name, material);
        setSoundType(SoundType.STONE);
        setHardness(10);
        setResistance(30f);
        setHarvestLevel("pickaxe", 3);
    }
}
