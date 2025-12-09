import java.util.*;
public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int total = 0, n, paid;
        System.out.print("Enter number of items: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter price for item " + (i + 1) + ": ");
            int num = sc.nextInt();
            total += num;
        }
        System.out.println("Total = " + total + "\n");
        System.out.print("Enter amount paid: ");
        paid = sc.nextInt();
        System.out.println("Change = " + (paid - total));
    }
}
