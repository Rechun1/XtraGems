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
import net.minecraft.world.gen.structure.template.Template;
import net.minecraftforge.fml.common.IWorldGenerator;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.Random;

public class ModWorldGenCustomStructures implements IWorldGenerator {
    public final ModWorldGenStructure ABANDONED_TOWER = new ModWorldGenStructure("tower");
    public final ModWorldGenStructure CAMP = new ModWorldGenStructure("camp");
    public final ModWorldGenStructure DESERT_TEMPLE = new ModWorldGenStructure("desert_temple");
    public final ModWorldGenStructure SWAMP_DEPOSIT = new ModWorldGenStructure("swamp_deposit");
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        switch (world.provider.getDimension()){
            case 1:
                break;
            case 0:
                generateStructure(ABANDONED_TOWER, world, random, chunkX, chunkZ, 1000, BiomePlains.class, BiomeDesert.class, BiomeForest.class, BiomeBeach.class, BiomeMesa.class, BiomeSavanna.class, BiomeHills.class, BiomeSnow.class);
                generateStructure(CAMP, world, random, chunkX, chunkZ, 600, BiomePlains.class);
                generateStructure(DESERT_TEMPLE, world, random, chunkX, chunkZ, 600, BiomeDesert.class);
                generateStructure(SWAMP_DEPOSIT, world, random, chunkX, chunkZ, 500, BiomeSwamp.class);
                break;
            case -1:
                break;
        }
    }
    private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Class<?>... classes){
        ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));

        int x = (chunkX * 16) + random.nextInt(15);
        int z = (chunkZ * 16) + random.nextInt(15);
        int y = calculateGenerationHeight(world, x, z);
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

    public static int calculateGenerationHeight(World world, int x, int z){
        int y = world.getHeight();
        boolean foundGround = false;

        while(!foundGround && y-- >= 0){
            Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
            foundGround = block == Blocks.GRASS || block == Blocks.SAND || block == Blocks.STONE;
        }

        return y;
    }

    public static boolean canSpawnHere(Template template, World worldIn, BlockPos posAboveGround){
        int zSize = template.getSize().getZ();
        int xSize = template.getSize().getX();

        boolean corner1 = isCornerValid(worldIn, posAboveGround);
        boolean corner2 = isCornerValid(worldIn, posAboveGround.add(xSize, 0 ,zSize));

        return posAboveGround.getY() > 30 && corner1 && corner2;
    }

    public static boolean isCornerValid(World worldIn, BlockPos pos){
        int variation = 3;
        int highestBlock = calculateGenerationHeight(worldIn, pos.getX(), pos.getZ());
        return highestBlock > pos.getY() - variation && highestBlock < pos.getY() + variation;
    }
}
