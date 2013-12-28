package bcs2.grackmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;

public class ItemGrackAxe extends ItemAxe {

	public ItemGrackAxe(int Id, EnumToolMaterial Material) {
		super(Id, Material);

		setTextureName("grackmod:grack_axe");
		setCreativeTab(CreativeTabs.tabTools);
		
	}

}
