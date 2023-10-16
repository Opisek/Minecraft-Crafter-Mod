package net.opisek.crafter.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.CraftingResultSlot;
import net.minecraft.screen.slot.Slot;
import net.opisek.crafter.screen.slot.ToggleableSlot;
import org.slf4j.LoggerFactory;

public class CrafterScreenHandler extends CraftingScreenHandler {

    public static final int RESULT_ID = 0;
    private static final int INPUT_START = 1;
    private static final int INPUT_END = 10;
    private static final int INVENTORY_START = 10;
    private static final int INVENTORY_END = 37;
    private static final int HOTBAR_START = 37;
    private static final int HOTBAR_END = 46;
    private final RecipeInputInventory input;
    private final CraftingResultInventory result;
    private final ScreenHandlerContext context;
    private final PlayerEntity player;
    public CrafterScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public CrafterScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(syncId, playerInventory, context);
        this.input = new CraftingInventory(this, 3, 3);
        this.result = new CraftingResultInventory();
        this.context = context;
        this.player = playerInventory.player;

        for (int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                this.slots.set(j + i * 3, new ToggleableSlot(this.input, j + i * 3, 30 + j * 18, 17 + i * 18));
            }
        }

        /*super(ScreenHandlerType.CRAFTING, syncId);

        this.input = new CraftingInventory(this, 3, 3);
        this.result = new CraftingResultInventory();
        this.context = context;
        this.player = playerInventory.player;

        this.addSlot(new CraftingResultSlot(playerInventory.player, this.input, this.result, 0, 124, 35));

        for (int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                this.addSlot(new ToggleableSlot(this.input, j + i * 3, 30 + j * 18, 17 + i * 18));
            }
        }

        for (int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }*/
    }

    @Override
    public boolean canInsertIntoSlot(ItemStack stack, Slot slot) {
        if ((slot instanceof ToggleableSlot) && ((ToggleableSlot)slot).isLocked()) return false;
        return super.canInsertIntoSlot(stack, slot);
    }

    @Override
    public boolean canInsertIntoSlot(int index) {
        Slot slot = this.slots.get(index);
        if (slot instanceof ToggleableSlot && ((ToggleableSlot)slot).isLocked()) return false;
        return super.canInsertIntoSlot(index);
    }
}
