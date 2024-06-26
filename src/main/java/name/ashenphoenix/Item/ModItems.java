package name.ashenphoenix.Item;

import name.ashenphoenix.AshenPhoenix;
import name.ashenphoenix.Item.custom.sunfeather;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SUNFEATHER = registerItem("sunfeather", new sunfeather(new FabricItemSettings()));
    public static final Item SUNFEATHERSHARD = registerItem("sunfeathershard", new Item(new FabricItemSettings()));
    public static final Item PHOENIXFEATHER = registerItem("phoenixfeather", new Item(new FabricItemSettings()));

    private static void addItemsToToolItemGroup(FabricItemGroupEntries entries) {
        entries.add(SUNFEATHER);
        entries.add(SUNFEATHERSHARD);
        entries.add(PHOENIXFEATHER);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AshenPhoenix.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AshenPhoenix.LOGGER.info("Registering Mod Items for " + AshenPhoenix.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolItemGroup);
    }
}
