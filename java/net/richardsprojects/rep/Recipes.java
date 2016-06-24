package net.richardsprojects.rep;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.richardsprojects.rep.items.ItemWoodBucket;
import net.richardsprojects.rep.items.RecipeExpansionPackItems;

public class Recipes {

	public static void register() {

		// Wooden Bucket Recipe
		// TODO: Implement support for all other types of wood planks
		GameRegistry.addRecipe(new ItemStack(
				RecipeExpansionPackItems.wood_bucket), "x x", "y y", " y ",
				'x', new ItemStack(Items.stick), 'y', new ItemStack(
						Blocks.planks));

		// Grass Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.grass),
				new ItemStack(RecipeExpansionPackItems.grass_seeds),
				new ItemStack(Blocks.dirt));
		
		// Cake Recipe
		GameRegistry.addRecipe(new ItemStack(Items.cake), "aaa", "bcb", "ddd",
				'a', new ItemStack(RecipeExpansionPackItems.wood_bucket_milk),
				'b', new ItemStack(Items.sugar), 'c', new ItemStack(Items.egg),
				'd', new ItemStack(Items.wheat));
	}

}
