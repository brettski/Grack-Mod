package bcs2.grackmod;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class GrackSeedsWheat extends Item implements IPlantable {

	public GrackSeedsWheat(int id, int parentId, int soilId) {
		super(id);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMaterials);
		
	}
	
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon("grackmod:grack_seeds");
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, 
			int par7, float par8, float par9, float par10) {
		
		if (par7 != 1) {
			return false;
		}
		else if (player.canPlayerEdit(x, y, z, par7, stack) && player.canPlayerEdit(x, y+1, z, par7, stack)) {
			
			int blockid = world.getBlockId(x,  y, z);
			Block soil = Block.blocksList[blockid];
			
			if (soil != null && soil.canSustainPlant(world, x, y, z, ForgeDirection.UP, this) && 
					world.isAirBlock(x, y + 1, z)) {
				
				world.setBlock(x, y + 1, z, GrackMod.grackWheatCrop.blockID);
				--stack.stackSize;
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z) {
		return EnumPlantType.Crop;
	}

	@Override
	public int getPlantID(World world, int x, int y, int z) {
		return GrackMod.grackWheatCrop.blockID;
	}

	@Override
	public int getPlantMetadata(World world, int x, int y, int z) {
		return 0;
	}

}
