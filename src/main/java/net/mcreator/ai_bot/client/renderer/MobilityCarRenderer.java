
package net.mcreator.ai_bot.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.ai_bot.entity.MobilityCarEntity;
import net.mcreator.ai_bot.client.model.animations.wamo_carAnimation;
import net.mcreator.ai_bot.client.model.Modelwamo_car;

import com.mojang.blaze3d.vertex.PoseStack;

public class MobilityCarRenderer extends MobRenderer<MobilityCarEntity, Modelwamo_car<MobilityCarEntity>> {
	public MobilityCarRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelwamo_car.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(MobilityCarEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(2f, 2f, 2f);
	}

	@Override
	public ResourceLocation getTextureLocation(MobilityCarEntity entity) {
		return new ResourceLocation("ai_bot:textures/entities/wamo_car.png");
	}

	private static final class AnimatedModel extends Modelwamo_car<MobilityCarEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<MobilityCarEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(MobilityCarEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animateWalk(wamo_carAnimation.moving, limbSwing, limbSwingAmount, 1f, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(MobilityCarEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
