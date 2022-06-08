package com.doontcare.me.commands.menu;

import com.doontcare.me.Main;
import com.doontcare.me.menus.Menu;
import com.doontcare.me.menus.MenuType;
import com.doontcare.me.utils.UtilChat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class CommandMenu implements CommandExecutor, Listener {

    private final Main main;
    private Menu menu;

    public CommandMenu(Main main, Menu menu) {
        this.main = main;
        this.menu = menu;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.openInventory(menu.get(MenuType.MENU));
        }
        return false;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player)e.getWhoClicked();

        MenuType invType=null;
        boolean correctInv = false;
        for (int i =0; i < menu.menuTypes.size();i++) {
            MenuType type = menu.menuTypes.get(i);
            String title = UtilChat.translate(menu.menuTitles.get(type));
            if (e.getView().getTitle().equals(title)) {
                correctInv=true;
                invType=type;
                break;
            }
        }

        if (correctInv && e.getCurrentItem()!=null) {
            e.setCancelled(true);
            switch(invType) {
                case MENU:
                    switch(e.getRawSlot()) {
                        case 13:
                            player.openInventory(menu.get(MenuType.BANK));
                            break;
                        default:break;
                    }
                    break;
                case BANK:
                    switch(e.getRawSlot()) {
                        case 1:
                            player.openInventory(menu.get(MenuType.SETTINGS));
                            break;
                        default:break;
                    }
                    break;
                case SETTINGS:
                    switch(e.getRawSlot()) {
                        case 0:
                            player.closeInventory();
                            break;
                        default:break;
                    }
                    break;
                default: break;
            }

        }
    }
}
