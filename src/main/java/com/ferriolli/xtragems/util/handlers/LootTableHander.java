package com.ferriolli.xtragems.util.handlers;

import com.ferriolli.xtragems.Init.ModItems;
import net.minecraft.init.Items;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class LootTableHander {
    @SubscribeEvent
    public static void onLootTablesLoaded(LootTableLoadEvent event){
        if (event.getName().equals(LootTableList.ENTITIES_PIG)){
            final LootPool pigLoot = event.getTable().getPool("main");
            if(pigLoot != null){
                pigLoot.setRolls(new RandomValueRange(1, 2));
                pigLoot.addEntry(new LootEntryItem(Items.DIAMOND, 1, 0, new LootFunction[]{new SetCount(new LootCondition[0], new RandomValueRange(10, 30))}, new LootCondition[0], "minecraft:diamond"));
            }
        }
    }
}
