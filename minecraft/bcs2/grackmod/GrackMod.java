package bcs2.grackmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="bcs2.grackmod", name="GrackMod", version="1.0.0")
@NetworkMod(clientSideRequired=true)
public class GrackMod {

	// Define items
	public static Item grackDust;
	private int grackDustId;
	public static Item grackCompressed;
	private int grackCompressedId;
	public static Item grackIngot;
	private int grackIngotId;
	
	// Define material
	
	
	// Define tools
	
	
	// Define Blocks
	public static Block blockOreGrack;
	private int blockOreGrackId;
	
	GrackModGenerator gen = new GrackModGenerator();
	

    // The instance of your mod that Forge uses.
    @Instance(value = "bcs2.grackmod")
    public static GrackMod instance;
    
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="bcs2.grackmod.client.ClientProxy", serverSide="bcs2.grackmod.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler // used in 1.6.2
    public void preInit(FMLPreInitializationEvent event) {
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
    	config.load();
    	
    	grackDustId = config.get(Configuration.CATEGORY_ITEM, "Grack Dust", 23001).getInt();
    	grackCompressedId = config.get(Configuration.CATEGORY_ITEM, "Compressed Grack", 23002).getInt();
    	grackIngotId = config.get(Configuration.CATEGORY_ITEM, "Grack Ingot", 23003).getInt();
    	
    	blockOreGrackId = config.get(Configuration.CATEGORY_BLOCK, "Grack Ore", 601).getInt();
    	
    	
    	
    	config.save();
    }
    
    @EventHandler // used in 1.6.2
    public void load(FMLInitializationEvent event) {
    	
    	// Item settings
    	grackDust = new ItemGrack(grackDustId).setUnlocalizedName("grackDust").setTextureName("grackmod:grack_dust");
    	grackCompressed = new ItemGrack(grackCompressedId).setUnlocalizedName("grackCompressed").setTextureName("grackmod:compressed_grack");
    	grackIngot = new ItemGrack(grackIngotId).setUnlocalizedName("grackIngot").setTextureName("grackmod:grack_ingot");
    	
    	// Tool settings
    	
    	
    	// Armor settings
    	
    	
    	// Block settings and registration
    	/* 0=wood, 1=stone, 2=iron, 3=diamond */
    	blockOreGrack = new BlockGrack(blockOreGrackId, Material.rock).setUnlocalizedName("blockOreGrack").setTextureName("grackmod:grack_ore");
    	MinecraftForge.setBlockHarvestLevel(blockOreGrack, "pickaxe", 1);
    	GameRegistry.registerBlock(blockOreGrack, "grackOre");
    	
    	
    	// Item names
    	LanguageRegistry.addName(grackDust, "Grack Dust");
    	LanguageRegistry.addName(grackCompressed, "Compressed Grack");
    	LanguageRegistry.addName(grackIngot, "Grack Ingot");
    	
    	
    	// Tool Names
    	
    	
    	// Armor names
    	
    	
    	// Block names
    	LanguageRegistry.addName(blockOreGrack, "blockOreGrack");
    	
    	
    	// Recipes in class RecipesGrack.java
    	RecipesGrack.getRecipes();    	
    	
    	
    	proxy.registerRenderers();
    	GameRegistry.registerWorldGenerator(gen);
    }
    
    @EventHandler // used in 1.6.2
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method

    }
}