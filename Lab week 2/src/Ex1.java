import java.util.*;
public class Ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("input : ");
        double tax = input.nextDouble();
        double result;
        if (tax > 50000) {
            result = tax * 0.1;
        } else {
            result = tax * 0.05;
        }
        
        System.out.println("result : " + result);
        
    }
}
