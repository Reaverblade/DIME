package dime;


import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CommonProxy {
    public static CreativeTabs bladeTab = new CreativeTabs("DIME") {
        @Override
        public Item getTabIconItem() {
            return pointer;
        }
    };

    public static Item pointer;
    public SelectedStats stats = new SelectedStats();

    public void init(FMLPreInitializationEvent evt){
        pointer = new ItemPointer().setUnlocalizedName("pointer").setTextureName("dime:pointer").setCreativeTab(bladeTab).setMaxStackSize(1);
        GameRegistry.registerItem(pointer, "pointer");
    }
    public void onServerStart(FMLServerStartingEvent p){
     p.registerServerCommand(new Command("doyoucareaboutcheating", "/doyoucareaboutcheating <yes/no>", new CommandTest()));
    }
}
