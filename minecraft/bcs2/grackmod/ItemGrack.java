package bcs2.grackmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemGrack extends Item {

	public ItemGrack(int id) {
		super(id);

		setCreativeTab(CreativeTabs.tabMaterials);
		setMaxStackSize(64);
		
	}

}
