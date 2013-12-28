package bcs2.grackmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;

public class ItemGrackShovel extends ItemSpade {

	public ItemGrackShovel(int Id, EnumToolMaterial Material) {
		super(Id, Material);

		setTextureName("grackmod:grack_shovel");
		setCreativeTab(CreativeTabs.tabTools);

	}

}
