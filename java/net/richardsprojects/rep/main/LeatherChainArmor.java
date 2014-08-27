package net.richardsprojects.rep.main;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.richardsprojects.rep.lib.Strings;


public class LeatherChainArmor extends ItemArmor {

	public LeatherChainArmor(ArmorMaterial mat, int id, int slot) {
		super(mat, id, slot);
		
		this.setCreativeTab(RecipeExpansionPack.tabRecipeXPack);
		
		switch(slot)
		{
		case 0:
			this.setTextureName(Strings.MODID + ":leatherChain_helmet");
			return;
		case 1:
			this.setTextureName(Strings.MODID + ":leatherChain_chestplate");
			return;
		case 2:
			this.setTextureName(Strings.MODID + ":leatherChain_leggings");
			return;
		case 3:
			this.setTextureName(Strings.MODID + ":leatherChain_boots");
			return;
		}
		
	}
	
	public String getArmorTexture(ItemStack is, Entity entity, int slot, String type)
	{
		if(is.getItem() == ItemLeatherChainArmor.helm || is.getItem() == ItemLeatherChainArmor.chest || is.getItem() == ItemLeatherChainArmor.boots)
		{
			return Strings.MODID + ":textures/model/armor/leatherchain_layer_1.png";
		}
		else if(is.getItem() == ItemLeatherChainArmor.legs)
		{
			return Strings.MODID + ":textures/model/armor/leatherChain_layer_2.png";
		}
		else
		{
			return null;
		}
	}
	
}
