import javax.swing.*;
import java.awt.*;

public class MDIFromGUI {
    private JFrame fr;
    private JDesktopPane dp;
    private JMenuBar mb;
    private JMenu m1, m2, m3, ms1;
    private JMenuItem mi1, mi2, mi3, mis1 ,mis2;
    private JInternalFrame f1, f2, f3;
    public MDIFromGUI() {
        fr = new JFrame("SubMenuItem Demo");
        
        mb = new JMenuBar();
        m1 = new JMenu("File");
        m2 = new JMenu("Edie");
        m3 = new JMenu("View");
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        
        ms1 = new JMenu("New");
        mi1 = new JMenuItem("Open");
        mi2 = new JMenuItem("Save");
        mi3 = new JMenuItem("Exit"); 
        m1.add(ms1); 
        m1.add(mi1); 
        m1.add(mi2); 
        m1.addSeparator(); 
        m1.add(mi3);
        
        mis1 = new JMenuItem("Window");
        mis2 = new JMenuItem("Message");
        ms1.add(mis1);
        ms1.add(mis2);
        
        dp = new JDesktopPane();
        dp.setBackground(Color.BLACK);
        
        f1 = new JInternalFrame("Application 01", true, true, true, true);
        f1.setSize(250, 150);
        f1.setLocation(50, 350);
        f1.setVisible(true);
        
        f2 = new JInternalFrame("Application 02", true, true, true, true);
        f2.setSize(200, 150);
        f2.setLocation(250, 150);
        f2.setVisible(true);

        f3 = new JInternalFrame("Application 03", true, true, true, true);
        f3.setSize(350, 200);
        f3.setLocation(500, 230);
        f3.setVisible(true);        
        
        dp.add(f1);
        dp.add(f2);
        dp.add(f3);
        
        fr.setJMenuBar(mb);
        fr.add(dp);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(900, 600);
        fr.setVisible(true);
    }
}
