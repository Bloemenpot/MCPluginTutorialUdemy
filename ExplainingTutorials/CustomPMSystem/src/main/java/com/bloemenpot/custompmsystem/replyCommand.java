package com.bloemenpot.custompmsystem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class replyCommand implements CommandExecutor {

    private CustomPMSystem main;

    public replyCommand(CustomPMSystem main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length >= 1) {
                if (main.getRecentMessages().containsKey(p.getUniqueId())) {
                    UUID uuid = main.getRecentMessages().get(p.getUniqueId());
                    if (Bukkit.getPlayer(uuid) != null) {
                        Player target = Bukkit.getPlayer(uuid);

                        StringBuilder builder = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            builder.append(args[i]).append(" ");
                        }

                        p.sendMessage("You -> " + target.getName() + ": " + builder);
                        target.sendMessage(p.getName() + " -> You: " + builder);

                    } else {
                        p.sendMessage(ChatColor.RED+"Player has gone offline");
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "You haven't messaged anyone yet!");
                }
            } else {
                p.sendMessage(ChatColor.RED + "Invalid Usage");
            }
        }

        return false;
    }
}
