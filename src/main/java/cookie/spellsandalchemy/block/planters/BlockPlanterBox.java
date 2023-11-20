package cookie.spellsandalchemy.block.planters;

import cookie.spellsandalchemy.block.SAABlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockPlanterBox extends Block {
	public BlockPlanterBox(String key, int id) {
		super(key, id, Material.wood);
	}

	@Override
	public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
		if (!world.isClientSide) {
            if (world.getBlockMetadata(x, y, z) == 0 && player.inventory.getCurrentItem() != null) {
                if (player.inventory.getCurrentItem().itemID == Block.dirt.id) {
                    world.setBlock(x, y, z, SAABlocks.planterBoxDirt.id);
                    world.markBlockNeedsUpdate(x, y, z);

					if (player.gamemode.consumeBlocks)
						--player.inventory.getCurrentItem().stackSize;
                }

                if (player.inventory.getCurrentItem().itemID == Block.sand.id) {
                    world.setBlock(x, y, z, SAABlocks.planterBoxSand.id);
                    world.markBlockNeedsUpdate(x, y, z);

					if (player.gamemode.consumeBlocks)
						--player.inventory.getCurrentItem().stackSize;
                }

                if (player.inventory.getCurrentItem().itemID == Block.soulsand.id) {
                    world.setBlock(x, y, z, SAABlocks.planterBoxSoulsand.id);
                    world.markBlockNeedsUpdate(x, y, z);

					if (player.gamemode.consumeBlocks)
						--player.inventory.getCurrentItem().stackSize;
                }
            }
		}
		return true;
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		return new ItemStack[]{new ItemStack(this)};
	}
}
