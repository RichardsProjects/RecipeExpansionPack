package net.richardsprojects.rep.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class ModelFlagPoleIronWithFlag extends ModelBase
{
  //fields
    ModelRenderer pole;
    ModelRenderer base;
    ModelRenderer top2;
    ModelRenderer top1;
    ModelRenderer top3;
    ModelRenderer FlagPart2;
    ModelRenderer FlagPart1;
  
  public ModelFlagPoleIronWithFlag()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      pole = new ModelRenderer(this, 0, 0);
      pole.addBox(0F, 0F, 0F, 3, 28, 3);
      pole.setRotationPoint(-2F, -4F, -2F);
      pole.setTextureSize(64, 32);
      pole.mirror = true;
      setRotation(pole, 0F, 0F, 0F);
      base = new ModelRenderer(this, 0, 0);
      base.addBox(0F, 0F, 0F, 7, 1, 7);
      base.setRotationPoint(-4F, 23F, -4F);
      base.setTextureSize(64, 32);
      base.mirror = true;
      setRotation(base, 0F, 0F, 0F);
      top2 = new ModelRenderer(this, 0, 0);
      top2.addBox(0F, 0F, 0F, 5, 1, 5);
      top2.setRotationPoint(-3F, -5F, -3F);
      top2.setTextureSize(64, 32);
      top2.mirror = true;
      setRotation(top2, 0F, 0F, 0F);
      top1 = new ModelRenderer(this, 0, 0);
      top1.addBox(0F, 0F, 0F, 4, 1, 4);
      top1.setRotationPoint(-2.5F, -4F, -2.5F);
      top1.setTextureSize(64, 32);
      top1.mirror = true;
      setRotation(top1, 0F, 0F, 0F);
      top3 = new ModelRenderer(this, 0, 0);
      top3.addBox(0F, 0F, 0F, 4, 1, 4);
      top3.setRotationPoint(-2.5F, -6F, -2.5F);
      top3.setTextureSize(64, 32);
      top3.mirror = true;
      setRotation(top3, 0F, 0F, 0F);
      FlagPart2 = new ModelRenderer(this, 0, 0);
      FlagPart2.addBox(0F, 0F, 0F, 13, 8, 1);
      FlagPart2.setRotationPoint(-16F, -2F, 0F);
      FlagPart2.setTextureSize(64, 32);
      FlagPart2.mirror = true;
      setRotation(FlagPart2, 0F, 0F, 0F);
      FlagPart1 = new ModelRenderer(this, 0, 0);
      FlagPart1.addBox(0F, 0F, 0F, 1, 9, 1);
      FlagPart1.setRotationPoint(-3F, -2F, -1F);
      FlagPart1.setTextureSize(64, 32);
      FlagPart1.mirror = true;
      setRotation(FlagPart1, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, int blockMetaData)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    pole.render(f5);
    base.render(f5);
    top2.render(f5);
    top1.render(f5);
    top3.render(f5);
    if(blockMetaData == 1) Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("rep:textures/blocks/FlagPoleFlag.png"));
    if(blockMetaData == 2) Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("rep:textures/blocks/FlagPoleFlag2.png"));
    if(blockMetaData == 3) Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("rep:textures/blocks/FlagPoleFlag3.png"));
    if(blockMetaData == 4) Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("rep:textures/blocks/FlagPoleFlag4.png"));
    if(blockMetaData == 5) Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("rep:textures/blocks/FlagPoleFlag5.png"));
    if(blockMetaData == 6) Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("rep:textures/blocks/FlagPoleFlag6.png"));
    if(blockMetaData == 7) Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("rep:textures/blocks/FlagPoleFlag7.png"));
    if(blockMetaData == 8) Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("rep:textures/blocks/FlagPoleFlag8.png"));
    if(blockMetaData == 9) Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("rep:textures/blocks/FlagPoleFlag9.png"));
    if(blockMetaData == 10) Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("rep:textures/blocks/FlagPoleFlag10.png"));
    if(blockMetaData == 11) Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("rep:textures/blocks/FlagPoleFlag11.png"));
    if(blockMetaData == 12) Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("rep:textures/blocks/FlagPoleFlag12.png"));
    if(blockMetaData == 13) Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("rep:textures/blocks/FlagPoleFlag13.png"));
    if(blockMetaData == 14) Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("rep:textures/blocks/FlagPoleFlag14.png"));
    if(blockMetaData == 15) Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("rep:textures/blocks/FlagPoleFlag15.png"));
    if(blockMetaData == 16) Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("rep:textures/blocks/FlagPoleFlag16.png"));
    FlagPart2.render(f5);
    FlagPart1.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
