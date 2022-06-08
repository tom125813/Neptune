package com.doontcare.me.profiles;

import java.util.UUID;

public class Profile {

    private final UUID uuid;
    private int level;
    private double balance;

    public Profile(UUID uuid, int level, double balance) {
        this.uuid=uuid;
        this.level=level;
        this.balance=balance;
    }

    public int getLevel() {return level;}

    public double getBalance() {return balance;}
}
