package data;

import java.time.LocalDateTime;

public class Sale {
    static int id0 = 1; // Initial ID
    int id; // Sale Id
    int nb; // Number of items sold
    Bike bike;
    double total; // Total amount
    LocalDateTime ldt; //Date of sale


    @Override
    public String toString() {
        String s = String.format("Invoice id: %d - Date: %s - Number of bikes: %d - Total %5.2f - Item: %s \n", id,ldt,nb,total, bike);
        return s;
    }

    public Sale(int nb, Bike b){
        id = id0; //id of the sale
        id0++;
        bike = b;
        this.nb = nb;
        ldt = LocalDateTime.now(); //time of sale
        total = (nb*b.getCost());//*(1+22./100);
    }
}
