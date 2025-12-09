import java.util.*;
public class Ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input your money : ");
        double money = input.nextDouble();
        System.out.print("Input your account type(Please type A B C or X in uppercase) : ");
        char ac = input.next().charAt(0);
        
        double interest = 0, result;
        switch (ac) {
            case 'A':
                interest = money * 0.015;
                break;
            case 'B':
                interest = money * 0.02;
                break;
            case 'C':
                interest = money * 0.015;
                break;
            case 'X': 
                interest = money * 0.05;
                break;
        }
        
        result = money + interest;
        System.out.println("Your total money in one year = " + (int)result);
    }
}
