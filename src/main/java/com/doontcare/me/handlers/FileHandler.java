package com.doontcare.me.handlers;

import com.doontcare.me.Main;
import com.doontcare.me.profiles.Profile;
import com.doontcare.me.utils.UtilFiles;

import java.util.UUID;

public class FileHandler {

    private Main main;
    public FileHandler(Main main) {
        this.main=main;
    }

    public void startup() {
        if (!main.getDataFolder().exists()) main.getDataFolder().mkdir();
        // Won't use a 2D array because it's stupid
        // String[][] files = {{"profiles"},{"json"}};

        if (UtilFiles.exists("profiles","json")) return;

        // will make a json file for each player profile
        UUID playerUUID = UUID.randomUUID();
        Profile profile = new Profile(playerUUID, 12, 2868.17);
        UtilFiles.writeJson(UtilFiles.initFile(String.valueOf(playerUUID),"json"),profile,true);
    }

}
