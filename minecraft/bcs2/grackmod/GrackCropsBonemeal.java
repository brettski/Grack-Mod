package bcs2.grackmod;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class GrackCropsBonemeal {

	@ForgeSubscribe
	public void onUseBonemeal(BonemealEvent event) {

		if (event.ID == GrackMod.grackWheatCrop.blockID) {
			int bm = event.world.getBlockMetadata(event.X, event.Y, event.Z);
			BlockGrackWheatCrop.growCrop(event.world, event.X, event.Y, event.Z);
		}
	}
	
}
