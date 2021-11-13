package com.josemarcellio.woodskins.command;

import com.josemarcellio.woodskins.WoodSkins;
import com.josemarcellio.woodskins.configuration.Messages;
import com.josemarcellio.woodskins.gui.WoodSkinsGUI;
import com.josemarcellio.woodskins.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command {

    private final WoodSkins plugin;

    public Command(WoodSkins plugin) {
        this.plugin = plugin;
    }

    @WoodSkinsCommand(command = "/bedwarswoodskins")
    public void main(CommandSender sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage ( Utils.getColor( Messages.MAIN_COMMAND ) );
        }

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase ( "open" )) {
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    WoodSkinsGUI gui = new WoodSkinsGUI ( plugin );
                    gui.open ( p );
                } else {
                    sender.sendMessage ( Utils.getColor( Messages.ONLY_PLAYER_CAN_USE_COMMAND ) );
                }
            }
        }
    }

    @WoodSkinsCommand(command = "/bedwarswoodskinsadmin", permission = "bwws.admin")
    public void admin(CommandSender sender, String[] args) {
        if (args.length == 0 || args.length == 1) {
            sender.sendMessage ( Utils.getColor ( Messages.ADMIN_COMMAND ) );
        }
        if (args.length == 2) {
            if (args[0].equalsIgnoreCase ( "open" )) {
                Player p = Bukkit.getPlayer(args[1]);
                WoodSkinsGUI gui = new WoodSkinsGUI ( plugin );
                if (p != null) {
                    gui.open ( p );
                }
            }
        }
    }
}
