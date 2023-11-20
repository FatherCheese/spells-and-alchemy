package cookie.spellsandalchemy.item.potions;

import cookie.spellsandalchemy.item.SAAItems;
import net.minecraft.core.item.Item;

public class ItemBottleLiquid extends Item {

	public ItemBottleLiquid(int id) {
		super(id);
		setMaxStackSize(1);
		setContainerItem(SAAItems.bottleEmpty);
	}
}
