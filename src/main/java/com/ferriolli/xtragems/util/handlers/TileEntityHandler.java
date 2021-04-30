package com.ferriolli.xtragems.util.handlers;

import com.ferriolli.xtragems.blocks.TileEntityGemRefiner;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
    public static void registerTileEntity(){
        GameRegistry.registerTileEntity(TileEntityGemRefiner.class, "gem_refiner");
    }
}
