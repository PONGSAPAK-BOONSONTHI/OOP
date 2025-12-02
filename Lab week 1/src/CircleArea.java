import java.util.*;
public class CircleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double area = Math.PI;
        double radius = sc.nextDouble();
        double result = Math.pow(radius, 2) * area;
        System.out.println("result : " + result);
 
    }
}
