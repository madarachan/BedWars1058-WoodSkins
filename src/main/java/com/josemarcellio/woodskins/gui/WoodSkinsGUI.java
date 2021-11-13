package com.josemarcellio.woodskins.gui;

import com.josemarcellio.woodskins.WoodSkins;
import com.josemarcellio.woodskins.configuration.ConfigReader;
import com.josemarcellio.woodskins.configuration.GUI;
import com.josemarcellio.woodskins.inventory.InventoryGUI;
import com.josemarcellio.woodskins.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class WoodSkinsGUI extends InventoryGUI {

    private final WoodSkins plugin;

    public WoodSkinsGUI(WoodSkins plugin) {
        super( Utils.getColor ( GUI.GUI_NAME),
                GUI.GUI_SIZE);
        this.plugin = plugin;
    }


    @Override
    public void init() {
        FileConfiguration gui = ConfigReader.Configs.GUI.getConfig();
        this.setGUI(1,
                this.createItem("OakPlank" ), gui.getInt("OakPlank.Location.X"),
                gui.getInt("OakPlank.Location.Y"));

        this.setGUI(2,
                this.createItem("SprucePlank" ), gui.getInt("SprucePlank.Location.X"),
                gui.getInt("SprucePlank.Location.Y"));

        this.setGUI(3,
                this.createItem("BirchPlank" ), gui.getInt("BirchPlank.Location.X"),
                gui.getInt("BirchPlank.Location.Y"));

        this.setGUI(4,
                this.createItem("JunglePlank" ), gui.getInt("JunglePlank.Location.X"),
                gui.getInt("JunglePlank.Location.Y"));

        this.setGUI(5,
                this.createItem("AcaciaPlank" ), gui.getInt("AcaciaPlank.Location.X"),
                gui.getInt("AcaciaPlank.Location.Y"));

        this.setGUI(6,
                this.createItem("DarkOakPlank" ), gui.getInt("DarkOakPlank.Location.X"),
                gui.getInt("DarkOakPlank.Location.Y"));

        this.setGUI(7,
                this.createItem("OakLog" ), gui.getInt("OakLog.Location.X"),
                gui.getInt("OakLog.Location.Y"));

        this.setGUI(8,
                this.createItem("SpruceLog" ), gui.getInt("SpruceLog.Location.X"),
                gui.getInt("SpruceLog.Location.Y"));

        this.setGUI(9,
                this.createItem("BirchLog" ), gui.getInt("BirchLog.Location.X"),
                gui.getInt("BirchLog.Location.Y"));

        this.setGUI(10,
                this.createItem("JungleLog" ), gui.getInt("JungleLog.Location.X"),
                gui.getInt("JungleLog.Location.Y"));

        this.setGUI(11,
                this.createItem("AcaciaLog" ), gui.getInt("AcaciaLog.Location.X"),
                gui.getInt("AcaciaLog.Location.Y"));

        this.setGUI(12,
                this.createItem("DarkOakLog" ), gui.getInt("DarkOakLog.Location.X"),
                gui.getInt("DarkOakLog.Location.Y"));

        this.setGUI(13,
                this.createItem("Close" ), gui.getInt("Close.Location.X"),
                gui.getInt("Close.Location.Y"));
    }

    @Override
    public void clickGUI(int id, Player p) {
        switch (id) {
            case 1:
                WoodSkins.getUtils().action(p, plugin.getEffectManager (),
                         "Oak Plank",
                        "oakplank", "OakPlank");
                break;
            case 2:
                WoodSkins.getUtils().action(p, plugin.getEffectManager (),
                         "Spruce Plank",
                        "spruceplank", "SprucePlank");
                break;
            case 3:
                WoodSkins.getUtils().action(p, plugin.getEffectManager (),
                         "Birch Plank",
                        "birchplank", "BirchPlank");
                break;
            case 4:
                WoodSkins.getUtils().action(p, plugin.getEffectManager (),
                         "Jungle Plank",
                        "jungleplank", "JunglePlank");
                break;
            case 5:
                WoodSkins.getUtils().action(p, plugin.getEffectManager (),
                         "Acacia Plank",
                        "acaciaplank", "AcaciaPlank");
                break;
            case 6:
                WoodSkins.getUtils().action(p, plugin.getEffectManager (),
                         "Dark Oak Plank",
                        "darkoakplank", "DarkOakPlank");
                break;
            case 7:
                WoodSkins.getUtils().action(p, plugin.getEffectManager (),
                        "Oak Log",
                        "oaklog", "OakLog");
                break;
            case 8:
                WoodSkins.getUtils().action(p, plugin.getEffectManager (),
                        "Spruce Log",
                        "sprucelog", "SpruceLog");
                break;
            case 9:
                WoodSkins.getUtils().action(p, plugin.getEffectManager (),
                        "Birch Log",
                        "birchlog", "BirchLog");
                break;
            case 10:
                WoodSkins.getUtils().action(p, plugin.getEffectManager (),
                        "Jungle Log",
                        "junglelog", "JungleLog");
                break;
            case 11:
                WoodSkins.getUtils().action(p, plugin.getEffectManager (),
                        "Acacia Log",
                        "acacialog", "AcaciaLog");
                break;
            case 12:
                WoodSkins.getUtils().action(p, plugin.getEffectManager (),
                        "Dark Oak Log",
                        "darkoaklog", "DarkOakLog");
                break;
            case 13:
                this.close(p);
                break;
        }
    }
}
