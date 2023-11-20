package cookie.spellsandalchemy.item;

import cookie.spellsandalchemy.SpellsAndAlchemy;
import cookie.spellsandalchemy.item.potions.ItemBottle;
import cookie.spellsandalchemy.item.potions.ItemBottleLiquid;
import cookie.spellsandalchemy.item.potions.ItemBottleSyntheticGold;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.ItemHelper;

public class SAAItems {
	private int itemID = 17450;
	private int nextItemID() {
		return ++itemID;
	}

	public static Item cinnabar;
	public static Item bottleEmpty;
	public static Item bottleWater;
	public static Item bottleSyntheticGold;

	public void initializeItems() {
		String MOD_ID = SpellsAndAlchemy.MOD_ID;

		cinnabar = ItemHelper.createItem(MOD_ID,
			new Item(nextItemID()),
			"cinnabar",
			"cinnabar.png");

		bottleEmpty = ItemHelper.createItem(MOD_ID,
			new ItemBottle(nextItemID()),
			"bottle.empty",
			"bottle_empty.png");
		bottleWater = ItemHelper.createItem(MOD_ID,
			new ItemBottleLiquid(nextItemID()),
			"bottle.water",
			"bottle_water.png");
		bottleSyntheticGold = ItemHelper.createItem(MOD_ID,
			new ItemBottleSyntheticGold(nextItemID()),
			"bottle.syntheticgold",
			"bottle_syntheticgold.png");

	}
}
