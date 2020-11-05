package com.ferriolli.xtragems.Init;

import com.ferriolli.xtragems.enchants.EnchantmentDamageHeal;
import com.ferriolli.xtragems.enchants.EnchantmentDamageIncrease;
import com.ferriolli.xtragems.util.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EnchantmentInit {
    public static final List<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();

    public static final Enchantment DAMAGE_HEAL = new EnchantmentDamageHeal(Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
    public static final Enchantment DAMAGE_INCREASE = new EnchantmentDamageIncrease(Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
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

    /*@SubscribeEvent
    public static void dmgIncrease(LivingAttackEvent event) {
        Object attacker = event.getSource().getTrueSource();
        Object enemy = event.getEntity();
        if (attacker instanceof EntityLivingBase){
            EntityLivingBase entityAttacker = (EntityLivingBase)attacker;
            EntityLivingBase entityEnemy = (EntityLivingBase)enemy;
            int level = EnchantmentHelper.getEnchantmentLevel(DAMAGE_INCREASE, entityAttacker.getHeldItemMainhand());
            if (!entityAttacker.getEntityWorld().isRemote && level > 0){
                float floatLevel = (float)level;
                if (((EntityLivingBase) attacker).getHealth() > 10){
                    //System.out.println(enemy.toString());
                    //entityEnemy.setHealth(0);
                    entityAttacker.getEntityWorld().playSound(null, entityAttacker.getPosition(), SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.HOSTILE, 1.0F, 0.1F);
                }
            }
        }
    }*/
    @SubscribeEvent
    public static void dmgIncrease(LivingHurtEvent event) {
        Object attacker = event.getSource().getTrueSource();
        if (attacker instanceof  EntityLivingBase){
            EntityLivingBase entityAttacker = (EntityLivingBase)attacker;
            int level = EnchantmentHelper.getEnchantmentLevel(DAMAGE_INCREASE, entityAttacker.getHeldItemMainhand());
            if (!entityAttacker.getEntityWorld().isRemote && level > 0){
                float floatLevel = (float)level;
                if (entityAttacker.getHealth() < 5){
                    event.setAmount(10000);
                    entityAttacker.getEntityWorld().playSound(null, entityAttacker.getPosition(), SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.HOSTILE, 1.0F, 0.1F);
                }
            }
        }
    }
}
