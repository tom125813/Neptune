package com.doontcare.me.menus;

import com.doontcare.me.utils.UtilChat;
import com.doontcare.me.utils.UtilItems;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu {

    private Inventory menu;
    private Inventory bank;
    private Inventory settings;

    public HashMap<MenuType,String> menuTitles = new HashMap<>();
    public List<MenuType> menuTypes = new ArrayList<>();

    public Inventory get(MenuType type) {
        switch(type) {
            case MENU:
                return menu;
            case BANK:
                return bank;
            case SETTINGS:
                return settings;
            default:
                return null;
        }
    }

    public void init() {
        menu = Bukkit.createInventory(null, 45,
                UtilChat.translate(getTitle(MenuType.MENU)));
        menuTypes.add(MenuType.MENU);
        bank = Bukkit.createInventory(null, 45,
                UtilChat.translate(getTitle(MenuType.BANK)));
        menuTypes.add(MenuType.BANK);
        settings = Bukkit.createInventory(null, 27,
                UtilChat.translate(getTitle(MenuType.SETTINGS)));
        menuTypes.add(MenuType.SETTINGS);

        load();
    }

    private void load() {
        menu.setItem(13, UtilItems.build(
                Material.CHEST,
                "&aBank Account",
                "&7View your bank account",
                "",
                "&eClick to view!"));

        bank.setItem(1, UtilItems.build(
                Material.PAPER,"&6£0.00",
                "&7Earn money by completing",
                "&7tasks or by creating farms",
                "",
                "&eLeft Click to Deposit",
                "&eRight Click to Withdraw"
        ));

        settings.setItem(4, UtilItems.build(Material.BARRIER, true, "lol", "lol"));
    }

    private String getTitle(MenuType type) {
        String title = type.getName()+" "+type.getDescription();
        menuTitles.put(type,title);
        return menuTitles.get(type);
    }

}
