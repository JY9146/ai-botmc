
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ai_bot.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.ai_bot.block.PizzaBlock;
import net.mcreator.ai_bot.block.DogBlock;
import net.mcreator.ai_bot.block.CoolGuyBlock;
import net.mcreator.ai_bot.AiBotMod;

public class AiBotModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, AiBotMod.MODID);
	public static final RegistryObject<Block> COOL_GUY = REGISTRY.register("cool_guy", () -> new CoolGuyBlock());
	public static final RegistryObject<Block> DOG = REGISTRY.register("dog", () -> new DogBlock());
	public static final RegistryObject<Block> PIZZA = REGISTRY.register("pizza", () -> new PizzaBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
