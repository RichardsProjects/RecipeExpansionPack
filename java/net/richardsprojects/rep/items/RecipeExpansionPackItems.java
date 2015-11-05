package net.richardsprojects.rep.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.richardsprojects.rep.References;

public class RecipeExpansionPackItems {

	public static Item wood_bucket;

	public static void init() {
		wood_bucket = new ItemWoodBucket(Blocks.air)
				.setUnlocalizedName("wood_bucket");
	}

	public static void register() {
		GameRegistry.registerItem(wood_bucket, wood_bucket.getUnlocalizedName()
				.substring(5));
	}

	public static void registerRenders() {
		registerRender(wood_bucket);
	}

	public static void registerRender(Item item) {
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
