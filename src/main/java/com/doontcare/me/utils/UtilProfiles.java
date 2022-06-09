package com.doontcare.me.utils;

import com.doontcare.me.managers.ProfileManager;
import com.doontcare.me.profiles.Profile;
import com.google.gson.Gson;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.UUID;

public class UtilProfiles {

    public static void initProfile(ProfileManager profileManager, UUID uuid) {
        if (UtilFiles.getFile(uuid.toString(), "json")!=null) {
            try {
                Gson gson = new Gson();
                Reader reader = new FileReader(UtilFiles.getFile(uuid.toString(), "json"));
                Profile output = gson.fromJson(reader, Profile.class);
                profileManager.add(uuid,output);
                return;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        // Forced to put new Date() here, but as long as everything runs correctly it will not cause a timing issue.
        Profile newProfile = new Profile(uuid,1,0,new Date());
        profileManager.add(uuid, newProfile);
    }

    public static void saveProfile(ProfileManager profileManager, UUID uuid) {
        Profile profile = profileManager.get(uuid);
        profile.setLastLogin(new Date());

        File file = UtilFiles.getFile(uuid.toString(), "json");
        if (file!=null) {
            UtilFiles.writeJson(file, profile, false);
        } else if (file==null) {
            UtilFiles.writeJson(UtilFiles.initFile(uuid.toString(), "json"), profile, false);
        }

        profileManager.remove(profile.getUUID());
    }

}
