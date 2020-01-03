package com.company;

import java.lang.reflect.Array;

public class Room {

    private int[] connectedRooms;
    private int heroX;
    private int heroY;

    public Room(int[] connectedRooms, int heroX, int heroY) {
        this.connectedRooms = connectedRooms;
        this.heroX = heroX;
        this.heroY = heroY;
    }

    public int[] getConnectedRooms() {
        return connectedRooms;
    }
}
