package com.company;

import java.util.ArrayList;

import java.util.ArrayList;

public class Backpack {

    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
        System.out.println("Added Item " + item.getName());
    }

    public void removeItem (Item item){
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Item getItemName(String name) {
        for (Item item : items){
            if(name.equals(item.getName())){
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Backpack{" +
                "items=" + items +
                '}';
    }
}
