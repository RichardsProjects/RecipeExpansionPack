package net.richardsprojects.rep.main;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
//import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.richardsprojects.rep.entity.BlockFlagPoleEntity;
import net.richardsprojects.rep.entity.BlockFlagPoleIronEntity;
import net.richardsprojects.rep.entity.BlockFlagPoleIronPennantEntity;
import net.richardsprojects.rep.entity.BlockWoodWallEntity;
import net.richardsprojects.rep.entity.EntitySpear;
import net.richardsprojects.rep.lib.Strings;
import net.richardsprojects.rep.model.ModelSpear;
import net.richardsprojects.rep.recipes.CompostRecipes;
import net.richardsprojects.rep.render.FlagPoleIronPennantRenderer;
import net.richardsprojects.rep.render.FlagPoleIronRenderer;
import net.richardsprojects.rep.render.FlagPolePennantRenderer;
import net.richardsprojects.rep.render.FlagPoleRenderer;
import net.richardsprojects.rep.render.RenderBlockWoodWall;
import net.richardsprojects.rep.render.RenderSpear;
import cpw.mods.fml.client.registry.ClientRegistry;
//import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
//import cpw.mods.fml.common.network.NetworkRegistry;
//import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid=Strings.MODID, name=Strings.MOD_NAME, version=Strings.VERSION)

public class RecipeExpansionPack {
	
	public static ArmorMaterial leatherChainArmor = EnumHelper.addArmorMaterial("LeatherChainArmor", 10, new int[] {2, 5, 4, 2}, 13);
	
