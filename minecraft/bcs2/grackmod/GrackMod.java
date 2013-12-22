package bcs2.grackmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
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
	
	// Define armor
	public static Item grackHelmet;
	public static Item grackChestplate;
	public static Item grackLeggings;
	public static Item grackBoots;
	private int grackHelmetId;
	private int grackChestplateId;
	private int grackLeggingsId;
	private int grackBootsId;
	
	GrackModGenerator gen = new GrackModGenerator();
	
	// Define material
	// Look at Enum class for description (<ctrl> + click)
	public static EnumArmorMaterial grackArmor = EnumHelper.addArmorMaterial("Grack", 100, new int[] {2, 5, 3, 1}, 25);
	

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
    	
    	grackHelmetId = config.get("Armor IDs", "Grack Helmet Id", 23020).getInt();
    	grackChestplateId = config.get("Armor IDs", "Grack Chestplate Id", 23021).getInt();
    	grackLeggingsId = config.get("Armor Ids", "Grack Leggings Id", 23022).getInt();
    	grackBootsId = config.get("Armor IDs", "Grack boots Id", 23023).getInt();
    	
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
    	grackHelmet = new GrackArmor(grackHelmetId, grackArmor, proxy.addArmor("GrackArmor"), 0).setUnlocalizedName("grackHelmet");
    	grackChestplate = new GrackArmor(grackChestplateId, grackArmor, proxy.addArmor("GrackArmor"), 1).setUnlocalizedName("grackChestplate");
    	grackLeggings = new GrackArmor(grackLeggingsId, grackArmor, proxy.addArmor("GrackArmor"), 2).setUnlocalizedName("grackLeggings");
    	grackBoots = new GrackArmor(grackBootsId, grackArmor, proxy.addArmor("GrackArmor"), 3).setUnlocalizedName("grackBoots");
    	
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
    	LanguageRegistry.addName(grackHelmet, "Grack Helmet");
    	LanguageRegistry.addName(grackChestplate, "Grack Chestplate");
    	LanguageRegistry.addName(grackLeggings, "Grack Leggings");
    	LanguageRegistry.addName(grackBoots, "Grack Boots");
    	
    	// Block names
    	LanguageRegistry.addName(blockOreGrack, "Grack Ore");
    	
    	
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