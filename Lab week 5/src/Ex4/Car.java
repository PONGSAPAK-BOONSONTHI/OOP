package Ex4;

public class Car extends Vehicle {
    private String typeEngine;

    public void setTypeEngine(String t) {
        typeEngine = t;
    }
    public String getTypeEngine() {
        return typeEngine;
    }
    public void showCarInfo() {
        System.out.println("Car engine is " + typeEngine + ".");
        System.out.println("Fuel is " + getFuel() + " litre and Top Speed is " + getTopSpeed() + " m/s");
    }
    public void setCarInfo(int s, String t, String y) {
        this.setFuel(s);
        this.setTopSpeed(t);
        typeEngine = y;
    }
    public void move() {
        int fuel = getFuel();
        if (fuel < 50) {
            System.out.println("Please add fuel.");
            return;
        }
        setFuel(fuel - 50);
        System.out.println("Move.");
    }
}
