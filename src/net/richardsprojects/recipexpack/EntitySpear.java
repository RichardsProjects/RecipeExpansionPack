package net.richardsprojects.recipexpack;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySpear extends EntityThrowable
{
	
	public int spearDurability;
	private boolean hasImpacted = false;
	
    public EntitySpear(World par1World)
    {
        super(par1World);
       
    }

    public EntitySpear(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);

    }

    public EntitySpear(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);

    }

    
    /**
     *  Sets the durability of the spear
     */
    public void setDurability(int durab) {
    	
    	this.spearDurability = durab;
    	
    }
    
    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if (par1MovingObjectPosition.entityHit != null)
        {
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeArrowDamage(new EntityArrow(worldObj), this.getThrower()), 20.0F);
        }

        for (int j = 0; j < 8; ++j)
        {
            //this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
        
        if(!hasImpacted) {
        	//Spawn new damaged spear in world
        	//ItemStack newSpear = new ItemStack(RecipeExpansionPack.spearIron);
        	//newSpear.damageItem(384 - (spearDurability - 1), this.getThrower());
        
        	//Entity entity = new EntityItem(worldObj, par1MovingObjectPosition.blockX, par1MovingObjectPosition.blockY, par1MovingObjectPosition.blockZ, newSpear);
        	//worldObj.spawnEntityInWorld(entity);
        	hasImpacted = true;
        }
    }
}
