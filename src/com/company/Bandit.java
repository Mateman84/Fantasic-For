package com.company;

public class Bandit extends  Monster {

    public Bandit(int currentRoom, String name, int healthPoints) {
        super(currentRoom, name, healthPoints);
    }

    public String toString(){
        return "Bandit's position: " + position +".";
    }


}
