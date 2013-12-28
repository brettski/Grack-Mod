package bcs2.grackmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class ItemGrackPickaxe extends ItemPickaxe {

	public ItemGrackPickaxe(int Id, EnumToolMaterial Material) {
		super(Id, Material);

		setTextureName("grackmod:grack_pickaxe");
		setCreativeTab(CreativeTabs.tabTools);
		
	}

}
