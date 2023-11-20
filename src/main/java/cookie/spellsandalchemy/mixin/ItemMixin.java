package cookie.spellsandalchemy.mixin;

import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Item.class, remap = false)
public abstract class ItemMixin {

	@Inject(method = "onItemRightClick", at = @At("TAIL"), cancellable = true)
	private void SAA_spellRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer, CallbackInfoReturnable<ItemStack> cir) {
		if (itemstack != null && itemstack.getData().containsKey("Magicified")) {
			world.playSoundAtEntity(entityplayer, "fire.ignite", 1.0F, 1.0F);
			entityplayer.swingItem();
			cir.setReturnValue(itemstack);
		}
	}
}
