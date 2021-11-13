package com.josemarcellio.woodskins.listeners;

import com.josemarcellio.woodskins.WoodSkins;
import com.josemarcellio.woodskins.api.BuyWoodSkins;
import com.josemarcellio.woodskins.api.PickUpWoodSkins;
import com.josemarcellio.woodskins.effect.PlayEffect;
import com.josemarcellio.woodskins.manager.EffectManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class InGameListener implements Listener {

    private final WoodSkins plugin;

    public InGameListener(WoodSkins plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void pickupwoodskins(PickUpWoodSkins e) {
        EffectManager effectManager = plugin.getEffectManager ();
        Player p = e.getOwner();
        PlayEffect play = effectManager.getEffect ( p );
        if (play != null) {
            play.pickupwoodskins (e);
        }
    }

    @EventHandler
    public void buywoodskins(BuyWoodSkins e) {
        EffectManager effectManager = plugin.getEffectManager ();
        Player p = e.getOwner();
        PlayEffect play = effectManager.getEffect ( p );
        if (play != null) {
            play.buywoodskins (e);
        }
    }
}
