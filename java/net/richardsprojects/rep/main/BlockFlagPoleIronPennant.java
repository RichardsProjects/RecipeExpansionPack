package net.richardsprojects.rep.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.richardsprojects.rep.entity.BlockFlagPoleEntity;
import net.richardsprojects.rep.entity.BlockFlagPoleIronPennantEntity;

public class BlockFlagPoleIronPennant extends BlockContainer {

	protected BlockFlagPoleIronPennant(Material mat) {
		super(mat);
		
		//Set Block Bounds
		this.setBlockBounds(0.3F, 0F, 0.3F, 0.7F, 1.86F, 0.7F);
		this.setCreativeTab(null);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new BlockFlagPoleIronPennantEntity();
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
	
	public static Block flagPoleIronPennant;
	
	public static void initializeBlock()
	{
		flagPoleIronPennant = new BlockFlagPoleIronPennant(Material.iron).setBlockName("flagPoleIron2").setBlockTextureName("iron_block").setHardness(.5F);
	}
	
	public static void registerBlock()
	{
		GameRegistry.registerBlock(flagPoleIronPennant, flagPoleIronPennant.getUnlocalizedName());
	}
    
}
