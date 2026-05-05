package application;

import data.Bike;
import data.Sale;
import logic.ReadFile;
import logic.Sales;

public class BikeStore {

    static ReadFile myStore;

    public static void main(String[] args) {
        myStore = new ReadFile(
                "src/files/bikes.txt"
        );
        System.out.println(myStore.toString());

        Bike b01 = myStore.findElement(204);
        System.out.println("Check finds 204:"+b01);

        Bike b03 = myStore.findElement(201);
        Sale s01 = new Sale(201,b03 , 3);
        // System.out.println(s01);
        Bike b04 = myStore.findElement(101);
        Bike b05 = myStore.findElement(204);
        Sale s02 = new Sale(101, b04, 1);
        Sale s03 = new Sale(204,b05, 11);

        Sales mySales = new Sales();
        mySales.add(s01);
        mySales.add(s02);
        mySales.add(s03);

        System.out.println(mySales);

        mySales.sortTotalDescending();
        System.out.println(mySales) ;
    }
}
