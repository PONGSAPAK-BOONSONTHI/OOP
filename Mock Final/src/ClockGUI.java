
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.*;
import javax.swing.*;

public class ClockGUI implements Runnable, ActionListener {
    private JFrame fr;
    private  JPanel pm, pt, pt1, pt2, pb;
    private JLabel laDay, laTime;
    private JTextField textField;
    private JButton btnSave;
    
    public ClockGUI() {
        fr = new JFrame("Clock");
        
        laDay = new JLabel("0000/00/00");
        laDay.setFont(new Font("Tahoma", Font.PLAIN, 26));
        laTime = new JLabel("00:00:00");
        laTime.setFont(new Font("Tahoma", Font.BOLD, 56)); // ***
        
        pt1 = new JPanel(new FlowLayout());
        pt1.add(laDay);
        pt2 = new JPanel(new FlowLayout());
        pt2.add(laTime);
        
        pt = new JPanel(new GridLayout(2, 1));
        pt.add(pt1); pt.add(pt2);
        
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(330, 30)); // ***
        btnSave = new JButton("Save");
        btnSave.addActionListener(this);
                
        pb = new JPanel(new FlowLayout());
        pb.add(textField); pb.add(btnSave);
        
        pm = new JPanel(new BorderLayout());
        pm.add(pt, BorderLayout.CENTER); pm.add(pb, BorderLayout.SOUTH);
        
        fr.add(pm);
        fr.setSize(450, 260);
        fr.setLocationRelativeTo(null); // ***
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
        
        Thread t = new Thread(this); // ***
        t.start(); // ***
    }
    public static void main(String[] args) {
        new ClockGUI();
        new LogsGUI();
    }
    
    private void saveData() {
        if (textField.getText().equals("")) {
            return;
        }
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("logs.txt", true))) { // ***
            String log = (laDay.getText() + " " + laTime.getText() + " " + textField.getText());
            bw.write(log + "\n");
            textField.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            saveData();      
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (this) {
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

                    LocalDateTime now = LocalDateTime.now();

                    String data = now.format(dateTimeFormatter);
                    String time = now.format(timeFormatter);
                    
                    this.laDay.setText(data);
                    this.laTime.setText(time);
                    
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
