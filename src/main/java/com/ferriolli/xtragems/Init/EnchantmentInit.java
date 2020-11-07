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
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EnchantmentInit {
    public static final List<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();

    public static final Enchantment DAMAGE_HEAL = new EnchantmentDamageHeal(Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
    public static final Enchantment DAMAGE_INCREASE = new EnchantmentDamageIncrease(Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
    public static final Enchantment MINER_TEST = new EnchantmentMinerTest(Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.DIGGER, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
    public static final Enchantment VENOMOUS = new EnchantmentVenomous(Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
    public static final Enchantment KNOWLEDGE = new EnchantmentKnowledge(Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});

    @SubscribeEvent
    public static void vampirism(LivingAttackEvent event){
        Object attacker = event.getSource().getTrueSource();
        if (attacker instanceof EntityLivingBase){
            EntityLivingBase entityAttacker = (EntityLivingBase)attacker;
            int level = EnchantmentHelper.getEnchantmentLevel(DAMAGE_HEAL, entityAttacker.getHeldItemMainhand());
            if (!entityAttacker.getEntityWorld().isRemote && level > 0){
                float floatLevel = (float)level;
                entityAttacker.heal(event.getAmount() * floatLevel);
                entityAttacker.getEntityWorld().playSound(null, entityAttacker.getPosition(), SoundEvents.ENTITY_DONKEY_ANGRY, SoundCategory.HOSTILE, 1.0F, 1.0F);
            }
        }
    }
    @SubscribeEvent
    public static void dmgIncrease(LivingHurtEvent event) {
        boolean dmgAlreadyIncreased = false;
        Object attacker = event.getSource().getTrueSource();
        if (attacker instanceof  EntityLivingBase){
            EntityLivingBase entityAttacker = (EntityLivingBase)attacker;
            int level = EnchantmentHelper.getEnchantmentLevel(DAMAGE_INCREASE, entityAttacker.getHeldItemMainhand());
            if (!entityAttacker.getEntityWorld().isRemote && level > 0){
                if (entityAttacker.getHealth() <= entityAttacker.getMaxHealth() * .2F && !dmgAlreadyIncreased) {
                    event.setAmount(event.getAmount() * 1.5F);
                    dmgAlreadyIncreased = true;
                    entityAttacker.getEntityWorld().playSound(null, entityAttacker.getPosition(), SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.HOSTILE, 1.0F, 0.1F);
                }
                else if(entityAttacker.getHealth() <= entityAttacker.getMaxHealth() * .4F && !dmgAlreadyIncreased){
                    event.setAmount(event.getAmount() * 1.25F);
                    dmgAlreadyIncreased = true;
                    entityAttacker.getEntityWorld().playSound(null, entityAttacker.getPosition(), SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.HOSTILE, 1.0F, 0.1F);
                }
            }
        }
    }
    @SubscribeEvent
    public static void minerTest(BlockEvent.BreakEvent event){
        EntityLivingBase entityBreaker = event.getPlayer();
        float destroyedBlockHeight = event.getPos().getY();
        int level = EnchantmentHelper.getEnchantmentLevel(MINER_TEST, entityBreaker.getHeldItemMainhand());
        if (level > 0){
            if (destroyedBlockHeight < 10){
                Block dBlock = event.getState().getBlock();
                if (dBlock == Blocks.STONE){
                    entityBreaker.getEntityWorld().playSound(null, entityBreaker.getPosition(), SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.HOSTILE, 1.0F, 0.1F);
                }
            }
        }
    }
    @SubscribeEvent
    public static void venomous(LivingAttackEvent event){
        Object attacker = event.getSource().getTrueSource();
        if (attacker instanceof EntityLivingBase){
            EntityLivingBase entityAttacker = (EntityLivingBase)attacker;
            Object enemy = event.getEntity();
            EntityLivingBase entityEnemy = (EntityLivingBase)enemy;
            int level = EnchantmentHelper.getEnchantmentLevel(VENOMOUS, entityAttacker.getHeldItemMainhand());
            if(level > 0){
                entityEnemy.addPotionEffect(new PotionEffect(MobEffects.POISON, 60 * level, level));
                entityAttacker.getEntityWorld().playSound(null, entityAttacker.getPosition(), SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.HOSTILE, 1.0F, 2F);
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
                event.setDroppedExperience(event.getOriginalExperience() * level);
                entityAttacker.getEntityWorld().playSound(null, entityAttacker.getPosition(), SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.HOSTILE, 1.0F, 2F);
            }
        }
    }
}