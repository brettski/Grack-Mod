package bcs2.grackmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;

public class ItemGrackHoe extends ItemHoe {

	public ItemGrackHoe(int Id, EnumToolMaterial Material) {
		super(Id, Material);
		
		setTextureName("grackmod:grack_hoe");
		setCreativeTab(CreativeTabs.tabTools);

	}

}
