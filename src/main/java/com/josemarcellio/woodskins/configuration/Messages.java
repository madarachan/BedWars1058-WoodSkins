package com.josemarcellio.woodskins.configuration;

import org.bukkit.plugin.java.JavaPlugin;

public class Messages extends ConfigManager {

    public Messages(JavaPlugin plugin) {
        super(plugin, "messages.yml");
    }

    @WoodSkinsConfig (path = "MainCommand")
    public static String MAIN_COMMAND;

    @WoodSkinsConfig (path = "AdminCommand")
    public static String ADMIN_COMMAND;

    @WoodSkinsConfig (path = "OnlyPlayerCanUseCommand")
    public static String ONLY_PLAYER_CAN_USE_COMMAND;

    @WoodSkinsConfig (path = "NoPermission")
    public static String NO_PERMISSION;

    @WoodSkinsConfig (path = "SelectedEffect")
    public static String SELECTED_EFFECT;

    @WoodSkinsConfig (path = "LockedEffect")
    public static String LOCKED_EFFECT;

    @WoodSkinsConfig (path = "PurchasedEffect")
    public static String PURCHASED_EFFECT;
}
