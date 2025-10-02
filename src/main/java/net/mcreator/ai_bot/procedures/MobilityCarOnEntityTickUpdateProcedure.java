package net.mcreator.ai_bot.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.client.Minecraft;
import net.minecraft.client.CameraType;

import net.mcreator.ai_bot.network.AiBotModVariables;
import net.mcreator.ai_bot.AiBotMod;

public class MobilityCarOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double y, Entity entity) {
		if (entity == null)
			return;
		if (entity.isVehicle()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, (int) Double.POSITIVE_INFINITY, 1, false, false));
			if (entity.getPersistentData().getBoolean("tagName")) {
				if (Math.random() < 0.2) {
					if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
						_livingEntity3.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.2);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 250, 1, false, false));
					entity.getPersistentData().putBoolean("tagName", false);
					AiBotMod.queueServerWork(250, () -> {
						entity.getPersistentData().putBoolean("tagName", true);
					});
				} else if (Math.random() < 0.1) {
					if (entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
						_livingEntity8.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 150, 255, false, false));
					entity.getPersistentData().putBoolean("tagName", false);
					AiBotMod.queueServerWork(150, () -> {
						entity.getPersistentData().putBoolean("tagName", true);
					});
				} else if (Math.random() < 0.2) {
					if (entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
						_livingEntity13.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.4);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 250, 10, false, false));
					entity.getPersistentData().putBoolean("tagName", false);
					AiBotMod.queueServerWork(250, () -> {
						entity.getPersistentData().putBoolean("tagName", true);
					});
				} else {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.MOVEMENT_SPEED);
					if (entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
						_livingEntity20.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3);
					entity.getPersistentData().putBoolean("tagName", false);
					AiBotMod.queueServerWork(350, () -> {
						entity.getPersistentData().putBoolean("tagName", true);
					});
				}
			}
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
				} else {
					if (entity instanceof Mob _entity)
						_entity.getNavigation().moveTo(AiBotModVariables.WorldVariables.get(world).xcoord, AiBotModVariables.WorldVariables.get(world).ycoord, AiBotModVariables.WorldVariables.get(world).zcoord, 1);
				}
				if (!(Minecraft.getInstance().options.getCameraType() == CameraType.FIRST_PERSON)) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.INVISIBILITY);
				}
			}
		} else {
			entity.getPersistentData().putBoolean("tagName", true);
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.INVISIBILITY);
			AiBotModVariables.WorldVariables.get(world).CarMoves = true;
			AiBotModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
