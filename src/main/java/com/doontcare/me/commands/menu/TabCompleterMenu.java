package com.doontcare.me.commands.menu;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabCompleterMenu implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        /*if (args.length == 1) {
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("open","close"), new ArrayList<>());
        } else if (args.length == 2) {
            List<String> names = new ArrayList<>();
            for (Player player : Bukkit.getOnlinePlayers())
                names.add(player.getName());
            return StringUtil.copyPartialMatches(args[1], names, new ArrayList<>());
        }*/
        return new ArrayList<>();
    }
}
