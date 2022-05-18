package com.bloemenpot.togling;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ToggleListener implements Listener {

    private List<UUID> enabled = new ArrayList<>();

    ItemStack GalaxyPurpleHelm = new ItemStack(Material.LEATHER_HELMET);

    public void openMenu(){

        LeatherArmorMeta GalaxyPurpleHelmMeta = (LeatherArmorMeta)GalaxyPurpleHelm.getItemMeta();
        GalaxyPurpleHelmMeta.setColor(Color.fromRGB(48, 0, 119));
        GalaxyPurpleHelmMeta.setDisplayName(ChatColor.GOLD+"Galaxy Purple Helm");
        GalaxyPurpleHelm.setItemMeta(GalaxyPurpleHelmMeta);
    }

    @EventHandler
        public void OnPlayerInteract(PlayerInteractEvent e) {

//        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) ;

            Player player = e.getPlayer();

        if (e.getHand().equals(EquipmentSlot.HAND)){
            if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getType().equals(Material.NETHER_STAR)){
                if (enabled.contains(player.getUniqueId())){
                    enabled.remove(player.getUniqueId());
                    player.sendMessage("Chat has been enabled!");
                } else {
                    enabled.add(player.getUniqueId());
                    player.sendMessage("Chat has been disabled!");
                }

            }
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        if (enabled.contains(e.getPlayer().getUniqueId())){
            e.setCancelled(true);
            e.getPlayer().sendMessage("You have typing disabled!");
        }
    }

}