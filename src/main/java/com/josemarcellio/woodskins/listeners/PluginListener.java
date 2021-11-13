package com.josemarcellio.woodskins.listeners;

import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.arena.Arena;
import com.josemarcellio.woodskins.api.BuyWoodSkins;
import com.josemarcellio.woodskins.api.PickUpWoodSkins;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class PluginListener implements Listener {

    @EventHandler
    public void pickup(PlayerPickupItemEvent e) {
        Player p = e.getPlayer ();
        ItemStack item = e.getItem ().getItemStack ();
        IArena a = Arena.getArenaByPlayer ( p );
        if (a == null) return;
        if (item == null || item.getType () == Material.AIR) return;
        if (item.getType () == Material.WOOD
                || item.getType () == Material.LOG
                || item.getType () == Material.LOG_2) {
            Bukkit.getPluginManager ().callEvent ( new PickUpWoodSkins ( p, item ) );
        }
    }

    @EventHandler
    public void inventoryclick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked ();
        IArena a = Arena.getArenaByPlayer ( p );
        if (a == null) return;
        if (e.getInventory ().getType () != InventoryType.CHEST) return;
        if (e.getClickedInventory ().contains ( Material.WOOD )
                || e.getClickedInventory ().contains ( Material.LOG )
                || e.getClickedInventory ().contains ( Material.LOG_2 )) {
            for (ItemStack item : p.getInventory ().getContents ()) {
                if (item == null || item.getType () == Material.AIR) return;
                if (item.getType () == Material.WOOD
                        || item.getType () == Material.LOG
                        || item.getType () == Material.LOG_2) {
                    Bukkit.getPluginManager ().callEvent ( new BuyWoodSkins ( p, item ) );
                }
            }
        }
    }
}