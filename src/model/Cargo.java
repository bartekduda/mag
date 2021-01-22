package model;

import utility.Database;

import java.time.LocalDate;

public class Cargo {
    private final int ID;
    private String category;
    private String description;
    private double massOfPackage;
    private int numberOfPackages;
    private int assignedWarehouse;
    private LocalDate arrivalDate;

    public Cargo(int id, String category, String description, double massOfPackage,
                 int numberOfPackages, int assignedWarehouse, LocalDate arrivalDate){
        this.ID = id;
        this.category = category;
        this.description = description;
        this.massOfPackage = massOfPackage;
        this.numberOfPackages = numberOfPackages;
        this.assignedWarehouse = assignedWarehouse;
        this.arrivalDate = arrivalDate;
    }

    public Cargo(String category, String description, double massOfPackage,
                 int numberOfPackages, int assignedWarehouse, LocalDate arrivalDate){
        this.ID = getNextFreeID();
        this.category = category;
        this.description = description;
        this.massOfPackage = massOfPackage;
        this.numberOfPackages = numberOfPackages;
        this.assignedWarehouse = assignedWarehouse;
        this.arrivalDate = arrivalDate;
    }

    private int getNextFreeID(){
        int lastID = 0;
        for(Cargo cargo : Database.lisOfCargo){
            if(cargo.getID() > lastID){
                lastID = cargo.getID();
            }
        }
        return lastID + 1;
    }

    public int getID() {
        return ID;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public double getMassOfPackage() {
        return massOfPackage;
    }

    public int getNumberOfPackages() {
        return numberOfPackages;
    }

    public int getAssignedWarehouse() {
        return assignedWarehouse;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        return "ID: " + ID +
                " category: " + getCategory() +
                " description: " + getDescription() +
                " massOfPackage: " + getMassOfPackage() +
                " numberOfPackages: " + getNumberOfPackages() +
                " assignedWarehouse: " + getAssignedWarehouse() +
                " arrivalDate: " + getArrivalDate();
    }
}
