package com.bloemenpot.togling;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.EventListener;

public final class Togling extends JavaPlugin {

    public class TEST{
        ItemStack GalaxyPurpleHelm = new ItemStack(Material.LEATHER_HELMET);
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ToggleListener(), this);


    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        ToggleListener listn = new ToggleListener();
        listn.openMenu();
        Player player = e.getPlayer();
        player.getInventory().setHelmet(TEST.GalaxyPurpleHelm);
    }
}