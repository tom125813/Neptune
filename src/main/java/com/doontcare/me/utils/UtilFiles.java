package com.doontcare.me.utils;

import com.doontcare.me.Main;
import com.google.gson.Gson;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.nio.file.Path;

public class UtilFiles {

    private static final File dataFolder = Main.getInstance().getDataFolder();

    // JSON

    /* READING DATA FROM JSON (example):
     * Gson gson = new Gson();
     * Reader reader = new FileReader(UtilFiles.initFile("profiles","json"))
     * Profile output = gson.fromJson(reader, Profile.class);
     */

    //                                                  append: (false = overwrite)
    //                                                          (true = add to end of file)
    public static void writeJson(String fileName, Object data, boolean append) {
        try {
            Gson gson = new Gson();
            Writer writer = new FileWriter(new File(dataFolder, fileName + ".json"), append);
            gson.toJson(data, writer);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void writeJson(File file, Object data, boolean append) {
        try {
            Gson gson = new Gson();
            Writer writer = new FileWriter(file, append);
            gson.toJson(data, writer);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // YAML

    public static YamlConfiguration getYaml(String fileName) {
        File file = new File(dataFolder, fileName+".yml");
        if (!file.exists()) return null;
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        return config;
    }


    // ..

    public static File initFile(String fileName, String fileEnding) {
        File file = new File(dataFolder, fileName+"."+fileEnding);
        if (!file.exists()) {
            try {
                file.createNewFile();
                return file;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return file;
    }

    public static File getFile(String fileName, String fileEnding) {
        File file = new File(dataFolder, fileName+"."+fileEnding);
        if (file.exists()) {
            return file;
        }
        return null;
    }

}
