package net.richardsprojects.rep;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.richardsprojects.rep.items.RecipeExpansionPackItems;
import net.richardsprojects.rep.proxy.CommonProxy;

@Mod(modid = References.MODID, name = References.MOD_NAME, version = References.VERSION)
public class RecipeExpansionPack {
	
	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final RecipeExpansionPackTab repTab = new RecipeExpansionPackTab();
	
	// TODO: Implement Cake recipe but with wood buckets of milk
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// Register Items		
		RecipeExpansionPackItems.init();
		RecipeExpansionPackItems.register();
		
		// Register Recipes
		Recipes.register();
		
    	// Register Event Handlers
    	MinecraftForge.EVENT_BUS.register(new MCForgeModEvents());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenders();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
