package Ex4;

public class Plane extends Vehicle {
    public void showPlaneInfo() {
        System.out.println("Plane detail is, Fuel is " + getFuel() + " litre and Top Speed is " + getTopSpeed() + " m/s.");
    }
    public void setPlaneInfo(int s, String t) {
        this.setFuel(s);
        this.setTopSpeed(t);
    }
    public void fly() {
        int fuel = getFuel();
        if (fuel < 200) {
            System.out.println("Please add fuel.");
            return;
        }
        setFuel(fuel - 200);
        System.out.println("Fly.");
    }
}
