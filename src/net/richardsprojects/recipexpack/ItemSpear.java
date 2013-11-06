package net.richardsprojects.recipexpack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemSpear extends Item {

    public static final String[] bowPullIconNameArray = new String[] {"-p_0", "-p_1", "-p_2"};
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;
	
    public int durabilityValue;
    
    public ItemSpear(int par1, int durab)
    {
        super(par1);
        this.maxStackSize = 1;
        this.setMaxDamage(384);
        this.setCreativeTab(CreativeTabs.tabCombat);
        
        //Store Durability Value
        this.durabilityValue = durab;

        
    }
    
    
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }
    
    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }
    
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
            
    	par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));

        return par1ItemStack;
    }
    

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("recipexpack:spear");
        this.iconArray = new Icon[bowPullIconNameArray.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon("recipexpack:spear" + bowPullIconNameArray[i]);
        }
    }
    
    public Icon getItemIconForUseDuration(int par1)
    {
        return this.iconArray[par1];
    }
    
    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
    }
    
    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
    {

    	
    	if (!par2World.isRemote)
    	{
    		
    	EntitySpear spear = new EntitySpear(par2World, par3EntityPlayer);
    	spear.setDurability(par1ItemStack.getItemDamage() - 1);
    	par2World.spawnEntityInWorld(spear);
    	}
    	
    	par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 2F, 1.6F / (itemRand.nextFloat() * 0.4F + 0.8F));
    	
    	//Remove item from player's inventory
    	
    }

}
