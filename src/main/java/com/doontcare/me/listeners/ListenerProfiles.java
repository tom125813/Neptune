package com.doontcare.me.listeners;

import com.doontcare.me.Main;
import com.doontcare.me.managers.ProfileManager;
import com.doontcare.me.utils.UtilProfiles;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class ListenerProfiles implements Listener {

    private Main main;
    public ListenerProfiles(Main main) {
        this.main=main;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onJoin(PlayerJoinEvent e) {
        UUID uuid = e.getPlayer().getUniqueId();
        UtilProfiles.initProfile(main.getProfileManager(), uuid);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        UUID uuid = e.getPlayer().getUniqueId();
        UtilProfiles.saveProfile(main.getProfileManager(), uuid);
    }
}
