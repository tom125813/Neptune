package com.doontcare.me;

import com.doontcare.me.commands.menu.CommandMenu;
import com.doontcare.me.commands.menu.TabCompleterMenu;
import com.doontcare.me.handlers.CustomRecipeHandler;
import com.doontcare.me.handlers.FileHandler;
import com.doontcare.me.listeners.ListenerJoinMessages;
import com.doontcare.me.listeners.ListenerProfiles;
import com.doontcare.me.managers.ProfileManager;
import com.doontcare.me.menus.Menu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    private static Main instance;

    private final Logger logger = Logger.getLogger("funni");

    private transient FileHandler fileHandler;

    private transient ProfileManager profileManager;
    private transient ListenerProfiles listenerProfiles;


    private transient ListenerJoinMessages listenerJoinMessages;

    private transient Menu menu;
    private transient CommandMenu commandMenu;

    private CustomRecipeHandler customRecipes;

    // TODO: Add a ranks system
    // TODO: Add custom crafting w/ custom items which have custom abilities.

    @Override
    public void onEnable() {
        instance=this;

        register();
        registerCommands();
        registerListeners();

        fileHandler.startup();
        customRecipes.register();
        menu.init();

        if (Bukkit.getOnlinePlayers().stream().count()>0) {
            // load all online players' profiles into profile manager.
        }
    }

    @Override
    public void onDisable() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            // save stats to file
        }
    }

    private void register() {
        fileHandler = new FileHandler(this);

        profileManager = new ProfileManager();
        listenerProfiles = new ListenerProfiles(this);

        listenerJoinMessages = new ListenerJoinMessages(this);

        customRecipes = new CustomRecipeHandler(this);

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
        pm.registerEvents(listenerProfiles,this);
        pm.registerEvents(listenerJoinMessages,this);
    }

    public static Main getInstance() {return instance;}
    public ProfileManager getProfileManager() {return profileManager;}

}
