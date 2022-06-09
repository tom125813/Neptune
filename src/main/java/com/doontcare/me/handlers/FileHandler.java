package com.doontcare.me.handlers;

import com.doontcare.me.Main;
import com.doontcare.me.profiles.Profile;
import com.doontcare.me.utils.UtilFiles;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class FileHandler {

    private Main main;
    public FileHandler(Main main) {
        this.main=main;
    }

    public void startup() {
        if (!main.getDataFolder().exists()) main.getDataFolder().mkdir();
    }

}
