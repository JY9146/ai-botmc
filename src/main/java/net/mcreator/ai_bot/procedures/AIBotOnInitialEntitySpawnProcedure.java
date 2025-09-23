package net.mcreator.ai_bot.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import net.mcreator.ai_bot.network.AiBotModVariables;
import net.mcreator.ai_bot.AiBotMod;

public class AIBotOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world) {
		AiBotMod.queueServerWork(100, () -> {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Hey there! I'm your friendly AI bot, here to help you with all your "
						+ ("\n" + ("MINECRAFT" + ("\n" + "needs! I'm a collection of AI you may know, such as ChatGPT, Gemini, Claude, Llama, Siri, Grok, etc. This makes me the most powerful AI yet."))))), false);
			AiBotMod.queueServerWork(20, () -> {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Here are some things you can ask me:" + ("\n" + ("Can you sing a song?" + ("\n"
							+ ("Can you give me some art?" + ("\n" + ("Can you call me a self driving car?" + ("\n" + ("Can you give me a __ (item)" + ("\n" + ("Where can I get more AI credits?" + ("\n" + "What else can I ask you?"))))))))))))),
							false);
			});
			AiBotMod.queueServerWork(10, () -> {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Keep in mind that I am still experimental, so my information may be outdated and I may use our chats to improve myself!"), false);
			});
		});
		AiBotModVariables.WorldVariables.get(world).AiRespond = true;
		AiBotModVariables.WorldVariables.get(world).syncData(world);
	}
}
