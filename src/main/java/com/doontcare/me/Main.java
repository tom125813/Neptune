package com.doontcare.me;

import com.doontcare.me.commands.menu.CommandMenu;
import com.doontcare.me.commands.menu.TabCompleterMenu;
import com.doontcare.me.menus.Menu;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private Menu menu;
    private CommandMenu commandMenu;

    @Override
    public void onEnable() {
        register();
        registerCommands();
        registerListeners();

        menu.init();
    }

    private void register() {
        menu = new Menu();
        commandMenu = new CommandMenu(this,menu);
    }

    private void registerCommands() {
        getCommand("menu").setExecutor(commandMenu);
        getCommand("menu").setTabCompleter(new TabCompleterMenu());
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(commandMenu,this);
    }

}
