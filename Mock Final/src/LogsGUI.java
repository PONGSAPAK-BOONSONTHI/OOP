
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class LogsGUI implements ActionListener, Runnable {
    private JFrame fr;
    private JPanel pm, pb;
    private JTextArea textArea;
    private JLabel laTotal;
    private JButton btnClear;
    private int Total = 0;
    public LogsGUI() {
        fr = new JFrame("Logs Wimdow");
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        
        laTotal = new JLabel("Total Logs: ");
        btnClear = new JButton("Clear Logs");
        btnClear.addActionListener(this);
        
        pb = new JPanel(new BorderLayout());
        pb.add(laTotal, BorderLayout.NORTH); pb.add(btnClear, BorderLayout.EAST);
        
        pm = new JPanel(new BorderLayout());
        pm.add(textArea, BorderLayout.CENTER); pm.add(pb, BorderLayout.SOUTH);
                
        fr.add(pm);
        fr.setSize(400, 300);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setVisible(true);
        
        Thread t = new Thread(this);
        t.start();
    }
    
    public void ClearData() { // ***
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("logs.txt", false))) {
            textArea.setText("");
            Total = 0;
            laTotal.setText("Total Logs: " + Total);            
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
    
    public void loadData() { // ***
        File f = new File("logs.txt");
        if (f.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                textArea.setText("");
                Total = 0;
                laTotal.setText("Total Logs " + Total);                
                String line;
                while ((line = br.readLine()) != null) { // ***            
                    textArea.append(line + "\n");
                    Total += 1;
                    laTotal.setText("Total Logs " + Total);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() ==  btnClear) {
            ClearData();
        }
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    loadData();
                    Thread.sleep(1000);      
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
