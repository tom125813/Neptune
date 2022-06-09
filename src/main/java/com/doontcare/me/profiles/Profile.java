package com.doontcare.me.profiles;

import com.doontcare.me.ranks.Rank;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Date;
import java.util.UUID;

public class Profile {

    private final UUID uuid;
    private Rank rank;
    private int level;
    private double balance;
    private Date lastLogin;

    public Profile(UUID uuid, Rank rank, int level, double balance, Date lastLogin) {
        this.rank=rank;
        this.uuid=uuid;
        this.level=level;
        this.balance=balance;
        this.lastLogin=lastLogin;
    }

    public UUID getUUID() {return uuid;}
    public Player getPlayer() {return Bukkit.getPlayer(uuid);}
    public Rank getRank() {return rank;}
    public int getLevel() {return level;}
    public double getBalance() {return balance;}
    public Date getLastLogin() {return lastLogin;}

    public void setRank(Rank rank) {this.rank=rank;}
    public void setLevel(int level) {this.level=level;}
    public void setBalance(double balance) {this.balance=balance;}
    public void setLastLogin(Date lastLogin) {this.lastLogin=lastLogin;}
}
