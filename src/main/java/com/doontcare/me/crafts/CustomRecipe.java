package com.doontcare.me.crafts;

import com.doontcare.me.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CustomRecipe {

    // TODO: Add a RecipeManager
    // TODO:    - Use this RecipeManager in coordination with the
    // TODO:      Menu system to create a custom recipe page.

    public CustomRecipe(String key, ItemStack itemStack, String[] shape, HashMap<Character, Material> ingredients) {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Main.getInstance(), key), itemStack);
        recipe.shape(shape);

        int size = ingredients.size();
        List<Character> ingredientCodes = ingredients.keySet().stream().collect(Collectors.toList());
        List<Material> ingredientMaterials = ingredients.values().stream().collect(Collectors.toList());
        for (int i = 0; i < size; i++)
            recipe.setIngredient(ingredientCodes.get(i), ingredientMaterials.get(i));

        Bukkit.addRecipe(recipe);
    }

}
