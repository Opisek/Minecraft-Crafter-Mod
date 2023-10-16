package net.opisek.crafter.screen.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.screen.slot.Slot;

public class ToggleableSlot extends Slot {
    private boolean locked;

    public ToggleableSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
        locked = false;
    }

    public boolean isLocked() {
        return locked;
    }
}
