package operations;

import model.Warehouse;

import java.util.Scanner;

public class Menu {

    public Menu(){
        WarehouseReadWrite.warehouseReadFromFile();
        CargoReadWrite.readCargoFromFile();
        showMenu();
    }

    public void showMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Add cargo");
        System.out.println("2. Remove cargo");
        System.out.println("3. Move cargo");
        System.out.println("4. Display cargo details");
        System.out.println("5. List nearly full warehouse");
        System.out.println("6. List nearly empty warehouse");
        System.out.println("7. All cargo from warehouse sorted by date");
        System.out.println("8. All cargo of specific category");
        System.out.println("9. Save data");
        System.out.println("0. exit");

        int choice;
        choice = scanner.nextInt();
        switch (choice){
            case 1:{
                MenuOperations.addCargo();
                CargoReadWrite.writeCargoToFile();
                break;
            }
            case 2:{
                //removecargo
            }
            case 3:{
                MenuOperations.moveCargo();
                CargoReadWrite.writeCargoToFile();
                break;

            }
            case 4:{
                MenuOperations.displayCargo();
                break;
            }
            case 5:{
                MenuOperations.nearlyFullWarehouse();
                break;

            }
            case 6:{
                MenuOperations.nearllyEmptyWarehouse();
                break;

            }
            case 7:{
                MenuOperations.cargoByArrivalDate();
                break;
            }
            case 8:{
                MenuOperations.cargoByCategory();
                break;
            }
            case 9:{
                WarehouseReadWrite.warehouseWriteToFile();
                CargoReadWrite.writeCargoToFile();
            }
            case 0:{
                return;
            }
            default:{
                System.out.println("Wrong operation number");
            }
        }

    }
}
