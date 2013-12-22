package bcs2.grackmod.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import bcs2.grackmod.CommonProxy;

public class ClientProxy extends CommonProxy {


	@Override
	public void registerRenderers() {
		// This is for rendering entities and so forth
		
		
		
	}
	
	public int addArmor(String armor) {
		
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	
	}
	
}
