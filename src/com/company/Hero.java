package com.company;

import java.util.Scanner;

public class Hero extends Creature {

    Backpack backpack = new Backpack();
    Maze maze;
    private int health;


    public Hero(int startRoom, String name, Maze maze) {
        super(startRoom, name);
        this.maze = maze;
        this.health = 100;

    }

    public void isInjured() {
        health = health - 50;
        if (health == 0) {
            System.out.println("You died, Game Over");
            System.exit(0);
        }
        System.out.println("Warning! You are injured. Do you want to drink a potion? \n Press Y for Yes");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("y")) {
            drinkPotion();
        }
    }

    private void drinkPotion() {
        // behöver hämta potion från backpack
        backpack.getItemName("Healing Potion");
// ska dricka den och återställt health till 100 samt ta bort en potion
        System.out.println("You are fully healed");
        backpack.removeItem(potion);
// om det är slut på potion så ska denna text komma
        System.out.println("You have no potions");
    }



    public void addItemToBackpack(Item item) {
        backpack.addItem(item);
    }

    public void attackSpider() {//problem?
        if (backpack.getItemName("superDagger") != null) {
            if (backpack.getItemName("superDagger").equals("superDagger")) {
                System.out.println("You defeat the Spider! Continue your adventure and find other Monster!");
                maze.removeSpiderFromMaze();
            }
        } else {
            isInjured();
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
            isInjured();
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
            isInjured();
            System.out.println("You need defeat other Monster first!");
        }

    }


}


