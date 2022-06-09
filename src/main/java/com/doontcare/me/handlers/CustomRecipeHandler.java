package com.doontcare.me.handlers;

import com.doontcare.me.Main;
import com.doontcare.me.recipes.CustomRecipe;
import com.doontcare.me.utils.UtilItems;
import org.bukkit.Material;

import java.util.HashMap;

public class CustomRecipeHandler {

    public Main main;
    public CustomRecipeHandler(Main main) {
        this.main = main;
    }

    public void register() {
        new CustomRecipe("lightning_stick", UtilItems.build(
                Material.STICK,
                true,
                "&aLightning Stick",
                "&7Used to cast lightning on",
                "&7your desired location...",
                "",
                "&eRight Click to Use"),
                new String[]{
                        "RRR",
                        "RSR",
                        "RRR"
                },
                new HashMap<Character, Material>(){{
                    put('S', Material.STICK);
                    put('R', Material.LIGHTNING_ROD);
        }});
    }

}
