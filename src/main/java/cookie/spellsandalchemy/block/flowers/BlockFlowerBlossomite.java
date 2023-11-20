package cookie.spellsandalchemy.block.flowers;

import cookie.spellsandalchemy.SAATags;
import cookie.spellsandalchemy.SpellsAndAlchemy;
import cookie.spellsandalchemy.spell.SpellUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockFlower;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.fx.EntityDiggingFX;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.sound.SoundType;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockFlowerBlossomite extends BlockFlower {

	public BlockFlowerBlossomite(String key, int id) {
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
		double partX2 = (float) x + rand.nextDouble();
		double partX3 = (float) x + rand.nextDouble();
		double partY = (float) y + 0.4;
		double partY2 = (float) y + 0.8;
		double partY3 = (float) y + 1.2F;
		double partZ = (float) z + rand.nextDouble();
		double partZ2 = (float) z + rand.nextDouble();
		double partZ3 = (float) z + rand.nextDouble();
		if (rand.nextInt(4) == 0) {
			world.spawnParticle("portal", partX, partY, partZ, 0.1F, 0.8F, 0.1F);
			world.spawnParticle("portal", partX2, partY2, partZ2, 0.1F, 0.6F, 0.1F);
			world.spawnParticle("portal", partX3, partY3, partZ3, 0.1F, 0.4F, 0.1F);
		}
		if (rand.nextInt(25) == 0)
			world.playSoundEffect(SoundType.WORLD_SOUNDS, (double)x + 0.5, (double)y + 0.5, (double)z + 0.5, "portal.portal", 0.15F, rand.nextFloat() * 5.0F);
	}

	@Override
	public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
		ItemStack stack = player.getHeldItem();

		if (stack != null && stack.getItem() == Item.stick)
			SpellUtil.bindSpell(stack);

		return super.blockActivated(world, x, y, z, player);
	}
}
