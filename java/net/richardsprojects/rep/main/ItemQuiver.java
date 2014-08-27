package net.richardsprojects.rep.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.richardsprojects.rep.utilities.ItemNameHandler;

public class ItemQuiver extends Item {

	public static Item quiver1;
	public static Item quiver2;
	public static Item quiver3;
	
	public ItemQuiver() {
	      super();
	      this.maxStackSize = 1;
	      this.setCreativeTab(RecipeExpansionPack.tabRecipeXPack);
	      
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		
		//Amount of Arrows in Quiver
		int numberOfArrows = ItemNameHandler.getArrowsInQuiver(par1ItemStack);
		
		//Drop Arrows In front of Player
		if(numberOfArrows > 0) {
			par3EntityPlayer.dropItem(Items.arrow, numberOfArrows);
		}
			
		//Set item name to 011
		if(par1ItemStack.getItem() == ItemQuiver.quiver1) {
			par1ItemStack.setStackDisplayName("Quiver (0/64)");
		}
		
		if(par1ItemStack.getItem() == ItemQuiver.quiver2) {
			par1ItemStack.setStackDisplayName("Quiver (0/128)");
		}
		
		if(par1ItemStack.getItem() == ItemQuiver.quiver3) {
			par1ItemStack.setStackDisplayName("Quiver (0/192)");

		}
		
		return par1ItemStack;
		
	}
	
	public static void mainRegistry()	
	{
		initializeItem();
		registerItem();
	}
	
	public static void initializeItem()
	{
		quiver1 = new ItemQuiver().setUnlocalizedName("quiver1").setCreativeTab(RecipeExpansionPack.tabRecipeXPack).setTextureName("rep:quiver").setMaxStackSize(1);
		quiver2 = new ItemQuiver().setUnlocalizedName("quiver2").setCreativeTab(RecipeExpansionPack.tabRecipeXPack).setTextureName("rep:quiver").setMaxStackSize(1);
		quiver3 = new ItemQuiver().setUnlocalizedName("quiver3").setCreativeTab(RecipeExpansionPack.tabRecipeXPack).setTextureName("rep:quiver").setMaxStackSize(1);

	}
	
	public static void registerItem()
	{
		GameRegistry.registerItem(quiver1, quiver1.getUnlocalizedName());
		GameRegistry.registerItem(quiver2, quiver2.getUnlocalizedName());
		GameRegistry.registerItem(quiver3, quiver3.getUnlocalizedName());
	}
	

	
}
