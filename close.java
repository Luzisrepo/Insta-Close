package com.example.instaclose;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(
    modid = InstaClose.MODID,
    name = "InstaClose",
    version = "1.0.0",
    acceptedMinecraftVersions = "[1.8.9]"
)
public class InstaClose {

    public static final String MODID = "instaclose";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // Register our client-side event handler
        MinecraftForge.EVENT_BUS.register(new GuiBlocker());
    }

    /** Event handler that cancels any container GUI opening. */
    public static class GuiBlocker {
        @SubscribeEvent
        public void onGuiOpen(GuiOpenEvent event) {
            GuiScreen gui = event.gui;
            if (gui == null) return;

            // Any inventory/container-based screen extends GuiContainer (includes player inv, chests, furnaces, crafting, hopper, anvil, creative inv, etc.)
            if (gui instanceof GuiContainer) {
                event.setCanceled(true);
            }
        }
    }
}
