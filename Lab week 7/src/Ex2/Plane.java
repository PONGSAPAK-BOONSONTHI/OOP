package Ex2;

public class Plane extends Vehicle implements Flyable{
    private String airline;
    private String boeing;
    private final static int MAX_FLYER = 2;
    
    public void setAirline(String airline) {
        this.airline = airline;
    }
    public String getAirline() {
        return airline;
    }
    public void setBoeing(String boeing) {
        this.boeing = boeing;
    }
    public String getBoeing() {
        return boeing;
    }
    public Plane() {
        this(0.0, "", "");
    }
    public Plane(double fuel, String airline, String boeing) {
        super(fuel);
        this.airline = airline;
        this.boeing = boeing;
    }
    @Override
    public void honk() {
        System.out.println("Weeeeeee");
    }
    @Override
    public void startEngine() {
        if (getFuel() < 20) {
            System.out.println("Fuel is not enough.");
            return;
        }
        setFuel(getFuel() - 20);
        System.out.println("Plane's Engine starts");
    }
    @Override
    public void stopEngine() {
        System.out.println("Plane's Engine stops");
    }    
    @Override
    public void fly() {
        if (getFuel() < 20) {
            System.out.println("Fuel is nearly empty.");
            return;
        }
        setFuel(getFuel() - 20);        
        System.out.println("Plane Fly");  
    }
    @Override
    public void takeOff() {
        if (getFuel() < 10) {
            System.out.println("Fuel is nearly empty.");
            return;
        }
        setFuel(getFuel() - 10);        
        System.out.println("Plane Already to Take Off"); 
    }
    @Override
    public void landing() {
        if (getFuel() < 10) {
            System.out.println("Fuel is nearly empty.");
            return;
        }
        setFuel(getFuel() - 10);
        System.out.println("Plane Already to Landing"); 
    }
}
