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


    // TODO: Iterate through all menu types instead of referencing each one so many fucking times

    public Inventory get(MenuType type) {
        switch(type) {
            case MENU: return menu;
            case BANK: return bank;
            case SETTINGS: return settings;
            default: return null;
        }
    }

    public void init() {
        init(MenuType.MENU, 45);
        init(MenuType.BANK, 45);
        init(MenuType.SETTINGS, 45);

        load();
    }

    private void init(MenuType menuType, int size) {
        Inventory inv = Bukkit.createInventory(null,size,UtilChat.translate(getTitle(menuType)));
        switch(menuType){
            case MENU: menu=inv; break;
            case BANK: bank=inv; break;
            case SETTINGS: settings=inv; break;
        }
        menuTypes.add(menuType);
    }

    private void load() {
        loadMenu();
        loadBank();
        loadSettings();
    }

    private void loadMenu() {
        menu.setItem(13, UtilItems.build(
                Material.CHEST,
                "&aBank Account",
                "&7View your bank account",
                "",
                "&eClick to view!"));
    }
    private void loadBank() {
        bank.setItem(1, UtilItems.build(
                Material.PAPER,"&6£0.00",
                "&7Earn money by completing",
                "&7tasks or by creating farms",
                "",
                "&eLeft Click to Deposit",
                "&eRight Click to Withdraw"
        ));
    }
    private void loadSettings() {
        settings.setItem(4, UtilItems.build(Material.BARRIER, true, "lol", "lol"));
    }

    private String getTitle(MenuType type) {
        String title = type.getName()+" "+type.getDescription();
        menuTitles.put(type,title);
        return menuTitles.get(type);
    }

}
