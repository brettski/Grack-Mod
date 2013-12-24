package bcs2.grackmod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemGrackFood extends ItemFood {

	public ItemGrackFood(int id, int amt, float saturationMod, boolean isWolfsFavoriteMeat) {
		super(id, amt, saturationMod, isWolfsFavoriteMeat);
		
		setCreativeTab(CreativeTabs.tabFood);

	}
	
	public void registerIcons(IconRegister ir) {
		if (this.itemID == GrackMod.grackDough.itemID) {
			
			this.itemIcon = ir.registerIcon("grackmod:grack_dough");

		} else if (this.itemID == GrackMod.grackBread.itemID) {
			
			this.itemIcon = ir.registerIcon("grackmod:grack_bread");			
		}
	}
	
	/*
	public ItemFood setPotionEffect(int a, int b, int c, float d) {
		super.setPotionEffect(a, b, c, d);
		
		return this;
		
	}
	*/
}
