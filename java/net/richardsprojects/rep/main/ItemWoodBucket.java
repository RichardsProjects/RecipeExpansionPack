package net.richardsprojects.rep.main;

//TODO: Fix code alignment

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class ItemWoodBucket extends ItemBucket {
   
   private Block isFull;
   
   private int i;
   private int j;
   private int k;
   
   public static Item bucketWoodEmpty;
   public static Item bucketWoodWater;
   public static Item bucketWoodMilk;
   
   public ItemWoodBucket(Block par2) {
      super(par2);
      this.isFull = par2;
      setMaxStackSize(16);
 
    }
   
	public static void mainRegistry()	
	{
		initializeItem();
		registerItem();
	}
   
	public static void initializeItem()
	{
		bucketWoodEmpty = (new ItemWoodBucket(null)).setUnlocalizedName("woodbucket").setCreativeTab(RecipeExpansionPack.tabRecipeXPack).setTextureName("rep:woodbucket-e");
		bucketWoodWater = (new ItemWoodBucket(Blocks.flowing_water)).setUnlocalizedName("woodbucketWater").setContainerItem(bucketWoodEmpty).setTextureName("rep:woodbucket-w").setCreativeTab(RecipeExpansionPack.tabRecipeXPack);
		bucketWoodMilk = (new ItemWoodBucketMilk()).setUnlocalizedName("woodbucketmilk").setContainerItem(bucketWoodEmpty).setTextureName("rep:woodbucket-m").setCreativeTab(RecipeExpansionPack.tabRecipeXPack);
	}
	
	public static void registerItem()
	{
		GameRegistry.registerItem(bucketWoodEmpty, bucketWoodEmpty.getUnlocalizedName());
		GameRegistry.registerItem(bucketWoodWater, bucketWoodWater.getUnlocalizedName());
		GameRegistry.registerItem(bucketWoodMilk, bucketWoodMilk.getUnlocalizedName());

	}
   
   /**
    * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
    */
   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
   {
       boolean flag = this.isFull == null;
       MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, flag);

       if (movingobjectposition == null)
       {
           return par1ItemStack;
       }
       else
       {
           FillBucketEvent event = new FillBucketEvent(par3EntityPlayer, par1ItemStack, par2World, movingobjectposition);
           if (MinecraftForge.EVENT_BUS.post(event))
           {
               return par1ItemStack;
           }

           if (event.getResult() == Result.ALLOW)
           {
               if (par3EntityPlayer.capabilities.isCreativeMode)
               {
                   return par1ItemStack;
               }

               if (--par1ItemStack.stackSize <= 0)
               {
                   return event.result;
               }

               if (!par3EntityPlayer.inventory.addItemStackToInventory(event.result))
               {
                   par3EntityPlayer.entityDropItem(event.result, 1);
               }

               return par1ItemStack;
           }

           if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
           {
               int i = movingobjectposition.blockX;
               int j = movingobjectposition.blockY;
               int k = movingobjectposition.blockZ;

               if (!par2World.canMineBlock(par3EntityPlayer, i, j, k))
               {
                   return par1ItemStack;
               }

               if (this.isFull == null)
               {
                   if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
                   {
                       return par1ItemStack;
                   }

                   if (par2World.getBlock(i, j, k) == Blocks.water && par2World.getBlockMetadata(i, j, k) == 0)
                   {
                       par2World.setBlockToAir(i, j, k);

                       if (par3EntityPlayer.capabilities.isCreativeMode)
                       {
                           return par1ItemStack;
                       }

                       if (--par1ItemStack.stackSize <= 0)
                       {
                           return new ItemStack(ItemWoodBucket.bucketWoodWater);
                       }

                       if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ItemWoodBucket.bucketWoodWater)))
                       {
                           par3EntityPlayer.dropItem(ItemWoodBucket.bucketWoodWater, 1);
                       }

                       return par1ItemStack;
                   }
               }
           }
       }

       if (this.isFull != null)
       {
           if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
           {
               int i = movingobjectposition.blockX;
               int j = movingobjectposition.blockY;
               int k = movingobjectposition.blockZ;
    	   
               if (movingobjectposition.sideHit == 0)
               {
            	   --j;
               }

               if (movingobjectposition.sideHit == 1)
               {
            	   ++j;
               }

               if (movingobjectposition.sideHit == 2)
               {
            	   --k;
               }

               if (movingobjectposition.sideHit == 3)
               {
            	   ++k;
               }

               if (movingobjectposition.sideHit == 4)
               {
            	   --i;
               }

               if (movingobjectposition.sideHit == 5)
               {
            	   ++i;
               }

               if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
               {
           	   return par1ItemStack;
               }

               if (this.tryPlaceContainedLiquid(par2World, i, j, k) && !par3EntityPlayer.capabilities.isCreativeMode)
               {
            	   return new ItemStack(ItemWoodBucket.bucketWoodEmpty);
               }
           }
       }    
 
     return par1ItemStack;
     }
   
}


