package net.opisek.crafter;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;

import net.minecraft.item.BlockItem;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import net.opisek.crafter.block.CrafterBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrafterMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("crafter");

	public static final Block CRAFTER_BLOCK = new CrafterBlock(FabricBlockSettings.create().strength(1.0f));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registries.BLOCK, new Identifier("crafter","crafter"), CRAFTER_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("crafter", "crafter"), new BlockItem(CRAFTER_BLOCK, new FabricItemSettings()));

		LOGGER.info("Crafter Mod has been initialized.");
	}
}