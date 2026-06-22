package net.ashleyscottgoad.tutorialmod;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    // --- Add your custom items here ---
    // Each item needs a line like this, plus entries in:
    //   src/main/resources/assets/tutorialmod/lang/en_us.json  (display name)
    //   src/main/resources/assets/tutorialmod/models/item/     (model file)
    //   src/main/resources/assets/tutorialmod/textures/item/   (16x16 PNG texture)

    public static final Item LUCKY_STONE = register("lucky_stone",
            new Item(new Item.Settings()));

    // Helper method — registers an item with Minecraft's item registry
    private static Item register(String name, Item item) {
        return Registry.register(
                Registries.ITEM,
                Identifier.of(TutorialMod.MOD_ID, name),
                item
        );
    }

    // Called from TutorialMod.onInitialize() — triggers the static field initializers above
    public static void registerItems() {
        TutorialMod.LOGGER.info("Registering items for " + TutorialMod.MOD_ID);
    }
}
