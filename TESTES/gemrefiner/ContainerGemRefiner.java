package com.ferriolli.xtragems.blocks.gemrefiner;

import com.ferriolli.xtragems.blocks.gemrefiner.slots.SlotRefinerFuel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerGemRefiner extends Container {
    private final IInventory tileRefiner;
    private int cookTime, totalCookTime, refinerBurnTime, currentItemBurnTime;

    public ContainerGemRefiner(InventoryPlayer playerInventory, IInventory refinerInventory) {
        this.tileRefiner = refinerInventory;
        this.addSlotToContainer(new Slot(refinerInventory, 0, 56, 17));
        this.addSlotToContainer(new SlotRefinerFuel(refinerInventory, 1, 56, 53));
        this.addSlotToContainer(new SlotRefinerOutput(playerInventory.player, refinerInventory, 2, 116, 35));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; k++) {
            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
        }
    }
        @Override
        public void addListener(IContainerListener listener){
            super.addListener(listener);
            listener.sendAllWindowProperties(this, this.tileRefiner);
        }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.listeners.size(); ++i)
        {
            IContainerListener icontainerlistener = this.listeners.get(i);

            if (this.cookTime != this.tileRefiner.getField(2))
            {
                icontainerlistener.sendWindowProperty(this, 2, this.tileRefiner.getField(2));
            }

            if (this.refinerBurnTime != this.tileRefiner.getField(0))
            {
                icontainerlistener.sendWindowProperty(this, 0, this.tileRefiner.getField(0));
            }

            if (this.currentItemBurnTime != this.tileRefiner.getField(1))
            {
                icontainerlistener.sendWindowProperty(this, 1, this.tileRefiner.getField(1));
            }

            if (this.totalCookTime != this.tileRefiner.getField(3))
            {
                icontainerlistener.sendWindowProperty(this, 3, this.tileRefiner.getField(3));
            }
        }

        this.cookTime = this.tileRefiner.getField(2);
        this.refinerBurnTime = this.tileRefiner.getField(0);
        this.currentItemBurnTime = this.tileRefiner.getField(1);
        this.totalCookTime = this.tileRefiner.getField(3);
    }

    @Override
    public void updateProgressBar(int id, int data)
    {
        this.tileRefiner.setField(id, data);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return  this.tileRefiner.isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index != 1 && index != 0)
            {
                if (!GemRefinerRecipes.instance().getRefiningResult(itemstack1).isEmpty())
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (TileEntityGemRefiner.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 3 && index < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount())
            {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }
}
