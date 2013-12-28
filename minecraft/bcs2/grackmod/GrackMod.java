package bcs2.grackmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
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

@Mod(modid="bcs2.grackmod", name="GrackMod", version="1.2")
@NetworkMod(clientSideRequired=true)
public class GrackMod {

	// Define items
	public static Item grackDust;
	private int grackDustId;
	public static Item grackCompressed;
	private int grackCompressedId;
	public static Item grackIngot;
	private int grackIngotId;
	public static Item grackDough;
	private int grackDoughId;
	public static Item grackBread;
	private int grackBreadId;
	public static Item grackWheat;
	private int grackWheatId;
	public static Item grackSeeds;
	public int grackSeedsId;
	
	// Define tools
	public static Item grackSword;
	private int grackSwordId;
	public static Item grackHoe;
	private int grackHoeId;
	public static Item grackAxe;
	private int grackAxeId;
	public static Item grackPickaxe;
	private int grackPickaxeId;
	public static Item grackShovel;
	private int grackShovelId;
	
	// Define Blocks
	public static Block blockOreGrack;
	private int blockOreGrackId;
	public static Block blockGrackBlock;
	private int blockGrackBlockId;
	public static Block grackWheatCrop;
	private int grackWheatCropId;
	
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
	public static EnumArmorMaterial grackArmorMaterial = EnumHelper.addArmorMaterial("Grack", 40, new int[] {3, 7, 5, 3}, 15);
	public static EnumToolMaterial grackToolMaterial = EnumHelper.addToolMaterial("Grack", 3, 1000, 7.2f, 2.5f, 15);

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
    	grackDoughId = config.get(Configuration.CATEGORY_ITEM, "Grack Dough", 23004).getInt();
    	grackBreadId = config.get(Configuration.CATEGORY_ITEM, "Grack Bread", 23005).getInt();
    	grackWheatId = config.get(Configuration.CATEGORY_ITEM, "Grack Wheat", 23006).getInt();
    	grackSeedsId = config.get(Configuration.CATEGORY_ITEM, "Grack Seeds", 23007).getInt();
    	grackSwordId = config.get(Configuration.CATEGORY_ITEM, "Grack Sword", 23008).getInt();
    	grackHoeId = config.get(Configuration.CATEGORY_ITEM, "Grack Hoe", 23009).getInt();
    	grackAxeId = config.get(Configuration.CATEGORY_ITEM, "Grack Axe", 23010).getInt();
    	grackPickaxeId = config.get(Configuration.CATEGORY_ITEM, "Grack Pickaxe", 23011).getInt();
    	grackShovelId = config.get(Configuration.CATEGORY_ITEM, "Grack Shovel", 23012).getInt();
    	
    	grackHelmetId = config.get("Armor IDs", "Grack Helmet Id", 23020).getInt();
    	grackChestplateId = config.get("Armor IDs", "Grack Chestplate Id", 23021).getInt();
    	grackLeggingsId = config.get("Armor Ids", "Grack Leggings Id", 23022).getInt();
    	grackBootsId = config.get("Armor IDs", "Grack boots Id", 23023).getInt();
    	
