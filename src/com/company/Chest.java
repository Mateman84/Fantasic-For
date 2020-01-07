package com.company;

import java.util.ArrayList;

public class Chest {

    private ArrayList<Dagger> daggers = new ArrayList<>();
    private String name;
    private int pos;

    public Chest(String name, int pos) {
        this.name = name;
        this.pos = pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getPos() {
        return pos;
    }

    @Override
    public String toString() {
        return null;
    }

    public void addItem(Dagger dagger) {
        daggers.add(dagger);

    }
}
