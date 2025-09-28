
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ai_bot.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.ai_bot.client.model.Modelwamo_car;
import net.mcreator.ai_bot.client.model.Modelaibot;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class AiBotModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelaibot.LAYER_LOCATION, Modelaibot::createBodyLayer);
		event.registerLayerDefinition(Modelwamo_car.LAYER_LOCATION, Modelwamo_car::createBodyLayer);
	}
}
