package cookie.spellsandalchemy;

import cookie.spellsandalchemy.block.SAABlocks;
import cookie.spellsandalchemy.item.SAAItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SpellsAndAlchemy implements ModInitializer {
    public static final String MOD_ID = "saa";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

		// DO NOT TOUCH THIS! It's an error prevention method. Thanks Useless!
		try {
			Class.forName("net.minecraft.core.block.Block");
			Class.forName("net.minecraft.core.item.Item");
		} catch (ClassNotFoundException ignored) {}

		new SAABlocks().initializeBlocks();
		new SAAItems().initializeItems();

        LOGGER.info("Spells and Alchemy initialized. Have fun, novice mage!");
    }
}
