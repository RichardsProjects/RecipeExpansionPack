package net.richardsprojects.rep.recipes;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.richardsprojects.rep.main.ItemCompostIron;
import net.richardsprojects.rep.main.ItemCompostWooden;
import net.richardsprojects.rep.main.ItemWoodBucket;
import cpw.mods.fml.common.registry.GameRegistry;

public class CompostRecipes {
	
	public static void addCompostRecipes(GameRegistry gameRegistry) {
		
		//Add Compost Recipes - Wooden Bucket
		
		//Carrot Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(ItemCompostWooden.bucketWoodCompost6),
				new ItemStack(Items.carrot), new ItemStack(Items.carrot), new ItemStack(Items.carrot),
				new ItemStack(Items.carrot), new ItemStack(ItemWoodBucket.bucketWoodEmpty));
		
		//Wheat Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(ItemCompostWooden.bucketWoodCompost6),
				new ItemStack(Items.wheat), new ItemStack(Items.wheat), new ItemStack(Items.wheat),
				new ItemStack(Items.wheat), new ItemStack(ItemWoodBucket.bucketWoodEmpty));
		
		//Sapling Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(ItemCompostWooden.bucketWoodCompost6),
				new ItemStack(Blocks.sapling), new ItemStack(Blocks.sapling), new ItemStack(Blocks.sapling),
				new ItemStack(Blocks.sapling), new ItemStack(ItemWoodBucket.bucketWoodEmpty));
		
	
		//Seeds Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(ItemCompostWooden.bucketWoodCompost6),
				new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds),
				new ItemStack(Items.wheat_seeds), new ItemStack(ItemWoodBucket.bucketWoodEmpty));
		
		//Potato Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(ItemCompostWooden.bucketWoodCompost6),
				new ItemStack(Items.potato), new ItemStack(Items.potato), new ItemStack(Items.potato),
				new ItemStack(Items.potato), new ItemStack(ItemWoodBucket.bucketWoodEmpty));
		
		//Sugarcane Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(ItemCompostWooden.bucketWoodCompost6),
				new ItemStack(Items.reeds), new ItemStack(Items.reeds), new ItemStack(Items.reeds),
				new ItemStack(Items.reeds), new ItemStack(ItemWoodBucket.bucketWoodEmpty));

		
		//Add Compost Recipes - Iron Bucket
		//Carrot Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(ItemCompostIron.bucketIronCompost6),
				new ItemStack(Items.carrot), new ItemStack(Items.carrot), new ItemStack(Items.carrot),
				new ItemStack(Items.carrot), new ItemStack(Items.bucket));
		
		//Wheat Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(ItemCompostIron.bucketIronCompost6),
				new ItemStack(Items.wheat), new ItemStack(Items.wheat), new ItemStack(Items.wheat),
				new ItemStack(Items.wheat), new ItemStack(Items.bucket));
		
		//Sapling Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(ItemCompostIron.bucketIronCompost6),
				new ItemStack(Blocks.sapling), new ItemStack(Blocks.sapling), new ItemStack(Blocks.sapling),
				new ItemStack(Blocks.sapling), new ItemStack(Items.bucket));
		
		//Seeds Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(ItemCompostIron.bucketIronCompost6),
				new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds),
				new ItemStack(Items.wheat_seeds), new ItemStack(Items.bucket));
		
		//Potato Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(ItemCompostIron.bucketIronCompost6),
				new ItemStack(Items.potato), new ItemStack(Items.potato), new ItemStack(Items.potato),
				new ItemStack(Items.potato), new ItemStack(Items.bucket));
		
		//Sugarcane Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(ItemCompostIron.bucketIronCompost6),
				new ItemStack(Items.reeds), new ItemStack(Items.reeds), new ItemStack(Items.reeds),
				new ItemStack(Items.reeds), new ItemStack(Items.bucket));
		
	}

}
