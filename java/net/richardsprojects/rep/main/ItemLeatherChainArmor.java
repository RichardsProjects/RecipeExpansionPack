package net.richardsprojects.rep.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemLeatherChainArmor
{
	public static Item helm;
	public static Item legs;
	public static Item chest;
	public static Item boots;

	public static void mainRegistry()	
	{
		initializeItems();
		registerItems();
	}
	
	public static void initializeItems()
	{
		helm = new LeatherChainArmor(RecipeExpansionPack.leatherChainArmor, RecipeExpansionPack.armorLeatherChainHelmID, 0).setUnlocalizedName("leatherChain_helmet");
		chest = new LeatherChainArmor(RecipeExpansionPack.leatherChainArmor, RecipeExpansionPack.armorLeatherChainChestID, 1).setUnlocalizedName("leatherChain_chestplate");
		legs = new LeatherChainArmor(RecipeExpansionPack.leatherChainArmor, RecipeExpansionPack.armorLeatherChainLegsID, 2).setUnlocalizedName("leatherChain_leggings");
		boots = new LeatherChainArmor(RecipeExpansionPack.leatherChainArmor, RecipeExpansionPack.armorLeatherChainBootsID, 3).setUnlocalizedName("leatherChain_boots");

	}
	
	public static void registerItems()
	{
		GameRegistry.registerItem(helm, helm.getUnlocalizedName());
		GameRegistry.registerItem(chest, chest.getUnlocalizedName());
		GameRegistry.registerItem(legs, legs.getUnlocalizedName());
		GameRegistry.registerItem(boots, boots.getUnlocalizedName());
	}

	
}
