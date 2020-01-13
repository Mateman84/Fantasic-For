package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Maze {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Integer>occupiedRooms = new ArrayList<Integer>();
    ArrayList<Monster> monsters = new ArrayList<>();
    Room[] rooms = new Room[9];


    String[][] grid = {
            {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"},
            {"X", " ", " ", " ", "X", " ", " ", " ", "X", " ", " ", " ", "X"},
            {"X", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "X"},
            {"X", " ", " ", " ", "X", " ", " ", " ", "X", " ", " ", " ", "X"},
            {"X", "X", " ", "X", "X", "X", " ", "X", "X", "X", " ", "X", "X"},
            {"X", " ", " ", " ", "X", " ", " ", " ", "X", " ", " ", " ", "X"},
            {"X", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "X"},
            {"X", " ", " ", " ", "X", " ", " ", " ", "X", " ", " ", " ", "X"},
            {"X", "X", " ", "X", "X", "X", " ", "X", "X", "X", " ", "X", "X"},
            {"X", " ", " ", " ", "X", " ", " ", " ", "X", " ", " ", " ", "X"},
            {"X", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "X"},
            {"X", " ", " ", " ", "X", " ", " ", " ", "X", " ", " ", " ", "X"},
            {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}
    };

    public Maze() {
        int connectedRooms0[] = {1, 3};
        rooms[0] = new Room(connectedRooms0, 2, 2);
        int connectedRooms1[] = {0, 2, 4};
        rooms[1] = new Room(connectedRooms1, 6, 2);
        int connectedRooms2[] = {1, 5};
        rooms[2] = new Room(connectedRooms2, 10, 2);
        int connectedRooms3[] = {0, 4, 6};
        rooms[3] = new Room(connectedRooms3, 2, 6);
        int connectedRooms4[] = {1, 3, 5, 7};
        rooms[4] = new Room(connectedRooms4, 6, 6);
        int connectedRooms5[] = {2, 4, 8};
        rooms[5] = new Room(connectedRooms5, 10, 6);
        int connectedRooms6[] = {3, 7};
        rooms[6] = new Room(connectedRooms6, 2, 10);
        int connectedRooms7[] = {4, 6, 8};
        rooms[7] = new Room(connectedRooms7, 6, 10);
        int connectedRooms8[] = {5, 7};
        rooms[8] = new Room(connectedRooms8, 10, 10);
    }

    public int addChestToMaze(Chest chest) {
        int randomRoomNr = roomRandomiser();

            if(occupiedRooms.contains(randomRoomNr) || randomRoomNr == 6){
                randomRoomNr = roomRandomiser();
            } else {
                chest.setPos(randomRoomNr);
                occupiedRooms.add(randomRoomNr);
            }
        return randomRoomNr;
    }

    public int addMonsterToRoom(){
        int newRoom;

        for (Monster monster : monsters) {
            newRoom = roomRandomiser();
            if (occupiedRooms.contains(newRoom) || newRoom == 6){
                continue;
            } else {
                monster.setCurrentRoom(newRoom);
                occupiedRooms.add(newRoom);
                return newRoom;
            }
        }
        return 0;
    }


    public void addMonsterToMaze(Monster monster) {
        monsters.add(monster);
    }

    public void removeSpiderFromMaze(){
        monsters.remove(getMonster("Spider"));
    }
    public void removeBanditFromMaze(){
        monsters.remove(getMonster("Bandit"));// 0 or 1?
    }
    public void removeDragonBossFromMaze(){
        monsters.remove(getMonster("DragonBoss"));
    }

    public Monster getMonster(String nameToSearchFor){
        for(Monster monster: monsters){
            if(nameToSearchFor.equals(monster.getName())){
                return monster;
            }
            if(monster == null){
                continue;
            }
        }
        return null;
    }

    public int roomRandomiser(){
        Random r = new Random();
        return r.ints(0, (8 + 1)).findFirst().getAsInt();
    }

    public void showMonster(){
        for(Monster monster: monsters){
            System.out.println(monster);
        }
    }


    public Room getRoom(int roomID) {
        return rooms[roomID];
    }

    public int[] getGetConnectedRooms(int roomID) {
        return rooms[roomID].getConnectedRooms();
    }


    public void showGameBoard() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }


    public void updateHeroPosition(Position pos, Position oldPosition) {
        grid[oldPosition.y][oldPosition.x] = " ";
        grid[pos.y][pos.x] = "H";
    }

    public void showRoomHeroHasEntered(Position oldPosition){

        grid[oldPosition.y][oldPosition.x]="*";
    }



}
