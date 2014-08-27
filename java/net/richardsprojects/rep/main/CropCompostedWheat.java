package net.richardsprojects.rep.main;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class CropCompostedWheat extends BlockCrops
{
    @SideOnly(Side.CLIENT)
    private IIcon[] field_149867_a;

    public static Block cropCompostedWheat;
    
    
	public static void mainRegistry()	
	{
		initializeBlock();
		registerBlock();
	}
	
	public static void initializeBlock()
	{
		cropCompostedWheat = new CropCompostedWheat().setBlockTextureName("wheat").setBlockName("compostedWheat");
	}
	
	public static void registerBlock()
	{
		GameRegistry.registerBlock(cropCompostedWheat, cropCompostedWheat.getUnlocalizedName());
	}
    
    protected CropCompostedWheat()
    {
        super();
        this.setTickRandomly(true);
        float f = 0.5F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
        this.setCreativeTab((CreativeTabs)null);
        this.setHardness(0.0F);
        this.setStepSound(this.stepSound);
        this.disableStats();
    }

    /**
     * is the block grass, dirt or farmland
     */
    protected boolean canPlaceBlockOn(Block p_149854_1_)
    {
        return p_149854_1_ == Blocks.farmland;
    }

    /**
     * Apply bonemeal to the crops.
     */
    public void fertilize(World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4) + MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);

        if (l > 7)
        {
            l = 7;
        }

        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
    }

     @SideOnly(Side.CLIENT)

 
    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 6;
    }

    @Override 
    protected Item func_149866_i()
    {
        return Items.wheat_seeds;
    }

    @Override
    protected Item func_149865_P()
    {
        return Items.wheat;
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);
    }


    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
    	this.field_149867_a = new IIcon[8];

        for (int i = 0; i < this.field_149867_a.length; ++i)
        {
            this.field_149867_a[i] = par1IconRegister.registerIcon("rep:" + this.getTextureName() + "_stage_" + i);
        }
    }
    
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random p_149745_1_)
    {
        return 5;
    }
    
    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        if (p_149691_2_ < 0 || p_149691_2_ > 7)
        {
            p_149691_2_ = 7;
        }

        return this.field_149867_a[p_149691_2_];
    }
}
