
package net.mcreator.ai_bot.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.ai_bot.entity.AIBotEntity;
import net.mcreator.ai_bot.client.model.animations.aibotAnimation;
import net.mcreator.ai_bot.client.model.Modelaibot;

public class AIBotRenderer extends MobRenderer<AIBotEntity, Modelaibot<AIBotEntity>> {
	public AIBotRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelaibot.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(AIBotEntity entity) {
		return new ResourceLocation("ai_bot:textures/entities/robotface.png");
	}

	private static final class AnimatedModel extends Modelaibot<AIBotEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<AIBotEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(AIBotEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animateWalk(aibotAnimation.animation, limbSwing, limbSwingAmount, 20f, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(AIBotEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
