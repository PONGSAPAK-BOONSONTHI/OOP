import java.awt.event.*;
import javax.swing.*;

public class MyFrame {
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        
        MyClock clock = new MyClock();
        Thread t = new Thread(clock);
        t.start();
        
        fr.add(clock);
        fr.pack();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }
}
