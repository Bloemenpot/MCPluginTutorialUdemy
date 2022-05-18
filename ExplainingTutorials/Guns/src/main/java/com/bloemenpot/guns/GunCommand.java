package com.bloemenpot.guns;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GunCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return false;
        }

        Player p = (Player) sender;

        ArrayList<String> lore = new ArrayList<String>();
        lore.add("Officieel Bloemenpot Item");

        if (!(args.length == 1)) {
            p.sendMessage("Incorrect Usage!");
            return false;
        }

        if (args[0].equalsIgnoreCase("pearl")) {
            ItemStack pearlGun = new ItemStack(Material.DIAMOND_HOE);
            ItemMeta pearlGunMeta = pearlGun.getItemMeta();
            pearlGunMeta.setDisplayName(ChatColor.DARK_PURPLE+"EnderPearl "+ChatColor.AQUA+"Gun");
            pearlGunMeta.setLore(lore);
            pearlGunMeta.setUnbreakable(true);
            pearlGunMeta.addEnchant(Enchantment.DURABILITY,0,true);
            pearlGunMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES,ItemFlag.HIDE_UNBREAKABLE,ItemFlag.HIDE_ENCHANTS);

            pearlGun.setItemMeta(pearlGunMeta);

            p.getInventory().setItem(p.getInventory().firstEmpty(),pearlGun);
        }
        if (args[0].equalsIgnoreCase("egg")) {

        }

        return false;
    }
}
