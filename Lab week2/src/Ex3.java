import java.util.*;
public class Ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String name;
        int age, numDay1, numDay2;  
        double weight, salary = 0, salaryBonus = 0;
        
        System.out.print("Please insert your name : ");
        name = input.next();
        System.out.print("Please insert your age : ");
        age = input.nextInt();
        System.out.print("Please insert number of working days : ");
        numDay1 = input.nextInt();
        System.out.print("Please insert number of absent days : ");
        numDay2 = input.nextInt();
        System.out.print("Please insert your body weight : ");
        weight = input.nextDouble();
        
        if (age >= 21 && age <= 30) {
            salary = (numDay1 * 300) - (numDay2 * 50);
        } else if (age >= 31 && age <= 40) {
            salary = (numDay2 * 500) - (numDay1 * 50);
        } else if (age >= 41 && age <= 50) {
            salary = (numDay2 * 1000) - (numDay1 * 25);
        } else if (age >= 51 && age <= 60) {
            salary = (numDay2 * 3000);
        }
        
        if (weight >= 10 && weight <= 60) {
            salaryBonus = salary + 5000 ;
        } else if (weight >= 61 && weight <= 90) {
            salaryBonus = salary + (5000 - ((weight - 60) * 10));
        }
        
        System.out.println("Hi, " + name);
        System.out.println("Your salary is " + (int)salary + " Baht");
        System.out.println("Your salary and bonus is " + (int)salaryBonus +" Baht");
    }
}
