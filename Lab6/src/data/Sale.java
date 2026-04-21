package data;

import java.time.LocalDateTime;

public class Sale {
    Bike b;
    int nb;
    double total;
    LocalDateTime ldt;
    int id;


    public Sale(int id, Bike b, int n){
        this.id = id;
        this.b = b;
        this.nb = n;
        ldt = LocalDateTime.now();
        total = nb* b.getCost();
    }

    public Bike getB() {
        return b;
    }

    public void setB(Bike b) {
        this.b = b;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getLdt() {
        return ldt;
    }

    public void setLdt(LocalDateTime ldt) {
        this.ldt = ldt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "b=" + b +
                ", nb=" + nb +
                ", total=" + total +
                ", ldt=" + ldt +
                ", id=" + id +
                '}';
    }
}
