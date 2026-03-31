import java.time.LocalDate;
import java.time.Period;

public class Rent {
    protected String customer;
    protected LocalDate dateOfRent;
    protected Bike bike;

    public Rent(){
        customer = "Nobody";
        dateOfRent = LocalDate.of(1970,1,1);
        bike = new Bike();
    }

    public Rent(String c, LocalDate d, Bike b){
        customer = c;
        dateOfRent = d;
        bike = b;
    }

    @Override
    public String toString() {
     String r = String.format("Customer: %20s, dateOfRent: %s ", customer, dateOfRent);
     r = r + bike.toString();
     return r;
    }

    public String returnBike(LocalDate l){
        // calculate difference
        long days = Period.between(dateOfRent, l).getDays();
        long months = Period.between(dateOfRent, l).getMonths();
        long years = Period.between(dateOfRent,l).getYears();
        String r = String.format("Renting period: from %s to %s for a total of %d days " + "%d months %d years", dateOfRent, l, days, months, years);
        return r;
    }


    public static void main(String[] args) {
        Rent r01 = new Rent("George Washington",
                LocalDate.of(2025,2,20),
                new Bike("graziella",25, Bike.bikeType.CITY)
        );
        System.out.println(r01);
        String r = r01.returnBike(LocalDate.now());
        System.out.println(r);
    }
}
