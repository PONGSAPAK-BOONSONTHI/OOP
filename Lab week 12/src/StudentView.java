import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;

public class StudentView implements ActionListener, WindowListener {
    private JFrame fr;
    private JPanel panel;
    private JLabel l_id, l_name, l_money;
    private JTextField txt_id, txt_name, txt_money;
    private JButton btn_dep, btn_with;
    private Student stu;
    
    public StudentView() {
        loadData();
        fr = new JFrame();
        fr.addWindowListener(this);
        
        l_id = new JLabel("ID :");
        l_name = new JLabel("Name:");
        l_money = new JLabel("Money:");
        Font boldFont = new Font("SansSerif", Font.BOLD, 14);
        l_id.setFont(boldFont);
        l_name.setFont(boldFont);
        l_money.setFont(boldFont);
        EmptyBorder emptyBorder = new EmptyBorder(0, 10, 0, 0);
        l_id.setBorder(emptyBorder);
        l_name.setBorder(emptyBorder);
        l_money.setBorder(emptyBorder);

        
        txt_id = new JTextField(String.valueOf(stu.getID()));
        txt_name = new JTextField(stu.getName());
        txt_money = new JTextField(String.valueOf(stu.getMoney()));
        txt_money.setEditable(false);
        
        btn_dep = new JButton("Deposit");
        btn_with = new JButton("Withdraw");
        btn_dep.addActionListener(this);
        btn_with.addActionListener(this);
        
        fr.setLayout(new GridLayout(4, 2));
        fr.add(l_id); fr.add(txt_id);
        fr.add(l_name); fr.add(txt_name);
        fr.add(l_money); fr.add(txt_money);
        fr.add(btn_dep); fr.add(btn_with);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300, 200);
        fr.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_dep) {
            stu.setMoney(stu.getMoney() + 100);
        } else if (e.getSource() == btn_with) {
            stu.setMoney(stu.getMoney() - 100);
        }
        txt_money.setText(String.valueOf(stu.getMoney()));
    }
    
    private void saveData() {
        try (FileOutputStream fout = new FileOutputStream("StudentM.dat");
                ObjectOutputStream oout = new ObjectOutputStream(fout)) {
            oout.writeObject(stu);
            System.out.println("Save Data");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    private void loadData() {
        File file = new File("StudentM.dat");
        if (file.exists()) {
            try (FileInputStream fin = new FileInputStream(file);
                    ObjectInputStream oin = new ObjectInputStream(fin)) {
                stu = (Student) oin.readObject();
                System.out.println("Load Data");
            } catch (Exception e) {
                stu = new Student();
            }
        } else {
            stu = new Student();
        }
    }
    

    @Override
    public void windowClosing(WindowEvent e) {
        stu.setID(Integer.parseInt(txt_id.getText()));
        stu.setName(txt_name.getText());
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
