import java.util.*;
public class TImeExercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h, m, s;
        System.out.print("Enter your exercise time 1: ");
        int time1 = sc.nextInt();
        System.out.print("Enter your exercise time 2: ");
        int time2 = sc.nextInt();
        s = time1 + time2;
        h = s / 3600;
        s %= 3600;
        m = s / 60;
        s %= 60;
        System.out.println("It is " + h + " hours " + m + " minutes and " + s + " seconds.");
    }
}
