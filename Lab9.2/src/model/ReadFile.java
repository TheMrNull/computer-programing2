package model;

import data.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        //Readfile r = new Readfile();

        String path = new File("src/files/bike.txt").getAbsolutePath();
        ReadFile r = new ReadFile(path);

        System.out.println("\nIteration through the list with Efor");
        System.out.println(r);


        r.sortWheelModel();
        System.out.println("\nonthefly WHEEL Sorted  and modelCatalog");
        System.out.println(r);

    }

    List<Bike> catalog;

    public ReadFile(String s){
        catalog = new ArrayList<Bike>();
        try {
            read(catalog, s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ReadFile(){
        catalog = new ArrayList<Bike>();
    }

    @Override
    public String toString() {
        String s="";
        for ( Bike b: catalog){
            s += b+"\n";
        }
        return s;
    }

    public void sortWheelModel(){
        Collections.sort(catalog, new Comparator<Bike>() {
            //Sort based on ascending order of dataLimit
            @Override
            public int compare(Bike obj1, Bike obj2) {

                int c = (int) (obj1.getWheelSize()-obj2.getWheelSize());
                if (c != 0) return c;
                return (int) (obj1.getModel().compareToIgnoreCase(obj2.getModel()));

            }
        });
    }

    public void sortWheel2(){
        Collections.sort(catalog, new Comparator<Bike>() {
            //Sort based on ascending order of dataLimit
            @Override
            public int compare(Bike obj1, Bike obj2) {

                int c = (int) -(obj1.getWheelSize()-obj2.getWheelSize());
                return c;

            }
        });
    }



    private void read(List <Bike> cat, String csvFilePath) throws Exception {

        //String csvFilePath = "D:\\users\\gino\\projects_proposals\\corso2021progogg\\esercitazioni\\220520_puttinglltogheter\\esercizio\\src\\it\\unitn\\cp2\\l220520\\files\\bikes.txt";
        String line = null;
        BufferedReader bufferedReader = null;

        try {
            File csvFile = new File(csvFilePath);
            FileReader fileReader = new FileReader(csvFile);
            //  FileReader fileReader = new FileReader(csvFile, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                String[] csvLineElements = line.split(",");

                for (int i = 0; i < csvLineElements.length; i++) {
                    System.out.print(csvLineElements[i] + " , ");
                }
                System.out.println("");
                Bike nb;
                if (csvLineElements.length == 5) {
                    double ws = (double) Double.parseDouble(csvLineElements[3]);
                    double c = (double) Double.parseDouble(csvLineElements[4]);
                    switch (csvLineElements[2].toLowerCase().trim()) {
                        case "road":
                            nb = new Bike(csvLineElements[0], csvLineElements[1], ws, c, Bike.bikeType.ROAD);
                            break;
                        case "city":
                            nb = new Bike(csvLineElements[0], csvLineElements[1], ws, c, Bike.bikeType.CITYBIKE);
                            break;
                        case "mtb":
                            nb = new Bike(csvLineElements[0], csvLineElements[1], ws, c, Bike.bikeType.MTB);
                            break;
                        default:
                            nb = new Bike();
                            break;
                    }
                    cat.add(nb);

                }
                if (csvLineElements.length == 6) {
                    double ws = (double) Double.parseDouble(csvLineElements[3]);
                    double c = (double) Double.parseDouble(csvLineElements[4]);
                    double batt = (double) Double.parseDouble(csvLineElements[5]);

                    switch (csvLineElements[2].toLowerCase().trim()) {
                        case "ebike":
                            nb = new EBike(csvLineElements[0], csvLineElements[1], ws, c, Bike.bikeType.ROAD, batt);
                            break;
                        default:
                            nb = new EBike();
                            break;
                    }
                    cat.add(nb);
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error Occured while parsing csv file.");
            e.printStackTrace();
        }
        catch (NumberFormatException e){
            System.out.println("Error Occured while parsing csv file numberformat");
            e.printStackTrace();
        }
        finally {
            bufferedReader.close();
        }

    }

}

