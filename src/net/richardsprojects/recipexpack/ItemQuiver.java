package net.richardsprojects.recipexpack;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.richardsprojects.recipexpack.client.ClientProxy;
import net.richardsprojects.recipexpack.utilities.ItemNameHandler;

public class ItemQuiver extends ItemArmor {

	public ItemQuiver(int par1) {
	      super(par1, RecipeExpansionPack.quiverArmor, 0, 1);
	      this.maxStackSize = 1;
	      
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		
		//Amount of Arrows in Quiver
		int numberOfArrows = ItemNameHandler.getArrowsInQuiver(par1ItemStack);
		
		//Drop Arrows In front of Player
		if(numberOfArrows > 0) {
			par3EntityPlayer.dropPlayerItem(new ItemStack(Item.arrow, numberOfArrows));
		}
			
		//Set item name to 0
		if(par1ItemStack.itemID == RecipeExpansionPack.quiver1.itemID) {
			par1ItemStack.setItemName("Quiver (0/64)");
		}
		
		if(par1ItemStack.itemID == RecipeExpansionPack.quiver2.itemID) {
			par1ItemStack.setItemName("Quiver (0/128)");
		}
		
		if(par1ItemStack.itemID == RecipeExpansionPack.quiver3.itemID) {
			par1ItemStack.setItemName("Quiver (0/192)");
		}
		
		return par1ItemStack;
		
	}
	
	//Set the Armor texture
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		
		return "recipexpack:textures/armor/quiver1.png";
		
	}
	
	
	
}
