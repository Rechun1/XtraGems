package com.ferriolli.xtragems.Init;

import com.ferriolli.xtragems.enchants.EnchantmentDamageHeal;
import com.ferriolli.xtragems.enchants.EnchantmentDamageIncrease;
import com.ferriolli.xtragems.enchants.EnchantmentMinerTest;
import com.ferriolli.xtragems.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDestroyBlockEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
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
                float floatLevel = (float)level;
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
}
