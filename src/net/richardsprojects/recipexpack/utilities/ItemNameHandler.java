package net.richardsprojects.recipexpack.utilities;

import net.minecraft.item.ItemStack;

public class ItemNameHandler {
	
	public static int getArrowsInQuiver(ItemStack quiver) {
		
		String name = quiver.getDisplayName();
		
		//Begin replacing pieces of the string until only the number is left
		String name1 = name.replace("Quiver ", "");
		String name2 = name1.replace("(", "");
		String name3 = name2.replace("/64)", "");
		String name4 = name3.replace("/128)", "");
		String name5 = name4.replace("/192)", "");
		
		//Convert the string to an integer
		int returnValue = Integer.parseInt(name5);
		
		//Return that value
		return returnValue;
		
	}

}
