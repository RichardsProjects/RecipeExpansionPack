package net.richardsprojects.rep.main;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.richardsprojects.rep.entity.EntitySpear;

public class ItemSpear extends Item {

    public static final String[] bowPullIconNameArray = new String[] {"-p_0", "-p_1", "-p_2"};
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
	
    public int durabilityValue;
    
    public static Item spearIron;
    
	public static void mainRegistry()	
	{
		InitializeItem();
		registerItem();
	}
	    
    public static void InitializeItem()
    {
    	spearIron = (new ItemSpear(384)).setCreativeTab(RecipeExpansionPack.tabRecipeXPack).setTextureName("rep:spear").setMaxStackSize(1).setMaxDamage(384).setUnlocalizedName("ironSpear");
    }
    
	public static void registerItem()
	{
		GameRegistry.registerItem(spearIron, spearIron.getUnlocalizedName());
	}
    
    public ItemSpear(int durab)
    {
        super();        
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
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("rep:spear");
        this.iconArray = new IIcon[bowPullIconNameArray.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon("rep:spear" + bowPullIconNameArray[i]);
        }
    }
    
    public IIcon getItemIconForUseDuration(int par1)
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
    	
    	par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() - 1);	
    		
    	EntitySpear spear = new EntitySpear(par2World, par3EntityPlayer);
    	spear.setDurability(par1ItemStack.getItemDamage() - 1);

    	//Store Data Values
    	SpearData.entitySpearData.put(spear.getEntityId(), par3EntityPlayer.getRotationYawHead());
    	
    	
    	
    	par2World.spawnEntityInWorld(spear);
    	}
    	
    	par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 2F, 1.6F / (itemRand.nextFloat() * 0.4F + 0.8F));
    	
    	//Remove item from player's inventory
    	
    }

}
