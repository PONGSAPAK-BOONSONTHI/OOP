import java.util.*;
public class Ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input your money : ");
        double money = input.nextDouble();
        char ac = input.next().charAt(0);
        
        double interest = 0, result;
        switch (ac) {
            case 'A' -> interest = money * 0.015;
            case 'B' -> interest = money * 0.02;
            case 'C' -> interest = money * 0.015;
            case 'X' -> interest = money * 0.05;
        }
        result = money + interest;
        System.out.println("Your total money in one year = " + (int)result);
    }
}
