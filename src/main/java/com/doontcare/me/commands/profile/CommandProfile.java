package com.doontcare.me.commands.profile;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandProfile implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("funni.profile")) {
                player.sendMessage(ChatColor.GREEN+"Has permission");
                return false;
            }
            player.sendMessage(ChatColor.RED+"No permission");
        }
        return false;
    }
}
