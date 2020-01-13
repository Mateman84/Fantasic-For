package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    public int chooseRoom(Maze maze, Hero hero) {

        while (true) {
            try {
                int connectedRooms[] = maze.getGetConnectedRooms(hero.getCurrentRoom());
                //System.out.println("\n You wake up in an empty room");
                System.out.println("\nChoose what room to go to:" + Arrays.toString(connectedRooms));
                int choice = Integer.parseInt(scanner.nextLine());

                for (int i = 0; i < connectedRooms.length; i++) {
                    if (choice == connectedRooms[i]) {
                        return choice;
                    }
                }
                System.out.println("You must select a room from connected rooms");
            } catch (Exception ex) {
                System.out.println("Hero, please select a number to choose a Room.");
            }
        }

    }
    public int roomEvents(int choice, int spiderPos, int banditPos, int dragonPos, int chestPos, Hero hero) {

        if (choice == spiderPos) {
            while (true)
                try {
                    if (hero.isSpiderDefeated()) {
                        System.out.println("\nYou have defeated the Spider in this room. Go and explore other room!");
                        return spiderPos;
                    } else {
                        System.out.println("\nThere is a spider inside, what do you want to do?");
                        System.out.println("1. Attack\n" + "2. Go to another room\n");
                    }
                    Scanner scanner = new Scanner(System.in);
                    int nextChoice = Integer.parseInt(scanner.nextLine());
                    if (nextChoice == 1 || nextChoice == 2) {
                        return nextChoice;
                    }
                    System.out.println("Hero, please select between 1-2 to choose an action");
                } catch (Exception ex) {
                    System.out.println("Hero, please select a number to choose an action.");
                }

        }  else if (choice == dragonPos) {
            while (true)
                try {
                    System.out.println("\nYou meet the dragon boss, what do you want to do?\"");
                    System.out.println("1. Attack\n" + "2. Go to another Room\n");

                    Scanner scanner = new Scanner(System.in);
                    int nextChoice = Integer.parseInt(scanner.nextLine());
                    if (nextChoice == 1 || nextChoice == 2) {
                        return nextChoice;
                    }
                    System.out.println("Hero, please select between 1-2 to choose an action");
                } catch (Exception ex) {
                    System.out.println("Hero, please select a number to choose an action.");
                }

        } else if (choice == banditPos) {
            while (true)
                try {
                    if (hero.isBanditDefeated()) {
                        System.out.println("\nYou have defeated the Bandit in this room. Go and explore other room!");
                        return banditPos;
                    } else {
                        System.out.println("\nThere is a Bandit inside, what do you want to do?");
                        System.out.println("1. Attack\n" + "2. Go to another room\n");
                    }

                    Scanner scanner = new Scanner(System.in);
                    int nextChoice = Integer.parseInt(scanner.nextLine());
                    if (nextChoice == 1 || nextChoice == 2) {
                        return nextChoice;
                    }
                    System.out.println("Hero, please select between 1-2 to choose an action");
                } catch (Exception ex) {
                    System.out.println("Hero, please select a number to choose an action.");
                }
        } else if (choice == chestPos) {
            System.out.println("You find a golden chest, there is a dagger inside, it has been put in your backpack!");
            return  chestPos;
        } else {
            System.out.println("\nEmpty Room, nothing inside. Go to another Room");
        }
        return 2;
    }
}








