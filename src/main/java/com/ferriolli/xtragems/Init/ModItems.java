package com.ferriolli.xtragems.Init;

import com.ferriolli.xtragems.items.ItemBase;
import com.ferriolli.xtragems.items.tools.*;
import net.minecraft.item.*;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final Item.ToolMaterial MATERIAL_RUBY = EnumHelper.addToolMaterial("material_ruby", 3, 1736, 14.0F, 3.0F, 10);
    public static final Item.ToolMaterial MATERIAL_TOPAZ = EnumHelper.addToolMaterial("material_topaz", 3, 848, 9.0F, 2.5F, 10);
    public static final Item.ToolMaterial MATERIAL_AMETHYST = EnumHelper.addToolMaterial("material_amethyst", 2, 348, 6.0F, 2.0F, 10);

    public static final Item TOPAZ = new ItemBase("topaz");
    public static final Item BLACK_GEM = new ItemBase("black_gem");
    public static final Item RUBY = new ItemBase("ruby");
    public static final Item AMETHYST = new ItemBase("amethyst");
    public static final Item SHADOW_INGOT = new ItemBase("shadow_ingot");
    public static final Item FIRITE_GEM = new ItemBase("firite_gem");
    public static final Item BLOODSTONE = new ItemBase("bloodstone");

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
}
