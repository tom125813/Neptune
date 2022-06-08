package com.doontcare.me;

import com.doontcare.me.commands.menu.CommandMenu;
import com.doontcare.me.commands.menu.TabCompleterMenu;
import com.doontcare.me.handlers.FileHandler;
import com.doontcare.me.menus.Menu;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    // some stuff will be shitty but its because of testing or not finished

    // Is this bad?
    private static Main instance;

    private final Logger logger = Logger.getLogger("funni");

    private transient FileHandler fileHandler;

    private transient Menu menu;
    private transient CommandMenu commandMenu;

    @Override
    public void onEnable() {
        instance=this;

        register();
        registerCommands();
        registerListeners();

        fileHandler.startup();
        menu.init();
    }

    private void register() {
        fileHandler=new FileHandler(this);

        menu = new Menu();
        commandMenu = new CommandMenu(this,menu);
    }

    private void registerCommands() {
        getCommand("menu").setExecutor(commandMenu);
        getCommand("menu").setTabCompleter(new TabCompleterMenu());
    }

    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(commandMenu,this);
    }

    public static Main getInstance() {return instance;}

}
