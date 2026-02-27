import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatDemo implements ActionListener, WindowListener {
    private JFrame fr;
    private JPanel panelMain, panalbtn;
    private JTextArea textArea;
    private JTextField textField;
    private JButton btnSub, btnRe;
    
    public ChatDemo() {
        fr = new JFrame();
        
        textArea = new JTextArea();
        textArea.setSize(45, 20);
        textArea.setEditable(false);
        
        textField = new JTextField();
        textField.setSize(45, 0);
        
        btnSub = new JButton("Submit");
        btnRe = new JButton("Reset");
        btnSub.addActionListener(this);
        btnRe.addActionListener(this);
        
        panalbtn = new JPanel();
        panalbtn.setLayout(new FlowLayout());
        panalbtn.add(btnSub);
        panalbtn.add(btnRe);
        
        
        panelMain = new JPanel();
        panelMain.setLayout(new GridLayout(2, 1));
        panelMain.add(textField);
        panelMain.add(panalbtn);
        
        loadData();
        
        fr.setLayout(new BorderLayout());
        fr.add(textArea, BorderLayout.CENTER);
        fr.add(panelMain, BorderLayout.SOUTH);
        
        fr.addWindowListener(this);
                
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(500, 400);
        fr.setVisible(true);
    }
    
    private void saveData() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("ChatDemo.dat"))) {
            pw.print(textArea.getText());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    private void loadData() {
        File file = new File("ChatDemo.dat");
        if (file.exists()) {
            try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = bf.readLine()) != null) {                    
                    textArea.append(line + "\n");
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSub) {
            if (!"".equals(textField.getText())) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                String time = dtf.format(LocalDateTime.now());   

                textArea.append(time + ": " + textField.getText() + "\n");
                textField.setText("");  
            }

        } else if (e.getSource() == btnRe) {
            textArea.setText("");
        }
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        saveData();
    }
    
    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {} 
}
