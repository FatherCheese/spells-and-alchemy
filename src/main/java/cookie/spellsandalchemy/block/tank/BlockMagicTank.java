package cookie.spellsandalchemy.block.tank;

import cookie.spellsandalchemy.block.tank.entity.TileEntityMagicTank;
import net.minecraft.core.block.BlockTileEntity;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.world.World;

public class BlockMagicTank extends BlockTileEntity {

	public BlockMagicTank(String key, int id) {
		super(key, id, Material.glass);
	}

	@Override
	public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
		TileEntityMagicTank tile = (TileEntityMagicTank) world.getBlockTileEntity(x, y, z);
		player.addChatMessage("Tank Amount | " + tile.magicAmount);
		return super.blockActivated(world, x, y, z, player);
	}

	@Override
	protected TileEntity getNewBlockEntity() {
		return new TileEntityMagicTank();
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
}
