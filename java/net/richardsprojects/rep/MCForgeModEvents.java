package net.richardsprojects.rep;

import net.minecraft.entity.passive.EntityCow;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.richardsprojects.rep.items.ItemWoodBucket;
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

}
