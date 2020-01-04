package com.company;

public class DungeonGame {

    Maze maze = new Maze();
    Hero hero;
    Backpack backpack;
    Dagger dagger;
    Menu menu = new Menu();
    GoldenChest goldenChest;



    public DungeonGame() {

        backpack = new Backpack();
        dagger = new Dagger("superDagger");
        goldenChest = new GoldenChest("goldenChest");

        goldenChest.addItem(dagger);

        hero = new Hero(6, "Hero",100, maze);                      // Sätter ut Hero i ett förutbestämt rum
        hero.addItemToBackpack(new Potion("Healing Potion"));
        hero.addItemToBackpack(new Potion("Healing Potion"));

    }

    public void startGame() {

        System.out.println("\nWelcome to explore the Dungeon, hero!\n");
        maze.updateHeroPosition(hero.getGridPosition(), hero.getGridPosition());
        maze.showGameBoard();
        maze.addMonsterToMaze();

        String filepath="D:\\my java\\Maze2\\Kahoot.wav";
        Music music = new Music();
        music.playMusic(filepath);

        while (true) {
            int choice = menu.chooseRoom(maze, hero);
            if (choice==7) {
                hero.addItemToBackpack(dagger);
                backpack.showItems();
            }

            moveHeroToRoom(choice);

            int nextChoice = menu.roomEvents(choice, hero);

            if(choice==7){
                hero.addItemToBackpack(dagger);
                backpack.showItems();
            }

            if (nextChoice == 1) {
                if (choice == 3){
                    hero.attackSpider();
                }

                if (choice == 1) {
                    hero.attackBandit();
                }

                if(choice==2){
                    hero.attackDragonBoss();
                }
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


}


