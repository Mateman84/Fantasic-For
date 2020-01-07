package com.company;

public class DragonBoss extends Monster {

    public DragonBoss(int currentRoom, String name, int healthPoints, int attack, int defense) {

        super(currentRoom, name, healthPoints, attack, defense);
    }

    public String toString(){
        return "DragonBoss's position: " + position +".";
    }




}
