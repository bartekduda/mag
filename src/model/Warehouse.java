package model;

import utility.Database;

public class Warehouse {
    private final int ID;
    private String location;
    private double capacity;

    public Warehouse(int id, String location, double capacity){
        this.ID = id;
        this.location = location;
        this.capacity = capacity;
    }
    public Warehouse(String location, double capacity){
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

    public double getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "ID: " + getID() +
                " location: " + getLocation()  +
                " capacity: " + getCapacity();
    }
}
