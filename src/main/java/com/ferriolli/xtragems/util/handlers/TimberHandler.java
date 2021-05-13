package com.ferriolli.xtragems.util.handlers;

import com.ferriolli.xtragems.Init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class TimberHandler {

    @SubscribeEvent
    public static void blockBreak(BlockEvent.BreakEvent event){
        World worldIn = event.getPlayer().getEntityWorld();
        if(!worldIn.isRemote){
            if(event.getPlayer().isSneaking()){
                return;
            }
            if(event.getPlayer().getHeldItemMainhand().getItem() == ModItems.UNIVERSAL_AXE){
                if(!event.getPlayer().isCreative()){
                    //encontra os blocos para quebrar
                }
            }
        }
    }
}
