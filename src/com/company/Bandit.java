package com.company;

public class Bandit extends  Monster {

    public Bandit(int currentRoom, String name) {

        super(currentRoom, name);
    }

    public String toString(){
        return "Bandit's position: " + position +".";
    }


}
