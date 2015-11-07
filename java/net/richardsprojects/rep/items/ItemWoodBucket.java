package net.richardsprojects.rep.items;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBucket;
import net.richardsprojects.rep.RecipeExpansionPack;

public class ItemWoodBucket extends ItemBucket {

	public ItemWoodBucket(Block substance) {
		super(substance);
		setUnlocalizedName("wood_bucket");
		setCreativeTab(RecipeExpansionPack.repTab);
	}

}
