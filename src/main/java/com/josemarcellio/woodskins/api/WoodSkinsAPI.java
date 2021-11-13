package com.josemarcellio.woodskins.api;

import org.bukkit.Material;

public interface WoodSkinsAPI {
    void setPickUpWoodSkins(PickUpWoodSkins e, Material m, Short d);
    void setBuyWoodSkins(BuyWoodSkins e, Material m, Short d);
}
