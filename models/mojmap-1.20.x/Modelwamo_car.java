// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelwamo_car<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "wamo_car"), "main");
	private final ModelPart Car;
	private final ModelPart Bottom;
	private final ModelPart FendersFront;
	private final ModelPart FendersBack;
	private final ModelPart Wheels;
	private final ModelPart wheel1;
	private final ModelPart wheel2;
	private final ModelPart wheel3;
	private final ModelPart wheel4;
	private final ModelPart Top;

	public Modelwamo_car(ModelPart root) {
		this.Car = root.getChild("Car");
		this.Bottom = this.Car.getChild("Bottom");
		this.FendersFront = this.Bottom.getChild("FendersFront");
		this.FendersBack = this.Bottom.getChild("FendersBack");
		this.Wheels = this.Bottom.getChild("Wheels");
		this.wheel1 = this.Wheels.getChild("wheel1");
		this.wheel2 = this.Wheels.getChild("wheel2");
		this.wheel3 = this.Wheels.getChild("wheel3");
		this.wheel4 = this.Wheels.getChild("wheel4");
		this.Top = this.Car.getChild("Top");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Car = partdefinition.addOrReplaceChild("Car", CubeListBuilder.create(),
				PartPose.offset(0.0F, 26.0F, 0.0F));

		PartDefinition Bottom = Car.addOrReplaceChild("Bottom", CubeListBuilder.create().texOffs(0, 0).addBox(-15.0F,
				-17.0F, -35.0F, 30.0F, 13.0F, 65.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition FendersFront = Bottom.addOrReplaceChild("FendersFront",
				CubeListBuilder.create().texOffs(78, 162)
						.addBox(15.0F, -12.0F, -4.0F, 3.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(110, 174)
						.addBox(15.0F, -12.0F, -22.0F, 3.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(154, 99)
						.addBox(15.0F, -12.0F, -17.0F, 3.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(126, 174)
						.addBox(-18.0F, -12.0F, -22.0F, 3.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(154, 115)
						.addBox(-18.0F, -12.0F, -17.0F, 3.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(94, 174)
						.addBox(-18.0F, -12.0F, -4.0F, 3.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -4.0F, 26.0F));

		PartDefinition FendersBack = Bottom.addOrReplaceChild("FendersBack",
				CubeListBuilder.create().texOffs(142, 174)
						.addBox(15.0F, -12.0F, -3.0F, 3.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(176, 131)
						.addBox(15.0F, -12.0F, -21.0F, 3.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(96, 158)
						.addBox(15.0F, -12.0F, -16.0F, 3.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(158, 176)
						.addBox(-18.0F, -12.0F, -21.0F, 3.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(128, 158)
						.addBox(-18.0F, -12.0F, -16.0F, 3.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(174, 176)
						.addBox(-18.0F, -12.0F, -3.0F, 3.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -4.0F, -31.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Wheels = Bottom.addOrReplaceChild("Wheels", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition wheel1 = Wheels.addOrReplaceChild("wheel1", CubeListBuilder.create().texOffs(160, 158)
				.addBox(-4.0F, -4.5F, -4.5F, 4.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-15.0F, -6.5F, 15.5F));

		PartDefinition wheel2 = Wheels.addOrReplaceChild("wheel2", CubeListBuilder.create().texOffs(0, 162)
				.addBox(-4.0F, -4.5F, -4.5F, 4.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-15.0F, -6.5F, -21.5F));

		PartDefinition wheel3 = Wheels.addOrReplaceChild("wheel3", CubeListBuilder.create().texOffs(52, 162)
				.addBox(0.0F, -4.5F, -4.5F, 4.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(15.0F, -6.5F, -21.5F));

		PartDefinition wheel4 = Wheels.addOrReplaceChild("wheel4", CubeListBuilder.create().texOffs(26, 162)
				.addBox(-1.0F, -4.5F, -4.5F, 4.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(16.0F, -6.5F, 15.5F));

		PartDefinition Top = Car.addOrReplaceChild("Top",
				CubeListBuilder.create().texOffs(0, 78)
						.addBox(-14.0F, -10.0F, -48.0F, 28.0F, 10.0F, 49.0F, new CubeDeformation(0.0F)).texOffs(96, 137)
						.addBox(-10.0F, -11.0F, -23.0F, 20.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(0, 137)
						.addBox(-12.0F, -12.0F, -25.0F, 24.0F, 1.0F, 24.0F, new CubeDeformation(0.0F)).texOffs(154, 78)
						.addBox(-4.0F, -19.0F, -19.0F, 8.0F, 7.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -17.0F, 14.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Car.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}