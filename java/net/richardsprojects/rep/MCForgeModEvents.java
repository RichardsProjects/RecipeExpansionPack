package net.richardsprojects.rep;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.richardsprojects.rep.items.ItemGrassSeeds;
import net.richardsprojects.rep.items.RecipeExpansionPackItems;

public class MCForgeModEvents {

	@SubscribeEvent
	public void cowHandler(EntityInteractEvent event) {
		ItemStack itemstack = event.entityPlayer.inventory.getCurrentItem();

		// For getting milk from a cow
		if (event.target instanceof EntityCow) {
			if (itemstack != null
					&& itemstack.getItem() == RecipeExpansionPackItems.wood_bucket) {
				if (--itemstack.stackSize <= 0) {
					event.entityPlayer.inventory.setInventorySlotContents(
							event.entityPlayer.inventory.currentItem,
							new ItemStack(
									RecipeExpansionPackItems.wood_bucket_milk));
				} else if (!event.entityPlayer.inventory
						.addItemStackToInventory(new ItemStack(
								RecipeExpansionPackItems.wood_bucket_milk))) {
					event.entityPlayer.dropItem(
							RecipeExpansionPackItems.wood_bucket_milk, 1);
				}

			} else {
			}
		}
	}

	@SubscribeEvent
	public void shovelHandler(PlayerInteractEvent e) {
		ItemStack itemstack = e.entityPlayer.inventory.getCurrentItem();

		if (e.action.equals(e.action.RIGHT_CLICK_BLOCK)) {
			if (e.entityPlayer.inventory.getCurrentItem() != null) {
				if (itemstack.getItem() == Items.diamond_shovel
						|| itemstack.getItem() == Items.iron_shovel
						|| itemstack.getItem() == Items.stone_shovel
						|| itemstack.getItem() == Items.wooden_shovel
						|| itemstack.getItem() == Items.golden_shovel) {
					// Change Grass to dirt
					if (e.entityPlayer.worldObj.getBlockState(e.pos).getBlock() == Blocks.grass) {
						e.entityPlayer.worldObj.setBlockState(e.pos,
								Blocks.dirt.getDefaultState());

						// Create itemEntity and place it on the block
						EntityItem entityitem = new EntityItem(
								e.entityPlayer.worldObj,
								e.pos.getX(),
								e.pos.getY() + 2,
								e.pos.getZ(),
								new ItemStack(
										RecipeExpansionPackItems.grass_seeds, 1));
						entityitem.setPickupDelay(5);

						if (!e.entityPlayer.worldObj.isRemote)
							e.entityPlayer.worldObj
									.spawnEntityInWorld(entityitem);

						// Reduce the durability
						itemstack.damageItem(1, e.entityPlayer);
					}
				}
			}
		}
	}

}
