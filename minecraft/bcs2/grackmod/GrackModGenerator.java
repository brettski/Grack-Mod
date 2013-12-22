package bcs2.grackmod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class GrackModGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		genBlocks(world, random, chunkX*16, chunkZ*16);
		
	}

	public void genBlocks(World world, Random random, int chunkX, int chunkZ) {
		
		addBlock(GrackMod.blockOreGrack, world, random, chunkX, chunkZ, 16, 16, 8, 20, 10, 100);
		
	}
	/**
	 * @param(0) block => The block to add
	 * @param(1) world => The world to create the block in
	 * @param(2) random => A Random object for retrieving random positions within the world to spawn the Block
	 * @param(3) chunkX => X-Coordinate for the Generation method 
	 * @param(4) chunkZ => Z-Coordinate for the Generation method
	 * @param(5) xMax => maximum X-Coordinate values for spawning on the X-Axis on a per chunk basis 
	 * @param(6) zMax => maximum Z-Coordinate values for spawning on the Z-Axis on a per chunk basis
	 * @param(7) vain => The maximum size of a vein
	 * @param(8) number => The Number of chances available for the Block to spawn per chunk
	 * @param(9) yMin => Minimum Y-Coordinate height at which this block may spawn 
	 * @param(10) yMax => Maximum Y-Coordinate height at which this block may spawn
	 */
	public void addBlock(Block block, World world, Random random, int chunkX, int chunkZ,
			int xMax, int zMax, int vain, int number, int yMin, int yMax) {
		
		for (int i = 0; i < number; i++) {
			(new WorldGenMinable(block.blockID, vain)).generate(world, random, 
					chunkX + random.nextInt(16), yMin + random.nextInt(yMax-yMin), chunkZ + random.nextInt(16));
		}
	}
}
