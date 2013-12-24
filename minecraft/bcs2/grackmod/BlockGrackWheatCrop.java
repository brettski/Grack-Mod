package bcs2.grackmod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class BlockGrackWheatCrop extends Block {

	public static int growthStages = 4;
	/*
	public static Icon grownIcon0;
	public static Icon grownIcon1;
	public static Icon grownIcon2;
	public static Icon grownIcon3;
	*/
	public static Icon[] growthIcon = new Icon[growthStages];

	
	public BlockGrackWheatCrop(int id) {
		super(id, Material.plants);
		
		setTickRandomly(true);
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.5f, 1.0f);

	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool (World world, int x, int y, int z) {
		return null;
	}
	
	public int getRenderType() {
		return 6;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public void registerIcons(IconRegister ir) {
		for (int i = 0; i < growthIcon.length; i++) {
			growthIcon[i] = ir.registerIcon("grackmod:grack_stage_" + i);
		}
		/*
		grownIcon0 = ir.registerIcon("grackmod:grack_stage_0");
		grownIcon1 = ir.registerIcon("grackmod:grack_stage_0");
		grownIcon2 = ir.registerIcon("grackmod:grack_stage_0");
		grownIcon3 = ir.registerIcon("grackmod:grack_stage_0");
		*/
	}
	
	public Icon getIcon(int side, int metadata) {
		if (metadata < growthStages) {
			
			return growthIcon[metadata];
			
		}
		return null;
	}
	
	public void updateTick(World world, int x, int y, int z, Random random) {

		// check if block is grown to full height
		int bm = world.getBlockMetadata(x, y, z);
		
		if (isFullyGrown(bm)) {
			return;
		}
		// is there enough light?
		if (world.getBlockLightValue(x,  y+1, z) < 9) {
			return;
		}
		// Randomize int, less possible int's if fertile soil.  If the number is not zero, then do nothing (return)
		if (random.nextInt(isFertile(world, x, y-1, z) ? 12 : 25) != 0) {
			return;
		}
		growCrop(world, x, y, z);
		//world.setBlockMetadataWithNotify(x, y, z, ++bm, 2);
	}
	/**
	 * Checks if crop is already at it's full height
	 * @param blockMetadata => Blocks current metadata value
	 * @return
	 */
	private static boolean isFullyGrown(int blockMetadata) {
		return !(blockMetadata < growthStages);
	}
	/**
	 * Use to grow crop directly, e.g. using bone meal, etc. 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 */
	public static void growCrop(World world, int x, int y, int z) {

		int bm = world.getBlockMetadata(x, y, z);
		
		if (isFullyGrown(bm)) {
			return;
		}
		world.setBlockMetadataWithNotify(x, y, z, ++bm, 2);
	}
	
	/*
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighborid) {
		if (!canBlockStay(world, x, y, z)) {
			
			dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
			world.setBlockMetadataWithNotify(x, y, z, 0, 2);
		}
	}
	*/
	
	public boolean canBlockStay(World world, int x, int y, int z) {
		Block soil = blocksList[world.getBlockId(x, y - 1,  z)];
		return (world.getFullBlockLightValue(x, y, z) >= 8 || world.canBlockSeeTheSky(x, y, z)) 
				&& (soil != null && soil.canSustainPlant(world, x, y, z, ForgeDirection.UP, (IPlantable)GrackMod.grackSeeds));
	}
	
	public int idDropped(int metadata, Random random, int par2) {
		if (metadata < growthStages - 1) {
			return GrackMod.grackSeeds.itemID;
		}
		return GrackMod.grackWheat.itemID;
	}
	
	public int idPicked(World world, int x, int y, int z) {
		return GrackMod.grackSeeds.itemID;
	}
	
	 /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    protected boolean canThisPlantGrowOnThisBlockID(int par1)
    {
        return par1 == Block.tilledField.blockID;
    }
}





