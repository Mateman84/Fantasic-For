package com.company;

public class DragonBoss extends Monster {

    public DragonBoss(int currentRoom, String name, int healthPoints) {

        super(currentRoom, name, healthPoints);
    }

    public String toString(){
        return "DragonBoss's position: " + position +".";
    }




}
