package com.company;

public class Spider extends Monster{

    public Spider(int currentRoom, String name,int healthPoints, int attack, int defense) {

        super(currentRoom, name, healthPoints, attack, defense);
    }
    
    public String toString(){
        return "Spider's position: " + position +".";
    }


}