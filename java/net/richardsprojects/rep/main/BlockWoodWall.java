package net.richardsprojects.rep.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.richardsprojects.rep.entity.BlockWoodWallEntity;

public class BlockWoodWall extends BlockContainer {
	
	protected BlockWoodWall(Material mat) {
		super(mat);
		this.setBlockBounds(0F, 0F, 0.5F, 1F, 1F, 1F);
		
	}

	public static void mainRegistry()
	{
		initializeBlock();
		registerBlock();
	}
	
	public static Block woodWall;
	
	public static void initializeBlock()
	{
		woodWall = new BlockWoodWall(Material.wood).setBlockName("woodWall").setBlockTextureName("planks_oak").setCreativeTab(RecipeExpansionPack.tabRecipeXPack);
	}
	
	public static void registerBlock()
	{
		GameRegistry.registerBlock(woodWall, woodWall.getUnlocalizedName());
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new BlockWoodWallEntity();
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

    

}