    	blockOreGrackId = config.get(Configuration.CATEGORY_BLOCK, "Grack Ore", 601).getInt();
    	blockGrackBlockId = config.get(Configuration.CATEGORY_BLOCK, "Grack Block", 602).getInt();
    	grackWheatCropId = config.get(Configuration.CATEGORY_BLOCK, "Grack Wheat Crop", 603).getInt();
    	
    	
    	config.save();
    }
    
    @EventHandler // used in 1.6.2
    public void load(FMLInitializationEvent event) {
    	
    	// Item settings
    	grackDust = new ItemGrack(grackDustId).setUnlocalizedName("grackDust").setTextureName("grackmod:grack_dust");
    	grackCompressed = new ItemGrack(grackCompressedId).setUnlocalizedName("grackCompressed").setTextureName("grackmod:compressed_grack");
    	grackIngot = new ItemGrack(grackIngotId).setUnlocalizedName("grackIngot").setTextureName("grackmod:grack_ingot");
    	grackDough = new ItemGrackFood(grackDoughId, 3, 0.2f, false).setUnlocalizedName("grackDough").setMaxStackSize(16);
    	grackBread = new ItemGrackFood(grackBreadId, 5, 0.8f, false).setPotionEffect(Potion.regeneration.id, 15, 0, 0.8f).setUnlocalizedName("grackBread"); // 80% chance of regen 1 for 15 seconds
    	grackWheat = new ItemGrack(grackWheatId).setUnlocalizedName("grackWheat").setTextureName("grackmod:grack_wheat");
    	
    	// Tool settings
    	grackSword = new ItemGrackSword(grackSwordId, grackToolMaterial).setUnlocalizedName("grackSword");
    	grackHoe = new ItemGrackHoe(grackHoeId, grackToolMaterial).setUnlocalizedName("grackHoe");
    	grackAxe = new ItemGrackAxe(grackAxeId, grackToolMaterial).setUnlocalizedName("grackAxe");
    	grackPickaxe = new ItemGrackPickaxe(grackPickaxeId, grackToolMaterial).setUnlocalizedName("grackPickaxe");
    	grackShovel = new ItemGrackShovel(grackShovelId, grackToolMaterial).setUnlocalizedName("grackShovel");
    	
    	// Armor settings
    	grackHelmet = new GrackArmor(grackHelmetId, grackArmorMaterial, proxy.addArmor("GrackArmor"), 0).setUnlocalizedName("grackHelmet");
    	grackChestplate = new GrackArmor(grackChestplateId, grackArmorMaterial, proxy.addArmor("GrackArmor"), 1).setUnlocalizedName("grackChestplate");
    	grackLeggings = new GrackArmor(grackLeggingsId, grackArmorMaterial, proxy.addArmor("GrackArmor"), 2).setUnlocalizedName("grackLeggings");
    	grackBoots = new GrackArmor(grackBootsId, grackArmorMaterial, proxy.addArmor("GrackArmor"), 3).setUnlocalizedName("grackBoots");
    	
    	// Block settings and registration
    	/* 0=wood, 1=stone, 2=iron, 3=diamond */
    	blockOreGrack = new BlockGrack(blockOreGrackId, Material.rock).setUnlocalizedName("blockOreGrack").setTextureName("grackmod:grack_ore");
    	MinecraftForge.setBlockHarvestLevel(blockOreGrack, "pickaxe", 1);
    	GameRegistry.registerBlock(blockOreGrack, "grackOre");
    	blockGrackBlock = new BlockGrack(blockGrackBlockId, Material.rock).setUnlocalizedName("blockGrackBlock").setTextureName("grackmod:grack_block");
    	MinecraftForge.setBlockHarvestLevel(blockGrackBlock, "pickaxe", 1);
    	GameRegistry.registerBlock(blockGrackBlock, "blockOfGrack");
    	grackWheatCrop = new BlockGrackWheatCrop(grackWheatCropId);
    	GameRegistry.registerBlock(grackWheatCrop, "grackWheatCrop");
    	
    	// Items which reference blocks settings
    	grackSeeds = new GrackSeedsWheat(grackSeedsId, grackWheatCrop.blockID, Block.tilledField.blockID);
    	
    	// Item names
    	LanguageRegistry.addName(grackDust, "Grack Dust");
    	LanguageRegistry.addName(grackCompressed, "Compressed Grack");
    	LanguageRegistry.addName(grackIngot, "Grack Ingot");
    	LanguageRegistry.addName(grackDough, "Grack Dough");
    	LanguageRegistry.addName(grackBread, "Grack Bread");
    	LanguageRegistry.addName(grackWheat, "Grack Wheat");
    	LanguageRegistry.addName(grackSeeds, "Grack Seeds");
    	
    	// Tool Names
    	LanguageRegistry.addName(grackSword, "Grack Sword");
    	LanguageRegistry.addName(grackHoe, "Grack Hoe");
    	LanguageRegistry.addName(grackAxe, "Grack Axe");
    	LanguageRegistry.addName(grackPickaxe, "Grack Pickaxe");
    	LanguageRegistry.addName(grackShovel, "Grack Shovel");
    	
    	// Armor names
    	LanguageRegistry.addName(grackHelmet, "Grack Helmet");
    	LanguageRegistry.addName(grackChestplate, "Grack Chestplate");
    	LanguageRegistry.addName(grackLeggings, "Grack Leggings");
    	LanguageRegistry.addName(grackBoots, "Grack Boots");
    	
    	// Block names
    	LanguageRegistry.addName(blockOreGrack, "Grack Ore");
    	LanguageRegistry.addName(blockGrackBlock,  "Grack Block");
    	LanguageRegistry.addName(grackWheatCrop, "Grack Wheat Crop");
    	
    	
    	// Recipes in class RecipesGrack.java
    	RecipesGrack.getRecipes();    	
    	
    	
    	proxy.registerRenderers();
    	GameRegistry.registerWorldGenerator(gen);
    	MinecraftForge.addGrassSeed(new ItemStack(grackSeeds), 1);
    	MinecraftForge.EVENT_BUS.register(new GrackCropsBonemeal());
    }
    
    @EventHandler // used in 1.6.2
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method

    }
}