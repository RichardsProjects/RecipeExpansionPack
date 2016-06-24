package net.richardsprojects.rep.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumWorldBlockLayer;
import net.richardsprojects.rep.RecipeExpansionPack;

public class WoodFlagPoleEmpty extends Block {

	public WoodFlagPoleEmpty() {
		super(Material.wood);
		this.setCreativeTab(RecipeExpansionPack.repTab);
		this.setBlockBounds(0.3F, 0F, 0.3F, 0.7F, 1.86F, 0.7F);
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}
}
