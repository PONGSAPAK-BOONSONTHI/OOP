import java.util.*;
public class Ex5 {
    public static void main(String[] args) {
        Scanner input = new  Scanner(System.in);
        
        double tem, hum;
        
        System.out.print("Enter temperature (C): ");
        tem = input.nextDouble();
        System.out.print("Enter humidity (%): ");
        hum = input.nextDouble();
        
        if (tem > 37.5) {
            System.out.println("Warning: High temperature!");
        } else {
            System.out.println("Temperature normal.");
        }
        
        if (hum > 80) {
            System.out.println("Humidity is too high.");
        } else {
            System.out.println("Humidity is acceptable.");
        }
    }
}
