package com.doontcare.me.listeners;

import com.doontcare.me.Main;
import com.doontcare.me.profiles.Profile;
import com.doontcare.me.ranks.Rank;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ListenerChatFormat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Profile profile = Main.getInstance().getProfileManager().get(e.getPlayer().getUniqueId());
        Rank rank = profile.getRank();
        e.setFormat(rank.getPrefix()+" "+e.getPlayer().getName() + ": " + rank.getChatColor() + e.getMessage());
    }

}
