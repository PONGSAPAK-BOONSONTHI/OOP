import java.util.*;
public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pw = "PASS2025", input_pw;
        while (true) {
            System.out.print("Enter password: ");
            input_pw = sc.next();
            
            if (input_pw.equals(pw)) {
                System.out.println("Access granted.");
                break;
            } else {
                System.out.println("Try again.");
            }
        }
    }
}
