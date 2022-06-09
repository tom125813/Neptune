package com.doontcare.me.managers;

import com.doontcare.me.profiles.Profile;

import java.util.HashMap;
import java.util.UUID;

public class ProfileManager {

    public HashMap<UUID, Profile> activeProfiles = new HashMap<UUID, Profile>();

    public void add(UUID uuid, Profile profile) {activeProfiles.put(uuid,profile);}
    public Profile get(UUID uuid) {return activeProfiles.get(uuid);}
    public void remove(UUID uuid) {activeProfiles.remove(uuid);}

}
