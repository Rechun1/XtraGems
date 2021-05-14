package com.ferriolli.xtragems.util.handlers;

import com.ferriolli.xtragems.Init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.Sys;

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
                    if(event.getState().getBlock() == Blocks.LOG || event.getState().getBlock() == Blocks.LOG2){
                        IBlockState iState = worldIn.getBlockState(event.getPos());
                        findBlocksToBreak(worldIn, event.getPlayer(), new ArrayList<BlockPos>(), event.getState().getBlock(), event.getPos());
                    }
                }
            }
        }
    }

    /**
     * This function finds blocks around the beggining position where the block is broken in the event on blockBreak
     * @param worldIn the player's world
     * @param player the player that broke the block
     * @param list a list with all the positions of the blocks to be broken
     * @param blockIn the block to be broken
     * @param pos the position of the first broken block
     */
    public static void findBlocksToBreak(World worldIn, EntityPlayer player, ArrayList<BlockPos> list, Block blockIn, BlockPos pos){

        if(worldIn.getBlockState(pos.up()).getBlock() == blockIn){
            list.add(pos.up());
        }
        if(worldIn.getBlockState(pos.down()).getBlock() == blockIn){
            list.add(pos.down());
        }
        if(worldIn.getBlockState(pos.south()).getBlock() == blockIn){
            list.add(pos.south());
        }
        if(worldIn.getBlockState(pos.north()).getBlock() == blockIn){
            list.add(pos.north());
        }
        if(worldIn.getBlockState(pos.east()).getBlock() == blockIn){
            list.add(pos.east());
        }
        if(worldIn.getBlockState(pos.west()).getBlock() == blockIn){
            list.add(pos.west());
        }

        if(list.size() <= 0){
            list = null;
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            BlockPos posToBreak = list.get(i);
            IBlockState state = worldIn.getBlockState(posToBreak);
            System.out.println(state.getBlock().getRegistryName());
            chopWood(worldIn, posToBreak, state);
            findBlocksToBreak(worldIn, player, new ArrayList<BlockPos>(), blockIn, posToBreak);
        }
    }

    /**
     * This functions sets blocks found on "findBlocksToBreak" to air and drops the items from that block.
     * Meta verifications were made to prevent the game from dropping items with no texture when breaking sideways logs.
     * @param worldIn the player's world
     * @param pos the position to break the block
     * @param state the blockstate at the position (pos)
     */
    public static void chopWood(World worldIn, BlockPos pos, IBlockState state){
        worldIn.setBlockToAir(pos);
        int meta = state.getBlock().getMetaFromState(state);
        if(meta >= 4 && meta < 8) meta -= 4;
        if(meta >= 8) meta -= 8;
        InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(state.getBlock(), 1, meta));
    }
}