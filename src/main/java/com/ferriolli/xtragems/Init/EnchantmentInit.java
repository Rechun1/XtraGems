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
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EnchantmentInit {
    public static final List<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();

    public static final Enchantment DAMAGE_HEAL = new EnchantmentDamageHeal(Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
    public static final Enchantment DAMAGE_INCREASE = new EnchantmentDamageIncrease(Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
    public static final Enchantment MINER_TEST = new EnchantmentMinerTest(Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.DIGGER, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
    public static final Enchantment VENOMOUS = new EnchantmentVenomous(Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
    public static final Enchantment KNOWLEDGE = new EnchantmentKnowledge(Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
    public static final Enchantment CATACLYSM = new EnchantmentCataclysm(Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
    public static final Enchantment BLAST_FURNACE = new EnchantmentBlastFurnace(Enchantment.Rarity.UNCOMMON, EnumEnchantmentType.DIGGER, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});

    //enchant de mob dropar cabeça
    //mudar cataclysm para chance de causar um tipo de efeito no mob atingido
    //VERIFICAR !WORLD.ISREMOTE
    @SubscribeEvent
    public static void vampirism(LivingDeathEvent event){
        Object attacker = event.getSource().getTrueSource();
        if (attacker instanceof EntityPlayer){
            EntityPlayer entityAttacker = (EntityPlayer)attacker;
            int level = EnchantmentHelper.getEnchantmentLevel(DAMAGE_HEAL, entityAttacker.getHeldItemMainhand());
            if (!entityAttacker.getEntityWorld().isRemote && level > 0){
                entityAttacker.heal(level);
                entityAttacker.getEntityWorld().playSound(null, entityAttacker.getPosition(), SoundEvents.ENTITY_ARROW_HIT_PLAYER, SoundCategory.HOSTILE, 1.0F, 2.0F);
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
                //Minecraft.getMinecraft().player.sendChatMessage("xp dropado: " + event.getOriginalExperience() + ", level 1: " + event.getOriginalExperience() * 1 * 1.5F + ", level 2: " + event.getOriginalExperience() * 2 * 1.5F + ", level 3: " + event.getOriginalExperience() * 3 * 1.5F);
                int droppedXp = (int) Math.ceil(event.getOriginalExperience() * level * 1.2F);
                event.setDroppedExperience(droppedXp);
                entityAttacker.getEntityWorld().playSound(null, entityAttacker.getPosition(), SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.HOSTILE, 1.0F, 2F);
            }
        }
    }
    @SubscribeEvent
    public static void cataclysm(LivingAttackEvent event){
        Object attacker = event.getSource().getTrueSource();
        if (attacker instanceof EntityLivingBase){
            EntityLivingBase entityAttacker = (EntityLivingBase) attacker;
            Object enemy = event.getEntity();
            EntityLivingBase entityEnemy = (EntityLivingBase) enemy;
            int level = EnchantmentHelper.getEnchantmentLevel(CATACLYSM, entityAttacker.getHeldItemMainhand());
            if (level > 0 && entityEnemy.getActivePotionEffects().isEmpty()){
                Random random = new Random();
                int chance = random.nextInt(3);
                Minecraft.getMinecraft().player.sendChatMessage("num: " + chance);
                switch (chance){
                    case 0:
                        //entityEnemy.setFire(3 * level);
                        Minecraft.getMinecraft().player.sendChatMessage("foguinho");
                        break;
                    case 1:
                        entityEnemy.addPotionEffect(new PotionEffect(MobEffects.WITHER, 60 * level, level));
                        break;
                    case 2:
                        entityEnemy.addPotionEffect(new PotionEffect(MobEffects.POISON, 60 * level, level));
                        break;
                }
                entityAttacker.getEntityWorld().playSound(null, entityAttacker.getPosition(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.HOSTILE, 1.0F, 2F);
            }
        }
    }
    @SubscribeEvent
    public static void blastFurnace(BlockEvent.HarvestDropsEvent event){
        if (event.getHarvester() instanceof EntityPlayer){
            EntityPlayer entityBreaker = event.getHarvester();
            int level = EnchantmentHelper.getEnchantmentLevel(BLAST_FURNACE, entityBreaker.getHeldItemMainhand());
            if (level > 0) {
                Block dblock = event.getState().getBlock();
                if (dblock == Blocks.IRON_ORE){
                    event.getDrops().add(new ItemStack(Items.IRON_INGOT));
                    event.getDrops().remove(0);
                    return;
                }
                if (dblock == Blocks.GOLD_ORE){
                    event.getDrops().add(new ItemStack(Items.GOLD_INGOT));
                    event.getDrops().remove(0);
                    return;
                }
            }
        }
    }

}