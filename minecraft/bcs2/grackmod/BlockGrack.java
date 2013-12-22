package bcs2.grackmod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockGrack extends Block {

	public BlockGrack(int id, Material material) {
		super(id, material);
		
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(Block.soundStoneFootstep);
		setHardness(2.0f);

	}
	
	/**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        //return 1;
    	return 2 + par1Random.nextInt(6);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return GrackMod.grackDust.itemID;
    }	

    @Override
    public int getExpDrop(World par1World, int par5, int par7)
    {
        int j1 = 0;

    	if (this.idDropped(par5, par1World.rand, par7) != this.blockID)
        {
            if (this.blockID == GrackMod.blockOreGrack.blockID)
            {
            	// same experience as coal when mined.  
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 0, 2);
            }
        }
        
        return j1;
    }

}
