package net.richardsprojects.rep.items;

import net.minecraft.item.Item;
import net.richardsprojects.rep.RecipeExpansionPack;

public class ItemGrassSeeds extends Item {
 
    public ItemGrassSeeds()
    {
        this.setMaxStackSize(64);
        setUnlocalizedName("grass_seeds");
        this.setCreativeTab(RecipeExpansionPack.repTab);
    }
}
