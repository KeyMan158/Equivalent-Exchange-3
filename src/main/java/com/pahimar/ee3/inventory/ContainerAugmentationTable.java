package com.pahimar.ee3.inventory;

import com.pahimar.ee3.tileentity.TileEntityAugmentationTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerAugmentationTable extends ContainerEE
{
    private TileEntityAugmentationTable tileEntityAugmentationTable;

    public ContainerAugmentationTable(InventoryPlayer inventoryPlayer, TileEntityAugmentationTable tileEntityAugmentationTable)
    {
        this.tileEntityAugmentationTable = tileEntityAugmentationTable;

        this.addSlotToContainer(new Slot(tileEntityAugmentationTable, TileEntityAugmentationTable.INPUT_SLOT_INVENTORY_INDEX, 36, 50));
        this.addSlotToContainer(new Slot(tileEntityAugmentationTable, TileEntityAugmentationTable.AUGMENT_SLOT_INVENTORY_INDEX, 72, 50));
        this.addSlotToContainer(new Slot(tileEntityAugmentationTable, TileEntityAugmentationTable.OUTPUT_SLOT_INVENTORY_INDEX, 136, 50));

        // Add the player's inventory slots to the container
        for (int inventoryRowIndex = 0; inventoryRowIndex < PLAYER_INVENTORY_ROWS; ++inventoryRowIndex)
        {
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < PLAYER_INVENTORY_COLUMNS; ++inventoryColumnIndex)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, inventoryColumnIndex + inventoryRowIndex * 9 + 9, 14 + inventoryColumnIndex * 18, 106 + inventoryRowIndex * 18));
            }
        }

        // Add the player's action bar slots to the container
        for (int actionBarSlotIndex = 0; actionBarSlotIndex < PLAYER_INVENTORY_COLUMNS; ++actionBarSlotIndex)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, actionBarSlotIndex, 14 + actionBarSlotIndex * 18, 164));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex)
    {
        return super.transferStackInSlot(entityPlayer, slotIndex);
    }
}
