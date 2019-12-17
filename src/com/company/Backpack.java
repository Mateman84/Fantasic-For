package com.company;

import java.util.ArrayList;

import java.util.ArrayList;

public class Backpack {

    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem (Item item){
        items.remove(item);
    }


    public void showItems(){
        for(Item item: items){
            System.out.println("Now you backpack have: " + item);;
        }
    }

    public Item getItemName(String name) {
        for (Item item : items){
            if(name.equals(item.getName())){
                return item;
            }
        }
        return null;
    }

    public String getDaggerName(String name) {
        for (Item item : items){
            if(item == null){
                continue;
            }
            if(name.equals(item.getName())){
                return item.getName();
            }
        }
        return null;
    }
}
