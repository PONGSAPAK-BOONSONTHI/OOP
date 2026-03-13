import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class PoringConstructor {
    private JFrame fr;
    private JButton btn;

    public PoringConstructor() {
        fr = new JFrame();
        
        btn = new JButton("Add");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn) {
                    new Poring();
                }
            } 
        });
        
        fr.setLayout(new FlowLayout());
        fr.add(btn);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
    }
}

