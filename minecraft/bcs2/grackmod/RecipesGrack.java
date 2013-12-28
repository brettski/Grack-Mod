package bcs2.grackmod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipesGrack {
	
	
	
	public static void getRecipes() {
		
		// Shapeless crafting
		GameRegistry.addShapelessRecipe(new ItemStack(GrackMod.grackDough), new ItemStack(GrackMod.grackWheat), new ItemStack(Item.bucketMilk), new ItemStack(Item.egg));		
		GameRegistry.addShapelessRecipe(new ItemStack(GrackMod.grackDough), new ItemStack(GrackMod.grackWheat), new ItemStack(Item.bucketWater), new ItemStack(Item.egg));		
				
		// crafting
		GameRegistry.addRecipe(new ItemStack(GrackMod.grackCompressed), "ggg", "ggg", "ggg", 'g', GrackMod.grackDust);
		GameRegistry.addRecipe(new ItemStack(GrackMod.grackHelmet), "ggg", "g g", 'g', GrackMod.grackIngot);
		GameRegistry.addRecipe(new ItemStack(GrackMod.grackChestplate), "g g", "ggg", "ggg", 'g', GrackMod.grackIngot);
		GameRegistry.addRecipe(new ItemStack(GrackMod.grackLeggings), "ggg", "g g", "g g", 'g', GrackMod.grackIngot);
		GameRegistry.addRecipe(new ItemStack(GrackMod.grackBoots), "g g", "g g", 'g', GrackMod.grackIngot);
		GameRegistry.addRecipe(new ItemStack(GrackMod.blockGrackBlock), "ggg", "ggg", "ggg", 'g', GrackMod.grackIngot);
		GameRegistry.addRecipe(new ItemStack(GrackMod.grackSword), " g ", " g ", " s ", 'g', GrackMod.grackIngot, 's', Item.stick);
		GameRegistry.addRecipe(new ItemStack(GrackMod.grackHoe), "gg ", " s ", " s ", 'g', GrackMod.grackIngot, 's', Item.stick);
		GameRegistry.addRecipe(new ItemStack(GrackMod.grackAxe), "gg ", "gs ", " s ", 'g', GrackMod.grackIngot, 's', Item.stick);
		GameRegistry.addRecipe(new ItemStack(GrackMod.grackPickaxe), "ggg", " s ", " s ", 'g', GrackMod.grackIngot, 's', Item.stick);
		GameRegistry.addRecipe(new ItemStack(GrackMod.grackShovel), " g ", " s ", " s ", 'g', GrackMod.grackIngot, 's', Item.stick);
		
		// smelting
		GameRegistry.addSmelting(GrackMod.grackCompressed.itemID, new ItemStack(GrackMod.grackIngot), 0.2f);
		GameRegistry.addSmelting(GrackMod.grackDough.itemID, new ItemStack(GrackMod.grackBread), 0.0f);
		

	}

}
