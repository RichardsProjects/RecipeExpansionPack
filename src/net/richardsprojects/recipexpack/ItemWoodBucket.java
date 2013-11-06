package net.richardsprojects.recipexpack;

//TODO: Fix code alignment

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class ItemWoodBucket extends ItemBucket {
   
   private int isFull;
   
   private int i;
   private int j;
   private int k;
   
   public ItemWoodBucket(int par1, int par2) {
      super(par1, par2);
      this.isFull = par2;
      setMaxStackSize(16);
 
   }
   
   /**
    * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
    */
   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
   {
       boolean flag = this.isFull == 0;
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

           if (event.getResult() == Event.Result.ALLOW)
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
                   par3EntityPlayer.dropPlayerItem(event.result);
               }

               return par1ItemStack;
           }

           if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
           {
               int i = movingobjectposition.blockX;
               int j = movingobjectposition.blockY;
               int k = movingobjectposition.blockZ;

               if (!par2World.canMineBlock(par3EntityPlayer, i, j, k))
               {
                   return par1ItemStack;
               }

               if (this.isFull == 0)
               {
                   if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
                   {
                       return par1ItemStack;
                   }

                   if (par2World.getBlockMaterial(i, j, k) == Material.water && par2World.getBlockMetadata(i, j, k) == 0)
                   {
                       par2World.setBlockToAir(i, j, k);

                       if (par3EntityPlayer.capabilities.isCreativeMode)
                       {
                           return par1ItemStack;
                       }

                       if (--par1ItemStack.stackSize <= 0)
                       {
                           return new ItemStack(RecipeExpansionPack.bucketWoodWater);
                       }

                       if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(RecipeExpansionPack.bucketWoodWater)))
                       {
                           par3EntityPlayer.dropPlayerItem(new ItemStack(RecipeExpansionPack.bucketWoodWater.itemID, 1, 0));
                       }

                       return par1ItemStack;
                   }
               }
           }
       }

       if (this.isFull > 0)
       {
           if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
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
            	   return new ItemStack(RecipeExpansionPack.bucketWoodEmpty);
               }
           }
       }    
 
     return par1ItemStack;
     }
   
}


