package com.company;


import java.util.Scanner;

public abstract class Creature {

    private int currentRoom;
    public Position position;
    private String name;
    private int healthPoints;
    private int attack;
    private int defense;

    public Creature (int currentRoom, String name, int healthPoints, int attack, int defense) {
        this.currentRoom = currentRoom;
        this.name = name;
        this.healthPoints = healthPoints;
        this.attack = attack;
        this.defense = defense;
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

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    /*
    public void isInjured() {
        this.healthPoints = this.healthPoints - 50;
        if (healthPoints == 0) {
            System.out.println("You died, Game Over");
            System.exit(0);
        }

        System.out.println("Warning! You are injured. Do you want to drink a potion? \nPress Y for Yes \nPress N to Continue");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.toLowerCase().equals("y")) {
            drinkPotion();
        }
    }
    */
    public Position getGridPosition(){     //new position means in the middle of the room
        int x = currentRoom % 3;
        int y = currentRoom / 3;
        return new Position(2 + (x*4), 2 + (y*4));
    }

}
