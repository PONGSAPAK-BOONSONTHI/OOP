package Ex2;

public class Ship extends Vehicle implements Floatable{
    public Ship() {
        super(0.0);
    }
    public Ship(double fuel) {
        super(fuel);
    }  
    @Override
    public void fl0at() {
        if (getFuel() < 50) {
            System.out.println("Fuel is not enough.");
            return;
        }
        setFuel(getFuel() - 50);        
        System.out.println("Ship moves");
    }
    @Override
    public void honk() {
        System.out.println("Shhhhh");
    }
    @Override
    public void startEngine() {
        if (getFuel() < 50) {
            System.out.println("Fuel is not enough.");
            return;
        }
        setFuel(getFuel() - 10);        
        System.out.println("Engine starts");
    }
    @Override
    public void stopEngine() {
        System.out.println("Engine stops");
    }
    public void move() {
        fl0at();
    }
    public void move(int distance) {
        for (int i = 0; i < distance; i++) {
            fl0at();
        }
    }
}
