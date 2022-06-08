package com.doontcare.me.utils;

import org.bukkit.ChatColor;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

public class UtilChat {

    public static String translate(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
