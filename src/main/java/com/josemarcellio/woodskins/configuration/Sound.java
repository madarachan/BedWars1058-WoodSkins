package com.josemarcellio.woodskins.configuration;

import org.bukkit.plugin.java.JavaPlugin;

public class Sound extends ConfigManager {

    public Sound(JavaPlugin plugin) {
        super(plugin, "sound.yml");
    }

    @WoodSkinsConfig (path = "SelectedEffect")
    public static String SELECTED_EFFECT;

    @WoodSkinsConfig (path = "LockedEffect")
    public static String LOCKED_EFFECT;

    @WoodSkinsConfig (path = "PurchasedEffect")
    public static String PURCHASED_EFFECT;
}
