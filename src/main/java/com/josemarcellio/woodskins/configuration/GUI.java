package com.josemarcellio.woodskins.configuration;

import org.bukkit.plugin.java.JavaPlugin;

public class GUI extends ConfigManager {

    public GUI(JavaPlugin plugin) {
        super(plugin, "gui.yml");
    }

    @WoodSkinsConfig (path = "GUI.Name")
    public static String GUI_NAME;

    @WoodSkinsConfig (path = "GUI.Size")
    public static int GUI_SIZE;

}
