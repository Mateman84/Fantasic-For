package com.company;

public class DungeonGame {

    Maze maze = new Maze();
    Hero hero;
    Dagger dagger = new Dagger("superDagger", 15);
    Menu menu = new Menu();
    Chest goldenChest;
    private int chestRoom;

    public DungeonGame() {

        hero = new Hero(6, "Hero",100,10,10, maze);                      // Sätter ut Hero i ett förutbestämt rum
        hero.addItemToBackpack(new Potion("Healing Potion"));
        hero.addItemToBackpack(new Potion("Healing Potion"));
        goldenChest = new Chest("goldenChest",6, true);
        chestRoom = maze.addChestToMaze(goldenChest);
        goldenChest.addItem(dagger);
    }

    public void startGame() {

        System.out.println("\nWelcome to explore the Dungeon, hero!\n");
        maze.updateHeroPosition(hero.getGridPosition(), hero.getGridPosition());
        maze.showGameBoard();

        maze.addMonsterToMaze(new Spider(chestRoom, "Spider", 100, 10, 5));
        maze.addMonsterToMaze(new Bandit(chestRoom, "Bandit", 150,15,10));
        maze.addMonsterToMaze(new DragonBoss(chestRoom, "Dragonboss", 200,20,15));

        int spiderRoom = maze.addMonsterToRoom();
        int banditRoom = maze.addMonsterToRoom();
        int dragonRoom = maze.addMonsterToRoom();

        System.out.println("Chest room = " + chestRoom + " Chest is empty = " + goldenChest.isEmpty());
        System.out.println("Spiders room is = " + spiderRoom);
        System.out.println("Bandit room is = " + banditRoom);
        System.out.println("Dragon room is = " + dragonRoom);
        System.out.println("Hero items in backpack = " + hero.getBackpack().getItems());


        String filepath="D:\\my java\\Maze2\\Kahoot.wav";
        //Music music = new Music();
        //music.playMusic(filepath);

        while (true) {
            int choice = menu.chooseRoom(maze, hero);

            moveHeroToRoom(choice);

            int nextChoice = menu.roomEvents(choice, spiderRoom, banditRoom, dragonRoom, chestRoom, hero);

            if(nextChoice == chestRoom){
                if(goldenChest.isEmpty()){
                    System.out.println("You have already emptied the chest.");
                } else {
                    goldenChest.removeItemFromChest(dagger);
                    hero.addItemToBackpack(dagger);
                    hero.setAttack(hero.getAttack() + dagger.getDamage());
                    System.out.println("Hero items in backpack = " + hero.getBackpack().getItems());
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
}


