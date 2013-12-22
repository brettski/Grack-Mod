package bcs2.grackmod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class GrackArmor extends ItemArmor {

	int ArmorTypeId = -1;
	
	public GrackArmor(int id, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) {
		super(id, par2EnumArmorMaterial, par3, par4);
		
		ArmorTypeId = par4;
		
		setCreativeTab(CreativeTabs.tabCombat);

	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		
		switch (ArmorTypeId) {
		case 0: this.itemIcon = ir.registerIcon("grackmod:grack_helmet");
			break;
		case 1: this.itemIcon = ir.registerIcon("grackmod:grack_chestplate");
			break;
		case 2: this.itemIcon = ir.registerIcon("grackmod:grack_leggings");
			break;
		case 3: this.itemIcon = ir.registerIcon("grackmod:grack_boots");
			break;
		}
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		
		if (ArmorTypeId == 2) {
			
			return "grackmod:textures/models/armor/grack_armor_2.png";
		}
				
		return "grackmod:textures/models/armor/grack_armor.png";
		
	}
}
