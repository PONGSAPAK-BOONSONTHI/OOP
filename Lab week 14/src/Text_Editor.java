
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Text_Editor implements ActionListener {
    private JFrame fr;
    private JLabel la;
    private JTextArea tArea;
    private JMenuBar mbar;
    private JMenu menu;
    private JMenuItem m1, m2, m3, m4;
    
    public Text_Editor() {
        fr = new JFrame("My Text Editor");
        
        m1 = new JMenuItem("New");
        m2 = new JMenuItem("Open");
        m3 = new JMenuItem("Save");
        m4 = new JMenuItem("Close");
        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        m4.addActionListener(this);
        
        
        menu = new JMenu("File");
        menu.add(m1);
        menu.add(m2);
        menu.add(m3);
        menu.addSeparator();
        menu.add(m4);
        
        mbar = new JMenuBar();
        fr.setJMenuBar(mbar); //*******
        mbar.add(menu);
        
        tArea = new JTextArea();
        fr.add(tArea);
        
        fr.setSize(500, 400);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }
    
    private void load(File f) {
        if (f.exists()) {
            try (BufferedReader bf = new BufferedReader(new FileReader(f))) {
                String line;
                while ((line = bf.readLine()) != null) {
                    tArea.append(line + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private void save(File f) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(f))) {
            pw.print(tArea.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    public static void main(String[] args) {
//        new Text_Editor();
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == m1) {
            tArea.setText("");
        } else if (e.getSource() == m2) {
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(fr);
            File f = fc.getSelectedFile();
            load(f);
        } else if (e.getSource() == m3) {
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(fr);
            File f = fc.getSelectedFile();
            save(f);
        } else if (e.getSource() == m4) {
            fr.dispose();
        }
    }
}
