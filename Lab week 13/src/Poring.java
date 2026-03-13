import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Poring {
    private JFrame fr;
    private JLabel lb_img, lb_count;
    private ImageIcon poring;
    private static ArrayList<Poring> countPorings = new ArrayList<>();
    
    public Poring() {
        countPorings.add(this);
        fr = new JFrame();
        
        poring = new ImageIcon("src/poring.png");
        lb_img = new JLabel(poring);
        lb_count = new JLabel(String.valueOf(countPorings.size()));
        
        lb_img.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                countPorings.remove(Poring.this);
                fr.dispose();
                update();
            }
        });
        
        fr.setLayout(new FlowLayout());
        fr.add(lb_img);
        fr.add(lb_count);
        
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
        
        update();
    }
    
    public static void update() {
        int count = countPorings.size();
        for (Poring p : countPorings) {
            if (p.lb_count != null) {
                p.lb_count.setText(String.valueOf(count));
            }
        }        
    }
}
