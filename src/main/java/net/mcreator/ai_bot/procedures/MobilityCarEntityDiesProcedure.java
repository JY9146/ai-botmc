package net.mcreator.ai_bot.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

import net.mcreator.ai_bot.network.AiBotModVariables;

public class MobilityCarEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 10, Level.ExplosionInteraction.TNT);
		AiBotModVariables.WorldVariables.get(world).CarMoves = true;
		AiBotModVariables.WorldVariables.get(world).syncData(world);
	}
}
