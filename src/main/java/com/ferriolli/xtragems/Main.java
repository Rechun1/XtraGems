package com.ferriolli.xtragems;

import com.ferriolli.xtragems.Init.ModSmeltingRecipes;
import com.ferriolli.xtragems.proxy.ClientProxy;
import com.ferriolli.xtragems.proxy.CommonProxy;
import com.ferriolli.xtragems.util.Reference;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
