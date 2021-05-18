package com.ferriolli.xtragems.Init;

import com.ferriolli.xtragems.items.ItemBase;;
import com.ferriolli.xtragems.items.ItemCustomFoodWithEffect;
import com.ferriolli.xtragems.items.ItemFillable;
import com.ferriolli.xtragems.items.tools.specialItems.ItemHealingStaff;
import com.ferriolli.xtragems.items.armor.ArmorBase;
import com.ferriolli.xtragems.items.tools.*;
import com.ferriolli.xtragems.items.tools.specialItems.ItemLightningStaff;
import com.ferriolli.xtragems.items.tools.specialItems.ItemMidasStaff;
import com.ferriolli.xtragems.items.tools.specialItems.ItemWindStaff;
import com.ferriolli.xtragems.util.Reference;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

import javax.tools.Tool;
import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final Item.ToolMaterial MATERIAL_RUBY = EnumHelper.addToolMaterial("material_ruby", 3, 1736, 14.0F, 4.0F, 10);
    public static final Item.ToolMaterial MATERIAL_TOPAZ = EnumHelper.addToolMaterial("material_topaz", 3, 848, 9.0F, 2.5F, 10);
    public static final Item.ToolMaterial MATERIAL_AMETHYST = EnumHelper.addToolMaterial("material_amethyst", 2, 348, 6.0F, 2.0F, 10);
    public static final Item.ToolMaterial MATERIAL_GLASS = EnumHelper.addToolMaterial("material_glass", 2, 50, 20.0F, 6.0F, 10);
    public static final Item.ToolMaterial MATERIAL_FIRITE = EnumHelper.addToolMaterial("material_firite", 3, 1561, 12.0F, 6.0F, 10);
    public static final Item.ToolMaterial MATERIAL_UNIVERSAL_GEM = EnumHelper.addToolMaterial("material_universal_gem", 4, 4212, 50.0F, 6.0F, 16);
    public static final Item.ToolMaterial MATERIAL_ENDERITE = EnumHelper.addToolMaterial("material_enderite", 4, 2234, 16.0F, 5.0F, 14);

    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_RUBY = EnumHelper.addArmorMaterial("armor_material_ruby", Reference.MOD_ID + ":ruby", 16, new int[] {4, 9, 7, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ENDERITE = EnumHelper.addArmorMaterial("armor_material_enderite", Reference.MOD_ID + ":enderite", 20, new int[] {7, 12, 10, 7}, 11, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0);

    public static final Item TOPAZ = new ItemBase("topaz");
    public static final Item BLACK_GEM = new ItemBase("black_gem");
    public static final Item RUBY = new ItemBase("ruby");
    public static final Item AMETHYST = new ItemBase("amethyst");
    public static final Item TURQUOISE = new ItemBase("turquoise");
    public static final Item SHADOW_INGOT = new ItemBase("shadow_ingot");
    public static final Item UNREFINED_FIRITE_GEM = new ItemBase("unrefined_firite_gem");
    public static final Item BLOODSTONE = new ItemBase("bloodstone");
    public static final Item GLASS_SHARD = new ItemBase("glass_shard");
    public static final Item REINFORCED_GLASS_SHARD = new ItemBase("reinforced_glass_shard");
    public static final Item ANIMAL_FAT = new ItemBase("animal_fat");
    public static final Item ANIMAL_FAT_BOTTLE = new ItemBase("animal_fat_bottle");
    public static final Item AMBER_PEARL = new ItemBase("amber_pearl");
    public static final Item AZURE_EMERALD = new ItemBase("azure_emerald");
    public static final Item BLOODY_DIAMOND = new ItemBase("bloody_diamond");
    public static final Item VIOLET_QUARTZ = new ItemBase("violet_quartz");
    public static final Item FIRITE_GEM = new ItemBase("firite_gem");
    public static final Item INFUSED_BLACK_GEM = new ItemBase("infused_black_gem");
    public static final Item RUBY_INFUSED_BLACK_GEM = new ItemBase("ruby_infused_black_gem");
    public static final Item TOPAZ_INFUSED_BLACK_GEM = new ItemBase("topaz_infused_black_gem");
    public static final Item AMETHYST_INFUSED_BLACK_GEM = new ItemBase("amethyst_infused_black_gem");
    public static final Item TURQUOISE_INFUSED_BLACK_GEM = new ItemBase("turquoise_infused_black_gem");
    public static final Item SHADOW_ESSENCE = new ItemBase("shadow_essence");
    public static final Item BLOODY_TURQUOISE = new ItemBase("bloody_turquoise");
    public static final Item VIOLET_AMBER = new ItemBase("violet_amber");
    public static final Item UNIVERSAL_GEM = new ItemBase("universal_gem");
    public static final Item UNIVERSAL_GEM_INGOT = new ItemBase("universal_ingot");
    public static final Item ENDERITE_INGOT = new ItemBase("enderite_ingot");

    public static final Item STAFF_HANDLE = new ItemBase("staff_handle");
    public static final ItemFillable EMPTY_POTENAY_BOTTLE = new ItemFillable("empty_potenay_bottle");
    public static final Item FILLED_POTENAY_BOTTLE = new ItemBase("filled_potenay_bottle");

    public static final Item OIL_BOTTLE = new ItemCustomFoodWithEffect("oil_bottle", 4, false, new PotionEffect(MobEffects.NAUSEA, 600, 2));
    public static final Item POTENAY = new ItemCustomFoodWithEffect("potenay", 2, false, new PotionEffect(MobEffects.STRENGTH, 3000, 3));

    public static final ItemSword RUBY_SWORD = new ToolSword("ruby_sword", MATERIAL_RUBY);
    public static final ItemSpade RUBY_SHOVEL = new ToolSpade("ruby_shovel", MATERIAL_RUBY);
    public static final ItemPickaxe RUBY_PICKAXE = new ToolPickaxe("ruby_pickaxe", MATERIAL_RUBY);
    public static final ItemAxe RUBY_AXE = new ToolAxe("ruby_axe", MATERIAL_RUBY);
    public static final ItemHoe RUBY_HOE = new ToolHoe("ruby_hoe", MATERIAL_RUBY);

    public static final ItemSword TOPAZ_SWORD = new ToolSword("topaz_sword", MATERIAL_TOPAZ);
    public static final ItemSpade TOPAZ_SHOVEL = new ToolSpade("topaz_shovel", MATERIAL_TOPAZ);
    public static final ItemPickaxe TOPAZ_PICKAXE = new ToolPickaxe("topaz_pickaxe", MATERIAL_TOPAZ);
    public static final ItemAxe TOPAZ_AXE = new ToolAxe("topaz_axe", MATERIAL_TOPAZ);
    public static final ItemHoe TOPAZ_HOE = new ToolHoe("topaz_hoe", MATERIAL_TOPAZ);

    public static final ItemSword AMETHYST_SWORD = new ToolSword("amethyst_sword", MATERIAL_AMETHYST);
    public static final ItemSpade AMETHYST_SHOVEL = new ToolSpade("amethyst_shovel", MATERIAL_AMETHYST);
    public static final ItemPickaxe AMETHYST_PICKAXE = new ToolPickaxe("amethyst_pickaxe", MATERIAL_AMETHYST);
    public static final ItemAxe AMETHYST_AXE = new ToolAxe("amethyst_axe", MATERIAL_AMETHYST);
    public static final ItemHoe AMETHYST_HOE = new ToolHoe("amethyst_hoe", MATERIAL_AMETHYST);

    public static final ItemSword GLASS_SWORD = new ToolSword("glass_sword", MATERIAL_GLASS);
    public static final ItemSpade GLASS_SHOVEL = new ToolSpade("glass_shovel", MATERIAL_GLASS);
    public static final ItemPickaxe GLASS_PICKAXE = new ToolPickaxe("glass_pickaxe", MATERIAL_GLASS);
    public static final ItemAxe GLASS_AXE = new ToolAxe("glass_axe", MATERIAL_GLASS);
    public static final ItemHoe GLASS_HOE = new ToolHoe("glass_hoe", MATERIAL_GLASS);

    public static final ItemPickaxe FIERY_PICKAXE = new ToolPickaxe("fiery_pickaxe", MATERIAL_FIRITE);

    public static final ItemPickaxe ENDERITE_PICKAXE = new ToolEnderitePickaxe("enderite_pickaxe", MATERIAL_ENDERITE);

    public static final ItemPickaxe UNIVERSAL_PICKAXE = new ToolPickaxe("universal_pickaxe", MATERIAL_UNIVERSAL_GEM);
    public static final ItemSword UNIVERSAL_SWORD = new ToolSword("universal_sword", MATERIAL_UNIVERSAL_GEM);
    public static final ItemSpade UNIVERSAL_SHOVEL = new ToolSpade("universal_shovel", MATERIAL_UNIVERSAL_GEM);
    public static final ItemAxe UNIVERSAL_AXE = new ToolAxe("universal_axe", MATERIAL_UNIVERSAL_GEM);
    public static final ItemHoe UNIVERSAL_HOE = new ToolHoe("universal_hoe", MATERIAL_UNIVERSAL_GEM);

    public static final Item RUBY_HELMET = new ArmorBase("ruby_helmet", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.HEAD);
    public static final Item RUBY_CHESTPLATE = new ArmorBase("ruby_chestplate", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.CHEST);
    public static final Item RUBY_LEGGINGS = new ArmorBase("ruby_leggings", ARMOR_MATERIAL_RUBY, 2, EntityEquipmentSlot.LEGS);
    public static final Item RUBY_BOOTS = new ArmorBase("ruby_boots", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.FEET);

    public static final Item ENDERITE_HELMET = new ArmorBase("enderite_helmet", ARMOR_MATERIAL_ENDERITE, 1, EntityEquipmentSlot.HEAD);
    public static final Item ENDERITE_CHESTPLATE = new ArmorBase("enderite_chestplate", ARMOR_MATERIAL_ENDERITE, 1, EntityEquipmentSlot.CHEST);
    public static final Item ENDERITE_LEGGINGS = new ArmorBase("enderite_leggings", ARMOR_MATERIAL_ENDERITE, 2, EntityEquipmentSlot.LEGS);
    public static final Item ENDERITE_BOOTS = new ArmorBase("enderite_boots", ARMOR_MATERIAL_ENDERITE, 1, EntityEquipmentSlot.FEET);

    public static final ItemHealingStaff HEALING_STAFF = new ItemHealingStaff("healing_staff");
    public static final ItemLightningStaff LIGHTNING_STAFF = new ItemLightningStaff("lightning_staff");
    public static final ItemMidasStaff MIDAS_STAFF = new ItemMidasStaff("midas_staff");
    public static final ItemWindStaff WIND_STAFF = new ItemWindStaff("wind_staff");
}