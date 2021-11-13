package com.josemarcellio.woodskins.effect;

import com.josemarcellio.woodskins.WoodSkins;
import com.josemarcellio.woodskins.api.BuyWoodSkins;
import com.josemarcellio.woodskins.api.PickUpWoodSkins;
import org.bukkit.Material;

public class SprucePlank extends PlayEffect {

    public SprucePlank() {
        super ( "SprucePlank");
    }

    @Override
    public void buywoodskins(BuyWoodSkins e) {
        WoodSkins.getAPI().setBuyWoodSkins (e, Material.WOOD, (short)1);
    }

    @Override
    public void pickupwoodskins(PickUpWoodSkins e) {
        WoodSkins.getAPI().setPickUpWoodSkins(e, Material.WOOD, (short)1);
    }

}
