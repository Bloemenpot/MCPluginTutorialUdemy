package com.bloemenpot.fireworks;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class Fireworks extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerSneak(PlayerToggleSneakEvent e) {

        if (e.isSneaking()){
            Firework firework = e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), Firework.class);
            FireworkMeta meta = (FireworkMeta) firework.getFireworkMeta();
            meta.addEffect(FireworkEffect.builder().withColor(Color.AQUA).withColor(Color.GREEN).with(Type.CREEPER).withFlicker().build());
            meta.setPower(1);
            firework.setFireworkMeta(meta);
        }
    }

}
