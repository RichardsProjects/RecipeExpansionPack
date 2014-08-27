package net.richardsprojects.rep.main;

import java.util.Random;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.richardsprojects.rep.utilities.ItemNameHandler;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class MCForgeModEvents
{

	@SubscribeEvent
	public void waterBottleHandler(PlayerInteractEvent event) {
		
		ItemStack itemstack = event.entityPlayer.inventory.getCurrentItem();
		
		//Check to see if the player right clicked
		if(event.action.equals(event.action.RIGHT_CLICK_BLOCK)) {
			
			//Check if player has nothing in their hand
			if(event.entityPlayer.inventory.getCurrentItem() != null)
			{
				
				if(itemstack.getItem() == Items.potionitem && itemstack.getItemDamage() == 0)
				{
			
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == Blocks.ice)
					{
						event.entityPlayer.inventory.setInventorySlotContents(event.entityPlayer.inventory.currentItem, new ItemStack(ItemIceBottle.iceBottle, 1));
					}
				}
			}
		}
	}
	@SubscribeEvent
	public void shovelHandler(PlayerInteractEvent event) {
		
		ItemStack itemstack = event.entityPlayer.inventory.getCurrentItem();
		
		//Check to see if the player right clicked
		if(event.action.equals(event.action.RIGHT_CLICK_BLOCK)) {
			
			//Check if player has nothing in their hand
			if(event.entityPlayer.inventory.getCurrentItem() != null) {
				
				if(itemstack.getItem() == Item.getItemById(269) || itemstack.getItem() == Item.getItemById(273) || itemstack.getItem() == Item.getItemById(284) || itemstack.getItem() == Item.getItemById(256) || itemstack.getItem() == Item.getItemById(277)) {
			
					System.out.println("Test2");
					
					//Change Grass to dirt
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == Block.getBlockFromName("grass")) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, Blocks.dirt, 0, 2);
				
						//Create itemEntity and place it on the block
						EntityItem entityitem = new EntityItem(event.entityPlayer.worldObj, event.x, event.y + 2, event.z, new ItemStack(ItemGrassSeeds.grassSeeds, 1));
						entityitem.delayBeforeCanPickup = 10;
						
						if(!event.entityPlayer.worldObj.isRemote) event.entityPlayer.worldObj.spawnEntityInWorld(entityitem);
						
						//Reduce the durability
						itemstack.damageItem(1, event.entityPlayer);
						
					}
				}
			}
		}
	}
		
	@SubscribeEvent
	public void cowHandler(EntityInteractEvent event)
	{
    	ItemStack itemstack = event.entityPlayer.inventory.getCurrentItem();

    	//For getting milk from a cow
    	
    	if(event.target instanceof EntityCow)
    	{    
    		System.out.println("Test1");
    		if (itemstack != null && itemstack.getItem() == ItemWoodBucket.bucketWoodEmpty)
    		{
    		    System.out.println("Test2");
    			if (--itemstack.stackSize <= 0)
    			{
    				event.entityPlayer.inventory.setInventorySlotContents(event.entityPlayer.inventory.currentItem, new ItemStack(ItemWoodBucket.bucketWoodMilk));
    			}
    			else if (!event.entityPlayer.inventory.addItemStackToInventory(new ItemStack(ItemWoodBucket.bucketWoodMilk)))
    			{
    				event.entityPlayer.dropItem(ItemWoodBucket.bucketWoodMilk, 1);
    			}

    		}
    		else
    		{
    		}
    	}
	}
	
	
	@SubscribeEvent
	public void flagHandler(PlayerInteractEvent event) {
		
		ItemStack itemstack = event.entityPlayer.inventory.getCurrentItem();
		
		//Check to see if the player right clicked
		if(event.action.equals(event.action.RIGHT_CLICK_BLOCK)) {
			
			//Check if player has nothing in their hand
			if(event.entityPlayer.inventory.getCurrentItem() != null) {
				
				if(itemstack.getItem() == ItemFlags.redFlag) {
								
					//Change Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 1, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 1, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemFlags.darkGreenFlag) {
					
					
					//Change Grass to dirt
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 2, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 2, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemFlags.yellowFlag) {
					
				
					//Change Grass to dirt
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 3, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 3, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemFlags.brownFlag) {
					
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 4, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 4, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemFlags.darkBlueFlag) {
					
					//Change Grass to dirt
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 5, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 5, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemFlags.whiteFlag) {
					
					//Change Grass to dirt
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 6, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 6, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemFlags.limeFlag) {
					
					//Change Grass to dirt
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 7, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 7, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemFlags.blueFlag) {
					
					//Change Grass to dirt
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 8, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 8, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemFlags.pinkFlag) {
					
					//Change Grass to dirt
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 9, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 9, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemFlags.blackFlag) {
					
					//Change Grass to dirt
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 10, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 10, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemFlags.cyanFlag) {
					
					//Change Grass to dirt
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 11, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 11, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemFlags.darkgrayFlag) {
					
					//Change Grass to dirt
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 12, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 12, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemFlags.magentaFlag) {
					
					//Change Grass to dirt
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 13, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 13, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemFlags.orangeFlag) {
					
					//Change Grass to dirt
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 14, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 14, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemFlags.purpleFlag) {
					
					//Change Grass to dirt
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 15, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 15, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemFlags.grayFlag) {
					
					//Change Grass to dirt
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 16, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 16, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				//Code for Pennants
				if(itemstack.getItem() == ItemPennants.redPennant) {
								
					//Change Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPolePennant.flagPole2);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 1, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPoleIronPennant.flagPoleIronPennant);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 1, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemPennants.darkGreenPennant) {
					
					//Change Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPolePennant.flagPole2);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 2, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPoleIronPennant.flagPoleIronPennant);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 2, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemPennants.yellowPennant) {
					
					//Change Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPolePennant.flagPole2);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 3, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPoleIronPennant.flagPoleIronPennant);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 3, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemPennants.brownPennant) {
					
					//Change Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPolePennant.flagPole2);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 4, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPoleIronPennant.flagPoleIronPennant);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 4, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemPennants.darkBluePennant) {
					
					//Change Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPolePennant.flagPole2);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 5, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPoleIronPennant.flagPoleIronPennant);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 5, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemPennants.whitePennant) {
					
					//Change Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPolePennant.flagPole2);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 6, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPoleIronPennant.flagPoleIronPennant);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 6, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemPennants.limePennant) {
					
					//Change Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPolePennant.flagPole2);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 7, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPoleIronPennant.flagPoleIronPennant);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 7, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemPennants.bluePennant) {
					
					//Change Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPolePennant.flagPole2);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 8, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPoleIronPennant.flagPoleIronPennant);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 8, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemPennants.pinkPennant) {
					
					//Change Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPolePennant.flagPole2);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 9, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPoleIronPennant.flagPoleIronPennant);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 9, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemPennants.blackPennant) {
					
					//Change Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPolePennant.flagPole2);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 10, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPoleIronPennant.flagPoleIronPennant);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 10, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemPennants.cyanPennant) {
					
					//Change Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPolePennant.flagPole2);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 11, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPoleIronPennant.flagPoleIronPennant);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 11, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemPennants.darkgrayPennant) {
					
					//Change Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPolePennant.flagPole2);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 12, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPoleIronPennant.flagPoleIronPennant);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 12, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemPennants.magentaPennant) {
					
					//Change Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPolePennant.flagPole2);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 13, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPoleIronPennant.flagPoleIronPennant);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 13, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemPennants.orangePennant) {
					
					//Change Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPolePennant.flagPole2);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 14, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPoleIronPennant.flagPoleIronPennant);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 14, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemPennants.purplePennant) {
					
					//Change Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPolePennant.flagPole2);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 15, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPoleIronPennant.flagPoleIronPennant);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 15, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
				
				if(itemstack.getItem() == ItemPennants.grayPennant) {
					
					//Change Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPolePennant.flagPole2);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 16, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
					
					//Iron Flag Pole
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole) {
						event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPoleIronPennant.flagPoleIronPennant);
						event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 16, 1);
				
						//Remove Flag from player's inventory
						itemstack.stackSize = 0;
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void removalOfFlagHandler(PlayerInteractEvent event) {
		
		ItemStack itemstack = event.entityPlayer.inventory.getCurrentItem();
		
		//Check to see if the player right clicked
		if(event.action.equals(event.action.LEFT_CLICK_BLOCK)) {
			
			//Check if the block is a flag pole and metadata is greater than 0
			if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPole.flagPole && event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) > 0)
			{
				int metadata = event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z);
				Item flag = null;
				
				if(metadata == 1) flag = ItemFlags.redFlag;
				if(metadata == 2) flag = ItemFlags.darkGreenFlag;
				if(metadata == 3) flag = ItemFlags.yellowFlag;
				if(metadata == 4) flag = ItemFlags.brownFlag;
				if(metadata == 5) flag = ItemFlags.darkBlueFlag;
				if(metadata == 6) flag = ItemFlags.whiteFlag;
				if(metadata == 7) flag = ItemFlags.limeFlag;
				if(metadata == 8) flag = ItemFlags.blueFlag;
				if(metadata == 9) flag = ItemFlags.pinkFlag;
				if(metadata == 10) flag = ItemFlags.blackFlag;
				if(metadata == 11) flag = ItemFlags.cyanFlag;
				if(metadata == 12) flag = ItemFlags.darkgrayFlag;
				if(metadata == 13) flag = ItemFlags.magentaFlag;
				if(metadata == 14) flag = ItemFlags.orangeFlag;
				if(metadata == 15) flag = ItemFlags.purpleFlag;
				if(metadata == 16) flag = ItemFlags.grayFlag;
				
				if(flag != null)
				{
					if(!event.entityPlayer.inventory.addItemStackToInventory(new ItemStack(flag, 1)))
					{
						if(!event.entityPlayer.worldObj.isRemote)
						{
							//Create itemEntity and place it on the block
							EntityItem entityitem = new EntityItem(event.entityPlayer.worldObj, event.x, event.y + 2, event.z, new ItemStack(flag, 1));
							entityitem.delayBeforeCanPickup = 10;
							
							event.entityPlayer.worldObj.spawnEntityInWorld(entityitem);
						}
					}
				}
				
				//Reset the metadata
				event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 0, 1);
			}
			
			//Check if the block is a flag pole and metadata is greater than 0
			if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPolePennant.flagPole2 && event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) > 0)
			{
				int metadata = event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z);
				Item flag = null;
				
				if(metadata == 1) flag = ItemPennants.redPennant;
				if(metadata == 2) flag = ItemPennants.darkGreenPennant;
				if(metadata == 3) flag = ItemPennants.yellowPennant;
				if(metadata == 4) flag = ItemPennants.brownPennant;
				if(metadata == 5) flag = ItemPennants.darkBluePennant;
				if(metadata == 6) flag = ItemPennants.whitePennant;
				if(metadata == 7) flag = ItemPennants.limePennant;
				if(metadata == 8) flag = ItemPennants.bluePennant;
				if(metadata == 9) flag = ItemPennants.pinkPennant;
				if(metadata == 10) flag = ItemPennants.blackPennant;
				if(metadata == 11) flag = ItemPennants.cyanPennant;
				if(metadata == 12) flag = ItemPennants.darkgrayPennant;
				if(metadata == 13) flag = ItemPennants.magentaPennant;
				if(metadata == 14) flag = ItemPennants.orangePennant;
				if(metadata == 15) flag = ItemPennants.purplePennant;
				if(metadata == 16) flag = ItemPennants.grayPennant;
				
				if(flag != null)
				{
					if(!event.entityPlayer.inventory.addItemStackToInventory(new ItemStack(flag, 1)))
					{
						if(!event.entityPlayer.worldObj.isRemote)
						{
							//Create itemEntity and place it on the block
							EntityItem entityitem = new EntityItem(event.entityPlayer.worldObj, event.x, event.y + 2, event.z, new ItemStack(flag, 1));
							entityitem.delayBeforeCanPickup = 10;
							
							event.entityPlayer.worldObj.spawnEntityInWorld(entityitem);
						}
					}
				}
				
				//Reset the metadata
				event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPole.flagPole);
				event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 0, 1);
			}
			
			//Check if the block is an iron flag pole and metadata is greater than 0
			if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIronPennant.flagPoleIronPennant && event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) > 0)
			{
				int metadata = event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z);
				Item flag = null;
				
				if(metadata == 1) flag = ItemPennants.redPennant;
				if(metadata == 2) flag = ItemPennants.darkGreenPennant;
				if(metadata == 3) flag = ItemPennants.yellowPennant;
				if(metadata == 4) flag = ItemPennants.brownPennant;
				if(metadata == 5) flag = ItemPennants.darkBluePennant;
				if(metadata == 6) flag = ItemPennants.whitePennant;
				if(metadata == 7) flag = ItemPennants.limePennant;
				if(metadata == 8) flag = ItemPennants.bluePennant;
				if(metadata == 9) flag = ItemPennants.pinkPennant;
				if(metadata == 10) flag = ItemPennants.blackPennant;
				if(metadata == 11) flag = ItemPennants.cyanPennant;
				if(metadata == 12) flag = ItemPennants.darkgrayPennant;
				if(metadata == 13) flag = ItemPennants.magentaPennant;
				if(metadata == 14) flag = ItemPennants.orangePennant;
				if(metadata == 15) flag = ItemPennants.purplePennant;
				if(metadata == 16) flag = ItemPennants.grayPennant;
				
				if(flag != null)
				{
					if(!event.entityPlayer.inventory.addItemStackToInventory(new ItemStack(flag, 1)))
					{
						if(!event.entityPlayer.worldObj.isRemote)
						{
							//Create itemEntity and place it on the block
							EntityItem entityitem = new EntityItem(event.entityPlayer.worldObj, event.x, event.y + 2, event.z, new ItemStack(flag, 1));
							entityitem.delayBeforeCanPickup = 10;
							
							event.entityPlayer.worldObj.spawnEntityInWorld(entityitem);
						}
					}
				}
				
				//Reset the metadata
				event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPoleIron.flagPole);
				event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 0, 1);
			}		
		}
		
		//Check if the block is an iron flag pole and metadata is greater than 0
		if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BlockFlagPoleIron.flagPole && event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) > 0)
		{
			int metadata = event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z);
			Item flag = null;
			
			if(metadata == 1) flag = ItemPennants.redPennant;
			if(metadata == 2) flag = ItemPennants.darkGreenPennant;
			if(metadata == 3) flag = ItemPennants.yellowPennant;
			if(metadata == 4) flag = ItemPennants.brownPennant;
			if(metadata == 5) flag = ItemPennants.darkBluePennant;
			if(metadata == 6) flag = ItemPennants.whitePennant;
			if(metadata == 7) flag = ItemPennants.limePennant;
			if(metadata == 8) flag = ItemPennants.bluePennant;
			if(metadata == 9) flag = ItemPennants.pinkPennant;
			if(metadata == 10) flag = ItemPennants.blackPennant;
			if(metadata == 11) flag = ItemPennants.cyanPennant;
			if(metadata == 12) flag = ItemPennants.darkgrayPennant;
			if(metadata == 13) flag = ItemPennants.magentaPennant;
			if(metadata == 14) flag = ItemPennants.orangePennant;
			if(metadata == 15) flag = ItemPennants.purplePennant;
			if(metadata == 16) flag = ItemPennants.grayPennant;
			
			if(flag != null)
			{
				if(!event.entityPlayer.inventory.addItemStackToInventory(new ItemStack(flag, 1)))
				{
					if(!event.entityPlayer.worldObj.isRemote)
					{
						//Create itemEntity and place it on the block
						EntityItem entityitem = new EntityItem(event.entityPlayer.worldObj, event.x, event.y + 2, event.z, new ItemStack(flag, 1));
						entityitem.delayBeforeCanPickup = 10;
						
						event.entityPlayer.worldObj.spawnEntityInWorld(entityitem);
					}
				}
			}
			
			//Reset the metadata
			event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, BlockFlagPoleIron.flagPole);
			event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, 0, 1);
		}		
	}
	
	@SubscribeEvent
	public void entityJoin(EntityJoinWorldEvent event)
	{
		//Check to make sure that the entity is a player
		if(event.entity instanceof EntityPlayer && event.entity.worldObj.isRemote)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			ThreadCheckForUpdates checkForUpdates = new ThreadCheckForUpdates(player);
			checkForUpdates.run();
			
		}
	}
	
	//Quiver Handling Code
	@SubscribeEvent
	public int arrowInQuiverHandler64(PlayerInteractEvent event) {
	//Check if player has right-clicked with arrows in their hands
		
		if(event.entityPlayer.inventory.getCurrentItem() != null) {
		
			if(event.entityPlayer.inventory.getCurrentItem().getItem() == Items.arrow && (event.action.equals(event.action.RIGHT_CLICK_BLOCK) || event.action.equals(event.action.RIGHT_CLICK_AIR))) {
				
				if(event.entityPlayer.inventory.hasItemStack(new ItemStack(ItemQuiver.quiver1))) {
					
					ItemStack currentItemInHand = event.entityPlayer.inventory.getCurrentItem();
					
					for(int i = 0; i <= 35; i++) {						
						
						if(event.entityPlayer.inventory.getStackInSlot(i) != null) {
						
							if(event.entityPlayer.inventory.getStackInSlot(i).getItem() == ItemQuiver.quiver1) {
							
								ItemStack quiver = event.entityPlayer.inventory.getStackInSlot(i);
														
								//Determine how many arrows are in the quiver
								int totalArrowsInQuiver = ItemNameHandler.getArrowsInQuiver(quiver);
							
								//Determine how many arrows the player currently has
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
									quiver.setStackDisplayName("Quiver (" + newAmountOfArrowsInQuiver + "/64)");
								
									//Exit Loop
									return 0;
								}
							
								//Adjust arrows in Stack
								currentItemInHand.stackSize = 0;
							
								//Update amount of Arrows in Quiver
								quiver.setStackDisplayName("Quiver (" + newAmountOfArrowsInQuiver + "/64)");
							
								//Exit the loop
								return 0;							
							
							}
						}
					}
				}
			}
		}
		
		//Check for Players with Quiver 2

		if(event.entityPlayer.inventory.getCurrentItem() != null) {
		
			if(event.entityPlayer.inventory.getCurrentItem().getItem() == Items.arrow && (event.action.equals(event.action.RIGHT_CLICK_BLOCK) || event.action.equals(event.action.RIGHT_CLICK_AIR))) {
				
				if(event.entityPlayer.inventory.hasItemStack(new ItemStack(ItemQuiver.quiver2))) {
					
					ItemStack currentItemInHand = event.entityPlayer.inventory.getCurrentItem();
					
					for(int i = 0; i <= 35; i++) {						
						
						if(event.entityPlayer.inventory.getStackInSlot(i) != null) {
						
							if(event.entityPlayer.inventory.getStackInSlot(i).getItem() == ItemQuiver.quiver2) {
							
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
									quiver.setStackDisplayName("Quiver (" + newAmountOfArrowsInQuiver + "/128)");
								
									//Exit Loop
									return 0;
								}
							
								//Adjust arrows in Stack
								currentItemInHand.stackSize = 0;
							
								//Update amount of Arrows in Quiver
								quiver.setStackDisplayName("Quiver (" + newAmountOfArrowsInQuiver + "/128)");
							
								//Exit the loop
								return 0;							
							
							}
						}
					}
				}
			}
		}
		
		
		//Check if player has quiver 3
		
		if(event.entityPlayer.inventory.getCurrentItem() != null) {
		
			if(event.entityPlayer.inventory.getCurrentItem().getItem() == Items.arrow && (event.action.equals(event.action.RIGHT_CLICK_BLOCK) || event.action.equals(event.action.RIGHT_CLICK_AIR))) {
				
				if(event.entityPlayer.inventory.hasItemStack(new ItemStack(ItemQuiver.quiver3)))
				{
					
					ItemStack currentItemInHand = event.entityPlayer.inventory.getCurrentItem();
					
					for(int i = 0; i <= 35; i++) {						
						
						if(event.entityPlayer.inventory.getStackInSlot(i) != null) {
						
							if(event.entityPlayer.inventory.getStackInSlot(i).getItem() == ItemQuiver.quiver3) {
							
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
									quiver.setStackDisplayName("Quiver (" + newAmountOfArrowsInQuiver + "/192)");
								
									//Exit Loop
									return 0;
								}
							
								//Adjust arrows in Stack
								currentItemInHand.stackSize = 0;
							
								//Update amount of Arrows in Quiver
								quiver.setStackDisplayName("Quiver (" + newAmountOfArrowsInQuiver + "/192)");
							
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
	
	@SubscribeEvent
	public int onArrowNock(ArrowNockEvent event)
	{
		
		if(event.entityPlayer.inventory.hasItemStack(new ItemStack(ItemQuiver.quiver3)) || event.entityPlayer.inventory.hasItemStack(new ItemStack(ItemQuiver.quiver2)) || event.entityPlayer.inventory.hasItemStack(new ItemStack(ItemQuiver.quiver1)))
		{
			
			ItemStack currentItemInHand = event.entityPlayer.inventory.getCurrentItem();
			
			for(int i = 0; i <= 35; i++)
			{						
				
				if(event.entityPlayer.inventory.getStackInSlot(i) != null)
				{
				
					if(event.entityPlayer.inventory.getStackInSlot(i).getItem() == ItemQuiver.quiver1)
					{
						
						ItemStack quiver = event.entityPlayer.inventory.getStackInSlot(i);
												
						//Determine how many arrows are in the quiver
						int totalArrowsInQuiver = ItemNameHandler.getArrowsInQuiver(quiver);
					
						if(ItemNameHandler.getArrowsInQuiver(quiver) > 0)
						{
							//We do not change the amount of arrows in the quiver yet
							//because that will happen in the next event.
							
							//Set the bow to be in use
							event.entityPlayer.setItemInUse(event.result, 7200);
							
							//Exit the loop
							return 0;
						}
					}
					
					if(event.entityPlayer.inventory.getStackInSlot(i).getItem() == ItemQuiver.quiver2)
					{
						
						ItemStack quiver = event.entityPlayer.inventory.getStackInSlot(i);
												
						//Determine how many arrows are in the quiver
						int totalArrowsInQuiver = ItemNameHandler.getArrowsInQuiver(quiver);
					
						if(ItemNameHandler.getArrowsInQuiver(quiver) > 0)
						{
							//We do not change the amount of arrows in the quiver yet
							//because that will happen in the next event.
							
							//Set the bow to be in use
							event.entityPlayer.setItemInUse(event.result, 7200);
							
							//Exit the loop
							return 0;
						}
					}
					
					if(event.entityPlayer.inventory.getStackInSlot(i).getItem() == ItemQuiver.quiver3)
					{
					
						ItemStack quiver = event.entityPlayer.inventory.getStackInSlot(i);
												
						//Determine how many arrows are in the quiver
						int totalArrowsInQuiver = ItemNameHandler.getArrowsInQuiver(quiver);
					
						if(ItemNameHandler.getArrowsInQuiver(quiver) > 0)
						{
							//We do not change the amount of arrows in the quiver yet
							//because that will happen in the next event.
							
							//Set the bow to be in use
							event.entityPlayer.setItemInUse(event.result, 7200);
							
							//Exit the loop
							return 0;
						}					
					}
				}
			}
		}
		return 0;
	}	
	
	@SubscribeEvent
	public int onArrowLoose(ArrowLooseEvent event)
	{
		//Test for debug
		System.out.println("Test to check if event is being called");
		
		int j = 7200 - event.charge;

		
		if(event.entityPlayer.inventory.hasItemStack(new ItemStack(ItemQuiver.quiver3)) || event.entityPlayer.inventory.hasItemStack(new ItemStack(ItemQuiver.quiver2)) || event.entityPlayer.inventory.hasItemStack(new ItemStack(ItemQuiver.quiver1)))
		{
			
			ItemStack currentItemInHand = event.entityPlayer.inventory.getCurrentItem();
			
			for(int i = 0; i <= 35; i++)
			{						
				
				if(event.entityPlayer.inventory.getStackInSlot(i) != null)
				{
				
					if(event.entityPlayer.inventory.getStackInSlot(i).getItem() == ItemQuiver.quiver1)
					{
						
						ItemStack quiver = event.entityPlayer.inventory.getStackInSlot(i);
												
						//Determine how many arrows are in the quiver
						int totalArrowsInQuiver = ItemNameHandler.getArrowsInQuiver(quiver);
					
						if(ItemNameHandler.getArrowsInQuiver(quiver) > 0)
						{
							int newArrowsInQuiver = totalArrowsInQuiver - 1;
							quiver.setStackDisplayName("Quiver (" + newArrowsInQuiver + "/64)");
							
							float f = (float)j / 20.0F;
	        					f = (f * f + f * 2.0F) / 3.0F;

	        					if ((double)f < 0.1D)
	        					{
	        						return 0;
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
							
	        		            if (!event.entityPlayer.worldObj.isRemote && !(event.entityPlayer.capabilities.isCreativeMode))
	        		            {
	        		            	event.entityPlayer.worldObj.spawnEntityInWorld(entityarrow);
	        		            }
	        					
							//Exit the loop
							return 0;
						}
					}
					
					if(event.entityPlayer.inventory.getStackInSlot(i).getItem() == ItemQuiver.quiver2)
					{
						
						ItemStack quiver = event.entityPlayer.inventory.getStackInSlot(i);
												
						//Determine how many arrows are in the quiver
						int totalArrowsInQuiver = ItemNameHandler.getArrowsInQuiver(quiver);
					
						if(ItemNameHandler.getArrowsInQuiver(quiver) > 0)
						{
							int newArrowsInQuiver = totalArrowsInQuiver - 1;
							quiver.setStackDisplayName("Quiver (" + newArrowsInQuiver + "/128)");
							
							float f = (float)j / 20.0F;
	        					f = (f * f + f * 2.0F) / 3.0F;

	        					if ((double)f < 0.1D)
	        					{
	        						return 0;
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
							
	        		            if (!event.entityPlayer.worldObj.isRemote && !(event.entityPlayer.capabilities.isCreativeMode))
	        		            {
	        		            	event.entityPlayer.worldObj.spawnEntityInWorld(entityarrow);
	        		            }
	        					
							//Exit the loop
							return 0;
						}
					}
					
					if(event.entityPlayer.inventory.getStackInSlot(i).getItem() == ItemQuiver.quiver3) {
					
						ItemStack quiver = event.entityPlayer.inventory.getStackInSlot(i);
												
						//Determine how many arrows are in the quiver
						int totalArrowsInQuiver = ItemNameHandler.getArrowsInQuiver(quiver);
					
						if(ItemNameHandler.getArrowsInQuiver(quiver) > 0)
						{
							int newArrowsInQuiver = totalArrowsInQuiver - 1;
							quiver.setStackDisplayName("Quiver (" + newArrowsInQuiver + "/192)");
							
							float f = (float)j / 20.0F;
	        					f = (f * f + f * 2.0F) / 3.0F;

	        					if ((double)f < 0.1D)
	        					{
	        						return 0;
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
							
	        		            if (!event.entityPlayer.worldObj.isRemote && !(event.entityPlayer.capabilities.isCreativeMode))
	        		            {
	        		            	event.entityPlayer.worldObj.spawnEntityInWorld(entityarrow);
	        		            }
	        					
							//Exit the loop
							return 0;					
						}
					}
				}
			}
		}
		return 0;
	}
	
	//Handles Skeletons death to occasionally drop a quiver
	@SubscribeEvent
	public void skeletonDeathHandler(LivingDeathEvent event)
	{
		if(event.entityLiving instanceof EntitySkeleton && event.source.getEntity() instanceof EntityPlayer)
		{
			if(!event.entityLiving.worldObj.isRemote)
			{
				int randomNumber = (int) (Math.random() * 100);
				
				if(randomNumber <= 4)
				{
					//Create itemEntity for quiver and drop it
					EntityItem entityitem = new EntityItem(event.entityLiving.worldObj, event.entityLiving.lastTickPosX, event.entityLiving.lastTickPosY + 2, event.entityLiving.lastTickPosZ, new ItemStack(ItemQuiver.quiver2, 1));
					if(randomNumber == 3 || randomNumber == 4)
					{
						entityitem = new EntityItem(event.entityLiving.worldObj, event.entityLiving.lastTickPosX, event.entityLiving.lastTickPosY + 2, event.entityLiving.lastTickPosZ, new ItemStack(ItemQuiver.quiver3, 1));
					}
					entityitem.delayBeforeCanPickup = 10;
					
					if(!event.entityLiving.worldObj.isRemote) event.entityLiving.worldObj.spawnEntityInWorld(entityitem);
				}
			}
		}
	}
}