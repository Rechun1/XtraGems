package com.ferriolli.xtragems.items.tools;

import com.ferriolli.xtragems.Init.ModItems;
import com.ferriolli.xtragems.Main;
import com.ferriolli.xtragems.items.ItemBase;
import com.ferriolli.xtragems.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ToolPickaxe extends ItemPickaxe implements IHasModel {
    public ToolPickaxe(String name, ToolMaterial material) {
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
    //Descobrir como fazer esse método rodar, aparentemente não está rodando.
    @SubscribeEvent
    public static void fieryPick(BlockEvent.HarvestDropsEvent event) {
        if (event.getHarvester() instanceof EntityPlayer) {
            EntityPlayer entityBreaker = event.getHarvester();
            if (entityBreaker.getHeldItemMainhand() == new ItemStack(ModItems.FIERY_PICKAXE)) {
                Block dBlock = event.getState().getBlock();
                if (dBlock == Blocks.IRON_ORE) {
                    event.getDrops().add(new ItemStack(Items.IRON_INGOT));
                    event.getDrops().remove(0);
                    return;
                }
                if (dBlock == Blocks.GOLD_ORE) {
                    event.getDrops().add(new ItemStack(Items.GOLD_INGOT));
                    event.getDrops().remove(0);
                    return;
                }
            }
        }
    }
}
