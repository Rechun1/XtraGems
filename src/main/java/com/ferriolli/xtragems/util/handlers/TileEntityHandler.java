package com.ferriolli.xtragems.util.handlers;

import com.ferriolli.xtragems.blocks.gemrefiner.TileEntityGemRefiner;
import com.ferriolli.xtragems.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
    public static void registerTileEntities(){
        GameRegistry.registerTileEntity(TileEntityGemRefiner.class, new ResourceLocation(Reference.MOD_ID + ":gem_refiner"));
    }
}
