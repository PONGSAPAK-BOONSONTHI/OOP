import java.util.*;
public class SolutionFinder2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double cus;
        int stamp;
        System.out.print("Total Price : ");
        cus =  sc.nextDouble();
        stamp = (int)cus / 50;
        System.out.println("You got " + stamp + " stamp(s)");
    }
}
