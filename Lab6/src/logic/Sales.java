package logic;

import data.Bike;
import data.Sale;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sales {
    List<Sale> myStoreSales;


    public Sales(){
        myStoreSales = new ArrayList<>();
    }

    public void add(Sale s){
        myStoreSales.add(s);
    }



    public void sortTotalDescending(){
        Collections.sort(myStoreSales, new Comparator<Sale>() {
            //Sort based on ascending order of dataLimit
            @Override
            public int compare(Sale obj1, Sale obj2) {
// Implement the compare for sorting
                int i = (int)(obj2.getTotal() - obj1.getTotal());
                return i;
            }
        });
    }


    @Override
    public String toString() {
        String s="";
        for ( Sale b: myStoreSales){
            s += b+"\n";
        }
        return s;
    }
}
