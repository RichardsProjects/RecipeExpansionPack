package net.richardsprojects.rep.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemFlags extends Item{

	public static Item redFlag;
	public static Item darkGreenFlag;
	public static Item yellowFlag;
	public static Item darkBlueFlag;
	public static Item brownFlag;
	public static Item whiteFlag;
	public static Item limeFlag;
	public static Item blueFlag;
	public static Item pinkFlag;
	public static Item blackFlag;
	public static Item cyanFlag;
	public static Item darkgrayFlag;
	public static Item magentaFlag;
	public static Item orangeFlag;
	public static Item purpleFlag;
	public static Item grayFlag;
	
	public static void mainRegistry()	
	{
		initializeItem();
		registerItem();
	}
	
	public static void initializeItem()
	{
		redFlag = new Item().setUnlocalizedName("redFlag").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:redflag").setMaxStackSize(1);
		darkGreenFlag = new Item().setUnlocalizedName("darkGreenFlag").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:greenflag").setMaxStackSize(1);
		yellowFlag = new Item().setUnlocalizedName("yellowFlag").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:yellowflag").setMaxStackSize(1);
	    darkBlueFlag = new Item().setUnlocalizedName("darkBlueFlag").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:darkblueflag").setMaxStackSize(1);
		brownFlag = new Item().setUnlocalizedName("brownFlag").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:brownflag").setMaxStackSize(1);
		whiteFlag = new Item().setUnlocalizedName("whiteFlag").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:whiteflag").setMaxStackSize(1);
		limeFlag = new Item().setUnlocalizedName("limeFlag").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:limeflag").setMaxStackSize(1);
		blueFlag = new Item().setUnlocalizedName("blueFlag").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:lightblueflag").setMaxStackSize(1);
		pinkFlag = new Item().setUnlocalizedName("pinkFlag").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:pinkflag").setMaxStackSize(1);
		blackFlag = new Item().setUnlocalizedName("blackFlag").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:blackflag").setMaxStackSize(1);
		cyanFlag = new Item().setUnlocalizedName("cyanFlag").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:cyanflag").setMaxStackSize(1);
		darkgrayFlag = new Item().setUnlocalizedName("darkgrayFlag").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:dgrayflag").setMaxStackSize(1);
	    magentaFlag = new Item().setUnlocalizedName("magentaFlag").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:magentaflag").setMaxStackSize(1);
		orangeFlag = new Item().setUnlocalizedName("orangeFlag").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:orangeflag").setMaxStackSize(1);
		purpleFlag = new Item().setUnlocalizedName("purpleFlag").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:purpleflag").setMaxStackSize(1);
		grayFlag = new Item().setUnlocalizedName("grayFlag").setCreativeTab(RecipeExpansionPack.tabRecipeXPack2).setTextureName("rep:grayflag").setMaxStackSize(1);
	}
	
	public static void registerItem()
	{
		GameRegistry.registerItem(redFlag, redFlag.getUnlocalizedName());
		GameRegistry.registerItem(darkGreenFlag, darkGreenFlag.getUnlocalizedName());
		GameRegistry.registerItem(yellowFlag, yellowFlag.getUnlocalizedName());
		GameRegistry.registerItem(darkBlueFlag, darkBlueFlag.getUnlocalizedName());
		GameRegistry.registerItem(brownFlag, brownFlag.getUnlocalizedName());
		GameRegistry.registerItem(whiteFlag, whiteFlag.getUnlocalizedName());
		GameRegistry.registerItem(limeFlag, limeFlag.getUnlocalizedName());
		GameRegistry.registerItem(blueFlag, blueFlag.getUnlocalizedName());
		GameRegistry.registerItem(pinkFlag, pinkFlag.getUnlocalizedName());
		GameRegistry.registerItem(blackFlag, blackFlag.getUnlocalizedName());
		GameRegistry.registerItem(cyanFlag, cyanFlag.getUnlocalizedName());
		GameRegistry.registerItem(darkgrayFlag, darkgrayFlag.getUnlocalizedName());
		GameRegistry.registerItem(magentaFlag, magentaFlag.getUnlocalizedName());
		GameRegistry.registerItem(purpleFlag, purpleFlag.getUnlocalizedName());
		GameRegistry.registerItem(grayFlag, grayFlag.getUnlocalizedName());
		GameRegistry.registerItem(orangeFlag, orangeFlag.getUnlocalizedName());
	}
	
}
