package net.mcreator.ai_bot.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ServerChatEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.ai_bot.network.AiBotModVariables;
import net.mcreator.ai_bot.init.AiBotModEntities;
import net.mcreator.ai_bot.init.AiBotModBlocks;
import net.mcreator.ai_bot.AiBotMod;

import javax.annotation.Nullable;

import java.util.Random;

@Mod.EventBusSubscriber
public class AITalkBackProcedure {
	@SubscribeEvent
	public static void onChat(ServerChatEvent event) {
		execute(event, event.getPlayer().level(), event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ(), event.getRawText());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, String text) {
		execute(null, world, x, y, z, text);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, String text) {
		if (text == null)
			return;
		double Random = 0;
		double Random2 = 0;
		double Random3 = 0;
		if (AiBotModVariables.WorldVariables.get(world).AiRespond == true) {
			if ((text).equals("Where can I get more AI credits?") || (text).equals("Where can I get more AI credits") || (text).equals("Where can I get more ai credits") || (text).equals("Where can I get more ai credits")
					|| (text).equals("where can i get more ai credits")) {
				AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("You can get them at: "), false);
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/tellraw @a {\"text\":\"Here!\",\"color\":\"yellow\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://bit.ly/moreaicredits\"}}");
				});
			} else if ((text).equals("Can you sing a song?") || (text).equals("Can you sing a song") || (text).equals("can you sing a song") || (text).equals("Sing a song") || (text).equals("sing a song")) {
				AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Sure! Here is the song"), false);
					AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("DAISY BELL"), false);
					});
				});
				AiBotMod.queueServerWork(80, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ai_bot:daisybell")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ai_bot:daisybell")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				});
			} else if ((text).equals("Can you call me a self driving car?") || (text).equals("Can you call me a self driving car") || (text).equals("can you drive me a self driving car")) {
				AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Sure! It will go wherever you look."), false);
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = AiBotModEntities.MOBILITY_CAR.get().spawn(_level, BlockPos.containing(x + 4, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				});
			} else if ((text).equals("Can you give me some art?") || (text).equals("Can you give me some art") || (text).equals("can you give me some art")) {
				Random3 = Mth.nextInt(RandomSource.create(), 1, 3);
				if (Random3 == 1) {
					AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Sure here is a" + ("\n" + "COOL GUY"))), false);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(AiBotModBlocks.COOL_GUY.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					});
				} else if (Random3 == 2) {
					AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Sure here is a" + ("\n" + "DOG"))), false);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(AiBotModBlocks.DOG.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					});
				} else if (Random3 == 3) {
					AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Sure here is a" + ("\n" + "PIZZA"))), false);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(AiBotModBlocks.PIZZA.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					});
				}
			} else if ((text).equals("Can you give me a item?") || (text).equals("Can you give me a item") || (text).equals("can you give me a item")) {
				Random = Mth.nextInt(RandomSource.create(), 1, 11);
				if (Random == 1) {
					AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Sure here is a" + ("\n" + "DIAMOND"))), false);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.DIRT));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					});
				} else if (Random == 2) {
					AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Sure here is a" + ("\n" + "IRON INGOT"))), false);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.CHAIN));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					});
				} else if (Random == 3) {
					AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Sure here is a" + ("\n" + "GOLD INGOT"))), false);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.GOLDEN_HOE));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					});
				} else if (Random == 4) {
					AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Sure here is a" + ("\n" + "NETHERITE INGOT"))), false);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.FLINT));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					});
				} else if (Random == 5) {
					AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Sure here is a" + ("\n" + "COMMAND BLOCK"))), false);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.ORANGE_CONCRETE));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					});
				} else if (Random == 6) {
					AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Sure here is a" + ("\n" + "LAPIS LAZULI"))), false);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BLUE_DYE));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					});
				} else if (Random == 7) {
					AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Sure here is a" + ("\n" + "EMERALD"))), false);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.GREEN_CANDLE));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					});
				} else if (Random == 8) {
					AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Sure here is a" + ("\n" + "BLAZE ROD"))), false);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.TORCH));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					});
				} else if (Random == 9) {
					AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Sure here is a" + ("\n" + "ENDER PEARL"))), false);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.HEART_OF_THE_SEA));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					});
				} else if (Random == 10) {
					AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Sure here is a" + ("\n" + "OBSIDIAN BLOCK"))), false);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.BLACKSTONE));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					});
				} else if (Random == 11) {
					AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Sure here is a" + ("\n" + "ENCHANTED GOLDEN APPLE"))), false);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.PUFFERFISH));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					});
				} else if (Random == 12) {
					AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Sure here is a" + ("\n" + "BEACON"))), false);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.ICE));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					});
				} else {
					AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Sure here is a" + ("\n" + "COPPER INGOT"))), false);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.COPPER_INGOT));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					});
				}
			} else if ((text).equals("What else can I ask you?") || (text).equals("What else can I ask you") || (text).equals("what else can I ask you") || (text).equals("what else can i ask you")) {
				AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4, 12), () -> {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList()
								.broadcastSystemMessage(Component.literal("I'm afraid this is all I can do for now, however my developer is working on improving me! Make sure to keep checking up on any updates to this project."), false);
				});
			} else {
				Random2 = Mth.nextInt(RandomSource.create(), 1, 3);
				if (Random2 == 1) {
					AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 12, 36), () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("I'm sorry I didn't get that. Try again later."), false);
					});
				} else if (Random2 == 2) {
					AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 12, 36), () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("My brain is unplugged! Please reset your Minecraft instance."), false);
					});
				} else if (Random2 == 3) {
					AiBotMod.queueServerWork(Mth.nextInt(RandomSource.create(), 12, 36), () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("You have run out of credits. You can now only use the specified questions, please wait until your credits reset or get more."), false);
					});
				}
			}
		}
	}
}
