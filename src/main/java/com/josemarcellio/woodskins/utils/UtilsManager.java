package com.josemarcellio.woodskins.utils;

import com.josemarcellio.woodskins.manager.EffectManager;
import org.bukkit.entity.Player;

public interface UtilsManager {
    void action(Player p, EffectManager em, String effectname, String permission, String effect);
}
