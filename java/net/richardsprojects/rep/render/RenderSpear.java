package net.richardsprojects.rep.render;

import java.util.Random;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import scala.tools.nsc.Phases.Model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.richardsprojects.rep.entity.EntitySpear;
import net.richardsprojects.rep.main.SpearData;
import net.richardsprojects.rep.model.ModelSpear;

@SideOnly(Side.CLIENT)
public class RenderSpear extends Render
{
    private static final ResourceLocation texture = new ResourceLocation("rep:textures/entity/spear.png");
    
    private ModelSpear model = new ModelSpear();
    
    public RenderSpear(ModelBase par1ModelBase, float par2)
    {
        super();
 
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntitySpear par1EntityCow)
    {
        return texture;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return texture;
    }

	@Override
	public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9)
	{
       	//The PushMatrix tells the renderer to "start" doing something.
        GL11.glPushMatrix();
        //This is setting the initial location.
        GL11.glTranslatef((float)var2, (float)var4, (float)var6);

       
        ResourceLocation textures = (new ResourceLocation("rep:textures/entity/Spear.png"));
        Minecraft.getMinecraft().renderEngine.bindTexture(textures);

        //This rotation part is very important! Without it, your model will render upside-down! And for some reason you DO need PushMatrix again!                      
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        
        //Print Test Rotation Data
        System.out.println("Rotation: " + SpearData.entitySpearData.get(var1.getEntityId()));
        
        GL11.glRotatef(SpearData.entitySpearData.get(var1.getEntityId()), 1F, 0F, 0F);
        GL11.glRotatef(var1.prevRotationYaw + (var1.rotationYaw - var1.prevRotationYaw) * var9 - 90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(var1.prevRotationPitch + (var1.rotationPitch - var1.prevRotationPitch) * var9, 0.0F, 0.0F, 1.0F);
        
        //Test Code
        byte b0 = 0;
        float f2 = 0.0F;
        float f3 = 0.5F;
        float f4 = (float)(0 + b0 * 10) / 32.0F;
        float f5 = (float)(5 + b0 * 10) / 32.0F;
        float f6 = 0.0F;
        float f7 = 0.15625F;
        float f8 = (float)(5 + b0 * 10) / 32.0F;
        float f9 = (float)(10 + b0 * 10) / 32.0F;
        float f10 = 0.05625F;
        
        //GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
        //GL11.glScalef(f10, f10, f10);
        //GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
        //GL11.glNormal3f(f10, 0.0F, 0.0F);
        
        //Render the model
        this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        
        //Tell it to stop rendering for both the PushMatrix's
        GL11.glPopMatrix();
        GL11.glPopMatrix();
	}

    
 
}