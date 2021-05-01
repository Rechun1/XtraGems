package com.ferriolli.xtragems.blocks.gemrefiner;

import com.ferriolli.xtragems.blocks.gemrefiner.TileEntityGemRefiner;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotGemRefinerFuel extends Slot {
    public SlotGemRefinerFuel(IInventory inventory, int index, int x, int y){
        super(inventory, index, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return TileEntityGemRefiner.isItemFuel(stack);
    }

    @Override
    public int getItemStackLimit(ItemStack stack) {
        return super.getItemStackLimit(stack);
    }
}
