package net.richardsprojects.recipexpack;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.richardsprojects.recipexpack.utilities.ItemNameHandler;

public class ModEvents
{

	@ForgeSubscribe
	public void cowHandler(EntityInteractEvent event)
	{
    	ItemStack itemstack = event.entityPlayer.inventory.getCurrentItem();

    	//For getting milk from a cow
    	
    	if(event.target instanceof EntityCow)
    	{    
    		if (itemstack != null && itemstack.itemID == RecipeExpansionPack.bucketWoodEmpty.itemID)
    		{
    			if (--itemstack.stackSize <= 0)
    			{
    				event.entityPlayer.inventory.setInventorySlotContents(event.entityPlayer.inventory.currentItem, new ItemStack(RecipeExpansionPack.bucketWoodMilk));
    			}
    			else if (!event.entityPlayer.inventory.addItemStackToInventory(new ItemStack(RecipeExpansionPack.bucketWoodMilk)))
    			{
    			event.entityPlayer.dropPlayerItem(new ItemStack(Item.bucketMilk.itemID, 1, 0));
    			}

    		}
    		else
    		{
    		}
    	}
	}
	
	@ForgeSubscribe
	public void shovelHandler(PlayerInteractEvent event) {
		
		ItemStack itemstack = event.entityPlayer.inventory.getCurrentItem();
		
		//Check to see if the player right clicked
		if(event.action.equals(event.action.RIGHT_CLICK_BLOCK)) {
			
			//Check if player has nothing in their hand
			if(event.entityPlayer.getCurrentItemOrArmor(0) != null) {
				
				if(itemstack.itemID == 269 || itemstack.itemID == 273 || itemstack.itemID == 256 || itemstack.itemID == 284 || itemstack.itemID == 277) {
			
					//Change Grass to dirt
					if(event.entityPlayer.worldObj.getBlockId(event.x, event.y, event.z) == 2) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, 3);
				
						//Drop "Grass Seeds" in front of player
						event.entityPlayer.dropPlayerItem(new ItemStack(RecipeExpansionPack.grassSeed, 1, 0));
						
						//Reduce the durability
						itemstack.damageItem(1, event.entityPlayer);
					}
				}
			}
		}
	}
		
	
	@ForgeSubscribe
	public int arrowInQuiverHandler64(PlayerInteractEvent event) {
	//Check if player has right-clicked with arrows in their hands
		
		if(event.entityPlayer.getCurrentItemOrArmor(0) != null) {
		
			if(event.entityPlayer.inventory.getCurrentItem().itemID == Item.arrow.itemID && (event.action.equals(event.action.RIGHT_CLICK_BLOCK) || event.action.equals(event.action.RIGHT_CLICK_AIR))) {
				
				if(event.entityPlayer.inventory.hasItemStack(new ItemStack(RecipeExpansionPack.quiver1))) {
					
					ItemStack currentItemInHand = event.entityPlayer.inventory.getCurrentItem();
					
					for(int i = 0; i <= 35; i++) {						
						
						if(event.entityPlayer.inventory.getStackInSlot(i) != null) {
						
							if(event.entityPlayer.inventory.getStackInSlot(i).itemID == RecipeExpansionPack.quiver1.itemID) {
							
								ItemStack quiver = event.entityPlayer.inventory.getStackInSlot(i);
														
								//Determine how many arrows are in the quiver
								int totalArrowsInQuiver = ItemNameHandler.getArrowsInQuiver(quiver);
							
								//Determine how arrows the player currently has
								int totalArrowsInStack = currentItemInHand.stackSize;
							
								int newAmountOfArrowsInQuiver = totalArrowsInStack + totalArrowsInQuiver;
							
								//Run Calculations
								if(newAmountOfArrowsInQuiver > 64) {
								
									newAmountOfArrowsInQuiver = 64;
									int amountOfArrowsToBeAddedToQuiver = newAmountOfArrowsInQuiver - totalArrowsInQuiver;
									int newAmountOfArrowsInStack = totalArrowsInStack - amountOfArrowsToBeAddedToQuiver;
								
									//Adjust arrows in Stack
									currentItemInHand.stackSize = newAmountOfArrowsInStack;
								
									//Update amount of Arrows in Quiver
									quiver.setItemName("Quiver (" + newAmountOfArrowsInQuiver + "/64)");
								
									//Exit Loop
									return 0;
								}
							
								//Adjust arrows in Stack
								currentItemInHand.stackSize = 0;
							
								//Update amount of Arrows in Quiver
								quiver.setItemName("Quiver (" + newAmountOfArrowsInQuiver + "/64)");
							
								//Exit the loop
								return 0;							
							
							}
						}
					}
				}
			}
		}
		
		//Check for Players with Quiver 2

		if(event.entityPlayer.getCurrentItemOrArmor(0) != null) {
		
			if(event.entityPlayer.inventory.getCurrentItem().itemID == Item.arrow.itemID && (event.action.equals(event.action.RIGHT_CLICK_BLOCK) || event.action.equals(event.action.RIGHT_CLICK_AIR))) {
				
				if(event.entityPlayer.inventory.hasItemStack(new ItemStack(RecipeExpansionPack.quiver2))) {
					
					ItemStack currentItemInHand = event.entityPlayer.inventory.getCurrentItem();
					
					for(int i = 0; i <= 35; i++) {						
						
						if(event.entityPlayer.inventory.getStackInSlot(i) != null) {
						
							if(event.entityPlayer.inventory.getStackInSlot(i).itemID == RecipeExpansionPack.quiver2.itemID) {
							
								ItemStack quiver = event.entityPlayer.inventory.getStackInSlot(i);
														
								//Determine how many arrows are in the quiver
								int totalArrowsInQuiver = ItemNameHandler.getArrowsInQuiver(quiver);
							
								//Determine how arrows the player currently has
								int totalArrowsInStack = currentItemInHand.stackSize;
							
								int newAmountOfArrowsInQuiver = totalArrowsInStack + totalArrowsInQuiver;
							
								//Run Calculations
								if(newAmountOfArrowsInQuiver > 128) {
								
									newAmountOfArrowsInQuiver = 128;
									int amountOfArrowsToBeAddedToQuiver = newAmountOfArrowsInQuiver - totalArrowsInQuiver;
									int newAmountOfArrowsInStack = totalArrowsInStack - amountOfArrowsToBeAddedToQuiver;
								
									//Adjust arrows in Stack
									currentItemInHand.stackSize = newAmountOfArrowsInStack;
								
									//Update amount of Arrows in Quiver
									quiver.setItemName("Quiver (" + newAmountOfArrowsInQuiver + "/128)");
								
									//Exit Loop
									return 0;
								}
							
								//Adjust arrows in Stack
								currentItemInHand.stackSize = 0;
							
								//Update amount of Arrows in Quiver
								quiver.setItemName("Quiver (" + newAmountOfArrowsInQuiver + "/128)");
							
								//Exit the loop
								return 0;							
							
							}
						}
					}
				}
			}
		}
		
		
		//Check if player has quiver 3
		
		if(event.entityPlayer.getCurrentItemOrArmor(0) != null) {
		
			if(event.entityPlayer.inventory.getCurrentItem().itemID == Item.arrow.itemID && (event.action.equals(event.action.RIGHT_CLICK_BLOCK) || event.action.equals(event.action.RIGHT_CLICK_AIR))) {
				
				if(event.entityPlayer.inventory.hasItemStack(new ItemStack(RecipeExpansionPack.quiver3))) {
					
					ItemStack currentItemInHand = event.entityPlayer.inventory.getCurrentItem();
					
					for(int i = 0; i <= 35; i++) {						
						
						if(event.entityPlayer.inventory.getStackInSlot(i) != null) {
						
							if(event.entityPlayer.inventory.getStackInSlot(i).itemID == RecipeExpansionPack.quiver3.itemID) {
							
								ItemStack quiver = event.entityPlayer.inventory.getStackInSlot(i);
														
								//Determine how many arrows are in the quiver
								int totalArrowsInQuiver = ItemNameHandler.getArrowsInQuiver(quiver);
							
								//Determine how arrows the player currently has
								int totalArrowsInStack = currentItemInHand.stackSize;
							
								int newAmountOfArrowsInQuiver = totalArrowsInStack + totalArrowsInQuiver;
							
								//Run Calculations
								if(newAmountOfArrowsInQuiver > 192) {
								
									newAmountOfArrowsInQuiver = 192;
									int amountOfArrowsToBeAddedToQuiver = newAmountOfArrowsInQuiver - totalArrowsInQuiver;
									int newAmountOfArrowsInStack = totalArrowsInStack - amountOfArrowsToBeAddedToQuiver;
								
									//Adjust arrows in Stack
									currentItemInHand.stackSize = newAmountOfArrowsInStack;
								
									//Update amount of Arrows in Quiver
									quiver.setItemName("Quiver (" + newAmountOfArrowsInQuiver + "/192)");
								
									//Exit Loop
									return 0;
								}
							
								//Adjust arrows in Stack
								currentItemInHand.stackSize = 0;
							
								//Update amount of Arrows in Quiver
								quiver.setItemName("Quiver (" + newAmountOfArrowsInQuiver + "/192)");
							
								//Exit the loop
								return 0;							
							
							}
						}
					}
				}
			}
		}		
		return 0;		
	}
	
	@ForgeSubscribe
	public void onArrowNock(ArrowNockEvent event) {
		
		//Get Item of ID of item in Chestplate Armor Slot
		int chestplateItemID = 0;
		try
		{
			chestplateItemID = event.entityPlayer.inventory.getStackInSlot(38).itemID;
		}catch(NullPointerException ex)
		{			
		}
		
		if((chestplateItemID == RecipeExpansionPack.quiver1.itemID) || (chestplateItemID == RecipeExpansionPack.quiver2.itemID) || (chestplateItemID == RecipeExpansionPack.quiver3.itemID) && !(event.entityPlayer.inventory.hasItem(Item.arrow.itemID)))
		{			
			//Check if there are arrows in the quiver			
			
			if(ItemNameHandler.getArrowsInQuiver(event.entityPlayer.inventory.getStackInSlot(38)) > 0) {
							
				//Set the bow to be in use
				event.entityPlayer.setItemInUse(event.result, 7200);
				
			}
			
		}

	}
	
	@ForgeSubscribe
	public void onArrowLoose(ArrowLooseEvent event) {
		
		int j = 7200 - event.charge;

		//Get Item of ID of item in Chestplate Armor Slot
		int chestplateItemID = 0;
		try
		{
			chestplateItemID = event.entityPlayer.inventory.getStackInSlot(38).itemID;
		}catch(NullPointerException ex)
		{			
		}
		
		if((chestplateItemID == RecipeExpansionPack.quiver1.itemID) || (chestplateItemID == RecipeExpansionPack.quiver2.itemID) || (chestplateItemID == RecipeExpansionPack.quiver3.itemID) && !(event.entityPlayer.inventory.hasItem(Item.arrow.itemID)) && !(EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, event.bow) > 0))
		{
			float f = (float)j / 20.0F;
	        f = (f * f + f * 2.0F) / 3.0F;

	        if ((double)f < 0.1D)
	        {
	        	return;
	        }

	        if (f > 1.0F)
	        {
	        	f = 1.0F;
	        }

	        EntityArrow entityarrow = new EntityArrow(event.entityPlayer.worldObj, event.entityPlayer, f * 2.0F);

	        if (f == 1.0F)
	        {
	        	entityarrow.setIsCritical(true);
	        }

	        int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, event.bow);

	        if (k > 0)
	        {
	        	entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
	        }

	        int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, event.bow);

	        if (l > 0)
	        {
	        	entityarrow.setKnockbackStrength(l);
	        }

	        if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, event.bow) > 0)
	        {
	        	entityarrow.setFire(100);
	        }

	        event.bow.damageItem(1, event.entityPlayer);
	            
	        Random itemRand = new Random();
	            
	        event.entityPlayer.worldObj.playSoundAtEntity(event.entityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

			if(chestplateItemID == RecipeExpansionPack.quiver1.itemID)
			{
				ItemStack quiver = event.entityPlayer.inventory.getStackInSlot(38);
					
				if(ItemNameHandler.getArrowsInQuiver(quiver) > 0) {
							
					quiver.setItemName("Quiver (" + (ItemNameHandler.getArrowsInQuiver(quiver) - 1) + "/64)");						
				}						
			}
					
			if(chestplateItemID == RecipeExpansionPack.quiver2.itemID)
			{
				ItemStack quiver = event.entityPlayer.inventory.getStackInSlot(38);
					
				if(ItemNameHandler.getArrowsInQuiver(quiver) > 0) {
						
					quiver.setItemName("Quiver (" + (ItemNameHandler.getArrowsInQuiver(quiver) - 1) + "/128)");
														
				}						
			}
						
			if(chestplateItemID == RecipeExpansionPack.quiver3.itemID)
			{
				ItemStack quiver = event.entityPlayer.inventory.getStackInSlot(38);
							
				if(ItemNameHandler.getArrowsInQuiver(quiver) > 0) {
								
					quiver.setItemName("Quiver (" + (ItemNameHandler.getArrowsInQuiver(quiver) - 1) + "/192)");
													
				}						
			}						
			

				if (!event.entityPlayer.worldObj.isRemote)
				{
					event.entityPlayer.worldObj.spawnEntityInWorld(entityarrow);
				}
	    }
	}
}

