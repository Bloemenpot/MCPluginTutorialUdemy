package com.bloemenpot.worlds;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Worlds extends JavaPlugin {

    @Override
    public void onEnable() {
        Player player = null;
        player.getWorld().setTime(6000);
    }
}
