package com.josemarcellio.woodskins;

import com.josemarcellio.woodskins.api.API;
import com.josemarcellio.woodskins.api.WoodSkinsAPI;
import com.josemarcellio.woodskins.command.Command;
import com.josemarcellio.woodskins.command.CommandManager;
import com.josemarcellio.woodskins.configuration.*;
import com.josemarcellio.woodskins.economy.Economy;
import com.josemarcellio.woodskins.economy.Vault;
import com.josemarcellio.woodskins.inventory.InventoryListener;
import com.josemarcellio.woodskins.listeners.InGameListener;
import com.josemarcellio.woodskins.listeners.PluginListener;
import com.josemarcellio.woodskins.manager.EffectManager;
import com.josemarcellio.woodskins.metrics.Metrics;
import com.josemarcellio.woodskins.utils.Utils;
import com.josemarcellio.woodskins.utils.UtilsManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Arrays;

public class WoodSkins extends JavaPlugin {

    private static WoodSkinsAPI api;

    public static WoodSkinsAPI getAPI() {
        return api;
    }

    private static UtilsManager utils;

    public static UtilsManager getUtils() {
        return utils;
    }

    private EffectManager effectManager;

    public EffectManager getEffectManager() {
        return effectManager;
    }

    private static Economy economy;

    public static Economy getEconomy() {
        return economy;
    }

    private final Messages messages = new Messages ( this );

    private final GUI gui = new GUI ( this );

    private final PlayerData playerdata = new PlayerData ( this );

    private final Sound sound = new Sound ( this );

    CommandManager register = new CommandManager (this);

    public void register(Listener... listeners) {
        Arrays.stream ( listeners ).forEach ( listener -> this.getServer ().getPluginManager ().registerEvents ( listener, this ) );
    }

    public void onLoad() {
        api = new API ();
        utils = new Utils ();
    }

    @Override
    public void onEnable() {
        if (!Bukkit.getPluginManager().isPluginEnabled("BedWars1058")) {
            getLogger().severe("BedWars1058 not found!");
            setEnabled(false);
            return;
        }

        new Metrics (this, 12864);

        register ( new PluginListener (),
                new InGameListener ( this ),
                new InventoryListener () );

        saveDefaultConfig ();
        new ConfigReader ( this );
        effectManager = new EffectManager ( this );

        RegisteredServiceProvider rsp = this.getServer ().getServicesManager ().getRegistration ( net.milkbowl.vault.economy.Economy.class );
        Vault.registerEconomy ( (net.milkbowl.vault.economy.Economy) rsp.getProvider () );
        economy = new Vault ();

        gui.load ();
        messages.load ();
        playerdata.load ();
        sound.load ();

        register.command(new Command (this));

        getLogger ().info ( "-------------------------------------------" );
        getLogger ().info ( "" );
        getLogger ().info ( "   BedWars1058-WoodSkins by JoseMarcellio" );
        getLogger ().info ( "" );
        getLogger ().info ( "-------------------------------------------" );
    }

    @Override
    public void onDisable() {
        getLogger ().info ( "Disabling BedWars-WoodSkins" );
        effectManager.saveEffects ();
    }
}


