package com.company;

public class DragonBoss extends Monster {

    public DragonBoss(int currentRoom, String name) {

        super(currentRoom, name);
    }

    public String toString(){
        return "DragonBoss's position: " + position +".";
    }




}
