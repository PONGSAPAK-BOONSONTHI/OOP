

import java.util.*;
public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyAdd cm = new MyAdd();

        System.out.println("Please insert number : ");
        int x = sc.nextInt();

        int num = cm.AddTwo(x);
        System.out.println("The result#1 is " + num);

        num = cm.AddTwo(x + 5);
        System.out.println("The result#2 is " + num);

        num = cm.AddTwo(x * 3 + 2);
        System.out.println("The result#3 is " + num);
    }
}
class MyAdd {
    public int AddTwo(int a) {
        return a + 2;
    }
}