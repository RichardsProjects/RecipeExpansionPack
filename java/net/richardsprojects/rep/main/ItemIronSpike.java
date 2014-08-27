package net.richardsprojects.rep.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemIronSpike {

	public static void mainRegistry()	
	{
		initializeItem();
		registerItem();
	}
	
	public static Item ironSpike;
	
	public static void initializeItem()
	{
		ironSpike = new Item().setUnlocalizedName("ironSpike").setCreativeTab(RecipeExpansionPack.tabRecipeXPack).setTextureName("rep:spike");
	}
	
	public static void registerItem()
	{
		GameRegistry.registerItem(ironSpike, ironSpike.getUnlocalizedName());
	}
}
