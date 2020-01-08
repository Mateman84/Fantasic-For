package com.company;

import java.util.Scanner;

public class Hero extends Creature {

    Backpack backpack = new Backpack();
    Maze maze;
    //private int health;

    public Hero(int currentRoom, String name, int healthPoints, int attack, int defense, Maze maze) {
        super(currentRoom, name, healthPoints, attack, defense);
        this.maze = maze;
        //this.health = 100;
    }
/*
    public void isInjured() {
        health = health - 50;
        if (health == 0) {
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
    private void drinkPotion() {
        Item potion = backpack.getItemName("Healing Potion");
        if (potion != null) {
            backpack.removeItem(potion);
            //health = health + 50;
            System.out.println("You are fully healed");
        }else {
            System.out.println("You don't have any potions left.");
        }
    }


    public void addItemToBackpack(Item item) {
        backpack.addItem(item);
    }

    public void attackSpider() {
        if (backpack.getItemName("superDagger") != null) {
                System.out.println("You defeat the Spider! Continue your adventure and find other Monster!");
                maze.removeSpiderFromMaze();
        } else {
            //isInjured();
            System.out.println("You need to find a dagger first");
        }
    }

    public boolean isSpiderDefeated() {
        Spider spider = (Spider) maze.getMonster("Spider");
        if (spider == null) {
            return true;
        }
        return false;
    }


    public void attackBandit() {
        if (isSpiderDefeated()) {
            System.out.println("You defeat the Bandit! Continue your adventure and find other Monster!");
            maze.removeBanditFromMaze();
        } else {
            //isInjured();
            System.out.println("You need defeat Spider first!");
        }
    }

    public boolean isBanditDefeated() {
        Bandit bandit = (Bandit) maze.getMonster("Bandit");
        if (bandit == null) {
            return true;
        }
        return false;
    }


    public void attackDragonBoss() {
        if (isBanditDefeated()) {
            System.out.println("Congratulations! You defeat the DragonBoss! You win the game!");
            maze.removeDragonBossFromMaze();
            System.exit(0);
        } else {
            //isInjured();
            System.out.println("You need defeat other Monster first!");
        }

    }
}


