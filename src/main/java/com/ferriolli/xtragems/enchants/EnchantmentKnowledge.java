package com.ferriolli.xtragems.enchants;

import com.ferriolli.xtragems.Init.EnchantmentInit;
import com.ferriolli.xtragems.util.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;

public class EnchantmentKnowledge extends Enchantment {

    public EnchantmentKnowledge(Rarity rarityIn, EnumEnchantmentType typeIn, EntityEquipmentSlot[] slots) {
        super(rarityIn, typeIn, slots);
        this.setName("knowledge");
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":knowledge"));

        EnchantmentInit.ENCHANTMENTS.add(this);
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return enchantmentLevel * 11;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return this.getMinEnchantability(enchantmentLevel * 11);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    protected boolean canApplyTogether(Enchantment ench) {
        return this != ench;
    }
}
