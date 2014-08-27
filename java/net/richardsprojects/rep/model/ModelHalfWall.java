package net.richardsprojects.rep.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public class ModelHalfWall extends ModelBase
{
    //fields
    ModelRenderer HalfWall;
  
  public ModelHalfWall()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      HalfWall = new ModelRenderer(this, 0, 0);
      HalfWall.addBox(0F, 0F, 0F, 16, 16, 8);
      HalfWall.setRotationPoint(-8F, 8F, 0F);
      HalfWall.setTextureSize(64, 32);
      HalfWall.mirror = true;
      setRotation(HalfWall, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    HalfWall.render(f5);
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
