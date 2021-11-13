package com.josemarcellio.woodskins.effect;

import com.josemarcellio.woodskins.WoodSkins;
import com.josemarcellio.woodskins.api.BuyWoodSkins;
import com.josemarcellio.woodskins.api.PickUpWoodSkins;
import org.bukkit.Material;

public class BirchLog extends PlayEffect {

    public BirchLog() {
        super ( "BirchLog");
    }

    @Override
    public void buywoodskins(BuyWoodSkins e) {
        WoodSkins.getAPI().setBuyWoodSkins (e, Material.LOG, (short)2);
    }

    @Override
    public void pickupwoodskins(PickUpWoodSkins e) {
        WoodSkins.getAPI().setPickUpWoodSkins(e, Material.LOG, (short)2);
    }

}
