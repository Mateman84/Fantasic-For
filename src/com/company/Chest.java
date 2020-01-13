package com.company;

import java.util.ArrayList;

public class Chest {

    private ArrayList<Item> items = new ArrayList<>();
    private String name;
    private int pos;
    private boolean isEmpty;

    public Chest(String name, int pos, boolean isEmpty) {
        this.name = name;
        this.pos = pos;
        this.isEmpty = true;
    }

    public String getName() {
        return name;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
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

    public void addItem(Item item) {
        items.add(item);
        this.setEmpty(false);
    }
}
