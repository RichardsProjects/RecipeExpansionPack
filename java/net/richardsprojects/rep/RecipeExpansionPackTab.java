package net.richardsprojects.rep;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.richardsprojects.rep.items.RecipeExpansionPackItems;

public class RecipeExpansionPackTab extends CreativeTabs {

	public RecipeExpansionPackTab() {
		super("tabRecipeExpansionPack");
		this.setBackgroundImageName("recipeExpansionPack.png");		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return RecipeExpansionPackItems.wood_bucket;
	}

}
