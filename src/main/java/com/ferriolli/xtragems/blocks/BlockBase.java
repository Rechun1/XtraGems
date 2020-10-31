package com.ferriolli.xtragems.blocks;

import com.ferriolli.xtragems.Init.ModBlocks;
import com.ferriolli.xtragems.Init.ModItems;
import com.ferriolli.xtragems.Main;
import com.ferriolli.xtragems.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
    public BlockBase(String name, Material material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Main.clientProxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
