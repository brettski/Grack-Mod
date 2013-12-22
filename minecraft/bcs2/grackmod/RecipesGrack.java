package bcs2.grackmod;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipesGrack {
	
	
	
	public static void getRecipes() {
		
		// Shapeless crafting
		
		
		
		// crafting
		GameRegistry.addRecipe(new ItemStack(GrackMod.grackCompressed), "ggg", "ggg", "ggg", 'g', GrackMod.grackDust);
		
		// smelting
		GameRegistry.addSmelting(GrackMod.grackCompressed.itemID, new ItemStack(GrackMod.grackIngot), 0.2f);
		

	}

}
