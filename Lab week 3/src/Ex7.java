import java.util.*;
public class Ex7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0, n = 0;
        while (total < 1000) {            
            System.out.print("Enter deposit amount: ");
            int deposit = sc.nextInt();
            total += deposit;
            n += 1;
        }
        System.out.println("\nTarget reached!");
        System.out.println("Total amount saved = " + total);
        System.out.println("Number of deposits = " + n);
    }
}
