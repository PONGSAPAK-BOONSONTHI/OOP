package Ex2;

public class Pigeon extends Bird{
    private static int numberOfPigeon;
    
    public Pigeon() {
        super(0.0, 0.0, 0.0 );
        numberOfPigeon += 1;
    }
    private Pigeon(double wingSize, double weight, double height) {
        super(wingSize, weight, height);
        numberOfPigeon += 1;
    }
    public void eat(String food) {
        if (food.equals("worm")) {
            eat(0.5);
        } else if (food.equals("seed")) {
            eat(0.2);
        } else {
            System.out.println("Pigeon can eat only worm and seed.");
        }
    }
    @Override
    public String toString() {
        return "Pigeon " + getWeight() + " kg and " + getHeight() + " cm. There are " + numberOfPigeon + " pigeons.";
    }
    @Override
    public void fly() {
        if (getWeight() < 4) {
            System.out.println("I'm hungry.");
            return;
        }
        setWeight(getWeight() - 0.25);        
        System.out.println("Fly Fly");
    }
    @Override
    public void takeOff() {
        if (getWeight() < 4) {
            System.out.println("I'm hungry.");
            return;
        }
        setWeight(getWeight() - 0.5);        
        System.out.println("Take Off");
    }
    @Override
    public void landing() {
        if (getWeight() < 4) {
            System.out.println("I'm hungry.");
            return;
        }
        setWeight(getWeight() - 0.5);             
        System.out.println("Landing");
    }
}
