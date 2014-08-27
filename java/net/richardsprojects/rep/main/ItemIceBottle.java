package net.richardsprojects.rep.main;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemIceBottle {
	
	public static Item iceBottle;

	public static void mainRegistry()	
	{
		initializeItem();
		registerItem();
	}
	
	public static void initializeItem()
	{
		iceBottle = new Item().setUnlocalizedName("iceBottle").setCreativeTab(RecipeExpansionPack.tabRecipeXPack).setTextureName("rep:ice_bottle").setMaxStackSize(1);

	}
	
	public static void registerItem()
	{
		GameRegistry.registerItem(iceBottle, iceBottle.getUnlocalizedName());

	}

}
