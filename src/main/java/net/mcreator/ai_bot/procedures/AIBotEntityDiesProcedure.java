package net.mcreator.ai_bot.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.ai_bot.network.AiBotModVariables;

public class AIBotEntityDiesProcedure {
	public static void execute(LevelAccessor world) {
		for (int index0 = 0; index0 < 2; index0++) {
			AiBotModVariables.WorldVariables.get(world).AiRespond = false;
			AiBotModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
