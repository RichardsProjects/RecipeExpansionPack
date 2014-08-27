package net.richardsprojects.rep.main;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class FlagPolePartItems {
	
	public static Item flagPartBase;
	public static Item flagPartTruk;
	public static Item flagPartPole;
	public static Item flagPartTrukIron;
	public static Item flagPartBaseIron;
	public static Item flagPartPoleIron;
	
	
	public static void mainRegistry()	
	{
		initializeItem();
		registerItem();
	}
	
	public static void initializeItem()
	{
		flagPartBase = new Item().setUnlocalizedName("flagPartBase").setCreativeTab(RecipeExpansionPack.tabRecipeXPack).setTextureName("rep:base").setMaxStackSize(1);
		flagPartTruk = new Item().setUnlocalizedName("flagPartTruk").setCreativeTab(RecipeExpansionPack.tabRecipeXPack).setTextureName("rep:truk").setMaxStackSize(1);
		flagPartPole = new Item().setUnlocalizedName("flagPartPole").setCreativeTab(RecipeExpansionPack.tabRecipeXPack).setTextureName("rep:pole").setMaxStackSize(1);
		flagPartTrukIron = new Item().setUnlocalizedName("flagPartTrukIron").setCreativeTab(RecipeExpansionPack.tabRecipeXPack).setTextureName("rep:truk_iron").setMaxStackSize(1);
		flagPartBaseIron = new Item().setUnlocalizedName("flagPartBaseIron").setCreativeTab(RecipeExpansionPack.tabRecipeXPack).setTextureName("rep:base_iron").setMaxStackSize(1);
		flagPartPoleIron = new Item().setUnlocalizedName("flagPartPoleIron").setCreativeTab(RecipeExpansionPack.tabRecipeXPack).setTextureName("rep:pole_iron").setMaxStackSize(1);
	}
	
	public static void registerItem()
	{
		GameRegistry.registerItem(flagPartBase, flagPartBase.getUnlocalizedName());
		GameRegistry.registerItem(flagPartTruk, flagPartTruk.getUnlocalizedName());
		GameRegistry.registerItem(flagPartPole, flagPartPole.getUnlocalizedName());
		GameRegistry.registerItem(flagPartTrukIron, flagPartTrukIron.getUnlocalizedName());
		GameRegistry.registerItem(flagPartPoleIron, flagPartPoleIron.getUnlocalizedName());
		GameRegistry.registerItem(flagPartBaseIron, flagPartBaseIron.getUnlocalizedName());
	}

}
