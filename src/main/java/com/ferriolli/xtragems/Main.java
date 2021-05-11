package com.ferriolli.xtragems;

import com.ferriolli.xtragems.Init.ModSmeltingRecipes;
import com.ferriolli.xtragems.items.tools.ToolHandler;
import com.ferriolli.xtragems.items.tools.specialItems.ItemWindStaff;
import com.ferriolli.xtragems.proxy.ClientProxy;
import com.ferriolli.xtragems.proxy.CommonProxy;
import com.ferriolli.xtragems.util.Reference;

//import com.ferriolli.xtragems.util.handlers.TileEntityHandler;
import com.ferriolli.xtragems.world.ModWorldGen;
import com.ferriolli.xtragems.world.ModWorldGenCustomStructures;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.logging.Logger;


@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)

public class Main {
    @Instance
    public static Main instance;

    /*@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;*/

    public static CommonProxy serverProxy = new CommonProxy();
    public static ClientProxy clientProxy = new ClientProxy();

    @EventHandler
    public static void PreInit(FMLPreInitializationEvent event)
    {
        GameRegistry.registerWorldGenerator(new ModWorldGenCustomStructures(), 0);
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
        MinecraftForge.EVENT_BUS.register(new ToolHandler());
    }

    @EventHandler
    public static void init(FMLInitializationEvent event)
    {
        ModSmeltingRecipes.Init();
    }

    @EventHandler
    public static void PostInit(FMLPostInitializationEvent event)
    {

    }
}
