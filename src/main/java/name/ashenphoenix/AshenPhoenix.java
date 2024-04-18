package name.ashenphoenix;

import name.ashenphoenix.Item.ModItemGroups;
import name.ashenphoenix.Item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AshenPhoenix implements ModInitializer {
	public static final String MOD_ID = "ashenphoenix";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}
}