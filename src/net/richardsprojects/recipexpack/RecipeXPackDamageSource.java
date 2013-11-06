package net.richardsprojects.recipexpack;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;

public class RecipeXPackDamageSource {
	
    public static DamageSource causeSpearDamage(EntitySpear par0EntitySpear, Entity par1Entity)
    {
        return (new EntityDamageSourceIndirect("spear", par0EntitySpear, par1Entity)).setProjectile();
    }

}
