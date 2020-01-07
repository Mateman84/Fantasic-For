package com.company;

public class Bandit extends  Monster {

    public Bandit(int currentRoom, String name, int healthPoints, int attack, int defense) {
        super(currentRoom, name, healthPoints, attack, defense);
    }

    public String toString(){
        return "Bandit's position: " + position +".";
    }


}
