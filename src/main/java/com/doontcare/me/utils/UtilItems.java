package com.doontcare.me.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class UtilItems {

    public static ItemStack build(Material material, String name, String... lore) {
        ItemStack i = new ItemStack(material);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName(ChatColor.translateAlternateColorCodes('&',name));
        List<String> loreList = new ArrayList<>();
        for (String s : lore)
            loreList.add(ChatColor.translateAlternateColorCodes('&',s));
        m.setLore(loreList);
        i.setItemMeta(m);
        return i;
    }

    public static ItemStack build(Material material, boolean fakeEnchant, String name, String... lore) {
        ItemStack i = new ItemStack(material);
        ItemMeta m = i.getItemMeta();
        if (fakeEnchant) {
            m.addEnchant(Enchantment.DURABILITY, 1, true);
            m.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        m.setDisplayName(ChatColor.translateAlternateColorCodes('&',name));
        List<String> loreList = new ArrayList<>();
        for (String s : lore)
            loreList.add(ChatColor.translateAlternateColorCodes('&',s));
        m.setLore(loreList);
        i.setItemMeta(m);
        return i;
    }
}
