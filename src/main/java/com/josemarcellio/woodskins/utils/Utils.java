package com.josemarcellio.woodskins.utils;

import com.josemarcellio.woodskins.WoodSkins;
import com.josemarcellio.woodskins.configuration.ConfigReader;
import com.josemarcellio.woodskins.configuration.Messages;
import com.josemarcellio.woodskins.configuration.Sound;
import com.josemarcellio.woodskins.manager.EffectManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Utils implements UtilsManager {

    public static String getColor(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public void action (Player p, EffectManager em, String en, String prm, String ep) {
        if (p.hasPermission ( "bwws_" + prm )) {
            em.setEffect ( p, ep );
            p.sendMessage ( Utils.getColor( Messages.SELECTED_EFFECT).replaceAll("%effect%", en) );
            p.playSound(p.getLocation(), org.bukkit.Sound.valueOf(Sound.SELECTED_EFFECT), 1f, 1f);
        } else {
            if (WoodSkins.getEconomy().getMoney ( p ) >= ConfigReader.Configs.GUI.getConfig().getInt(ep + ".Price")) {
                WoodSkins.getEconomy().takeMoney ( p, ConfigReader.Configs.GUI.getConfig().getInt(ep + ".Price") );
                p.sendMessage ( Utils.getColor(Messages.PURCHASED_EFFECT).replaceAll("%effect%", en) );
                p.playSound(p.getLocation(), org.bukkit.Sound.valueOf(Sound.PURCHASED_EFFECT), 1f, 1f);
                Bukkit.dispatchCommand ( Bukkit.getConsoleSender (), ConfigReader.Configs.GUI.getConfig().getString(ep + ".Command").replaceAll("%permission%", "bwws_" + prm).replaceAll("%player%", p.getName()) );
            } else {
                p.sendMessage ( Utils.getColor(Messages.LOCKED_EFFECT) );
                p.playSound(p.getLocation(), org.bukkit.Sound.valueOf(Sound.LOCKED_EFFECT), 1f, 1f);
            }
        }
    }
}


