package com.company;

public class DungeonGame {

    Maze maze = new Maze();
    Hero hero;
    Backpack backpack;
    Dagger dagger;
    Menu menu = new Menu();
    Chest goldenChest;

    public DungeonGame() {

        backpack = new Backpack();
        dagger = new Dagger("superDagger");
        goldenChest = new Chest("goldenChest",4);
        goldenChest.addItem(dagger);

        hero = new Hero(6, "Hero",100,10,10, maze);                      // Sätter ut Hero i ett förutbestämt rum
        hero.addItemToBackpack(new Potion("Healing Potion"));
        hero.addItemToBackpack(new Potion("Healing Potion"));

    }

    public void startGame() {

        System.out.println("\nWelcome to explore the Dungeon, hero!\n");
        maze.updateHeroPosition(hero.getGridPosition(), hero.getGridPosition());
        maze.showGameBoard();
        int chestRoom = maze.addChestToMaze(goldenChest);
        int spiderRoom = maze.addMonsterToMaze("spider");
        int banditRoom = maze.addMonsterToMaze("bandit");
        int dragonRoom = maze.addMonsterToMaze("dragon");

        System.out.println(spiderRoom);
        System.out.println(banditRoom);
        System.out.println(dragonRoom);

        String filepath="D:\\my java\\Maze2\\Kahoot.wav";
        //Music music = new Music();
        //music.playMusic(filepath);

        while (true) {
            int choice = menu.chooseRoom(maze, hero);

            moveHeroToRoom(choice);

            int nextChoice = menu.roomEvents(choice, spiderRoom, banditRoom, dragonRoom, chestRoom, hero);

            if(nextChoice==chestRoom){
                hero.addItemToBackpack(dagger);
                backpack.showItems();
            }

            if (nextChoice == spiderRoom){
                hero.attackSpider();
            }

            if (nextChoice == banditRoom) {
                hero.attackBandit();
            }

            if(nextChoice == dragonRoom){
                hero.attackDragonBoss();
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


