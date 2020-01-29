package com.company;

public class Armor extends Item {

    private int defense;

    public Armor(String name, int defense) {
        super(name);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "defense=" + defense +
                '}';
    }
}
