package net.richardsprojects.recipexpack.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.client.MinecraftForgeClient;
import net.richardsprojects.recipexpack.CommonProxy;
import net.richardsprojects.recipexpack.EntitySpear;
import net.richardsprojects.recipexpack.RecipeExpansionPack;

public class ClientProxy extends CommonProxy {
        
        public void registerRenderThings() {

        	EntityRegistry.registerModEntity(EntitySpear.class, "recipexpack:flyingSpear", 1, RecipeExpansionPack.instance, 64, 10, true);
        	//RenderingRegistry.registerEntityRenderingHandler(EntitySpear.class, new RenderSnowball(RecipeExpansionPack.spearIronFlying));
        	
        	
        }
        
        
        public int addArmor(String armor) {
			return RenderingRegistry.addNewArmourRendererPrefix(armor);
        	
        }
}
