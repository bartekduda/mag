package operations;

import model.Cargo;
import model.Warehouse;
import utility.Database;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class MenuOperations {
    static Scanner scanner = new Scanner(System.in);

    public void addCargo() {
        String category;
        String description;
        double massOfPackage;
        int numberOfPackages;
        int assignedWarehouse;
        LocalDate arrivalDate;
        String ad;

        System.out.println("Cargo category: ");
        category = scanner.next();
        System.out.println("Cargo description: ");
        description = scanner.next();
        System.out.println("Mass of package: ");
        massOfPackage = scanner.nextDouble();
        System.out.println("Number of packages: ");
        numberOfPackages = scanner.nextInt();
        System.out.println("Assigned warehouse: ");
        assignedWarehouse = scanner.nextInt();
        System.out.println("Date of arrival(yyyy-mm-dd): ");
        ad = scanner.next();

        if (isValid(ad)){
            arrivalDate = LocalDate.parse(ad);
            for(Cargo cargo : Database.lisOfCargo){
                Database.lisOfCargo.add(new Cargo(category,description,massOfPackage,numberOfPackages,
                        assignedWarehouse,arrivalDate));
                CargoReadWrite.writeCargoToFile();
            }
        }

    }

    private boolean isValid(String ad){
        boolean valid;
        try{
            LocalDate.parse(ad, DateTimeFormatter.ofPattern("uuuu-MM-dd")
                    .withResolverStyle(ResolverStyle.STRICT)
            );
            valid = true;
        }catch (DateTimeParseException e){
            System.out.println("Wrong date!");
            valid = false;
        }
        return valid;
    }

    public void moveCargo(){
        int choiceCargo;
        int choiceWarehouse;
        System.out.println("Which cargo would you like to move?");
        for(Cargo cargo : Database.lisOfCargo){
            System.out.println(cargo);
        }
        choiceCargo = scanner.nextInt();
        System.out.println("Where to?");
        for (Warehouse warehouse : Database.listOfWarehouse){
            System.out.println(warehouse);
        }
        choiceWarehouse = scanner.nextInt();

        moving(choiceCargo,choiceWarehouse);

    }
    private void moving(int choiceCargo, int choiceWarehouse){
        for(Cargo cargo : Database.lisOfCargo){
            if(cargo.getID() == choiceCargo){
                cargo.setAssignedWarehouse(choiceWarehouse);
            }
        }
    }

    
}
