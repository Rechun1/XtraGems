package com.ferriolli.xtragems.items.tools;

import com.ferriolli.xtragems.Init.ModItems;
import com.ferriolli.xtragems.Main;
import com.ferriolli.xtragems.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;

public class ToolPickaxe extends ItemPickaxe implements IHasModel {
    public ToolPickaxe(String name, ToolMaterial material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.TOOLS);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        //Main.proxy.registerItemRenderer(this, 0, "inventory");
        Main.clientProxy.registerItemRenderer(this, 0, "inventory");
    }
}
