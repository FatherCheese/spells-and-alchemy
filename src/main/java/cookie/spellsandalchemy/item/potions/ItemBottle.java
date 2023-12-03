package cookie.spellsandalchemy.item.potions;

import cookie.spellsandalchemy.item.SAAItems;
import net.minecraft.core.HitResult;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.phys.Vec3d;
import net.minecraft.core.world.World;

import static net.minecraft.core.item.ItemBucketEmpty.useBucket;

public class ItemBottle extends Item {

	public ItemBottle(int id) {
		super(id);
	}

	// This is copied from ItemBucketEmpty.class
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		float playerXRot = entityplayer.xRotO + (entityplayer.xRot - entityplayer.xRotO);
		float playerYRot = entityplayer.yRotO + (entityplayer.yRot - entityplayer.yRotO);
		double playerXO = entityplayer.xo + (entityplayer.x - entityplayer.xo);
		double playerYO = entityplayer.yo + (entityplayer.y - entityplayer.yo) + 1.62 - (double)entityplayer.heightOffset;
		double playerZO = entityplayer.zo + (entityplayer.z - entityplayer.zo);
		Vec3d vec3d = Vec3d.createVector(playerXO, playerYO, playerZO);
		float yRotCos = MathHelper.cos(-playerYRot * 0.01745329F - 3.141593F);
		float yRotSin = MathHelper.sin(-playerYRot * 0.01745329F - 3.141593F);
		float xRotCos = -MathHelper.cos(-playerXRot * 0.01745329F);
		float xRotSin = MathHelper.sin(-playerXRot * 0.01745329F);
		float ySinTimesXCos = yRotSin * xRotCos;
		float yCosTimesXCos = yRotCos * xRotCos;
		Vec3d vec3d1 = vec3d.addVector((double)ySinTimesXCos * 5.0F, (double)xRotSin * 5.0F, (double)yCosTimesXCos * 5.0F);
		HitResult movingObjectPosition = world.checkBlockCollisionBetweenPoints(vec3d, vec3d1, true);

		if (movingObjectPosition == null)
			return itemstack;
        else {
			if (movingObjectPosition.hitType == HitResult.HitType.TILE) {
				int tileX = movingObjectPosition.x;
				int tileY = movingObjectPosition.y;
				int tileZ = movingObjectPosition.z;
				if (!world.canMineBlock(entityplayer, tileX, tileY, tileZ))
					return itemstack;

				if (world.getBlockMaterial(tileX, tileY, tileZ) == Material.water && world.getBlockMetadata(tileX, tileY, tileZ) == 0) {
					if (useBucket(entityplayer, new ItemStack(SAAItems.bottleWater))) {
						world.setBlockWithNotify(tileX, tileY, tileZ, 0);
						entityplayer.swingItem();
					}
				}
			}

			return itemstack;
		}
	}
}
