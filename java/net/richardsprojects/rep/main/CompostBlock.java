package net.richardsprojects.rep.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class CompostBlock extends Block{

	protected CompostBlock(Material mat) {
		super(mat);
		
	}
	
	public static Block compostBlock;
	
	public static void mainRegistry()	
	{
		initializeBlock();
		registerBlock();
	}
	
	public static void initializeBlock()
	{
		compostBlock = new CompostBlock(Material.ground).setBlockTextureName("rep:compostblock").setBlockName("compostBlock");
	}
	
	public static void registerBlock()
	{
		GameRegistry.registerBlock(compostBlock, compostBlock.getUnlocalizedName());
	}

}
