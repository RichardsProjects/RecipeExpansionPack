package net.richardsprojects.rep.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public class ModelSpear extends ModelBase
{
  //fields
    ModelRenderer Shaft;
    ModelRenderer tip1;
    ModelRenderer tip2;
    ModelRenderer tip3;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
  
  public ModelSpear()
  {
	  textureWidth = 64;
	  textureHeight = 32;
    
      Shaft = new ModelRenderer(this, 0, 0);
      Shaft.addBox(0F, 0F, 0F, 31, 1, 1);
      Shaft.setRotationPoint(0F, 15F, 7F);
      Shaft.setTextureSize(64, 32);
      Shaft.mirror = true;
      setRotation(Shaft, 0F, 1.570796F, 0F);
      tip1 = new ModelRenderer(this, 0, 0);
      tip1.addBox(0F, 0F, 0F, 1, 3, 1);
      tip1.setRotationPoint(0F, 14F, 6F);
      tip1.setTextureSize(64, 32);
      tip1.mirror = true;
      setRotation(tip1, 0F, 1.570796F, 0F);
      tip2 = new ModelRenderer(this, 0, 0);
      tip2.addBox(0F, 0F, 0F, 1, 2, 1);
      tip2.setRotationPoint(0F, 14.5F, 7F);
      tip2.setTextureSize(64, 32);
      tip2.mirror = true;
      setRotation(tip2, 0F, 1.570796F, 0F);
      tip3 = new ModelRenderer(this, 0, 0);
      tip3.addBox(0F, 0F, 0F, 1, 1, 3);
      tip3.setRotationPoint(-1F, 15F, 6F);
      tip3.setTextureSize(64, 32);
      tip3.mirror = true;
      setRotation(tip3, 0F, 1.570796F, 0F);
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 1, 1, 2);
      Shape1.setRotationPoint(-0.5F, 15F, 7F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 1.570796F, 0F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape2.setRotationPoint(0F, 15F, 7.5F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 1.570796F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shaft.render(f5);
    tip1.render(f5);
    tip2.render(f5);
    tip3.render(f5);
    Shape1.render(f5);
    Shape2.render(f5);
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
