public class Test {
    public static void main(String[] args) {
        Bike bk01 = new Bike("SCOTT Performance", 60, Bike.bikeType.MTB);
        EBike bk02 = new EBike("FOCUS",80, Bike.bikeType.MTB,250);
        Bike bk03 = new EBike("SCOTT SuperElect",76, Bike.bikeType.CITY,150);
        System.out.println(bk01);
        System.out.println(bk02);
        System.out.println(bk03);
    }
}
