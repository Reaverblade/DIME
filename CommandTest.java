package dime;

import com.mojang.authlib.GameProfile;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.WorldSettings;

/**
 * Created by OkuBlade.
 */
public class CommandTest implements ICommandLol{
    @Override
    public void onCommand(Command cmd, ICommandSender snd, String[] args) {
        if(args.length == 0) {
            snd.addChatMessage(new ChatComponentText(EnumChatFormatting.RED+"Usage: "+cmd.commandUsage));
            return;
        }
        if(args[0].equalsIgnoreCase("yes")){
            snd.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA+"That's Good! We Don't Want Cheaters Here!"));
            if (snd instanceof EntityPlayer){
                boolean isCreative = ((EntityPlayer) snd).capabilities.isCreativeMode;
                // not in creative
                if(isCreative){
                    snd.addChatMessage(new ChatComponentText(EnumChatFormatting.RED+"You're in Creative! How dare you!"));
                    ((EntityPlayer) snd).setGameType(WorldSettings.GameType.SURVIVAL);
                }else {
                    snd.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA+"Great! Here's something to help!"));
                    ((EntityPlayer) snd).inventory.addItemStackToInventory(new ItemStack(Items.golden_apple, 1, 1));
                }


            }
        }else if(args[0].equalsIgnoreCase("no")){
            snd.addChatMessage(new ChatComponentText("FINE!"));
            if(snd instanceof EntityPlayer){
               ((EntityPlayer) snd).addExperienceLevel(5);
                boolean isCreative = ((EntityPlayer) snd).capabilities.isCreativeMode;
                // not in creative
                if(isCreative){
                    snd.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA+"Good. You're already there. Have Fun!"));
                }else {
                    snd.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA + "How can you cheat without Creative?"));
                    ((EntityPlayer) snd).setGameType(WorldSettings.GameType.CREATIVE);
                }
            }
        }
    }
}
