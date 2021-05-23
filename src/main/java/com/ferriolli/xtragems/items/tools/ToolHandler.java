package com.ferriolli.xtragems.items.tools;

import com.ferriolli.xtragems.Init.ModBlocks;
import com.ferriolli.xtragems.Init.ModItems;
import com.ferriolli.xtragems.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.gen.feature.WorldGenWaterlily;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import com.ferriolli.xtragems.items.tools.specialItems.ItemWindStaff;

import java.util.Random;

@Mod.EventBusSubscriber
public class ToolHandler {
    @SubscribeEvent
    public static void fieryPick(BlockEvent.HarvestDropsEvent event) {
        if (event.getHarvester() != null) {
            EntityPlayer entityBreaker = event.getHarvester();
            if (!entityBreaker.getEntityWorld().isRemote) {
                if (entityBreaker.getHeldItemMainhand().getItem() == ModItems.FIERY_PICKAXE) {
                    Block dBlock = event.getState().getBlock();
                    int level = event.getFortuneLevel();
                    Random random = new Random();
                    if (level > 0) {
                        int droppedAmount = random.nextInt(level) + 1;
                        if (dBlock == Blocks.IRON_ORE) {
                            for (int i = 0; i <= droppedAmount; i++) {
                                event.getDrops().add(new ItemStack(Items.IRON_INGOT));
                            }
                            event.getDrops().remove(0);
                            return;
                        }
                        if (dBlock == Blocks.GOLD_ORE) {
                            for (int i = 0; i <= droppedAmount; i++) {
                                event.getDrops().add(new ItemStack(Items.GOLD_INGOT));
                            }
                            event.getDrops().remove(0);
                        }
                        if (dBlock == ModBlocks.BLACK_GEM_ORE) {
                            for (int i = 0; i <= droppedAmount; i++) {
                                event.getDrops().add(new ItemStack(ModItems.BLACK_GEM));
                            }
                            event.getDrops().remove(0);
                        }
                    } else {
                        if (dBlock == Blocks.IRON_ORE) {
                            event.getDrops().add(new ItemStack(Items.IRON_INGOT));
                            event.getDrops().remove(0);
                        }
                        if (dBlock == Blocks.GOLD_ORE) {
                            event.getDrops().add(new ItemStack(Items.GOLD_INGOT));
                            event.getDrops().remove(0);
                        }
                        if (dBlock == ModBlocks.BLACK_GEM_ORE) {
                            event.getDrops().add(new ItemStack(ModItems.BLACK_GEM));
                            event.getDrops().remove(0);
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void breakGlassChance(BlockEvent.BreakEvent event) {
        if (event.getPlayer() != null) {
            EntityPlayer entityBreaker = event.getPlayer();
            if (entityBreaker.getHeldItemMainhand().getItem() == ModItems.GLASS_AXE || entityBreaker.getHeldItemMainhand().getItem() == ModItems.GLASS_PICKAXE || entityBreaker.getHeldItemMainhand().getItem() == ModItems.GLASS_HOE || entityBreaker.getHeldItemMainhand().getItem() == ModItems.GLASS_SHOVEL) {
                Random random = new Random();
                int chance = random.nextInt(21);
                if (chance == 1) {
                    entityBreaker.getHeldItemMainhand().damageItem(9999, event.getPlayer());
                }
            }
        }
    }

    /*@SubscribeEvent
    public static void cancelFallDamage(LivingFallEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof EntityPlayer && entity != null) {
            EntityPlayer playerIn = (EntityPlayer) entity;
            Item itemInHand = playerIn.getHeldItemMainhand().getItem();
            if(!playerIn.world.isRemote){
                if(playerIn.inventory.armorItemInSlot(0).getItem() == ModItems.ENDERITE_BOOTS
                        && playerIn.inventory.armorItemInSlot(1).getItem() == ModItems.ENDERITE_LEGGINGS
                        && playerIn.inventory.armorItemInSlot(2).getItem() == ModItems.ENDERITE_CHESTPLATE
                        && playerIn.inventory.armorItemInSlot(3).getItem() == ModItems.ENDERITE_HELMET
                        && itemInHand == ModItems.ENDERITE_TOTEM){
                    event.setCanceled(true);
                }
            }
        }
    }*/
}