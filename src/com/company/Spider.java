package com.company;

public class Spider extends Monster{

    public Spider(int currentRoom, String name,int healthPoints) {

        super(currentRoom, name, healthPoints);
    }
    
    public String toString(){
        return "Spider's position: " + position +".";
    }


}