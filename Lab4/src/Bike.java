public class Bike {
    protected String manufacturer; // protected = private but the children can see it directly
    protected double dailyRate;
    protected bikeType type; //type of bike

    public enum bikeType{
        CITY,
        MTB,
        RACE,
        EBIKE
    }


    public Bike(String m, double r, bikeType b){
        manufacturer = m;
        dailyRate = r;
        type = b;
    }

    public Bike(){
        this("NA", -1, bikeType.CITY);
    }


    @Override
    public String toString() {
        String r = String.format("Bike : manufacturer: %-30s, rate: %6.2f, BikeType: %s",
                manufacturer, dailyRate, type);
        return r;
    }

    public static void main(String[] args) {
        Bike b01 = new Bike();
        Bike b02 = new Bike("Pinarello Dogma",45,bikeType.RACE);
        Bike b03 = new Bike("Graziella", 12,bikeType.CITY);
        System.out.println(b01);
        System.out.println(b02);
        System.out.println(b03);
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public bikeType getType() {
        return type;
    }

    public void setType(bikeType type) {
        this.type = type;
    }
}
