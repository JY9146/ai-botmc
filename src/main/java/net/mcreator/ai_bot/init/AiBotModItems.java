
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ai_bot.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.ai_bot.AiBotMod;

public class AiBotModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, AiBotMod.MODID);
	public static final RegistryObject<Item> AI_BOT_SPAWN_EGG = REGISTRY.register("ai_bot_spawn_egg", () -> new ForgeSpawnEggItem(AiBotModEntities.AI_BOT, -6710887, -13421773, new Item.Properties()));
	public static final RegistryObject<Item> COOL_GUY = block(AiBotModBlocks.COOL_GUY);
	public static final RegistryObject<Item> DOG = block(AiBotModBlocks.DOG);
	public static final RegistryObject<Item> PIZZA = block(AiBotModBlocks.PIZZA);
	public static final RegistryObject<Item> MOBILITY_CAR_SPAWN_EGG = REGISTRY.register("mobility_car_spawn_egg", () -> new ForgeSpawnEggItem(AiBotModEntities.MOBILITY_CAR, -1, -3355444, new Item.Properties()));

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
