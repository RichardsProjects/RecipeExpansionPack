package net.richardsprojects.rep.proxy;

import net.richardsprojects.rep.items.RecipeExpansionPackItems;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenders() {
		RecipeExpansionPackItems.registerRenders();
	}
}
