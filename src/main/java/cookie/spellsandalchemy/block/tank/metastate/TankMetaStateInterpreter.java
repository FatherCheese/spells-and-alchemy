package cookie.spellsandalchemy.block.tank.metastate;

import cookie.spellsandalchemy.block.tank.entity.TileEntityMagicTank;
import net.minecraft.core.block.Block;
import net.minecraft.core.world.WorldSource;
import useless.dragonfly.model.blockstates.processed.MetaStateInterpreter;

import java.util.HashMap;

public class TankMetaStateInterpreter extends MetaStateInterpreter {

	@Override
	public HashMap<String, String> getStateMap(WorldSource worldSource, int x, int y, int z, Block block, int meta) {
		HashMap<String, String> result = new HashMap<>();
		TileEntityMagicTank tank = (TileEntityMagicTank) worldSource.getBlockTileEntity(x, y, z);
		int magicstate = 0;

		if (tank != null) {
			if (tank.magicAmount >= 25 && tank.magicAmount < 50)
				magicstate = 1;

			if (tank.magicAmount >= 50 && tank.magicAmount < 75)
				magicstate = 2;

			if (tank.magicAmount >= 75 && tank.magicAmount < 100)
				magicstate = 3;

			if (tank.magicAmount == 100)
				magicstate = 4;
		}

		result.put("magicstate", String.valueOf(magicstate));
		return result;
	}
}
