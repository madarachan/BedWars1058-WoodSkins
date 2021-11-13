package com.josemarcellio.woodskins.effect;

import com.josemarcellio.woodskins.api.BuyWoodSkins;
import com.josemarcellio.woodskins.api.PickUpWoodSkins;

public abstract class PlayEffect {

    protected String e;
    protected String effect;

    public PlayEffect(String effect) {
        this.effect = effect;
    }

    public String getEffect() {
        return effect;
    }

    public abstract void buywoodskins(BuyWoodSkins e);

    public abstract void pickupwoodskins(PickUpWoodSkins e);

}
