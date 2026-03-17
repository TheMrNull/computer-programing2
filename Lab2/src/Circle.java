public class Circle {
    private double x ;
    private double y;
    private double radius;
    private String name;

    public Circle(double x, double y, double radius, String name) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.name = name;
        this.area();  //this.area works but since the function is void it can also be omitted as shown below
        perimeter();
    }

    public Circle(){
        this(0.0,0.0,0.0,"not defined");
    }

    private double area;
    private double perimeter;

    public void area(){
        area = radius*radius*Math.PI;
    }
    public void perimeter(){
        perimeter = 2*radius*Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", perimeter=" + perimeter +
                '}';
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public double distance(Circle c){
        double dx = this.x - c.getX();
        double dy = this.y - c.getY();
        double d = Math.sqrt((dx*dx)+(dy*dy));
        return d;
    }

    public boolean insideB(Circle b){
        double d = this.distance(b);
        if(d <= (radius - b.getRadius())){
            return true;
        }
        return false;
    }

    public boolean intersectB(Circle b){
        double d = this.distance(b);
        if(d <= (radius + b.getRadius())){
            return true;
        }
        return false;
    }


    public void allcheck(Circle b){
        System.out.println("Distance: " + this.distance(b));
        System.out.println("Check if B is inside A: " + this.insideB(b));
        System.out.println("Check if A intersects B: " + this.intersectB(b));
    }


    public static void main(String[] args) {
        Circle c1 = new Circle(1,2,5,"First Circle");
        Circle c2 = new Circle();
        Circle c3 = new Circle(2,2,3,"Circle 3");

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        //System.out.println("Distance: " + c1.distance(c3));
        c1.allcheck(c3);

    }

}


