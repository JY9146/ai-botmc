
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ai_bot.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.ai_bot.AiBotMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AiBotModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AiBotMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(AiBotModItems.AI_BOT_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.OP_BLOCKS) {
			if (tabData.hasPermissions()) {
				tabData.accept(AiBotModBlocks.COOL_GUY.get().asItem());
				tabData.accept(AiBotModBlocks.DOG.get().asItem());
				tabData.accept(AiBotModBlocks.PIZZA.get().asItem());
			}
		}
	}
}
