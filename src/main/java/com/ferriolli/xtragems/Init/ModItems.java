package com.ferriolli.xtragems.Init;

import com.ferriolli.xtragems.items.ItemBase;
import com.ferriolli.xtragems.items.tools.ToolAxe;
import com.ferriolli.xtragems.items.tools.ToolPickaxe;
import com.ferriolli.xtragems.items.tools.ToolSpade;
import com.ferriolli.xtragems.items.tools.ToolSword;
import net.minecraft.item.*;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final Item.ToolMaterial MATERIAL_RUBY = EnumHelper.addToolMaterial("material_ruby", 3, 750, 12F, 3.0F, 10);

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
}
