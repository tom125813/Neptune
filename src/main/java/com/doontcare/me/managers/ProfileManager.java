package com.doontcare.me.managers;

import com.doontcare.me.profiles.Profile;

import java.util.HashMap;
import java.util.UUID;

public class ProfileManager {

    public HashMap<UUID, Profile> activeProfiles = new HashMap<UUID, Profile>();

    // did for the funny
    /*public Profile getProfileFromUUID(UUID uuid) {
        if (activeProfiles.get(uuid)==null) return null;
        return activeProfiles.get(uuid);
    }*/

}
