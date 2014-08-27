package net.richardsprojects.rep.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;



public class ItemCompostWooden extends Item {
   
	
   public ItemCompostWooden() {
      super();
      this.maxStackSize = 1;

   }
   
   //Register Item Code
   public static Item bucketWoodCompost6;
   public static Item bucketWoodCompost5;
   public static Item bucketWoodCompost4;
   public static Item bucketWoodCompost3;
   public static Item bucketWoodCompost2;
   public static Item bucketWoodCompost1;
	
	public static void initializeItem()
	{
		bucketWoodCompost6 = (new ItemCompostWooden()).setTextureName("rep:woodbucket-c").setUnlocalizedName("CompostWood6").setCreativeTab(RecipeExpansionPack.tabRecipeXPack);
	    bucketWoodCompost5 = (new ItemCompostWooden()).setTextureName("rep:woodbucket-c").setUnlocalizedName("CompostWood5").setCreativeTab(null);
	    bucketWoodCompost4 = (new ItemCompostWooden()).setTextureName("rep:woodbucket-c").setUnlocalizedName("CompostWood4").setCreativeTab(null);
	    bucketWoodCompost3 = (new ItemCompostWooden()).setTextureName("rep:woodbucket-c").setUnlocalizedName("CompostWood3").setCreativeTab(null);
	    bucketWoodCompost2 = (new ItemCompostWooden()).setTextureName("rep:woodbucket-c").setUnlocalizedName("CompostWood2").setCreativeTab(null);
	    bucketWoodCompost1 = (new ItemCompostWooden()).setTextureName("rep:woodbucket-c").setUnlocalizedName("CompostWood1").setCreativeTab(null);
	}
	
