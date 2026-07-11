public class Tesla extends Vehicle implements selfDrive {

    @Override
    void accelerate() {
        System.out.println("Speeding up");
    }

    @Override
    public void autopilot() {
        System.out.println("Autopilot on");
    }
}


abstract class Vehicle{
    int wheels =4;
    abstract void accelerate();
}

interface selfDrive{
    void autopilot();
}


void main(String[] args) {
    Tesla test01 = new Tesla();
}

