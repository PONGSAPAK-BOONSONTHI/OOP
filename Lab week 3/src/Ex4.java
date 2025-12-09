import java.util.*;
public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n;
        String Fnum = "";
        System.out.print("Enter number of digits: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter digit " + (i + 1) +": ");
            String num = sc.next();
            Fnum += num;
        }
        System.out.println("Final Code = " + Fnum);
    }
}
