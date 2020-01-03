package com.company;

public class Spider extends Monster{

    public Spider(int currentRoom, String name) {

        super(currentRoom, name);
    }
    
    public String toString(){
        return "Spider's position: " + position +".";
    }


}