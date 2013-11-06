package net.richardsprojects.recipexpack.recipes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.richardsprojects.recipexpack.RecipeExpansionPack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CompostRecipes {
	
	public static void addCompostRecipes(GameRegistry gameRegistry) {
		
		//Add Compost Recipes - Wooden Bucket
		
		//Carrot Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(RecipeExpansionPack.bucketWoodCompost6),
				new ItemStack(Item.carrot), new ItemStack(Item.carrot), new ItemStack(Item.carrot),
				new ItemStack(Item.carrot), new ItemStack(RecipeExpansionPack.bucketWoodEmpty));
		
		//Wheat Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(RecipeExpansionPack.bucketWoodCompost6),
				new ItemStack(Item.wheat), new ItemStack(Item.wheat), new ItemStack(Item.wheat),
				new ItemStack(Item.wheat), new ItemStack(RecipeExpansionPack.bucketWoodEmpty));
		
		//Sapling Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(RecipeExpansionPack.bucketWoodCompost6),
				new ItemStack(Block.sapling), new ItemStack(Block.sapling), new ItemStack(Block.sapling),
				new ItemStack(Block.sapling), new ItemStack(RecipeExpansionPack.bucketWoodEmpty));
		
	
		//Seeds Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(RecipeExpansionPack.bucketWoodCompost6),
				new ItemStack(Item.seeds), new ItemStack(Item.seeds), new ItemStack(Item.seeds),
				new ItemStack(Item.seeds), new ItemStack(RecipeExpansionPack.bucketWoodEmpty));
		
		//Potato Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(RecipeExpansionPack.bucketWoodCompost6),
				new ItemStack(Item.potato), new ItemStack(Item.potato), new ItemStack(Item.potato),
				new ItemStack(Item.potato), new ItemStack(RecipeExpansionPack.bucketWoodEmpty));
		
		//Sugarcane Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(RecipeExpansionPack.bucketWoodCompost6),
				new ItemStack(Item.reed), new ItemStack(Item.reed), new ItemStack(Item.reed),
				new ItemStack(Item.reed), new ItemStack(RecipeExpansionPack.bucketWoodEmpty));

		
		//Add Compost Recipes - Iron Bucket
		//Carrot Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(RecipeExpansionPack.bucketIronCompost6),
				new ItemStack(Item.carrot), new ItemStack(Item.carrot), new ItemStack(Item.carrot),
				new ItemStack(Item.carrot), new ItemStack(Item.bucketEmpty));
		
		//Wheat Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(RecipeExpansionPack.bucketIronCompost6),
				new ItemStack(Item.wheat), new ItemStack(Item.wheat), new ItemStack(Item.wheat),
				new ItemStack(Item.wheat), new ItemStack(Item.bucketEmpty));
		
		//Sapling Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(RecipeExpansionPack.bucketIronCompost6),
				new ItemStack(Block.sapling), new ItemStack(Block.sapling), new ItemStack(Block.sapling),
				new ItemStack(Block.sapling), new ItemStack(Item.bucketEmpty));
		
		//Seeds Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(RecipeExpansionPack.bucketIronCompost6),
				new ItemStack(Item.seeds), new ItemStack(Item.seeds), new ItemStack(Item.seeds),
				new ItemStack(Item.seeds), new ItemStack(Item.bucketEmpty));
		
		//Potato Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(RecipeExpansionPack.bucketIronCompost6),
				new ItemStack(Item.potato), new ItemStack(Item.potato), new ItemStack(Item.potato),
				new ItemStack(Item.potato), new ItemStack(Item.bucketEmpty));
		
		//Sugarcane Recipe
		gameRegistry.addShapelessRecipe(new ItemStack(RecipeExpansionPack.bucketIronCompost6),
				new ItemStack(Item.reed), new ItemStack(Item.reed), new ItemStack(Item.reed),
				new ItemStack(Item.reed), new ItemStack(Item.bucketEmpty));
		
	}

}
