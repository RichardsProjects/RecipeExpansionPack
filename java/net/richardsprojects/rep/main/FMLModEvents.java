package net.richardsprojects.rep.main;

import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class FMLModEvents {
	
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent e) 
	{
		//EntityPlayer player, ItemStack item, IInventory inv
		//e.craftMatrix
		//e.crafting
		
		System.out.println("Test!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		IInventory inv = e.craftMatrix;
		
		System.out.println("DEBUG: " + inv.getSizeInventory());
		
	    for(int i=0; i < inv.getSizeInventory(); i++)
	    {
	        if(inv.getStackInSlot(i) != null)
	        {
	            ItemStack j = inv.getStackInSlot(i);
	            if(j.getItem() != null && j.getItem() == ItemIceBottle.iceBottle)
	            {
	                ItemStack k = new ItemStack(Items.glass_bottle, 2);
	                inv.setInventorySlotContents(i, k);
	            }
	        }
	    }
	}
	
	@SubscribeEvent
	public void onCrafting2(ItemCraftedEvent e) 
	{
		//EntityPlayer player, ItemStack item, IInventory inv
		//e.craftMatrix
		//e.crafting
		
		IInventory inv = e.craftMatrix;
		
	    for(int i=0; i < inv.getSizeInventory(); i++)
	    {
	        if(inv.getStackInSlot(i) != null)
	        {
	            ItemStack j = inv.getStackInSlot(i);
	            if(j.getItem() != null && j.getItem() == ItemChisel.chisel)
	            {
	                ItemStack k = new ItemStack(ItemChisel.chisel, 2, j.getItemDamage() + 1);
	                inv.setInventorySlotContents(i, k);
	            }
	        }
	    }
	}

}
