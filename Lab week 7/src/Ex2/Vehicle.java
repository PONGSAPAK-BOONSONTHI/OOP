package Ex2;

public abstract class Vehicle implements Dieselable{
    protected double fuel;
    
    public void setFuel(double fuel) {
        this.fuel = fuel;
    }
    public double getFuel() {
        return fuel;
    }
    public Vehicle() {
        this(0.0);
    }
    public Vehicle(double fuel) {
        this.fuel = fuel;
    }
    public void addFuel(double fuel) {
        this.fuel += fuel;
    }
    public abstract void honk();
}
