package com.company;

public class Dagger extends Item {

    private int damage;

    public Dagger(String name, int damage) {
        super(name);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return getName();
    }




}


