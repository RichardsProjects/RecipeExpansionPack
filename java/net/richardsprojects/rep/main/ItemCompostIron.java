package net.richardsprojects.rep.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;



public class ItemCompostIron extends Item {
   
   public ItemCompostIron() {
      super();
      this.maxStackSize = 1;
      
   }
   
    //Item Registration Code
	public static void mainRegistry()	
	{
		initializeItem();
		registerItem();
	}
	
    public static Item bucketIronCompost6;
    public static Item bucketIronCompost5;
    public static Item bucketIronCompost4;
    public static Item bucketIronCompost3;
    public static Item bucketIronCompost2;
    public static Item bucketIronCompost1;
	
	public static void initializeItem()
	{
	    bucketIronCompost6 = (new ItemCompostIron()).setTextureName("rep:ironbucket-c").setUnlocalizedName("CompostIron6").setCreativeTab(RecipeExpansionPack.tabRecipeXPack);
	    bucketIronCompost5 = (new ItemCompostIron()).setTextureName("rep:ironbucket-c").setUnlocalizedName("CompostIron5").setCreativeTab(null);
	    bucketIronCompost4 = (new ItemCompostIron()).setTextureName("rep:ironbucket-c").setUnlocalizedName("CompostIron4").setCreativeTab(null);
	    bucketIronCompost3 = (new ItemCompostIron()).setTextureName("rep:ironbucket-c").setUnlocalizedName("CompostIron3").setCreativeTab(null);
	    bucketIronCompost2 = (new ItemCompostIron()).setTextureName("rep:ironbucket-c").setUnlocalizedName("CompostIron2").setCreativeTab(null);
	    bucketIronCompost1 = (new ItemCompostIron()).setTextureName("rep:ironbucket-c").setUnlocalizedName("CompostIron1").setCreativeTab(null);
	}
	
	public static void registerItem()
	{
		GameRegistry.registerItem(bucketIronCompost6, bucketIronCompost6.getUnlocalizedName());
		GameRegistry.registerItem(bucketIronCompost5, bucketIronCompost5.getUnlocalizedName());
		GameRegistry.registerItem(bucketIronCompost4, bucketIronCompost4.getUnlocalizedName());
		GameRegistry.registerItem(bucketIronCompost3, bucketIronCompost3.getUnlocalizedName());
		GameRegistry.registerItem(bucketIronCompost2, bucketIronCompost2.getUnlocalizedName());
		GameRegistry.registerItem(bucketIronCompost1, bucketIronCompost1.getUnlocalizedName());
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
			     
			     ItemStack replacementItemStack = new ItemStack(Items.bucket);
			     
			     if(bucketValue == 5) {
			    	 replacementItemStack = new ItemStack(ItemCompostIron.bucketIronCompost5);
			     }
			     else if(bucketValue == 4)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostIron.bucketIronCompost4);
			     }
			     else if(bucketValue == 3)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostIron.bucketIronCompost3);
			     }
			     else if(bucketValue == 2)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostIron.bucketIronCompost2);
			     }
			     else if(bucketValue == 1)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostIron.bucketIronCompost1);
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
			     
			     ItemStack replacementItemStack = new ItemStack(Items.bucket);
			     
			     if(bucketValue == 5) {
			    	 replacementItemStack = new ItemStack(ItemCompostIron.bucketIronCompost5);
			     }
			     else if(bucketValue == 4)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostIron.bucketIronCompost4);
			     }
			     else if(bucketValue == 3)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostIron.bucketIronCompost3);
			     }
			     else if(bucketValue == 2)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostIron.bucketIronCompost2);
			     }
			     else if(bucketValue == 1)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostIron.bucketIronCompost1);
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
			     
			     ItemStack replacementItemStack = new ItemStack(Items.bucket);
			     
			     if(bucketValue == 5) {
			    	 replacementItemStack = new ItemStack(ItemCompostIron.bucketIronCompost5);
			     }
			     else if(bucketValue == 4)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostIron.bucketIronCompost4);
			     }
			     else if(bucketValue == 3)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostIron.bucketIronCompost3);
			     }
			     else if(bucketValue == 2)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostIron.bucketIronCompost2);
			     }
			     else if(bucketValue == 1)
			     {
			    	 replacementItemStack = new ItemStack(ItemCompostIron.bucketIronCompost1);
			     }
			     
			     //Create the modified bucket
			     
			     par2EntityPlayer.inventory.setInventorySlotContents(par2EntityPlayer.inventory.currentItem, replacementItemStack);
			     
			     //Add Visual Effects
			     par3World.playAuxSFX(2001, par4, par5, par6, Block.getIdFromBlock(CompostBlock.compostBlock) + (0 << 12));
		   
	   }
       return false;
   }
}