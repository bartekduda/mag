package operations;

import model.Cargo;
import utility.Database;

import java.io.*;
import java.time.LocalDate;

public class CargoReadWrite {
    private static String filename = "cargo.csv";
    private static String spliter = ",";

    public static void writeCargoToFile(){
        try(PrintWriter outS = new PrintWriter(new BufferedWriter(new FileWriter(filename)))){
            for(Cargo cargo : Database.lisOfCargo){
                outS.write(cargo.getID() + spliter + cargo.getCategory() + spliter + cargo.getDescription()
                + spliter + cargo.getMassOfPackage() + spliter + cargo.getNumberOfPackages()
                        + spliter + cargo.getAssignedWarehouse() + spliter + cargo.getArrivalDate());
                outS.println();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void readCargoFromFile(){
        try(BufferedReader inS = new BufferedReader(new FileReader(filename))){
            int id;
            String category;
            String description;
            double massOfPackage;
            int numberOfPackages;
            int assignedWarehouse;
            LocalDate arrivalDate;
            String line;
            String[] lineArray;

            while ((line = inS.readLine()) != null){
                lineArray = line.split(spliter);
                id = Integer.parseInt(lineArray[0]);
                category = lineArray[1];
                description = lineArray[2];
                massOfPackage = Double.parseDouble(lineArray[3]);
                numberOfPackages = Integer.parseInt(lineArray[4]);
                assignedWarehouse = Integer.parseInt(lineArray[5]);
                arrivalDate = LocalDate.parse(lineArray[6]);

                Database.lisOfCargo.add(new Cargo(id,category,description,massOfPackage,
                        numberOfPackages,assignedWarehouse,arrivalDate));
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
