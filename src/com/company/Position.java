package com.company;

public class Position {
    public int x;
    public int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public String toString() {
        return "Position " +
                "x=" + x +
                " y=" + y;
    }
}
