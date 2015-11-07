package net.richardsprojects.rep.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.richardsprojects.rep.RecipeExpansionPack;

public class ItemWoodBucketMilk extends Item
{
    private static final String __OBFID = "CL_00000048";

    public ItemWoodBucketMilk()
    {
        this.setMaxStackSize(1);
        setUnlocalizedName("wood_bucket_milk");
        this.setCreativeTab(RecipeExpansionPack.repTab);
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        if (!playerIn.capabilities.isCreativeMode)
        {
            --stack.stackSize;
        }

        if (!worldIn.isRemote)
        {
            playerIn.curePotionEffects(stack);
        }

        return stack.stackSize <= 0 ? new ItemStack(RecipeExpansionPackItems.wood_bucket) : stack;
    }

    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 32;
    }

    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
    }

    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
        return itemStackIn;
    }
}