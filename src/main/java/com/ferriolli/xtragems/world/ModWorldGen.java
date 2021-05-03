package com.ferriolli.xtragems.world;

import com.ferriolli.xtragems.Init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class ModWorldGen implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if(world.provider.getDimension() == 0){
            generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }
        if (world.provider.getDimension() == -1){
            generateNether(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }
    }

    private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider){
        generateOre(ModBlocks.RUBY_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 16, random.nextInt(6) + 1, 5);
        generateOre(ModBlocks.TURQUOISE_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 16, random.nextInt(6) + 1, 5);
        generateOre(ModBlocks.TOPAZ_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 32, random.nextInt(5) + 1, 10);
        generateOre(ModBlocks.AMETHYST_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 64, random.nextInt(5) + 1, 8);
    }

    private void generateNether(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider){
        generateOreNether(ModBlocks.BLACK_GEM_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 125, random.nextInt(4) + 2, 18);
    }

    private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances){
        int deltaY = maxY - minY;

        for (int i = 0; i < chances; i++){
            BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));
            WorldGenMinable generator = new WorldGenMinable(ore, size);
            generator.generate(world, random, pos);
        }
    }

    private void generateOreNether(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances){
        int deltaY = maxY - minY;
        for (int i = 0; i < chances; i++){
            BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));
            WorldGenMinable generator = new WorldGenMinable(ore, size, BlockMatcher.forBlock(Blocks.NETHERRACK));
            for(EnumFacing direction : EnumFacing.VALUES){
                BlockPos fromPos = pos.offset(direction);
                IBlockState state = world.getBlockState(fromPos);
                Block blockIn = state.getBlock();
                if(blockIn == Blocks.AIR){
                    generator.generate(world, random, pos);
                }
            }
        }
    }
}
