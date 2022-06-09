package com.doontcare.me.ranks;

import com.doontcare.me.utils.UtilChat;
import org.bukkit.ChatColor;

import java.util.List;

public enum Rank {

    // TODO: Add permissions on startup

    ADMIN(UtilChat.translate("&c[Admin]&r"), ChatColor.RED, null),
    MEMBER(UtilChat.translate("&7[Member]&r"), ChatColor.ITALIC, null);

    private String prefix;
    private ChatColor chatColor;
    private List<String> permissions;

    Rank(String prefix, ChatColor chatColor, List<String> permissions) {
        this.prefix=prefix;
        this.chatColor=chatColor;
        this.permissions=permissions;
    }

    public String getPrefix() {return prefix;}
    public ChatColor getChatColor() {return chatColor;}
    public List<String> getPermissions() {return permissions;}
    
}
