package com.josemarcellio.woodskins.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.josemarcellio.woodskins.WoodSkins;
import com.josemarcellio.woodskins.configuration.ConfigReader;
import com.josemarcellio.woodskins.effect.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class EffectManager {

    private final List<PlayEffect> playEffect;
    private HashMap<String, PlayEffect> playEffectMap;
    private final WoodSkins plugin;

    public EffectManager(WoodSkins plugin) {
        playEffect = new ArrayList<>();
        registerEffect(new OakPlank ());
        registerEffect(new SprucePlank ());
        registerEffect(new BirchPlank ());
        registerEffect(new JunglePlank ());
        registerEffect(new AcaciaPlank ());
        registerEffect(new DarkOakPlank ());
        registerEffect(new OakLog ());
        registerEffect(new SpruceLog ());
        registerEffect(new BirchLog ());
        registerEffect(new JungleLog ());
        registerEffect(new AcaciaLog ());
        registerEffect(new DarkOakLog ());
        this.plugin = plugin;
        loadEffects();
    }

    public void loadEffects() {
        playEffectMap = new HashMap<>();
        FileConfiguration playerdata = ConfigReader.Configs.PLAYERDATA.getConfig();
        for (String uuid : playerdata.getKeys(false)) {
            String effect = playerdata.getString(uuid + ".selected");
            playEffectMap.put(uuid, getEffects(effect));
        }
    }

    public void saveEffects() {
        FileConfiguration playerdata = ConfigReader.Configs.PLAYERDATA.getConfig();
        for (String uuid : playEffectMap.keySet()) {
            playerdata.set(uuid + ".selected", playEffectMap.get(uuid).getEffect());
        }
        try {
            playerdata.save(plugin.getDataFolder () + "/playerdata.yml");
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public void registerEffect(PlayEffect effectManager) {
        playEffect.add(effectManager);
    }

    public PlayEffect getEffects(String effect) {
        for (PlayEffect effectManager : playEffect) {
            if (effectManager.getEffect().equalsIgnoreCase(effect)) {
                return effectManager;
            }
        }
        return null;
    }

    public PlayEffect getEffect(Player p) {
        String uuid = p.getUniqueId().toString();
        if (playEffectMap.containsKey(uuid)) {
            return playEffectMap.get(uuid);
        }
        return null;
    }

    public void setEffect(Player p, String effect) {
        String uuid = p.getUniqueId().toString();
        playEffectMap.remove(uuid);
        PlayEffect playeffect = getEffects(effect);
        if (playeffect != null) {
            playEffectMap.put(uuid, playeffect);
        }
    }
}
