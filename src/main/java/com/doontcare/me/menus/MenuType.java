package com.doontcare.me.menus;

public enum MenuType {
    MENU("&8Menu", ""),
    BANK("&8Bank", "&7Deposit and withdraw"),
    SETTINGS("&8Settings", "&7Alter your preferences");

    private String name;
    private String description;

    MenuType(String name, String description) {
        this.name=name;
        this.description=description;
    }

    public String getName() {return name;}
    public String getDescription() {return description;}
}
