package com.doontcare.me.listeners;

import com.doontcare.me.utils.UtilChat;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ListenerCrafting implements Listener {

    private Cache<UUID,Long> cooldown = CacheBuilder
            .newBuilder()
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .build();

    @EventHandler
    public void onCraft(CraftItemEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (!cooldown.asMap().containsKey(player.getUniqueId())) {
            cooldown.asMap().put(player.getUniqueId(),System.currentTimeMillis()*5000);
            return;
        }
        e.setCancelled(true);
        player.sendMessage(UtilChat.translate("&c&lWARNING &7You cannot craft things that quickly!"));
    }
}
