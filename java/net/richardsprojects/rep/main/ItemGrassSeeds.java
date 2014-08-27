package net.richardsprojects.rep.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemGrassSeeds {

	public static void mainRegistry()	
	{
		initializeItem();
		registerItem();
	}
	
	public static Item grassSeeds;
	
	public static void initializeItem()
	{
		grassSeeds = new Item().setUnlocalizedName("grassSeeds").setCreativeTab(RecipeExpansionPack.tabRecipeXPack).setTextureName("rep:grassSeeds");
	}
	
	public static void registerItem()
	{
		GameRegistry.registerItem(grassSeeds, grassSeeds.getUnlocalizedName());
	}
}
