package bcs2.grackmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class ItemGrackSword extends ItemSword {

	public ItemGrackSword(int Id, EnumToolMaterial Material) {
		super(Id, Material);
		
		setTextureName("grackmod:grack_sword");
		setCreativeTab(CreativeTabs.tabCombat);

	}

}
