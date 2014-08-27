package net.richardsprojects.rep.main;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemChisel {
	
	public static Item chisel;

	public static void mainRegistry()	
	{
		initializeItem();
		registerItem();
	}
	
	public static void initializeItem()
	{
		chisel = new Item().setUnlocalizedName("chisel").setCreativeTab(RecipeExpansionPack.tabRecipeXPack).setTextureName("rep:chisel").setMaxStackSize(1).setMaxDamage(64);

	}
	
	public static void registerItem()
	{
		GameRegistry.registerItem(chisel, chisel.getUnlocalizedName());

	}

}
