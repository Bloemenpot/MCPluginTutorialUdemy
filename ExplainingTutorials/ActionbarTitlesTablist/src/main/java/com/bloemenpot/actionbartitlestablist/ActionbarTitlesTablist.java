package com.bloemenpot.actionbartitlestablist;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ActionbarTitlesTablist extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this,this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        //Title
        e.getPlayer().sendTitle(
                ChatColor.RED + "Hallo",
                ChatColor.GREEN + "Welkom op de server!",
                20,
                100,
                20);

        //ActionBar (Tekst boven je hotbar)
        e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§4§lHALLO VRIEND MAN BRO"));

        //Tablist Header/Footer
        e.getPlayer().setPlayerListHeaderFooter(ChatColor.RED + "Hallo!", ChatColor.AQUA + "First Line\n" + ChatColor.DARK_AQUA + "Second Line");


    }

}
