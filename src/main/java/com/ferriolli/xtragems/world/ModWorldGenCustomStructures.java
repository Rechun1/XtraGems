package com.ferriolli.xtragems.world;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.*;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.Random;

public class ModWorldGenCustomStructures implements IWorldGenerator {
    public final ModWorldGenStructure MINER_HOUSE = new ModWorldGenStructure("miner_house");
    public final ModWorldGenStructure RUINED_HOUSE = new ModWorldGenStructure("ruined_house");
    public final ModWorldGenStructure ABANDONED_TOWER = new ModWorldGenStructure("abandoned_tower");
    public final ModWorldGenStructure CAMP = new ModWorldGenStructure("camp");
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        switch (world.provider.getDimension()){
            case 1:

                break;

            case 0:
                    generateStructure(MINER_HOUSE, world, random, chunkX, chunkZ, 100, Blocks.GRASS, BiomePlains.class);
                    generateStructure(RUINED_HOUSE, world, random, chunkX, chunkZ, 100, Blocks.GRASS, BiomePlains.class);
                    generateStructure(ABANDONED_TOWER, world, random, chunkX, chunkZ, 100, Blocks.GRASS, BiomePlains.class, BiomeDesert.class, BiomeForest.class, BiomeBeach.class, BiomeMesa.class, BiomeSavanna.class, BiomeHills.class, BiomeSnow.class);
                    generateStructure(CAMP, world, random, chunkX, chunkZ, 1000, Blocks.GRASS, BiomePlains.class);
                break;
            case -1:
                break;
        }
    }
    private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes){
        ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));

        int x = (chunkX * 16) + random.nextInt(15);
        int z = (chunkZ * 16) + random.nextInt(15);
        int y = calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x, y, z);

        Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();

        if (world.getWorldType() != WorldType.FLAT){
            if(classesList.contains(biome)){
                if (random.nextInt(chance)== 0){
                    generator.generate(world, random, pos);
                }
            }
        }
    }

    private int calculateGenerationHeight(World world, int x, int z, Block topBlock){
        int y = world.getHeight();
        boolean foundGround = false;

        while(!foundGround && y-- >= 0){
            Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
            foundGround = block == topBlock;
        }

        return y;
    }
}
