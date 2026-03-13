import java.awt.event.*;
import javax.swing.*;

public class MyFrame2 {
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        
        MyClock2 clock = new MyClock2();
        Thread t = new Thread(clock);
        t.start();
        
        clock.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clock.fn_stop();
            }
            
        });
        
        fr.add(clock);
        fr.pack();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }
}
