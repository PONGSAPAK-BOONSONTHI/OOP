import java.util.*;
public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, exc = 0, good = 0, fair = 0, poor = 0;
        System.out.print("Enter number of students: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter score for student " + (i + 1) + " : ");
            int score = sc.nextInt();
            if (score >= 80) {
                exc += 1;
                System.out.println("Excellent");
            } else if (score >= 60) {
                good += 1;
                System.out.println("Good");
            } else if (score >= 50) {
                fair += 1;
                System.out.println("Fair");
            } else {
                poor += 1;
                System.out.println("Poor");
            }
        }
        
        System.out.println("\nSummary :");
        System.out.println("Excellent : " + exc);
        System.out.println("Good : " + good);
        System.out.println("Fair : " + fair);
        System.out.println("Poor : " + poor);
    }
}
