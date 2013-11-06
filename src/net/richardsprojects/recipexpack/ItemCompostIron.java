package net.richardsprojects.recipexpack;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;



public class ItemCompostIron extends Item {
   
   public ItemCompostIron(int par1) {
      super(par1);
      this.maxStackSize = 1;
      
   }
   
   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
   {
	   //Code to fertilize wheat
	   if(par3World.getBlockId(par4, par5, par6) == Block.crops.blockID)
	   {
		   //par3World.setBlockAndMetadataWithNotify(par4, par5, par6, RecipeExpansionPack.cropCompostedWheat.blockID, par3World.getBlockMetadata(par4, par5, par6), 1);
		   
		   int blockMeta = par3World.getBlockMetadata(par4, par5, par6);
		   
		   par3World.setBlock(par4, par5, par6, RecipeExpansionPack.cropCompostedWheat.blockID);
		   par3World.setBlockMetadataWithNotify(par4, par5, par6, blockMeta, 1);
		   
		   //Calculate which bucket is being used
		   String itemName = this.getItemDisplayName(par1ItemStack);
		   String itemName2 = itemName.replace("Bucket of Compost ", "");
		   String itemName3 = itemName2.replace("/6)", "");
		   String itemName4 = itemName3.replace("(", "");
		   int bucketValue = 0;
			

			   	 //Convert the number left in the item name to int.
			     bucketValue = Integer.parseInt(itemName4);
			     
			     //Subtract one from that value to get the new bucket number
			     bucketValue = bucketValue - 1;
			     
			     ItemStack replacementItemStack = new ItemStack(Item.bucketEmpty);
			     
			     if(bucketValue == 5) {
			    	 replacementItemStack = new ItemStack(RecipeExpansionPack.bucketIronCompost5);
			     }
			     else if(bucketValue == 4)
			     {
			    	 replacementItemStack = new ItemStack(RecipeExpansionPack.bucketIronCompost4);
			     }
			     else if(bucketValue == 3)
			     {
			    	 replacementItemStack = new ItemStack(RecipeExpansionPack.bucketIronCompost3);
			     }
			     else if(bucketValue == 2)
			     {
			    	 replacementItemStack = new ItemStack(RecipeExpansionPack.bucketIronCompost2);
			     }
			     else if(bucketValue == 1)
			     {
			    	 replacementItemStack = new ItemStack(RecipeExpansionPack.bucketIronCompost1);
			     }
			     
			     //Create the modified bucket
			     
			     par2EntityPlayer.inventory.setInventorySlotContents(par2EntityPlayer.inventory.currentItem, replacementItemStack);
			     
			     //Add Visual Effects
			     par3World.playAuxSFX(2001, par4, par5, par6, RecipeExpansionPack.compostBlock.blockID + (0 << 12));
  
	   }
	   
	   if(par3World.getBlockId(par4, par5, par6) == Block.carrot.blockID) {
		   
int blockMeta = par3World.getBlockMetadata(par4, par5, par6);
		   
		   par3World.setBlock(par4, par5, par6, RecipeExpansionPack.cropCompostedCarrot.blockID);
		   par3World.setBlockMetadataWithNotify(par4, par5, par6, blockMeta, 1);
		   
		   //Calculate which bucket is being used
		   String itemName = this.getItemDisplayName(par1ItemStack);
		   String itemName2 = itemName.replace("Bucket of Compost ", "");
		   String itemName3 = itemName2.replace("/6)", "");
		   String itemName4 = itemName3.replace("(", "");
		   int bucketValue = 0;
			

			   	 //Convert the number left in the item name to int.
			     bucketValue = Integer.parseInt(itemName4);
			     
			     //Subtract one from that value to get the new bucket number
			     bucketValue = bucketValue - 1;
			     
			     ItemStack replacementItemStack = new ItemStack(Item.bucketEmpty);
			     
			     if(bucketValue == 5) {
			    	 replacementItemStack = new ItemStack(RecipeExpansionPack.bucketIronCompost5);
			     }
			     else if(bucketValue == 4)
			     {
			    	 replacementItemStack = new ItemStack(RecipeExpansionPack.bucketIronCompost4);
			     }
			     else if(bucketValue == 3)
			     {
			    	 replacementItemStack = new ItemStack(RecipeExpansionPack.bucketIronCompost3);
			     }
			     else if(bucketValue == 2)
			     {
			    	 replacementItemStack = new ItemStack(RecipeExpansionPack.bucketIronCompost2);
			     }
			     else if(bucketValue == 1)
			     {
			    	 replacementItemStack = new ItemStack(RecipeExpansionPack.bucketIronCompost1);
			     }
			     
			     //Create the modified bucket
			     
			     par2EntityPlayer.inventory.setInventorySlotContents(par2EntityPlayer.inventory.currentItem, replacementItemStack);
			     
			     //Add Visual Effects
			     par3World.playAuxSFX(2001, par4, par5, par6, RecipeExpansionPack.compostBlock.blockID + (0 << 12));
		   
	   }
	   
	   
	   if(par3World.getBlockId(par4, par5, par6) == Block.potato.blockID) {
		   
		   int blockMeta = par3World.getBlockMetadata(par4, par5, par6);
		   
		   par3World.setBlock(par4, par5, par6, RecipeExpansionPack.cropCompostedPotato.blockID);
		   par3World.setBlockMetadataWithNotify(par4, par5, par6, blockMeta, 1);
		   
		   //Calculate which bucket is being used
		   String itemName = this.getItemDisplayName(par1ItemStack);
		   String itemName2 = itemName.replace("Bucket of Compost ", "");
		   String itemName3 = itemName2.replace("/6)", "");
		   String itemName4 = itemName3.replace("(", "");
		   int bucketValue = 0;
			

			   	 //Convert the number left in the item name to int.
			     bucketValue = Integer.parseInt(itemName4);
			     
			     //Subtract one from that value to get the new bucket number
			     bucketValue = bucketValue - 1;
			     
			     ItemStack replacementItemStack = new ItemStack(Item.bucketEmpty);
			     
			     if(bucketValue == 5) {
			    	 replacementItemStack = new ItemStack(RecipeExpansionPack.bucketIronCompost5);
			     }
			     else if(bucketValue == 4)
			     {
			    	 replacementItemStack = new ItemStack(RecipeExpansionPack.bucketIronCompost4);
			     }
			     else if(bucketValue == 3)
			     {
			    	 replacementItemStack = new ItemStack(RecipeExpansionPack.bucketIronCompost3);
			     }
			     else if(bucketValue == 2)
			     {
			    	 replacementItemStack = new ItemStack(RecipeExpansionPack.bucketIronCompost2);
			     }
			     else if(bucketValue == 1)
			     {
			    	 replacementItemStack = new ItemStack(RecipeExpansionPack.bucketIronCompost1);
			     }
			     
			     //Create the modified bucket
			     
			     par2EntityPlayer.inventory.setInventorySlotContents(par2EntityPlayer.inventory.currentItem, replacementItemStack);
			     
			     //Add Visual Effects
			     par3World.playAuxSFX(2001, par4, par5, par6, RecipeExpansionPack.compostBlock.blockID + (0 << 12));
		   
	   }
       return false;
   }
}