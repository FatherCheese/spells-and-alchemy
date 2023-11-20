package cookie.spellsandalchemy.block;

import cookie.spellsandalchemy.item.SAAItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockOreCinnabar extends Block {

	public BlockOreCinnabar(String key, int id, Material material) {
		super(key, id, material);
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        switch (dropCause) {
            case PICK_BLOCK:
            case SILK_TOUCH:
                return new ItemStack[]{new ItemStack(this)};
			case PROPER_TOOL:
			case EXPLOSION:
				return new ItemStack[]{new ItemStack(SAAItems.cinnabar)};
			default:
				return null;
        }
	}
}
