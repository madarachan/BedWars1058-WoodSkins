package com.josemarcellio.woodskins.api;

import org.bukkit.Material;

public class API implements WoodSkinsAPI {

    @Override
    public void setPickUpWoodSkins (PickUpWoodSkins e, Material m, Short d) {
        e.getWood().setType(m);
        e.getWood().setDurability( d );
    }

    @Override
    public void setBuyWoodSkins (BuyWoodSkins e, Material m, Short d) {
        e.getWood().setType(m);
        e.getWood().setDurability( d );
    }
}
