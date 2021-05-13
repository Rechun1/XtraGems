package com.ferriolli.xtragems.Init;

import com.ferriolli.xtragems.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block RUBY_BLOCK = new RubyBlock("ruby_block", Material.IRON);
    public static final Block TOPAZ_BLOCK = new TopazBlock("topaz_block", Material.IRON);
    public static final Block BLOODSTONE_ORE = new BloodstoneOre("bloodstone_ore", Material.ROCK);
    public static final Block RUBY_ORE = new RubyOre("ruby_ore", Material.ROCK);
    public static final Block FIRITE_ORE = new FiriteOre("firite_ore", Material.ROCK);
    public static final Block AMETHYST_ORE = new AmethystOre("amethyst_ore", Material.ROCK);
    public static final Block TOPAZ_ORE = new TopazOre("topaz_ore", Material.ROCK);
    public static final Block BLACK_GEM_ORE = new BlackGemOre("black_gem_ore", Material.ROCK);
    public static final Block AMETHYST_BLOCK = new AmethystBlock("amethyst_block", Material.ROCK);
    public static final Block TURQUOISE_ORE = new TurquoiseOre("turquoise_ore", Material.ROCK);
    public static final GemRefiner GEM_REFINER = new GemRefiner("gem_refiner", Material.IRON);
    public static final Block ENDERITE_ORE = new EnderiteOre("enderite_ore", Material.ROCK);

}