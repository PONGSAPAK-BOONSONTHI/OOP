import java.util.*;
public class Calculate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 9, b = 4, c, d;        
        c = b++ * ++a; // 4 * (1+5) bf b = 4 + 1
        d = ++b * a++; // (1+5) * 10 bg a = 10 + 11
        System.out.println("A is " + a);
        System.out.println("B is " + b);
        System.out.println("C is " + c);
        System.out.println("D is " + d);
        
        int num1, num2 = 6;
        System.out.print("Enter value ");
        num1 = sc.nextInt();
        num1 = num1 + 2;
        num2 = num1 / num2;
        System.out.println("result = " + num2);
    }
}
