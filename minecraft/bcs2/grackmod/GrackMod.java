package bcs2.grackmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
//import cpw.mods.fml.common.Mod.PreInit;    // used in 1.5.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="bcs2.grackmod", name="GrackMod", version="1.0.0")
@NetworkMod(clientSideRequired=true)
public class GrackMod {

        // The instance of your mod that Forge uses.
        @Instance(value = "bcs2.grackmod")
        public static GrackMod instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="bcs2.grackmod.client.ClientProxy", serverSide="bcs2.grackmod.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler // used in 1.6.2
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method

        }
        
        @EventHandler // used in 1.6.2
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();

        }
        
        @EventHandler // used in 1.6.2
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method

        }
}