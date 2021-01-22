package operations;

import model.Warehouse;
import utility.Database;

import java.io.*;

public class WarehouseReadWrite {
    private String filepath = "warehouse.csv";
    private String spliter = ",";

    public void warehouseWriteToFile(){
        try(PrintWriter outS = new PrintWriter(new BufferedWriter(new FileWriter(filepath)))) {
            for(Warehouse warehouse : Database.listOfWarehouse){
                outS.write(warehouse.getID() + spliter + warehouse.getLocation()
                        + spliter + warehouse.getCapacity());
                outS.println();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());;
        }
    }

    public void warehouseReadFromFile(){
        try(BufferedReader inS = new BufferedReader(new FileReader(filepath))) {
            int id;
            String location;
            double capacity;
            String line;
            String[] lineArray;

            while ((line = inS.readLine()) != null){
                lineArray = line.split(spliter);
                id = Integer.parseInt(lineArray[0]);
                location = lineArray[1];
                capacity = Double.parseDouble(lineArray[2]);

                Database.listOfWarehouse.add(new Warehouse(id,location,capacity));
            }

        }catch (IOException e){
            System.out.println(e.getMessage());;
        }
    }
}
