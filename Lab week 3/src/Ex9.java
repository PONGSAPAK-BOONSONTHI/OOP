import java.util.*;
public class Ex9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please insert a number : ");
        int n = sc.nextInt();
        
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0) {
                if (i == n) {
                    System.out.println("/");
                } else {
                    System.out.print("/");
                }
            } else {
                if (i == n) {
                    System.out.println("|");
                } else {
                    System.out.print("|");
                }
            }
        }
    }
}
