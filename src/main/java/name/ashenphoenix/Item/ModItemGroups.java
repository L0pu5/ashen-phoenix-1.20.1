package name.ashenphoenix.Item;

import name.ashenphoenix.AshenPhoenix;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup Feathers = Registry.register(Registries.ITEM_GROUP, new Identifier(AshenPhoenix.MOD_ID, "feather"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.feathers"))
                    .icon(()  -> new ItemStack(ModItems.SUNFEATHER)).entries((displayContext, entries) -> {
                        entries.add(ModItems.SUNFEATHER);
                        entries.add(ModItems.SUNFEATHERSHARD);
                        entries.add(ModItems.PHOENIXFEATHER);

                    }).build());

    public static void registerItemGroups(){
        AshenPhoenix.LOGGER.info("Registering Item Groups for " +AshenPhoenix.MOD_ID);
    }
}
