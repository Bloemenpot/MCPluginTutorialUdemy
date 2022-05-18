package com.bloemenpot.guns;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Objects;

public final class Guns extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getCommand("gun").setExecutor(new GunCommand());
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {


        if (e.hasItem()) {
            Player p = e.getPlayer();
            ItemStack heldItem = p.getInventory().getItemInMainHand();

            if (!(heldItem.getItemMeta().hasLore())) {
                List<String> loreInHeldItem = heldItem.getItemMeta().getLore();
                for (String loreLine : loreInHeldItem) {
                    if (!(loreLine.contains("Officieel Bloemenpot Item"))) {
                        return;

                    }
                }
            }

            if (e.getItem().getType().equals(Material.DIAMOND_HOE)) {

                EnderPearlLauncher(p);

            } else if (e.getItem().getType().equals(Material.IRON_HOE)) {

                EggLauncher(p);

            }
        }
    }

    public void EnderPearlLauncher(Player p) {
        p.launchProjectile(EnderPearl.class);
        p.sendMessage("Shot the Pearl Launcher!");
    }

    private void EggLauncher(Player p) {
        p.launchProjectile(Egg.class);
        p.sendMessage("Shot the Egg Launcher!");
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {

        if (Objects.requireNonNull(e.getHitEntity()).getType().equals(EntityType.PLAYER)) {

            Player hitPlayer = (Player) e.getHitEntity();

            if (e.getEntity().getType().equals(EntityType.ENDER_PEARL)) {
                hitPlayer.sendMessage("You have been hit with an enderpearl!");
            }
            if (e.getEntity().getType().equals(EntityType.EGG)) {
                hitPlayer.sendMessage("You have been hit with an egg!");
            }
        } else {
            return;
        }
    }
}
