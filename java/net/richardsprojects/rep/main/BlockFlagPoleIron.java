package net.richardsprojects.rep.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.richardsprojects.rep.entity.BlockFlagPoleEntity;
import net.richardsprojects.rep.entity.BlockFlagPoleIronEntity;

public class BlockFlagPoleIron extends BlockContainer {

	protected BlockFlagPoleIron(Material mat) {
		super(mat);
		
		//Set Block Bounds
		this.setBlockBounds(0.3F, 0F, 0.3F, 0.7F, 1.86F, 0.7F);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new BlockFlagPoleIronEntity();
	}
	
    //You don't want the normal render type, or it wont render properly.
    @Override
    public int getRenderType() {
            return -1;
    }
   
    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube() {
            return false;
    }
   
    //It's not a normal block, so you need this too.
    public boolean renderAsNormalBlock() {
            return false;
    }

	public static void mainRegistry()
	{
		initializeBlock();
		registerBlock();
	}
	
	public static Block flagPole;
	
	public static void initializeBlock()
	{
		flagPole = new BlockFlagPoleIron(Material.iron).setBlockName("flagPoleIron").setBlockTextureName("iron_block").setCreativeTab(RecipeExpansionPack.tabRecipeXPack).setHardness(.5F);
	}
	
	public static void registerBlock()
	{
		GameRegistry.registerBlock(flagPole, flagPole.getUnlocalizedName());
	}
    
}
