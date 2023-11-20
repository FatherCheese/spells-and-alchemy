package cookie.spellsandalchemy.item.potions;

import cookie.spellsandalchemy.block.SAABlocks;
import cookie.spellsandalchemy.item.SAAItems;
import net.minecraft.core.HitResult;
import net.minecraft.core.block.Block;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.sound.SoundType;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.Vec3d;
import net.minecraft.core.world.World;

public class ItemBottleSyntheticGold extends Item {

	public ItemBottleSyntheticGold(int id) {
		super(id);
		setMaxStackSize(1);
		setContainerItem(SAAItems.bottleEmpty);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		float playerXRot = entityplayer.xRotO + (entityplayer.xRot - entityplayer.xRotO);
		float playerYRot = entityplayer.yRotO + (entityplayer.yRot - entityplayer.yRotO);
		double posX = entityplayer.xo + (entityplayer.x - entityplayer.xo);
		double posY = entityplayer.yo + (entityplayer.y - entityplayer.yo) + 1.62 - (double) entityplayer.heightOffset;
		double posZ = entityplayer.zo + (entityplayer.z - entityplayer.zo);
		Vec3d vec3d = Vec3d.createVector(posX, posY, posZ);
		float cosYRot = MathHelper.cos(-playerYRot * 0.01745329F - 3.141593F);
		float sinYRot = MathHelper.sin(-playerYRot * 0.01745329F - 3.141593F);
		float cosXRot = -MathHelper.cos(-playerXRot * 0.01745329F);
		float sinXRot = MathHelper.sin(-playerXRot * 0.01745329F);
		float sinYCosX = sinYRot * cosXRot;
		float CosYCosX = cosYRot * cosXRot;
		Vec3d vec3d1 = vec3d.addVector((double) sinYCosX * 5.0, (double) sinXRot * 5.0, (double) CosYCosX * 5.0);
		HitResult rayTraceResult = world.checkBlockCollisionBetweenPoints(vec3d, vec3d1, false);
		if (rayTraceResult != null && rayTraceResult.hitType == HitResult.HitType.TILE) {
			int x = rayTraceResult.x;
			int y = rayTraceResult.y;
			int z = rayTraceResult.z;
			Block block = world.getBlock(x, y, z);

			if (block == Block.flowerYellow) {
				world.playSoundEffect(SoundType.WORLD_SOUNDS, x, y, z, "liquid.splash", 0.15F, 2.0F);
				world.setBlockWithNotify(x, y, z, SAABlocks.flowerNature.id);
				entityplayer.swingItem();

				if (entityplayer.gamemode.consumeBlocks)
					return new ItemStack(SAAItems.bottleEmpty);
			}

			if (block == Block.flowerRed) {
				world.playSoundEffect(SoundType.WORLD_SOUNDS, x, y, z, "liquid.splash", 0.15F, 2.0F);
				world.setBlockWithNotify(x, y, z, SAABlocks.flowerNether.id);
				entityplayer.swingItem();

				if (entityplayer.gamemode.consumeBlocks)
					return new ItemStack(SAAItems.bottleEmpty);
			}
		}
		return itemstack;
	}
}
