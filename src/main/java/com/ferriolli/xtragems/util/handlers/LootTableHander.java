package com.ferriolli.xtragems.util.handlers;

import com.ferriolli.xtragems.Init.ModItems;
import net.minecraft.init.Items;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.EntityHasProperty;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.LootingEnchantBonus;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraft.world.storage.loot.functions.Smelt;
import net.minecraft.world.storage.loot.properties.EntityOnFire;
import net.minecraft.world.storage.loot.properties.EntityProperty;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class LootTableHander {

    /*@SubscribeEvent
    public static void onLootTablesLoaded(LootTableLoadEvent event){
        if (event.getName().equals(LootTableList.ENTITIES_PIG)){
            final LootPool pigLoot = event.getTable().getPool("main");
            if(pigLoot != null){
                pigLoot.setRolls(new RandomValueRange(1, 2));
                pigLoot.addEntry(new LootEntryItem(ModItems.ANIMAL_FAT, 1, 0, new LootFunction[]{new SetCount(new LootCondition[0], new RandomValueRange(10, 30))}, new LootCondition[0], "animal_fat"));

            }
        }
    }*/

    @SubscribeEvent
    public static void lootTableLoad(LootTableLoadEvent event){
        LootCondition[] chance;
        LootCondition[] lootingEnchant;
        LootFunction[] count;
        LootEntry[] item;
        LootPool newPool;
        LootTable loot = event.getTable();
        if(event.getName().equals(LootTableList.ENTITIES_PIG)){
            LootTableUtil.addItemToTable(loot, ModItems.ANIMAL_FAT, 1, 1, 1, 1, 2, 1, 2, "xtragems:animal_fat");
        }
        if(event.getName().equals(LootTableList.ENTITIES_ENDERMAN)){
            LootTableUtil.addItemToTable(loot, ModItems.RUBY, 1, 1, 0.8F, 1, 2, 0, 1, "xtragems_ruby",
                new LootTableUtil.IMethod() {
                    @Override
                    public void FunctionsCallback(ArrayList<LootFunction> lootfuncs) {
                    LootFunction looting = new LootingEnchantBonus(null, new RandomValueRange(0,1), 0);
                    lootfuncs.add(looting);
                    }
                }
            );
        }
    }
}