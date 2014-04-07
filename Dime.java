package dime;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraft.command.ICommandSender;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;


@Mod(modid = Dime.MODID, version = Dime.VERSION)
    public class Dime
    {
        public static final String MODID = "DIME";
        public static final String VERSION = "0.05% Complete!";
        @SidedProxy(serverSide = "dime.CommonProxy", clientSide = "dime.ClientProxy")
        public static CommonProxy proxy;

        @EventHandler
        public void init(FMLPreInitializationEvent e){
         proxy.init(e);

       }
        @EventHandler
        public void init(FMLServerStartingEvent e){
         proxy.onServerStart(e);
        }

public static void sendChat(ICommandSender ics,String msg){
    ics.addChatMessage(new ChatComponentText(msg));
}

}