import java.util.*;
public class Ex4 {
    public static void main(String[] args) {
        Scanner input = new  Scanner(System.in);
        
        double GPA;
        int money;
        
        System.out.print("Enter GPA: ");
        GPA = input.nextDouble();
        System.out.print("Enter family income: ");
        money = input.nextInt();
        
        if (GPA >= 3.5) {
            if (money <= 15000) {
                System.out.println("you are eligible for the scholarship.");
            } else {
                System.out.println("You are not eligible for a scholarship.");                
            }
        } else {
            System.out.println("You are not eligible for a scholarship.");
        }
        
    }
}
