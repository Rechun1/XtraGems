package com.ferriolli.xtragems.Init;

import com.ferriolli.xtragems.items.ItemBase;
import com.ferriolli.xtragems.items.armor.ArmorBase;
import com.ferriolli.xtragems.items.tools.*;
import com.ferriolli.xtragems.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final Item.ToolMaterial MATERIAL_RUBY = EnumHelper.addToolMaterial("material_ruby", 3, 1736, 14.0F, 4.0F, 10);
    public static final Item.ToolMaterial MATERIAL_TOPAZ = EnumHelper.addToolMaterial("material_topaz", 3, 848, 9.0F, 2.5F, 10);
    public static final Item.ToolMaterial MATERIAL_AMETHYST = EnumHelper.addToolMaterial("material_amethyst", 2, 348, 6.0F, 2.0F, 10);
    public static final Item.ToolMaterial MATERIAL_GLASS = EnumHelper.addToolMaterial("material_glass", 2, 50, 20.0F, 6.0F, 10);

    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_RUBY = EnumHelper.addArmorMaterial("armor_material_ruby", Reference.MOD_ID + ":ruby", 16, new int[] {4, 9, 7, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0);

    public static final Item TOPAZ = new ItemBase("topaz");
    public static final Item BLACK_GEM = new ItemBase("black_gem");
    public static final Item RUBY = new ItemBase("ruby");
    public static final Item AMETHYST = new ItemBase("amethyst");
    public static final Item SHADOW_INGOT = new ItemBase("shadow_ingot");
    public static final Item FIRITE_GEM = new ItemBase("firite_gem");
    public static final Item BLOODSTONE = new ItemBase("bloodstone");
    public static final Item GLASS_SHARD = new ItemBase("glass_shard");
    public static final Item REINFORCED_GLASS_SHARD = new ItemBase("reinforced_glass_shard");

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

    public static final Item RUBY_HELMET = new ArmorBase("ruby_helmet", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.HEAD);
    public static final Item RUBY_CHESTPLATE = new ArmorBase("ruby_chestplate", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.CHEST);
    public static final Item RUBY_LEGGINGS = new ArmorBase("ruby_leggings", ARMOR_MATERIAL_RUBY, 2, EntityEquipmentSlot.LEGS);
    public static final Item RUBY_BOOTS = new ArmorBase("ruby_boots", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.FEET);


}
