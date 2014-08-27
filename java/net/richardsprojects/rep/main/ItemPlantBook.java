package net.richardsprojects.rep.main;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemPlantBook extends Item {
	
	public static Item plantBook;
	
    //Item Registration Code
	public static void mainRegistry()	
	{
		initializeItem();
		registerItem();
	}

	private static void registerItem() {
		GameRegistry.registerItem(plantBook, plantBook.getUnlocalizedName());		
	}

	private static void initializeItem() {
		plantBook = new ItemPlantBook().setUnlocalizedName("PlantBook").setCreativeTab(RecipeExpansionPack.tabRecipeXPack).setTextureName("book_normal").setMaxStackSize(1).setMaxDamage(64);
	}
		
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if(!par2EntityPlayer.worldObj.isRemote)
		{
			String text = "";
			
			//Code to check stage of Wheat
			if(par3World.getBlock(par4, par5, par6) == Blocks.wheat)
			{
				text = "Wheat (" + (par3World.getBlockMetadata(par4, par5, par6));
				text = text + ")";
			}
			   
			//Code to check stage of Carrots
			if(par3World.getBlock(par4, par5, par6) == Blocks.carrots)
			{
				text = "Carrots (" + (par3World.getBlockMetadata(par4, par5, par6));
				text = text + ")";
			}
			   
			//Code to check stage of Potatoes
			if(par3World.getBlock(par4, par5, par6) == Blocks.potatoes)
			{
				text = "Potatoes (" + (par3World.getBlockMetadata(par4, par5, par6));
				text = text + ")";
			}
			   
			//Code to check the flowers
			if(par3World.getBlock(par4, par5, par6) == Block.getBlockById(38))
			{
				if(par3World.getBlockMetadata(par4, par5, par6) == 0) text = "Poppy";
				if(par3World.getBlockMetadata(par4, par5, par6) == 1) text = "Blue Orchid";
				if(par3World.getBlockMetadata(par4, par5, par6) == 2) text = "Allium";
				if(par3World.getBlockMetadata(par4, par5, par6) == 3) text = "Azure Bluet";
				if(par3World.getBlockMetadata(par4, par5, par6) == 4) text = "Red Tulip";
				if(par3World.getBlockMetadata(par4, par5, par6) == 5) text = "Orange Tulip";
				if(par3World.getBlockMetadata(par4, par5, par6) == 6) text = "White Tulip";
				if(par3World.getBlockMetadata(par4, par5, par6) == 7) text = "Pink Tulip";
				if(par3World.getBlockMetadata(par4, par5, par6) == 8) text = "Oxeye Daisy";			 
			}
			   
			//Code to check tall flowers
			if(par3World.getBlock(par4, par5, par6) == Block.getBlockById(175))
			{
				if(par3World.getBlockMetadata(par4, par5, par6) == 0) text = "Sunflower";
				if(par3World.getBlockMetadata(par4, par5, par6) == 1) text = "Lilac";
				if(par3World.getBlockMetadata(par4, par5, par6) == 2) text = "Double Tallgrass";
				if(par3World.getBlockMetadata(par4, par5, par6) == 3) text = "Large Fern";
				if(par3World.getBlockMetadata(par4, par5, par6) == 4) text = "Rose Bush";
				if(par3World.getBlockMetadata(par4, par5, par6) == 5) text = "Peony";
				if(text.equals(""))
				{
					if(par3World.getBlockMetadata(par4, par5 - 1, par6) == 0) text = "Sunflower";
					if(par3World.getBlockMetadata(par4, par5 - 1, par6) == 1) text = "Lilac";
					if(par3World.getBlockMetadata(par4, par5 - 1, par6) == 2) text = "Double Tallgrass";
					if(par3World.getBlockMetadata(par4, par5 - 1, par6) == 3) text = "Large Fern";
					if(par3World.getBlockMetadata(par4, par5 - 1, par6) == 4) text = "Rose Bush";
					if(par3World.getBlockMetadata(par4, par5 - 1, par6) == 5) text = "Peony";
				}
			}
			   
			//Code to check tall grass and dead plants
			if(par3World.getBlock(par4, par5, par6) == Block.getBlockById(31))
			{
				if(par3World.getBlockMetadata(par4, par5, par6) == 0) text = "Shrub";
				if(par3World.getBlockMetadata(par4, par5, par6) == 1) text = "Tallgrass";
				if(par3World.getBlockMetadata(par4, par5, par6) == 2) text = "Fern";
				if(par3World.getBlockMetadata(par4, par5, par6) == 3) text = "Shrub";
			}
			   
			//Code to check dandelions
			if(par3World.getBlock(par4, par5, par6) == Blocks.yellow_flower) text = "Dandelion";
			   
		    //Code to check lilypads
			if(par3World.getBlock(par4, par5, par6) == Block.getBlockById(111)) text = "Lily Pad";
			
			//Code to check reeds
			if(par3World.getBlock(par4, par5, par6) == Blocks.reeds) text = "Sugar Cane";
			
			//Print Message in Chat & Deal Durability damage if applicable
			if(!text.equals(""))
			{
				//Print Message in Chat
				par2EntityPlayer.addChatComponentMessage(new ChatComponentText("\u00a77The book seems to identify the plant as a \u00a7e" + text + "\u00a77."));
				
				//Damge Item (If not in creative)
				if(!par2EntityPlayer.capabilities.isCreativeMode)
				{
					par1ItemStack.damageItem(1, par2EntityPlayer);
				}
			}
		}
		return true;
	}
		
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}
}