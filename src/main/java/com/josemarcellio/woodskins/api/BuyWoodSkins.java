package com.josemarcellio.woodskins.api;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class BuyWoodSkins extends Event {
    private final Player p;
    private final ItemStack item;
    public static final HandlerList handlers = new HandlerList();

    public BuyWoodSkins(Player player, ItemStack itemstack) {
        this.p = player;
        this.item = itemstack;
    }

    public Player getOwner() {
        return this.p;
    }

    public ItemStack getWood() {
        return this.item;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
