package com.josemarcellio.woodskins.effect;

import com.josemarcellio.woodskins.WoodSkins;
import com.josemarcellio.woodskins.api.BuyWoodSkins;
import com.josemarcellio.woodskins.api.PickUpWoodSkins;
import org.bukkit.Material;

public class AcaciaPlank extends PlayEffect {

    public AcaciaPlank() {
        super ( "AcaciaPlank");
    }

    @Override
    public void buywoodskins(BuyWoodSkins e) {
        WoodSkins.getAPI().setBuyWoodSkins (e, Material.WOOD, (short)4);
    }

    @Override
    public void pickupwoodskins(PickUpWoodSkins e) {
        WoodSkins.getAPI().setPickUpWoodSkins(e, Material.WOOD, (short)4);
    }

}
