package com.ferriolli.xtragems.items.tools;

import com.ferriolli.xtragems.Init.ModItems;
import com.ferriolli.xtragems.Main;
import com.ferriolli.xtragems.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;

public class ToolHoe extends ItemHoe implements IHasModel {
    public ToolHoe(String name, Item.ToolMaterial material){
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
