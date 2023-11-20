package cookie.spellsandalchemy.block.flowers;

import cookie.spellsandalchemy.SAATags;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockFlower;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockFlowerNetherbell extends BlockFlower {

	public BlockFlowerNetherbell(String key, int id) {
		super(key, id);
		setTickOnLoad(true);
	}

	@Override
	protected boolean canThisPlantGrowOnThisBlockID(int i) {
		return Block.blocksList[i] != null && (Block.blocksList[i].hasTag(BlockTags.GROWS_FLOWERS) || Block.blocksList[i].hasTag(SAATags.NETHER_GROWTH));
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		double partX = (float) x + rand.nextDouble();
		double partY = (float) y + 0.7F;
		double partZ = (float) z + rand.nextDouble();
		if (rand.nextInt(3) != 0) {
			world.spawnParticle("smoke", partX, partY, partZ, 0.0, 0.02, 0.0);
			world.spawnParticle("flame", partX, partY, partZ, 0.0, 0.01, 0.0);
		} else {
			world.spawnParticle("smoke", partX, partY, partZ, 0.0, 0.2, 0.0);
			world.spawnParticle("flame", partX, partY, partZ, 0.0, 0.1, 0.0);
		}
	}
}
