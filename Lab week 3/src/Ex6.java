import java.util.*;
public class Ex6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = "", textCon = "";
        while (true) {
            System.out.print("Enter a character: ");
            char c = sc.next().charAt(0);
            if (c == 'z') {break;}
            if ((c >= 'a') && (c <= 'y')) {
                if (!(c == 'a' | c == 'e' | c == 'i' | c == 'o' | c == 'u')) {
                    textCon += c;
                }
                text += c;
            } else {
                System.out.println("Invalid input. Only lowercase a-z are allowed.");
            }
        }
        System.out.println("All characters entered: " + text);
        System.out.println("Consonants only: " + textCon);
        
    }
}
