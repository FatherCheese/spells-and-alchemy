package cookie.spellsandalchemy.block.planters;

import cookie.spellsandalchemy.block.SAABlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockPlanterSoulsand extends Block {

	public BlockPlanterSoulsand(String key, int id) {
		super(key, id, Material.wood);
	}

	@Override
	public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
		world.setBlock(x, y, z, SAABlocks.planterBox.id);
		world.dropItem(x, y + 1, z, new ItemStack(Block.soulsand));
		world.markBlockNeedsUpdate(x, y, z);
		return true;
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		System.out.println("Growth!");
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		return new ItemStack[]{new ItemStack(SAABlocks.planterBox), new ItemStack(Block.soulsand)};
	}
}
