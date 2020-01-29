package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class DungeonGame {

    Maze maze = new Maze();
    Hero hero;
    Spider spider;
    Bandit bandit;
    DragonBoss dragonBoss;
    Weapon weapon = new Weapon("superDagger", 15);
    Armor armor = new Armor("superArmor", 10);
    Menu menu = new Menu();
    Chest goldenChest;
    Chest silverChest;
    private int goldenChestRoom;
    private int silverChestRoom;

    public DungeonGame() {

        hero = new Hero(6, "Hero",100,10,10, maze);                      // Sätter ut Hero i ett förutbestämt rum
        hero.addItemToBackpack(new Potion("Healing Potion"));
        hero.addItemToBackpack(new Potion("Healing Potion"));
        spider = new Spider(goldenChestRoom, "Spider", monsterStatRandomizer(05,100), monsterStatRandomizer(5,10), monsterStatRandomizer(0,5));
        bandit = new Bandit(goldenChestRoom, "Bandit", 150,15,10);
        dragonBoss = new DragonBoss(goldenChestRoom, "Dragonboss", 200,20,15);
        goldenChest = new Chest("goldenChest",6, true);
        silverChest = new Chest("silverChest", 6, true);
        goldenChestRoom = maze.addChestToMaze(goldenChest);
        silverChestRoom = maze.addChestToMaze(silverChest);
        goldenChest.addItem(weapon);
        silverChest.addItem(armor);
    }

    public void startGame() {

        System.out.println("\nWelcome to explore the Dungeon, hero!\n");
        maze.updateHeroPosition(hero.getGridPosition(), hero.getGridPosition());
        maze.showGameBoard();

        maze.addMonsterToMaze(spider);
        maze.addMonsterToMaze(bandit);
        maze.addMonsterToMaze(dragonBoss);

        int spiderRoom = maze.addMonsterToRoom();
        int banditRoom = maze.addMonsterToRoom();
        int dragonRoom = maze.addMonsterToRoom();

        System.out.println("Golden chest room = " + goldenChestRoom + " golden chest is empty = " + goldenChest.isEmpty());
        System.out.println("Silver chest room = " + silverChestRoom + " silver chest is empty = " + silverChest.isEmpty());
        System.out.println("Spiders room is = " + spiderRoom);
        System.out.println("Spiders stats: " + spider.getHealthPoints() + " " + spider.getAttack() + " " + spider.getDefense());
        System.out.println("Bandit room is = " + banditRoom);
        System.out.println("Dragon room is = " + dragonRoom);
        System.out.println("Hero items in backpack = " + hero.getBackpack().getItems());


        String filepath="D:\\my java\\Maze2\\Kahoot.wav";
        //Music music = new Music();
        //music.playMusic(filepath);

        while (true) {
            int choice = menu.chooseRoom(maze, hero);

            moveHeroToRoom(choice);

            int nextChoice = menu.roomEvents(choice, spiderRoom, banditRoom, dragonRoom, goldenChestRoom, silverChestRoom, hero);

            if(nextChoice == goldenChestRoom){
                if(goldenChest.isEmpty()){
                    System.out.println("You have already emptied the chest.");
                } else {
                    goldenChest.removeItemFromChest(weapon);
                    hero.addItemToBackpack(weapon);
                    hero.setAttack(hero.getAttack() + weapon.getDamage());
                    System.out.println("Your damage is now: " + hero.getAttack());
                }
            }
            if(nextChoice == silverChestRoom){
                if(silverChest.isEmpty()){
                    System.out.println("You have already emptied the chest.");
                } else {
                    silverChest.removeItemFromChest(armor);
                    hero.addItemToBackpack(armor);
                    hero.setDefense(hero.getDefense() + armor.getDefense());
                    System.out.println("Your Armor is now: " + hero.getDefense());
                }
            }

            if (nextChoice == spiderRoom){
                //hero.attackSpider();
            }

            if (nextChoice == banditRoom) {
                //hero.attackBandit();
            }

            if (nextChoice == dragonRoom) {
                //hero.attackDragonBoss();
            }
        }
}

    public void moveHeroToRoom(int roomNumber) {
        Position oldPosition = hero.getGridPosition();
        hero.setCurrentRoom(roomNumber);
        maze.updateHeroPosition(hero.getGridPosition(), oldPosition);
        maze.showRoomHeroHasEntered(oldPosition);
        maze.showGameBoard();
    }
    public int monsterStatRandomizer (int lowestStat, int highestStat){
        int randomStatNumber = ThreadLocalRandom.current().nextInt(lowestStat, highestStat);
        System.out.println("Random number generated is : " + randomStatNumber);

        return randomStatNumber;
    }
}


