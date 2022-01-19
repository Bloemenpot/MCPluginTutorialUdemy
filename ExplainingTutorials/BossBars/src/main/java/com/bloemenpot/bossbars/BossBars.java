package com.bloemenpot.bossbars;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class BossBars extends JavaPlugin implements Listener {

    private BossBar bossBar;

    @Override
    public void onEnable() {
        bossBar = Bukkit.createBossBar(
                ChatColor.LIGHT_PURPLE + "Gooi een ei!",
                BarColor.BLUE,
                BarStyle.SEGMENTED_6);

        Bukkit.getPluginManager().registerEvents(this,this);
    }

    @EventHandler
    public void OnJoin(PlayerJoinEvent e) {
        bossBar.addPlayer(e.getPlayer());
    }

    @EventHandler
    public void EggThrow(PlayerEggThrowEvent e) {
        bossBar.removePlayer(e.getPlayer());

    }

}
