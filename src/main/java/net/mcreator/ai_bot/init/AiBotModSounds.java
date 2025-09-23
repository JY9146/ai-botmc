
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ai_bot.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ai_bot.AiBotMod;

public class AiBotModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AiBotMod.MODID);
	public static final RegistryObject<SoundEvent> DAISYBELL = REGISTRY.register("daisybell", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("ai_bot", "daisybell")));
}
