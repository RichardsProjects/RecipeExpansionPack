package net.richardsprojects.rep.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemPennants {

	public static Item redPennant;
	public static Item darkGreenPennant;
	public static Item yellowPennant;
	public static Item darkBluePennant;
	public static Item brownPennant;
	public static Item whitePennant;
	public static Item limePennant;
	public static Item bluePennant;
	public static Item pinkPennant;
	public static Item blackPennant;
	public static Item cyanPennant;
	public static Item darkgrayPennant;
	public static Item magentaPennant;
	public static Item orangePennant;
	public static Item purplePennant;
	public static Item grayPennant;
	
	public static void mainRegistry()	
	{
		initializeItem();
		registerItem();
	}
	
	public static void initializeItem()
	{
		redPennant = new Item().setUnlocalizedName("redPennant").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:redPennant").setMaxStackSize(1);
		darkGreenPennant = new Item().setUnlocalizedName("darkGreenPennant").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:greenPennant").setMaxStackSize(1);
		yellowPennant = new Item().setUnlocalizedName("yellowPennant").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:yellowPennant").setMaxStackSize(1);
	    darkBluePennant = new Item().setUnlocalizedName("darkBluePennant").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:darkbluePennant").setMaxStackSize(1);
		brownPennant = new Item().setUnlocalizedName("brownPennant").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:brownPennant").setMaxStackSize(1);
		whitePennant = new Item().setUnlocalizedName("whitePennant").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:whitePennant").setMaxStackSize(1);
		limePennant = new Item().setUnlocalizedName("limePennant").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:limePennant").setMaxStackSize(1);
		bluePennant = new Item().setUnlocalizedName("bluePennant").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:lightbluePennant").setMaxStackSize(1);
		pinkPennant = new Item().setUnlocalizedName("pinkPennant").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:pinkPennant").setMaxStackSize(1);
		blackPennant = new Item().setUnlocalizedName("blackPennant").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:blackPennant").setMaxStackSize(1);
		cyanPennant = new Item().setUnlocalizedName("cyanPennant").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:cyanPennant").setMaxStackSize(1);
		darkgrayPennant = new Item().setUnlocalizedName("darkgrayPennant").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:dgrayPennant").setMaxStackSize(1);
	    magentaPennant = new Item().setUnlocalizedName("magentaPennant").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:magentaPennant").setMaxStackSize(1);
		orangePennant = new Item().setUnlocalizedName("orangePennant").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:orangePennant").setMaxStackSize(1);
		purplePennant = new Item().setUnlocalizedName("purplePennant").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:purplePennant").setMaxStackSize(1);
		grayPennant = new Item().setUnlocalizedName("grayPennant").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:grayPennant").setMaxStackSize(1);
	}
	
	public static void registerItem()
	{
		GameRegistry.registerItem(redPennant, redPennant.getUnlocalizedName());
		GameRegistry.registerItem(darkGreenPennant, darkGreenPennant.getUnlocalizedName());
		GameRegistry.registerItem(yellowPennant, yellowPennant.getUnlocalizedName());
		GameRegistry.registerItem(darkBluePennant, darkBluePennant.getUnlocalizedName());
		GameRegistry.registerItem(brownPennant, brownPennant.getUnlocalizedName());
		GameRegistry.registerItem(whitePennant, whitePennant.getUnlocalizedName());
		GameRegistry.registerItem(limePennant, limePennant.getUnlocalizedName());
		GameRegistry.registerItem(bluePennant, bluePennant.getUnlocalizedName());
		GameRegistry.registerItem(pinkPennant, pinkPennant.getUnlocalizedName());
		GameRegistry.registerItem(blackPennant, blackPennant.getUnlocalizedName());
		GameRegistry.registerItem(cyanPennant, cyanPennant.getUnlocalizedName());
		GameRegistry.registerItem(darkgrayPennant, darkgrayPennant.getUnlocalizedName());
		GameRegistry.registerItem(magentaPennant, magentaPennant.getUnlocalizedName());
		GameRegistry.registerItem(purplePennant, purplePennant.getUnlocalizedName());
		GameRegistry.registerItem(grayPennant, grayPennant.getUnlocalizedName());
		GameRegistry.registerItem(orangePennant, orangePennant.getUnlocalizedName());
	}
}
