package com.ferriolli.xtragems.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlackGemOre extends BlockBase{
    public BlackGemOre(String name, Material material) {
        super(name, material);
        setSoundType(SoundType.STONE);
        setHardness(5);
        setResistance(30f);
        setHarvestLevel("pickaxe", 3);
    }
}
