package net.richardsprojects.rep.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.richardsprojects.rep.References;
import net.richardsprojects.rep.items.Strings;

public class RecipeExpansionPackBlocks {

	public static Block woodFlagPoleEmpty;
	public static Block woodFlagPoleFlag;
	public static Block woodFlagPolePennant;

	public static void init() {
		woodFlagPoleEmpty = new WoodFlagPoleEmpty()
				.setUnlocalizedName("woodFlagPoleEmpty");
		woodFlagPoleFlag = new WoodFlagPoleFlag().setUnlocalizedName("woodFlagPoleFlag");
		//woodFlagPolePennant = new WoodFlagPoleEmpty(FlagMaterial.PENNANT)
		//		.setUnlocalizedName("woodFlagPolePennant");
	}

	public static void register() {
		GameRegistry.registerBlock(woodFlagPoleEmpty, woodFlagPoleEmpty
				.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(woodFlagPoleFlag, woodFlagPoleFlag
				.getUnlocalizedName().substring(5));
		//GameRegistry.registerBlock(woodFlagPolePennant, woodFlagPolePennant
		//		.getUnlocalizedName().substring(5));
	}

	public static void registerRenders() {
		registerRender(woodFlagPoleEmpty);
		registerRender(woodFlagPoleFlag);
		//registerRender(woodFlagPolePennant);
	}

	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft
				.getMinecraft()
				.getRenderItem()
				.getItemModelMesher()
				.register(
						item,
						0,
						new ModelResourceLocation(References.MODID + ":"
								+ item.getUnlocalizedName().substring(5),
								"inventory"));
	}

}
