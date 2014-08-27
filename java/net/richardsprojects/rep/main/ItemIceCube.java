package net.richardsprojects.rep.main;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemIceCube {

	public static Item iceCube;

	public static void mainRegistry()	
	{
		initializeItem();
		registerItem();
	}
	
	public static void initializeItem()
	{
		iceCube = new Item().setUnlocalizedName("iceCube").setCreativeTab(RecipeExpansionPack.tabRecipeXPack).setTextureName("rep:ice_cube").setMaxStackSize(64);

	}
	
	public static void registerItem()
	{
		GameRegistry.registerItem(iceCube, iceCube.getUnlocalizedName());

	}
	
}
