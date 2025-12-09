import java.util.*;
public class Ex8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        while (true) {
            System.out.print("Enter a number (-1 to stop): ");
            int num = sc.nextInt();
            if (num == -1) {
                if ((maximum == Integer.MIN_VALUE) && (minimum == Integer.MAX_VALUE)) {
                    System.out.println("No numbers were entered.");
                } else {
                    break;
                }
            }
            if ((num > maximum) && (num != -1)) { maximum = num; }
            if ((num < minimum) && (num != -1)) { minimum = num; }
        }
        System.out.println("Maximum = " + maximum);
        System.out.println("Minimum = " + minimum);
    }
}
