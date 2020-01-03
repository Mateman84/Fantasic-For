package com.company;


public abstract class Creature {
    private int currentRoom;

    public Position position;

    private String name;

    public Creature (int currentRoom, String name) {

        this.currentRoom = currentRoom;
        this.name = name;

        this.position = getGridPosition();
    }

    public String getName() {
        return name;
    }

    public int getCurrentRoom() {

        return currentRoom;
    }

    public void setCurrentRoom(int currentRoom) {

        this.currentRoom = currentRoom;
    }

    public Position getGridPosition(){     //new position means in the middle of the room
        int x = currentRoom % 3;
        int y = currentRoom / 3;
        return new Position(2 + (x*4), 2 + (y*4));
    }

}
