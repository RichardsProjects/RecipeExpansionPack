package net.richardsprojects.rep.main;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockWhiteFence {

	public static Block whiteFence;
	public static void mainRegistry()
	{
		initializeBlock();
		registerBlock();
	}
	
	public static void initializeBlock()
	{
		whiteFence = new BlockFence("rep:white_fence", Material.wood).setHardness(0.3F).setBlockName("whitefence").setBlockTextureName("recipexpack:white_fence").setCreativeTab(RecipeExpansionPack.tabRecipeXPack);
	}
	
	public static void registerBlock()
	{
		GameRegistry.registerBlock(whiteFence, whiteFence.getUnlocalizedName());
	}
	
}
