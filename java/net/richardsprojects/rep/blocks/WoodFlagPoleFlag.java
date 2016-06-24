package net.richardsprojects.rep.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class WoodFlagPoleFlag extends Block {
	
	public static final PropertyEnum TYPE = PropertyEnum.create("type", WoodFlagPoleFlag.EnumType.class);
	
	public WoodFlagPoleFlag() {
		super(Material.wood);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumType.WHITE));
	}

	@Override
	protected BlockState createBlockState() {
	    return new BlockState(this, new IProperty[] { TYPE });
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
	    switch (meta) {
	    	case 0: return getDefaultState().withProperty(TYPE, EnumType.WHITE);
	    	case 1: return getDefaultState().withProperty(TYPE, EnumType.ORANGE);
	    	case 2: return getDefaultState().withProperty(TYPE, EnumType.MAGENTA);
	    	case 3: return getDefaultState().withProperty(TYPE, EnumType.LIGHT_BLUE);
	    	case 4: return getDefaultState().withProperty(TYPE, EnumType.YELLOW);
	    	case 5: return getDefaultState().withProperty(TYPE, EnumType.LIME);
	    	case 6: return getDefaultState().withProperty(TYPE, EnumType.PINK);
	    	case 7: return getDefaultState().withProperty(TYPE, EnumType.GRAY);
	    	case 8: return getDefaultState().withProperty(TYPE, EnumType.LIGHT_GRAY);
	    	case 9: return getDefaultState().withProperty(TYPE, EnumType.CYAN);
	    	case 10: return getDefaultState().withProperty(TYPE, EnumType.PURPLE);
	    	case 11: return getDefaultState().withProperty(TYPE, EnumType.BLUE);
	    	case 12: return getDefaultState().withProperty(TYPE, EnumType.BROWN);
	    	case 13: return getDefaultState().withProperty(TYPE, EnumType.GREEN);
	    	case 14: return getDefaultState().withProperty(TYPE, EnumType.RED);
	    	case 15: return getDefaultState().withProperty(TYPE, EnumType.BLACK);
	    }
	    return null;
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos) {
	    return new ItemStack(RecipeExpansionPackBlocks.woodFlagPoleEmpty, 1);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
	    EnumType type = (EnumType) state.getValue(TYPE);
	    return type.getID();
	}
	
	@Override
	public int damageDropped(IBlockState state) {
	    return 0;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}
	
	public enum EnumType implements IStringSerializable {
	    WHITE(0, "white"),
	    ORANGE(1, "orange"),
	    MAGENTA(2, "magenta"),
	    LIGHT_BLUE(3, "light_blue"),
	    YELLOW(4, "yellow"),
	    LIME(5, "lime"),
	    PINK(6, "pink"),
	    GRAY(7, "gray"),
	    LIGHT_GRAY(8, "light_gray"),
	    CYAN(9, "cyan"),
	    PURPLE(10, "purple"),
	    BLUE(11, "blue"),
	    BROWN(12, "brown"),
	    GREEN(13, "green"),
	    RED(14, "red"),
	    BLACK(15, "black");

	    private int ID;
	    private String name;
	    
	    private EnumType(int ID, String name) {
	        this.ID = ID;
	        this.name = name;
	    }
	    
	    @Override
	    public String getName() {
	        return name;
	    }

	    @Override
	    public String toString() {
	        return getName();
	    }
	    
	    public int getID() {
	        return ID;
	    }
	}
}
