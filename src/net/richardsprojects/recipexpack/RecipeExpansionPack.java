package net.richardsprojects.recipexpack;

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.richardsprojects.recipexpack.recipes.CompostRecipes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; 
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="REP", name="Recipe Expansion Pack", version="0.0.6")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class RecipeExpansionPack {

        // The instance of your mod that Forge uses.
        @Instance("RecipeExpansionPack")
        public static RecipeExpansionPack instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="net.richardsprojects.recipexpack.client.ClientProxy", serverSide="net.richardsprojects.recipexpack.CommonProxy")
        public static CommonProxy proxy;
        
        //New Armor Material
        public static EnumArmorMaterial quiverArmor = EnumHelper.addArmorMaterial("quiver", 25, new int[]{0, 0, 0, 0}, 0);
        
        //New Items
        //TODO: Use as little chaining as possible to shorton code
        public static Item bucketWoodEmpty = (new ItemWoodBucket(5000, 0)).setUnlocalizedName("woodbucket").func_111206_d("recipexpack:woodbucket-e");
        public static Item bucketWoodWater = (new ItemWoodBucket(5001, Block.waterMoving.blockID)).setUnlocalizedName("woodbucketWater").setContainerItem(bucketWoodEmpty).func_111206_d("recipexpack:woodbucket-w");
        public static Item bucketWoodMilk = (new ItemWoodBucketMilk(5002)).setUnlocalizedName("woodbucketmilk").setContainerItem(bucketWoodEmpty).func_111206_d("recipexpack:woodbucket-m");
        public static Item grassSeed = (new ItemGrassSeeds(5003)).func_111206_d("seeds_wheat");
        //public static Item spearIron = (new ItemSpear(5004, 384)).func_111206_d("recipexpack:spear");
        //public static Item spearIronFlying = (new ItemSpearFlying(5005, 384)).func_111206_d("recipexpack:flyingSpear");
        public static Item bucketWoodCompost6 = (new ItemCompostWooden(5006)).func_111206_d("recipexpack:woodbucket-c").setUnlocalizedName("CompostWood6");
        public static Item bucketIronCompost6 = (new ItemCompostIron(5007)).func_111206_d("recipexpack:ironbucket-c").setUnlocalizedName("CompostIron6");
        public static Item bucketWoodCompost5 = (new ItemCompostWooden(5008)).func_111206_d("recipexpack:woodbucket-c").setUnlocalizedName("CompostWood5");
        public static Item bucketIronCompost5 = (new ItemCompostIron(5009)).func_111206_d("recipexpack:ironbucket-c").setUnlocalizedName("CompostIron5");
        public static Item bucketWoodCompost4 = (new ItemCompostWooden(5010)).func_111206_d("recipexpack:woodbucket-c").setUnlocalizedName("CompostWood4");
        public static Item bucketIronCompost4 = (new ItemCompostIron(5011)).func_111206_d("recipexpack:ironbucket-c").setUnlocalizedName("CompostIron4");
        public static Item bucketWoodCompost3 = (new ItemCompostWooden(5012)).func_111206_d("recipexpack:woodbucket-c").setUnlocalizedName("CompostWood3");
        public static Item bucketIronCompost3 = (new ItemCompostIron(5013)).func_111206_d("recipexpack:ironbucket-c").setUnlocalizedName("CompostIron3");
        public static Item bucketWoodCompost2 = (new ItemCompostWooden(5014)).func_111206_d("recipexpack:woodbucket-c").setUnlocalizedName("CompostWood2");
        public static Item bucketIronCompost2 = (new ItemCompostIron(5015)).func_111206_d("recipexpack:ironbucket-c").setUnlocalizedName("CompostIron2");
        public static Item bucketWoodCompost1 = (new ItemCompostWooden(5016)).func_111206_d("recipexpack:woodbucket-c").setUnlocalizedName("CompostWood1");
        public static Item bucketIronCompost1 = (new ItemCompostIron(5017)).func_111206_d("recipexpack:ironbucket-c").setUnlocalizedName("CompostIron1");
        public static Item quiver1 = (new ItemQuiver(5018)).func_111206_d("recipexpack:quiver").setUnlocalizedName("quiver1");
        public static Item quiver2 = (new ItemQuiver(5019)).func_111206_d("recipexpack:quiver").setUnlocalizedName("quiver2");
        public static Item quiver3 = (new ItemQuiver(5020)).func_111206_d("recipexpack:quiver").setUnlocalizedName("quiver3");
        
        //New Blocks
        public static final Block cropCompostedWheat = new CropCompostedWheat(500).func_111022_d("recipexpack:cwheat");
        public static final Block compostBlock = new CompostBlock(501, Material.cake).func_111022_d("recipexpack:compostblock");
        public static final Block cropCompostedCarrot = new CropCompostedCarrot(502).func_111022_d("carrots");
        public static final Block cropCompostedPotato = new CropCompostedPotato(503).func_111022_d("potatoes");
        public static final Block clearGlass = (new BlockClearGlass(504, Material.glass)).setHardness(0.3F).setUnlocalizedName("cglass");
        public static final Block whiteFence = (new BlockFence(505, "recipexpack:white_fence", Material.wood)).setHardness(0.3F).setUnlocalizedName("whitefence").func_111022_d("recipexpack:white_fence");
        
        //Recipe Expansion Pack Tab
        public static CreativeTabs tabRecipeXPack = new CreativeTabs("tabREP") {
            public ItemStack getIconItemStack() {
                    return new ItemStack(RecipeExpansionPack.bucketWoodEmpty, 1, 0);
            }
    };
        
        
        @EventHandler // used in 1.6.2
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        }
        
        @EventHandler // used in 1.6.2
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
                
                //Register Blocks
                GameRegistry.registerBlock(clearGlass, "cglass");
                GameRegistry.registerBlock(whiteFence, "whitefence");                
                
                //Name Items
                LanguageRegistry.addName(bucketWoodEmpty, "Wood Bucket");
                LanguageRegistry.addName(bucketWoodWater, "Water Bucket");
                LanguageRegistry.addName(bucketWoodMilk, "Milk Bucket");
                LanguageRegistry.addName(grassSeed, "Grass Seed");                
                LanguageRegistry.addName(bucketIronCompost6, "Bucket of Compost (6/6)");
                LanguageRegistry.addName(bucketWoodCompost6, "Bucket of Compost (6/6)");
                LanguageRegistry.addName(bucketIronCompost5, "Bucket of Compost (5/6)");
                LanguageRegistry.addName(bucketWoodCompost5, "Bucket of Compost (5/6)");
                LanguageRegistry.addName(bucketIronCompost4, "Bucket of Compost (4/6)");
                LanguageRegistry.addName(bucketWoodCompost4, "Bucket of Compost (4/6)");
                LanguageRegistry.addName(bucketIronCompost3, "Bucket of Compost (3/6)");
                LanguageRegistry.addName(bucketWoodCompost3, "Bucket of Compost (3/6)");
                LanguageRegistry.addName(bucketIronCompost2, "Bucket of Compost (2/6)");
                LanguageRegistry.addName(bucketWoodCompost2, "Bucket of Compost (2/6)");
                LanguageRegistry.addName(bucketIronCompost1, "Bucket of Compost (1/6)");
                LanguageRegistry.addName(bucketWoodCompost1, "Bucket of Compost (1/6)");
                LanguageRegistry.addName(quiver1, "Quiver (0/64)");
                LanguageRegistry.addName(quiver2, "Quiver (0/128)");
                LanguageRegistry.addName(quiver3, "Quiver (0/192)");
                LanguageRegistry.addName(clearGlass, "Clear Glass");
                LanguageRegistry.addName(whiteFence, "White Fence");
                
                //Add Items to their proper tabs
                bucketWoodEmpty.setCreativeTab(this.tabRecipeXPack);
                bucketWoodMilk.setCreativeTab(this.tabRecipeXPack);
                bucketWoodWater.setCreativeTab(this.tabRecipeXPack);
                grassSeed.setCreativeTab(this.tabRecipeXPack);
                bucketWoodCompost6.setCreativeTab(this.tabRecipeXPack);
                bucketIronCompost6.setCreativeTab(this.tabRecipeXPack);
                bucketWoodCompost5.setCreativeTab(this.tabRecipeXPack);
                bucketIronCompost5.setCreativeTab(this.tabRecipeXPack);
                bucketWoodCompost4.setCreativeTab(this.tabRecipeXPack);
                bucketIronCompost4.setCreativeTab(this.tabRecipeXPack);
                bucketWoodCompost3.setCreativeTab(this.tabRecipeXPack);
                bucketIronCompost3.setCreativeTab(this.tabRecipeXPack);
                bucketWoodCompost2.setCreativeTab(this.tabRecipeXPack);
                bucketIronCompost2.setCreativeTab(this.tabRecipeXPack);
                bucketWoodCompost1.setCreativeTab(this.tabRecipeXPack);
                bucketIronCompost1.setCreativeTab(this.tabRecipeXPack);
                quiver1.setCreativeTab(this.tabRecipeXPack);
                quiver2.setCreativeTab(this.tabRecipeXPack);
                quiver3.setCreativeTab(this.tabRecipeXPack);
                clearGlass.setCreativeTab(this.tabRecipeXPack);
                whiteFence.setCreativeTab(this.tabRecipeXPack);

                //Add Events
                MinecraftForge.EVENT_BUS.register(new ModEvents());
                
                //Add Recipes
                
                //Compost Recipes
                CompostRecipes.addCompostRecipes(new GameRegistry());
                
                //Wooden Bucket Recipe
                GameRegistry.addRecipe(new ItemStack(bucketWoodEmpty), "x x", "y y", " y ",
                        'x', new ItemStack(Item.stick), 'y', new ItemStack(Block.planks));
                
                //Flint Recipe
                GameRegistry.addShapelessRecipe(new ItemStack(Item.flint), new ItemStack(Block.gravel), 
                		new ItemStack(Block.gravel));
                     
                //White Fence - Recipe
                GameRegistry.addShapelessRecipe(new ItemStack(whiteFence), new ItemStack(Block.fence), 
                		new ItemStack(Item.dyePowder, 1, 15));
                
                //Clear Glass - Recipe
                GameRegistry.addShapelessRecipe(new ItemStack(clearGlass), new ItemStack(Block.glass));
                
                //Mossy Cobblestone - Cobble & Vines
                GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestoneMossy),
                		new ItemStack(Block.vine), new ItemStack(Block.cobblestone));
                
                //Grass Block - grass seeds
                GameRegistry.addShapelessRecipe(new ItemStack(Block.grass),
                		new ItemStack(grassSeed), new ItemStack(Block.dirt));
                
                //Quiver - Level 1 - Recipe
                GameRegistry.addRecipe(new ItemStack(quiver1), " xy", "x y", " xy",
                        'x', new ItemStack(Item.silk), 'y', new ItemStack(Item.leather));
                
                //Quiver - Level 2 - Recipe
                GameRegistry.addRecipe(new ItemStack(quiver2), "yyy", "yxy", "yyy",
                        'x', new ItemStack(quiver1), 'y', new ItemStack(Item.leather));
                
                //Quiver - Level 3 - Recipe
                GameRegistry.addRecipe(new ItemStack(quiver3), "yyy", "yxy", "yyy",
                        'x', new ItemStack(quiver2), 'y', new ItemStack(Item.leather));
                
               //Register Mod Entities
                EntityRegistry.registerModEntity(EntitySpear.class, "Spear", 1, this, 64, 10, true);
                
                //Register Custom Tab
                LanguageRegistry.instance().addStringLocalization("itemGroup.tabREP", "en_US", "Recipe Expansion Pack");


        }
        
        @EventHandler // used in 1.6.2
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
        
}