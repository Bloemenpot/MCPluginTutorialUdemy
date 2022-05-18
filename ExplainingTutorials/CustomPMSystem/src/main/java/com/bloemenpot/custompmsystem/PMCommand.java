package com.bloemenpot.custompmsystem;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PMCommand implements CommandExecutor {

    private CustomPMSystem main;

    public PMCommand(CustomPMSystem main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            if (args.length == 2){

                if (Bukkit.getPlayerExact(args[0]) != null) {
                    Player target = Bukkit.getPlayerExact(args[0]);

                    StringBuilder builder = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        builder.append(args[i]).append(" ");
                    }

                    p.sendMessage("You -> " + target.getName() + ": " + builder);
                    target.sendMessage(p.getName() + " -> You: " + builder);

                    main.getRecentMessages().put(p.getUniqueId(), target.getUniqueId());

                } else {
                    p.sendMessage("Player not found!");
                }

            } else {
                p.sendMessage("Invalid usage!");
            }

        }

        return false;
    }
}
