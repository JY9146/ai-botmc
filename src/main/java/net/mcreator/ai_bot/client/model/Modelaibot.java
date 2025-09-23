package net.mcreator.ai_bot.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelaibot<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("ai_bot", "modelaibot"), "main");
	public final ModelPart Tires;
	public final ModelPart TorsoArmLegs;
	public final ModelPart Head;
	public final ModelPart HeadThing;

	public Modelaibot(ModelPart root) {
		this.Tires = root.getChild("Tires");
		this.TorsoArmLegs = root.getChild("TorsoArmLegs");
		this.Head = root.getChild("Head");
		this.HeadThing = root.getChild("HeadThing");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Tires = partdefinition.addOrReplaceChild("Tires", CubeListBuilder.create(), PartPose.offset(0.0F, 21.5F, 1.5F));
		PartDefinition tire2_r1 = Tires.addOrReplaceChild("tire2_r1", CubeListBuilder.create().texOffs(0, 25).addBox(-2.5F, -2.5F, -1.5F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.5F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition tire1_r1 = Tires.addOrReplaceChild("tire1_r1", CubeListBuilder.create().texOffs(18, 18).addBox(-2.5F, -2.5F, -1.5F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.5F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition TorsoArmLegs = partdefinition.addOrReplaceChild("TorsoArmLegs", CubeListBuilder.create().texOffs(0, 18).addBox(-3.0F, -8.0F, -1.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 13)
				.addBox(-7.0F, -11.0F, -1.0F, 14.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 33).addBox(-2.0F, -14.0F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition Head = partdefinition
				.addOrReplaceChild(
						"Head", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -25.0F, -1.0F, 20.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(12, 34).addBox(10.0F, -22.0F, -1.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
								.texOffs(34, 17).addBox(-13.0F, -22.0F, -1.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(22, 34).addBox(-1.5F, -27.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition HeadThing = partdefinition.addOrReplaceChild("HeadThing",
				CubeListBuilder.create().texOffs(16, 30).addBox(-3.0F, -28.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(16, 26).addBox(-3.0F, -33.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.0F, 23.0F, 0.0F));
		PartDefinition cube_r1 = HeadThing.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(32, 30).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -29.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
		PartDefinition cube_r2 = HeadThing.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(32, 13).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, -29.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Tires.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		TorsoArmLegs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		HeadThing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
