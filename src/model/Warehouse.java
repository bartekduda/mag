package model;

import utility.Database;

public class Warehouse {
    private final int ID;
    private String location;
    private int capacity;

    Warehouse(int id, String location, int capacity){
        this.ID = id;
        this.location = location;
        this.capacity = capacity;
    }
    Warehouse(String location, int capacity){
        this.ID = getNextFreeID();
        this.location = location;
        this.capacity = capacity;
    }

    private int getNextFreeID(){
        int lastID = 0;
        for(Warehouse warehouse : Database.listOfWarehouse){
            if(warehouse.getID() > lastID){
                lastID = warehouse.getID();
            }
        }
        return lastID + 1;
    }

    public int getID() {
        return ID;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }
}
