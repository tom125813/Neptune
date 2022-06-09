package com.doontcare.me.listeners;

import com.doontcare.me.Main;
import com.doontcare.me.profiles.Profile;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.text.DecimalFormat;

public class ListenerJoinMessages implements Listener {

    private Main main;
    public ListenerJoinMessages(Main main) {
        this.main=main;
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        Profile profile = main.getProfileManager().get(player.getUniqueId());

        int level = profile.getLevel();
        String balance = new DecimalFormat("0.00").format(profile.getBalance());

        player.sendMessage("");
        player.sendMessage("Welcome back ["+level+"] " + player.getName()+"!");
        player.sendMessage("You have $" + balance + " stored in your bank");
        player.sendMessage("");
    }

}
