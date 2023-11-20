package cookie.spellsandalchemy.spell;

import com.mojang.nbt.CompoundTag;
import net.minecraft.core.item.ItemStack;

public class SpellUtil {

	public static CompoundTag createTag() {
		CompoundTag compoundTag = new CompoundTag();
		compoundTag.putBoolean("Magicified", true);

		return compoundTag;
	};

	public static void bindSpell(ItemStack itemStack) {
		if (itemStack != null)
			itemStack.getData().put("Magicified", createTag());
	};
}
