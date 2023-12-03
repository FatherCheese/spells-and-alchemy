package cookie.spellsandalchemy.block.tank.entity;

import com.mojang.nbt.CompoundTag;
import cookie.spellsandalchemy.block.SAABlocks;
import cookie.spellsandalchemy.block.flowers.BlockFlowerBlossomite;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.world.World;

import java.util.Random;

public class TileEntityMagicTank extends TileEntity {
	private int nextMagic = 0;
	private int nextMagicMax = 200;
	private int boosterCount = 0;
	public int magicAmount = 0;
	public final int maxMagic = 100;

	private void adjacentFlowers() {
		boosterCount = 0;

		if (worldObj.getBlockId(xCoord + 1, yCoord, zCoord) == SAABlocks.flowerNature.id)
			boosterCount += 1;

		if (worldObj.getBlockId(xCoord - 1, yCoord, zCoord) == SAABlocks.flowerNature.id)
			boosterCount += 1;

		if (worldObj.getBlockId(xCoord, yCoord, zCoord + 1) == SAABlocks.flowerNature.id)
			boosterCount += 1;

		if (worldObj.getBlockId(xCoord, yCoord, zCoord - 1) == SAABlocks.flowerNature.id)
			boosterCount += 1;
	}

	@Override
	public void updateEntity() {
		if (!worldObj.isClientSide) {

			adjacentFlowers();

			for (int x = xCoord - 1; x < xCoord + 1; x++)
				for (int z = zCoord - 1; z < zCoord + 1; z++) {
					Block nearbyBlocks = worldObj.getBlock(x, yCoord, z);

					if (nearbyBlocks != null && nearbyBlocks.id != 0 && nearbyBlocks instanceof BlockFlowerBlossomite) {
						nextMagicMax = 175;
					} else
						nextMagicMax = 200;
				}

			nextMagicMax -= boosterCount * 25;

			if (magicAmount != maxMagic) {
				nextMagic++;

				if (nextMagic >= nextMagicMax) {
					magicAmount += 1;
					nextMagic = 0;

					Random rand = new Random();
					double partX = (float) xCoord + rand.nextDouble();
					double partY = (float) yCoord + 0.4;
					double partZ = (float) zCoord + rand.nextDouble();
					worldObj.spawnParticle("portal", partX, partY, partZ, 0.1F, 0.8F, 0.1F);
				}

				if (magicAmount == 25)
					worldObj.markBlockNeedsUpdate(xCoord, yCoord, zCoord);

				if (magicAmount == 50)
					worldObj.markBlockNeedsUpdate(xCoord, yCoord, zCoord);

				if (magicAmount == 75)
					worldObj.markBlockNeedsUpdate(xCoord, yCoord, zCoord);

				if (magicAmount == 100)
					worldObj.markBlockNeedsUpdate(xCoord, yCoord, zCoord);
			}
		}
	}

	@Override
	public void writeToNBT(CompoundTag nbttagcompound) {
		super.writeToNBT(nbttagcompound);
		nbttagcompound.putInt("Magic", magicAmount);
	}

	@Override
	public void readFromNBT(CompoundTag nbttagcompound) {
		super.readFromNBT(nbttagcompound);
		magicAmount = nbttagcompound.getInteger("Magic");
	}
}
