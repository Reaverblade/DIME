package dime;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by OkuBlade.
 */
public class ItemPointer extends Item {
    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {

        if(!par3World.isRemote){
            if(!par2EntityPlayer.capabilities.isCreativeMode){
                Dime.sendChat(par2EntityPlayer,"You Cannot Survive on Commands Alone! (Please go into Creative Mode)");
                return false;
            }
           SelectedStats.Selection s = Dime.proxy.stats.getSelectionForPlayer(par2EntityPlayer);
           if(!s.isSet()){
               s.setPoint(par4, par5, par6);
               String point = s.pointToSet == 1 ? "1" : "2";
               Dime.sendChat(par2EntityPlayer, "Point "+(s.pointToSet) + 1+"set!");
           }else{
               SelectedStats.Point p1 = s.minSelection;
               SelectedStats.Point p2 = s.maxSelection;
               int diffX = p2.x - p1.x;
               int diffY = p2.y - p1.y;
               int diffZ = p2.z - p1.z;
               Dime.sendChat(par2EntityPlayer, "");
           }
       }
        return super.onItemUse(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
    }

    @Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {
        return super.hitEntity(par1ItemStack, par2EntityLivingBase, par3EntityLivingBase);
    }
}
