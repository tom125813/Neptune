package com.doontcare.me.profiles;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Date;
import java.util.UUID;

public class Profile {

    private final UUID uuid;
    private int level;
    private double balance;
    private Date lastLogin;

    public Profile(UUID uuid, int level, double balance, Date lastLogin) {
        this.uuid=uuid;
        this.level=level;
        this.balance=balance;
        this.lastLogin=lastLogin;
    }

    public UUID getUUID() {return uuid;}
    public Player getPlayer() {return Bukkit.getPlayer(uuid);}
    public int getLevel() {return level;}
    public double getBalance() {return balance;}
    public Date getLastLogin() {return lastLogin;}

    public void setLevel(int level) {this.level=level;}
    public void setBalance(double balance) {this.balance=balance;}
    public void setLastLogin(Date lastLogin) {this.lastLogin=lastLogin;}
}
