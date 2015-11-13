package net.richardsprojects.rep.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.richardsprojects.rep.RecipeExpansionPack;
import net.richardsprojects.rep.References;

public class RecipeExpansionPackItems {

	public static Item wood_bucket;
	public static Item wood_bucket_milk;
	public static Item wood_bucket_water;
	public static Item grass_seeds;

	public static void init() {
		wood_bucket = new ItemWoodBucket(Blocks.air);
		wood_bucket_milk = new ItemWoodBucketMilk();
		wood_bucket_water = new ItemWoodBucketWater(Blocks.water);
		grass_seeds = new ItemGrassSeeds();
	}

	public static void register() {
		GameRegistry.registerItem(wood_bucket, wood_bucket.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(wood_bucket_milk, wood_bucket_milk
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(wood_bucket_water, wood_bucket_water
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(grass_seeds, grass_seeds.getUnlocalizedName()
				.substring(5));
	}

	public static void registerRenders() {
		registerRender(wood_bucket);
		registerRender(wood_bucket_milk);
		registerRender(wood_bucket_water);
		registerRender(grass_seeds);
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