	public static void registerItem()
	{
		GameRegistry.registerItem(bucketWoodCompost6, bucketWoodCompost6.getUnlocalizedName());
		GameRegistry.registerItem(bucketWoodCompost5, bucketWoodCompost5.getUnlocalizedName());
		GameRegistry.registerItem(bucketWoodCompost4, bucketWoodCompost4.getUnlocalizedName());
		GameRegistry.registerItem(bucketWoodCompost3, bucketWoodCompost3.getUnlocalizedName());
		GameRegistry.registerItem(bucketWoodCompost2, bucketWoodCompost2.getUnlocalizedName());
		GameRegistry.registerItem(bucketWoodCompost1, bucketWoodCompost1.getUnlocalizedName());
	}
   
   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
   {
	   //Code to fertilize wheat
	   if(par3World.getBlock(par4, par5, par6) == Blocks.wheat)
	   {
		   //par3World.setBlockAndMetadataWithNotify(par4, par5, par6, RecipeExpansionPack.cropCompostedWheat.blockID, par3World.getBlockMetadata(par4, par5, par6), 1);
		   
		   int blockMeta = par3World.getBlockMetadata(par4, par5, par6);
		   
		   par3World.setBlock(par4, par5, par6, CropCompostedWheat.cropCompostedWheat);
		   par3World.setBlockMetadataWithNotify(par4, par5, par6, blockMeta, 1);
		   
		   //Calculate which bucket is being used
		   String itemName = this.getItemStackDisplayName(par1ItemStack);
		   String itemName2 = itemName.replace("Bucket of Compost ", "");
		   String itemName3 = itemName2.replace("/6)", "");
		   String itemName4 = itemName3.replace("(", "");
		   int bucketValue = 0;
			

			   	 //Convert the number left in the item name to int.
			     bucketValue = Integer.parseInt(itemName4);
			     
			     //Subtract one from that value to get the new bucket number
			     bucketValue = bucketValue - 1;
			     
			     ItemStack replacementItemStack = new ItemStack(ItemWoodBucket.bucketWoodEmpty);
			     
			     if(bucketValue == 5) {
			    	 replacementItemStack = new ItemStack(ItemCompostWooden.bucketWoodCompost5);
			     }
			     else if(bucketValue == 4)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostWooden.bucketWoodCompost4);
			     }
			     else if(bucketValue == 3)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostWooden.bucketWoodCompost3);
			     }
			     else if(bucketValue == 2)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostWooden.bucketWoodCompost2);
			     }
			     else if(bucketValue == 1)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostWooden.bucketWoodCompost1);
			     }
			     
			     //Create the modified bucket
			     
			     par2EntityPlayer.inventory.setInventorySlotContents(par2EntityPlayer.inventory.currentItem, replacementItemStack);
			     
			     //Add Visual Effects
			     par3World.playAuxSFX(2001, par4, par5, par6, Block.getIdFromBlock(CompostBlock.compostBlock) + (0 << 12));
  
	   }
	   
	   if(par3World.getBlock(par4, par5, par6) == Blocks.carrots) {
		   
		   int blockMeta = par3World.getBlockMetadata(par4, par5, par6);
		   
		   par3World.setBlock(par4, par5, par6, CropCompostedCarrot.cropCompostedCarrot);
		   par3World.setBlockMetadataWithNotify(par4, par5, par6, blockMeta, 1);
		   
		   //Calculate which bucket is being used
		   String itemName = this.getItemStackDisplayName(par1ItemStack);
		   String itemName2 = itemName.replace("Bucket of Compost ", "");
		   String itemName3 = itemName2.replace("/6)", "");
		   String itemName4 = itemName3.replace("(", "");
		   int bucketValue = 0;
			

			   	 //Convert the number left in the item name to int.
			     bucketValue = Integer.parseInt(itemName4);
			     
			     //Subtract one from that value to get the new bucket number
			     bucketValue = bucketValue - 1;
			     
			     ItemStack replacementItemStack = new ItemStack(ItemWoodBucket.bucketWoodEmpty);
			     
			     if(bucketValue == 5) {
			    	 replacementItemStack = new ItemStack(ItemCompostWooden.bucketWoodCompost5);
			     }
			     else if(bucketValue == 4)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostWooden.bucketWoodCompost4);
			     }
			     else if(bucketValue == 3)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostWooden.bucketWoodCompost3);
			     }
			     else if(bucketValue == 2)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostWooden.bucketWoodCompost2);
			     }
			     else if(bucketValue == 1)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostWooden.bucketWoodCompost1);
			     }
			     
			     //Create the modified bucket
			     
			     par2EntityPlayer.inventory.setInventorySlotContents(par2EntityPlayer.inventory.currentItem, replacementItemStack);
			     
			     //Add Visual Effects
			     par3World.playAuxSFX(2001, par4, par5, par6, Block.getIdFromBlock(CompostBlock.compostBlock) + (0 << 12));
		   
	   }
	   
	   
	   if(par3World.getBlock(par4, par5, par6) == Blocks.potatoes) {
		   
		   int blockMeta = par3World.getBlockMetadata(par4, par5, par6);
		   
		   par3World.setBlock(par4, par5, par6, CropCompostedPotato.cropCompostedPotato);
		   par3World.setBlockMetadataWithNotify(par4, par5, par6, blockMeta, 1);
		   
		   //Calculate which bucket is being used
		   String itemName = this.getItemStackDisplayName(par1ItemStack);
		   String itemName2 = itemName.replace("Bucket of Compost ", "");
		   String itemName3 = itemName2.replace("/6)", "");
		   String itemName4 = itemName3.replace("(", "");
		   int bucketValue = 0;
			

			   	 //Convert the number left in the item name to int.
			     bucketValue = Integer.parseInt(itemName4);
			     
			     //Subtract one from that value to get the new bucket number
			     bucketValue = bucketValue - 1;
			     
			     ItemStack replacementItemStack = new ItemStack(ItemWoodBucket.bucketWoodEmpty);
			     
			     if(bucketValue == 5) {
			    	 replacementItemStack = new ItemStack(ItemCompostWooden.bucketWoodCompost5);
			     }
			     else if(bucketValue == 4)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostWooden.bucketWoodCompost4);
			     }
			     else if(bucketValue == 3)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostWooden.bucketWoodCompost3);
			     }
			     else if(bucketValue == 2)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostWooden.bucketWoodCompost2);
			     }
			     else if(bucketValue == 1)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostWooden.bucketWoodCompost1);
			     }
			     
			     //Create the modified bucket
			     
			     par2EntityPlayer.inventory.setInventorySlotContents(par2EntityPlayer.inventory.currentItem, replacementItemStack);
			     
			     //Add Visual Effects
			     par3World.playAuxSFX(2001, par4, par5, par6, Block.getIdFromBlock(CompostBlock.compostBlock) + (0 << 12));
	   }
       return false;
   }

public static void mainRegistry() {
	
	initializeItem();
	registerItem();
	
}
}
