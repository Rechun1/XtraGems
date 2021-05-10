package com.ferriolli.xtragems.Init;

import com.ferriolli.xtragems.enchants.*;
import com.ferriolli.xtragems.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.Sys;

import javax.naming.event.ObjectChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EnchantmentInit {
    public static final List<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();

    public static final Enchantment DAMAGE_HEAL = new EnchantmentDamageHeal(Enchantment.Rarity.RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
    public static final Enchantment MINER_TEST = new EnchantmentMinerTest(Enchantment.Rarity.RARE, EnumEnchantmentType.DIGGER, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
    public static final Enchantment KNOWLEDGE = new EnchantmentKnowledge(Enchantment.Rarity.RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
    public static final Enchantment CATACLYSM = new EnchantmentCataclysm(Enchantment.Rarity.UNCOMMON, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
    //Enchant de mob dropar cabeça
    //TODO: Enchant de quebrar árvore
    @SubscribeEvent
    public static void vampirism(LivingDeathEvent event){
        Object attacker = event.getSource().getTrueSource();
        if (attacker instanceof EntityPlayer){
            EntityPlayer entityAttacker = (EntityPlayer)attacker;
            if(!entityAttacker.getEntityWorld().isRemote){
                int level = EnchantmentHelper.getEnchantmentLevel(DAMAGE_HEAL, entityAttacker.getHeldItemMainhand());
                if (level > 0){
                    entityAttacker.heal(level);
                }
            }
        }
    }

    @SubscribeEvent
    public static void minerTest(BlockEvent.HarvestDropsEvent event){
        if(event.getHarvester() instanceof EntityPlayer){
            EntityPlayer player = event.getHarvester();
            if(!event.getHarvester().getEntityWorld().isRemote){
                Block dBlock = event.getState().getBlock();
                int level = EnchantmentHelper.getEnchantmentLevel(MINER_TEST, player.getHeldItemMainhand());
                if(dBlock == Blocks.STONE){
                    Random random = new Random();
                    if(level > 0){
                        int chosenNumber = random.nextInt(2);
                        switch (chosenNumber){
                            case 0:
                                event.getDrops().add(new ItemStack(Items.IRON_INGOT));
                                break;
                            case 1:
                                event.getDrops().add(new ItemStack(Items.GOLD_INGOT));
                                break;
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void knowledge(LivingExperienceDropEvent event){
        Object attacker = event.getAttackingPlayer();
        EntityLivingBase entityAttacker = (EntityLivingBase)attacker;
        if (attacker instanceof EntityLivingBase){
            int level = EnchantmentHelper.getEnchantmentLevel(KNOWLEDGE, entityAttacker.getHeldItemMainhand());
            if (level > 0){
                //Minecraft.getMinecraft().player.sendChatMessage("xp dropado: " + event.getOriginalExperience() + ", level 1: " + event.getOriginalExperience() * 1 * 1.5F + ", level 2: " + event.getOriginalExperience() * 2 * 1.5F + ", level 3: " + event.getOriginalExperience() * 3 * 1.5F);
                int droppedXp = (int) Math.ceil(event.getOriginalExperience() * level * 1.5F);
                event.setDroppedExperience(droppedXp);
                entityAttacker.getEntityWorld().playSound(null, entityAttacker.getPosition(), SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.HOSTILE, 1.0F, 2F);
            }
        }
    }

    @SubscribeEvent
    public static void cataclysm(LivingHurtEvent event) {
        Object attacker = event.getSource().getTrueSource();
        if (attacker instanceof EntityLivingBase){
            EntityLivingBase attackerPlayer = (EntityLivingBase)attacker;
            if (!attackerPlayer.getEntityWorld().isRemote){
                EntityLivingBase enemy = (EntityLivingBase)event.getEntity();
                Random random = new Random();
                int level = EnchantmentHelper.getEnchantmentLevel(CATACLYSM, attackerPlayer.getHeldItemMainhand());
                if (level > 0 && enemy.getActivePotionEffects().isEmpty()){
                    int chance = random.nextInt(3);
                    switch (chance){
                        case 0:
                            enemy.setFire(3 * level);
                            break;
                        case 1:
                            enemy.addPotionEffect(new PotionEffect(MobEffects.WITHER, 60 * level, level));
                            break;
                        case 2:
                            enemy.addPotionEffect(new PotionEffect(MobEffects.POISON, 60 * level, level));
                            break;
                    }
                }
            }
        }
    }
}