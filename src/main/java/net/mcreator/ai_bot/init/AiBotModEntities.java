
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ai_bot.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.ai_bot.entity.MobilityCarEntity;
import net.mcreator.ai_bot.entity.AIBotEntity;
import net.mcreator.ai_bot.AiBotMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AiBotModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AiBotMod.MODID);
	public static final RegistryObject<EntityType<AIBotEntity>> AI_BOT = register("ai_bot",
			EntityType.Builder.<AIBotEntity>of(AIBotEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(71).setUpdateInterval(3).setCustomClientFactory(AIBotEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MobilityCarEntity>> MOBILITY_CAR = register("mobility_car",
			EntityType.Builder.<MobilityCarEntity>of(MobilityCarEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MobilityCarEntity::new)

					.sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			AIBotEntity.init();
			MobilityCarEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(AI_BOT.get(), AIBotEntity.createAttributes().build());
		event.put(MOBILITY_CAR.get(), MobilityCarEntity.createAttributes().build());
	}
}
