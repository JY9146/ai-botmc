package net.mcreator.ai_bot.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.client.Minecraft;
import net.minecraft.client.CameraType;

import net.mcreator.ai_bot.network.AiBotModVariables;

public class MobilityCarOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double y, Entity entity) {
		if (entity == null)
			return;
		if (entity.isVehicle()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, (int) Double.POSITIVE_INFINITY, 1, false, false));
			for (Entity entityiterator : entity.getIndirectPassengers()) {
				if (AiBotModVariables.WorldVariables.get(world).CarMoves) {
					if (entity instanceof Mob _entity)
						_entity.getNavigation()
								.moveTo((entityiterator.level()
										.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entityiterator))
										.getBlockPos().getX()), y,
										(entityiterator.level().clip(
												new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entityiterator))
												.getBlockPos().getZ()),
										1);
				}
				if (!(Minecraft.getInstance().options.getCameraType() == CameraType.FIRST_PERSON)) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.INVISIBILITY);
				}
			}
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.INVISIBILITY);
		}
	}
}
