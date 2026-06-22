package net.ashleyscottgoad.tutorialmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {

    public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Tutorial Mod loaded! Let's build something.");

        // Register all custom items defined in ModItems.java
        ModItems.registerItems();

        // Add the Lucky Stone to the Ingredients tab in Creative mode
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModItems.LUCKY_STONE);
        });
    }
}
