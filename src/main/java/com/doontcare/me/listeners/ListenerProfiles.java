package com.doontcare.me.listeners;

import com.doontcare.me.Main;
import com.doontcare.me.managers.ProfileManager;
import com.doontcare.me.profiles.Profile;
import com.doontcare.me.utils.UtilFiles;
import com.google.gson.Gson;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.UUID;

public class ListenerProfiles implements Listener {

    private Main main;
    public ListenerProfiles(Main main) {
        this.main=main;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onJoin(PlayerJoinEvent e) {
        UUID uuid = e.getPlayer().getUniqueId();
        ProfileManager pm = main.getProfileManager();

        if (UtilFiles.getFile(uuid.toString(), "json")!=null) {
            try {
                Gson gson = new Gson();
                Reader reader = new FileReader(UtilFiles.getFile(uuid.toString(), "json"));
                Profile output = gson.fromJson(reader, Profile.class);
                pm.add(uuid,output);
                return;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        // Forced to put new Date() here, but as long as everything runs correctly it will not cause a timing issue.
        Profile newProfile = new Profile(uuid,1,0,new Date());
        pm.add(uuid, newProfile);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        UUID uuid = e.getPlayer().getUniqueId();

        ProfileManager pm = main.getProfileManager();
        Profile profile = pm.get(uuid);
        profile.setLastLogin(new Date());

        File file = UtilFiles.getFile(uuid.toString(), "json");
        if (file!=null) {
            UtilFiles.writeJson(file, profile, false);
        } else if (file==null) {
            UtilFiles.writeJson(UtilFiles.initFile(uuid.toString(), "json"), profile, false);
        }

        pm.remove(profile.getUUID());
    }
}