	public static CreativeTabs tabRecipeXPack = new CreativeTabs("tabREP") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return ItemGrassSeeds.grassSeeds;
		}
	};

	public static CreativeTabs tabRecipeXPack2 = new CreativeTabs("tabFlags") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return ItemFlags.blueFlag;
		}
	};
	
    // The instance of your mod that Forge uses.
    @Instance("RecipeExpansionPack")
    public static RecipeExpansionPack instance;
    
    public static int armorLeatherChainHelmID;
    public static int armorLeatherChainLegsID;
    public static int armorLeatherChainChestID;
    public static int armorLeatherChainBootsID;
    
    @EventHandler 
    public void preInit(FMLPreInitializationEvent event) {

    	//TODO: Add Recipe for Iron Flag Pole
    	
    	ItemGrassSeeds.mainRegistry();
    	ItemWoodBucket.mainRegistry();
    	ItemCompostIron.mainRegistry();
    	ItemCompostWooden.mainRegistry();
    	CompostBlock.mainRegistry();
    	CropCompostedCarrot.mainRegistry();
    	CropCompostedWheat.mainRegistry();
    	CropCompostedPotato.mainRegistry();
    	ItemFlags.mainRegistry();
    	ItemIceBottle.mainRegistry();
    	FlagPolePartItems.mainRegistry();
    	ItemIceCube.mainRegistry();
    	ItemQuiver.mainRegistry();
    	BlockWhiteFence.mainRegistry();
    	BlockClearGlass.mainRegistry();
    	ItemChisel.mainRegistry();
    	BlockFlagPolePennant.mainRegistry();
    	ItemPennants.mainRegistry();
    	ItemLeatherChainArmor.mainRegistry();
    	ItemIronSpike.mainRegistry();
    	//TODO: Disabled temporarily as I was unable to get it to work in time
    	//ItemSpear.mainRegistry();
    	//TODO: Disabled temporarily as I was unable to get it to work in time
    	//BlockWoodWall.mainRegistry();
    	BlockFlagPole.mainRegistry();
    	BlockFlagPoleIron.mainRegistry();
    	BlockFlagPoleIronPennant.mainRegistry();
    	ItemPlantBook.mainRegistry();
    	
    	//Register Event Handlers
    	MinecraftForge.EVENT_BUS.register(new MCForgeModEvents());
    	FMLCommonHandler.instance().bus().register(new FMLModEvents());
    	
    	//Register Entities
    	//EntityRegistry.registerModEntity(EntitySpear.class, "Spear", 1, this, 64, 10, true);
    	//RenderingRegistry.registerEntityRenderingHandler(EntitySpear.class, new RenderSpear(new ModelSpear(), 0));
    	GameRegistry.registerTileEntity(BlockFlagPoleEntity.class, "tileEntityFlagPole");
    	GameRegistry.registerTileEntity(BlockFlagPolePennantEntity.class, "tileEntityFlagPolePennant");
    	GameRegistry.registerTileEntity(BlockFlagPoleIronEntity.class, "tileEntityFlagPoleIron");
    	GameRegistry.registerTileEntity(BlockFlagPoleIronPennantEntity.class, "tileEntityFlagPoleIronPennant");
   	    	
    	//Add Recipes
    	
    	//Add Compost Recipe
    	CompostRecipes.addCompostRecipes(new GameRegistry());
    	
    	//Flint Recipe
        GameRegistry.addShapelessRecipe(new ItemStack(Items.flint), new ItemStack(Blocks.gravel), 
        		new ItemStack(Blocks.gravel));
        
        //Mossy Cobblestone - Cobble & Vines
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.mossy_cobblestone),
        		new ItemStack(Blocks.vine), new ItemStack(Blocks.cobblestone));
        
        //Grass Block - grass seeds
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.grass),
        		new ItemStack(ItemGrassSeeds.grassSeeds), new ItemStack(Blocks.dirt));
        
        //Wooden Bucket Recipe
        GameRegistry.addRecipe(new ItemStack(ItemWoodBucket.bucketWoodEmpty), "x x", "y y", " y ",
                'x', new ItemStack(Items.stick), 'y', new ItemStack(Blocks.planks));
        
        //Flag Pole Recipe
        GameRegistry.addShapelessRecipe(new ItemStack(BlockFlagPole.flagPole),
        		new ItemStack(FlagPolePartItems.flagPartBase), new ItemStack(FlagPolePartItems.flagPartTruk), new ItemStack(FlagPolePartItems.flagPartPole));
        
        //Iron Flag Pole Recipe
        GameRegistry.addShapelessRecipe(new ItemStack(BlockFlagPoleIron.flagPole),
        		new ItemStack(FlagPolePartItems.flagPartBaseIron), new ItemStack(FlagPolePartItems.flagPartTrukIron), new ItemStack(FlagPolePartItems.flagPartPoleIron));
        
        //Flag Pole Part Recipe
        GameRegistry.addRecipe(new ItemStack(FlagPolePartItems.flagPartPole), "x", "x", "x",
                'x', new ItemStack(Items.stick));
        
        //Iron Flag Pole Part Recipe
        GameRegistry.addRecipe(new ItemStack(FlagPolePartItems.flagPartPoleIron), "x", "x", "x",
                'x', new ItemStack(Items.iron_ingot));
        
        final int WILDCARD_VALUE = Short.MAX_VALUE;
        
        //Flag Pole Truk
        GameRegistry.addShapelessRecipe(new ItemStack(FlagPolePartItems.flagPartTruk),
        		new ItemStack(Blocks.planks), new ItemStack(ItemChisel.chisel, 1, WILDCARD_VALUE));
        
        //Iron Truk
        GameRegistry.addShapelessRecipe(new ItemStack(FlagPolePartItems.flagPartTrukIron),
        		new ItemStack(Items.iron_ingot), new ItemStack(ItemChisel.chisel, 1, WILDCARD_VALUE));
        
        //Flag Pole Base Recipe
        GameRegistry.addRecipe(new ItemStack(FlagPolePartItems.flagPartBase), "xxx", "xxx", "xxx",
                'x', new ItemStack(Blocks.planks));
        
        //Iron Flag Pole Base Recipe
        GameRegistry.addRecipe(new ItemStack(FlagPolePartItems.flagPartBaseIron), "   ", "xxx", "xxx",
                'x', new ItemStack(Items.iron_ingot));
        
        //Flag Recipes
        	
        	//Yellow Flag
        	GameRegistry.addRecipe(new ItemStack(ItemFlags.yellowFlag), "xxx", "xxx", "xxx",
        			'x', new ItemStack(Blocks.wool, 1, 4));
        
        	//Red Flag
        	GameRegistry.addRecipe(new ItemStack(ItemFlags.redFlag), "xxx", "xxx", "xxx",
        			'x', new ItemStack(Blocks.wool, 1, 14));

        	//Green Flag
        	GameRegistry.addRecipe(new ItemStack(ItemFlags.darkGreenFlag), "xxx", "xxx", "xxx",
        			'x', new ItemStack(Blocks.wool, 1, 13));
        	
        	//Brown Flag
        	GameRegistry.addRecipe(new ItemStack(ItemFlags.brownFlag), "xxx", "xxx", "xxx",
        			'x', new ItemStack(Blocks.wool, 1, 12));
        	
        	//Blue Flag
        	GameRegistry.addRecipe(new ItemStack(ItemFlags.darkBlueFlag), "xxx", "xxx", "xxx",
        			'x', new ItemStack(Blocks.wool, 1, 11));
        	
        	//Pink Flag
        	GameRegistry.addRecipe(new ItemStack(ItemFlags.pinkFlag), "xxx", "xxx", "xxx",
        			'x', new ItemStack(Blocks.wool, 1, 6));
        	
        	//Black Flag
        	GameRegistry.addRecipe(new ItemStack(ItemFlags.blackFlag), "xxx", "xxx", "xxx",
        			'x', new ItemStack(Blocks.wool, 1, 15));
        	
        	//Cyan Flag
        	GameRegistry.addRecipe(new ItemStack(ItemFlags.cyanFlag), "xxx", "xxx", "xxx",
        			'x', new ItemStack(Blocks.wool, 1, 9));
        	
        	//Dark Gray Flag
        	GameRegistry.addRecipe(new ItemStack(ItemFlags.darkgrayFlag), "xxx", "xxx", "xxx",
        			'x', new ItemStack(Blocks.wool, 1, 7));
        	
        	//Magenta Flag
        	GameRegistry.addRecipe(new ItemStack(ItemFlags.magentaFlag), "xxx", "xxx", "xxx",
        			'x', new ItemStack(Blocks.wool, 1, 2));
        	
        	//Orange Flag
        	GameRegistry.addRecipe(new ItemStack(ItemFlags.orangeFlag), "xxx", "xxx", "xxx",
        			'x', new ItemStack(Blocks.wool, 1, 1));
        	
        	//Purple Flag
        	GameRegistry.addRecipe(new ItemStack(ItemFlags.purpleFlag), "xxx", "xxx", "xxx",
        			'x', new ItemStack(Blocks.wool, 1, 10));
        	
        	//Gray Flag
        	GameRegistry.addRecipe(new ItemStack(ItemFlags.grayFlag), "xxx", "xxx", "xxx",
        			'x', new ItemStack(Blocks.wool, 1, 8));
        
        	
        	//Pennant Recipes
        	
        	//Yellow Pennant
        	GameRegistry.addRecipe(new ItemStack(ItemPennants.yellowPennant), "x  ", "xx ", "x  ",
        			'x', new ItemStack(Blocks.wool, 1, 4));
        
        	//Red Pennant
        	GameRegistry.addRecipe(new ItemStack(ItemPennants.redPennant), "x  ", "xx ", "x  ",
        			'x', new ItemStack(Blocks.wool, 1, 14));

        	//Green Pennant
        	GameRegistry.addRecipe(new ItemStack(ItemPennants.darkGreenPennant), "x  ", "xx ", "x ",
        			'x', new ItemStack(Blocks.wool, 1, 13));
        	
        	//Brown Pennant
        	GameRegistry.addRecipe(new ItemStack(ItemPennants.brownPennant), "x  ", "xx ", "x ",
        			'x', new ItemStack(Blocks.wool, 1, 12));
        	
        	//Blue Pennant
        	GameRegistry.addRecipe(new ItemStack(ItemPennants.bluePennant), "x  ", "xx ", "x  ",
        			'x', new ItemStack(Blocks.wool, 1, 11));
        	
        	//Pink Pennant
        	GameRegistry.addRecipe(new ItemStack(ItemPennants.pinkPennant), "x  ", "xx ", "x  ",
        			'x', new ItemStack(Blocks.wool, 1, 6));
        	
        	//Black Pennant
        	GameRegistry.addRecipe(new ItemStack(ItemPennants.blackPennant), "x  ", "xx ", "x ",
        			'x', new ItemStack(Blocks.wool, 1, 15));
        	
        	//Cyan Pennant
        	GameRegistry.addRecipe(new ItemStack(ItemPennants.cyanPennant), "x  ", "xx ", "x  ",
        			'x', new ItemStack(Blocks.wool, 1, 9));
        	
        	//Dark Gray Pennant
        	GameRegistry.addRecipe(new ItemStack(ItemPennants.darkgrayPennant), "x  ", "xx ", "x  ",
        			'x', new ItemStack(Blocks.wool, 1, 7));
        	
        	//Magenta Pennant
        	GameRegistry.addRecipe(new ItemStack(ItemPennants.magentaPennant), "x  ", "xx ", "x  ",
        			'x', new ItemStack(Blocks.wool, 1, 2));
        	
        	//Orange Pennant
        	GameRegistry.addRecipe(new ItemStack(ItemPennants.orangePennant), "x  ", "xx ", "x  ",
        			'x', new ItemStack(Blocks.wool, 1, 1));
        	
        	//Purple Flag
        	GameRegistry.addRecipe(new ItemStack(ItemPennants.purplePennant), "x  ", "xx ", "x  ",
        			'x', new ItemStack(Blocks.wool, 1, 10));
        	
        	//Gray Flag
        	GameRegistry.addRecipe(new ItemStack(ItemPennants.grayPennant), "x  ", "xx ", "x  ",
        			'x', new ItemStack(Blocks.wool, 1, 8));
        //Ice Cube Recipe
        GameRegistry.addShapelessRecipe(new ItemStack(ItemIceCube.iceCube), new ItemStack(ItemIceBottle.iceBottle));
        
        //Ice Block
        GameRegistry.addRecipe(new ItemStack(Blocks.ice), "xxx", "xxx", "xxx",
        		'x', new ItemStack(ItemIceCube.iceCube));
        
        //Quiver - Level 1 - Recipe
        GameRegistry.addRecipe(new ItemStack(ItemQuiver.quiver1), " xy", "x y", " xy",
                'x', new ItemStack(Items.string), 'y', new ItemStack(Items.leather));
        
        //Quiver - Level 2 - Recipe
        GameRegistry.addRecipe(new ItemStack(ItemQuiver.quiver2), "yyy", "yxy", "yyy",
                'x', new ItemStack(ItemQuiver.quiver1), 'y', new ItemStack(Items.leather));
        
        //Quiver - Level 3 - Recipe
        GameRegistry.addRecipe(new ItemStack(ItemQuiver.quiver3), "yyy", "yxy", "yyy",
                'x', new ItemStack(ItemQuiver.quiver2), 'y', new ItemStack(Items.leather));
        
        //White Fence - Recipe
        GameRegistry.addShapelessRecipe(new ItemStack(BlockWhiteFence.whiteFence), new ItemStack(Blocks.fence), 
        		new ItemStack(Items.dye, 1, 15));
        
        //Clear Glass - Recipe
        GameRegistry.addShapelessRecipe(new ItemStack(BlockClearGlass.clearGlass), new ItemStack(Blocks.glass));
        
        //Add Chisel Recipe
        GameRegistry.addRecipe(new ItemStack(ItemChisel.chisel), "x", "y",
        		'x', new ItemStack(Items.iron_ingot), 'y', new ItemStack(Items.stick));
        
        //Add Plantbook Recipe
        GameRegistry.addShapelessRecipe(new ItemStack(ItemPlantBook.plantBook), new ItemStack(Items.carrot), 
        		new ItemStack(Items.potato), new ItemStack(Items.wheat_seeds), new ItemStack(Block.getBlockById(175), 1, 2),
        		new ItemStack(Blocks.yellow_flower), new ItemStack(Block.getBlockById(38), 1, 2), 
        		new ItemStack(Block.getBlockById(175), 1, 0), new ItemStack(Block.getBlockById(175), 1, 5), 
        		new ItemStack(Items.book));

        //Add Packed Ice Recipe
        GameRegistry.addRecipe(new ItemStack(Blocks.packed_ice), "aaa", "aaa", "aaa",
        		'a', new ItemStack(Blocks.ice));
        
        //Add seeds from wheat Recipe
        GameRegistry.addShapelessRecipe(new ItemStack(Items.wheat_seeds, 3), new ItemStack(Items.wheat));
        
        //Spikes Recipe
        GameRegistry.addShapelessRecipe(new ItemStack(ItemIronSpike.ironSpike, 8), new ItemStack(Items.iron_ingot));
        
        //Leather Chain Recipes
        
        	//Chestplate
        	GameRegistry.addRecipe(new ItemStack(ItemLeatherChainArmor.chest), "aaa", "aba", "aaa",
        			'a', new ItemStack(ItemIronSpike.ironSpike), 'b', new ItemStack(Items.leather_chestplate));
        	
        	//Legs
        	GameRegistry.addRecipe(new ItemStack(ItemLeatherChainArmor.legs), "aaa", "aba", "aaa",
        			'a', new ItemStack(ItemIronSpike.ironSpike), 'b', new ItemStack(Items.leather_leggings));
        	
        	//Boots
        	GameRegistry.addRecipe(new ItemStack(ItemLeatherChainArmor.boots), "aaa", "aba", "aaa",
        			'a', new ItemStack(ItemIronSpike.ironSpike), 'b', new ItemStack(Items.leather_boots));
        	
        	//Helmet
        	GameRegistry.addRecipe(new ItemStack(ItemLeatherChainArmor.helm), "aaa", "aba", "aaa",
        			'a', new ItemStack(ItemIronSpike.ironSpike), 'b', new ItemStack(Items.leather_helmet));
        
        
    }
    
    
    @EventHandler
    @SideOnly(Side.CLIENT)
    public void loadClient(FMLInitializationEvent event) {
    	
        //proxy.registerKeyBindings();
        //NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
    	//client.registerRenderThings();
        
    	//EntityRegistry.registerModEntity(EntitySpear.class, "recipexpack:flyingSpear", 1, RecipeExpansionPack.instance, 64, 10, true);
    	//RenderingRegistry.registerEntityRenderingHandler(EntitySpear.class, new RenderSpear(new ModelSpear(), 0));
        //ClientRegistry.bindTileEntitySpecialRenderer(BlockWoodWallEntity.class, new RenderBlockWoodWall());
        ClientRegistry.bindTileEntitySpecialRenderer(BlockFlagPoleEntity.class, new FlagPoleRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(BlockFlagPolePennantEntity.class, new FlagPolePennantRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(BlockFlagPoleIronEntity.class, new FlagPoleIronRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(BlockFlagPoleIronPennantEntity.class, new FlagPoleIronPennantRenderer());
           	
    }
    
    @EventHandler
    @SideOnly(Side.SERVER)
    public void loadServer(FMLInitializationEvent event) {
           
    	
    }

	@EventHandler 
    public void postInit(FMLPostInitializationEvent event) {
            
    }

}
