package net.richardsprojects.rep.main;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCarrot;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class CropCompostedCarrot extends BlockCrops
{
    public static Block cropCompostedCarrot;
	
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

    public CropCompostedCarrot()
    {
        super();
    }

	public static void mainRegistry()	
	{
		initializeBlock();
		registerBlock();
	}
	
	public static void initializeBlock()
	{
		cropCompostedCarrot = new CropCompostedCarrot().setBlockTextureName("carrots").setBlockName("compostedCarrot");
	}
	
	public static void registerBlock()
	{
		GameRegistry.registerBlock(cropCompostedCarrot, cropCompostedCarrot.getUnlocalizedName());
	}
    
    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        if (p_149691_2_ < 7)
        {
            if (p_149691_2_ == 6)
            {
                p_149691_2_ = 5;
            }

            return this.iconArray[p_149691_2_ >> 1];
        }
        else
        {
            return this.iconArray[3];
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.iconArray = new IIcon[4];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = p_149651_1_.registerIcon("rep:" + this.getTextureName() + "_stage_" + i);
        }
    }
    
   
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 5;
    }
    
    @Override
    protected Item func_149866_i()
    {
        return Items.carrot;
    }

    @Override
    protected Item func_149865_P()
    {
        return Items.carrot;
    }
}
