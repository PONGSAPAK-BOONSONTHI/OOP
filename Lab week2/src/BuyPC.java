import java.util.*;
public class BuyPC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double pc = 375.99, size, DVD_CD, printer, result = 0;
        result += pc;

        System.out.println("please insert your monitor size 38 or 43 only");
        size = sc.nextInt();
        if (size == 38) {result += 75.99;}
        else if (size == 43) {result += 99.99;}
        
        System.out.println("Do you want DVD-ROM? 1 is Yes / 0 is No");
        DVD_CD = sc.nextDouble();
        if (DVD_CD == 1) {result += 65.99;}
        System.out.println("Do you want printer? 1 is Yes / 0 is No");
        printer = sc.nextDouble();
        if (printer == 1) {result += 125.00;}
        
        System.out.println("=======Your order=======");
        System.out.println("* computer >>> " + pc);
        if (size == 38) {System.out.println("* 38'Monitor >>> 75.99");}
        else if (size == 43) {System.out.println("* 43'Monitor >>> 99.99");}
        if (DVD_CD == 1) {System.out.println("* DVD-Rom >>> 65.99");}
        if (printer == 1) {System.out.println("* Printer >>> 125.00");}
        System.out.println("=======Total price >>> "+ result + " =======");

    }
}
