package net.richardsprojects.rep.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.richardsprojects.rep.RecipeExpansionPack;

public class ItemWoodBucket extends ItemBucket {

    private Block isFull;
	
	public ItemWoodBucket(Block substance) {
		super(substance);
		setUnlocalizedName("wood_bucket");
        this.isFull = substance;
		setCreativeTab(RecipeExpansionPack.repTab);
	}

	 /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        boolean flag = this.isFull == Blocks.air;
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(worldIn, playerIn, flag);

        if (movingobjectposition == null)
        {
            return itemStackIn;
        }
        else
        {
            ItemStack ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, itemStackIn, movingobjectposition);
            if (ret != null) return ret;

            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                BlockPos blockpos = movingobjectposition.getBlockPos();

                if (!worldIn.isBlockModifiable(playerIn, blockpos))
                {
                    return itemStackIn;
                }

                if (flag)
                {
                    if (!playerIn.canPlayerEdit(blockpos.offset(movingobjectposition.sideHit), movingobjectposition.sideHit, itemStackIn))
                    {
                        return itemStackIn;
                    }

                    IBlockState iblockstate = worldIn.getBlockState(blockpos);
                    Material material = iblockstate.getBlock().getMaterial();

                    // TODO: Uncomment this once the water bucket is implemented
                    /*if (material == Material.water && ((Integer)iblockstate.getValue(BlockLiquid.LEVEL)).intValue() == 0)
                    {
                        worldIn.setBlockToAir(blockpos);
                        playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
                        return this.fillBucket(itemStackIn, playerIn, Items.water_bucket);
                    }*/

                }
                else
                {
                    if (this.isFull == Blocks.air)
                    {
                        return new ItemStack(RecipeExpansionPackItems.wood_bucket);
                    }

                    // TODO: Move this code to the water bucket class once it is implemented
                    /*BlockPos blockpos1 = blockpos.offset(movingobjectposition.sideHit);

                    if (!playerIn.canPlayerEdit(blockpos1, movingobjectposition.sideHit, itemStackIn))
                    {
                        return itemStackIn;
                    }

                    if (this.tryPlaceContainedLiquid(worldIn, blockpos1) && !playerIn.capabilities.isCreativeMode)
                    {
                        playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
                        return new ItemStack(Items.bucket);
                    }*/
                }
            }

            return itemStackIn;
        }
    }

    private ItemStack fillBucket(ItemStack emptyBuckets, EntityPlayer player, Item fullBucket)
    {
        if (player.capabilities.isCreativeMode)
        {
            return emptyBuckets;
        }
        else if (--emptyBuckets.stackSize <= 0)
        {
            return new ItemStack(fullBucket);
        }
        else
        {
            if (!player.inventory.addItemStackToInventory(new ItemStack(fullBucket)))
            {
                player.dropPlayerItemWithRandomChoice(new ItemStack(fullBucket, 1, 0), false);
            }

            return emptyBuckets;
        }
    }

    
    // TODO: Move this function to the water bucket once it is implemented
    /*public boolean tryPlaceContainedLiquid(World worldIn, BlockPos pos)
    {
        if (this.isFull == Blocks.air)
        {
            return false;
        }
        else
        {
            Material material = worldIn.getBlockState(pos).getBlock().getMaterial();
            boolean flag = !material.isSolid();

            if (!worldIn.isAirBlock(pos) && !flag)
            {
                return false;
            }
            else
            {
                if (worldIn.provider.doesWaterVaporize() && this.isFull == Blocks.flowing_water)
                {
                    int i = pos.getX();
                    int j = pos.getY();
                    int k = pos.getZ();
                    worldIn.playSoundEffect((double)((float)i + 0.5F), (double)((float)j + 0.5F), (double)((float)k + 0.5F), "random.fizz", 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);

                    for (int l = 0; l < 8; ++l)
                    {
                        worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double)i + Math.random(), (double)j + Math.random(), (double)k + Math.random(), 0.0D, 0.0D, 0.0D, new int[0]);
                    }
                }
                else
                {
                    if (!worldIn.isRemote && flag && !material.isLiquid())
                    {
                        worldIn.destroyBlock(pos, true);
                    }

                    worldIn.setBlockState(pos, this.isFull.getDefaultState(), 3);
                }

                return true;
            }
        }
    }*/
}
