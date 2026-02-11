import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TellerGUI implements ActionListener {
    private JFrame fr;
    private JPanel panel1, panel2;
    private JLabel txtBal, txtAmo;
    private JTextField txt1, txt2;
    private JButton btnDep, btnWith, btnExit;
    private Account myAcc;
    private double amount;
    public TellerGUI() {
        myAcc = new Account(6000, "user");
        
        fr = new JFrame("Teller GUI");
        
        txtBal = new JLabel("   Balance");
        txtAmo = new JLabel("   Amount");
        txtBal.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtAmo.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        txt1 = new JTextField(String.valueOf(myAcc.getBalance()));
        txt1.setEditable(false);
        txt2 = new JTextField();
        
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 2));
        panel1.add(txtBal);
        panel1.add(txt1);
        panel1.add(txtAmo);
        panel1.add(txt2);
        
        btnDep = new JButton("Deposit");
        btnWith = new JButton("Withdraw");
        btnExit = new JButton("Exit");
        
        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.add(btnDep);
        panel2.add(btnWith);
        panel2.add(btnExit);
        
        // addActionListener
        btnDep.addActionListener(this);
        btnWith.addActionListener(this);
        btnExit.addActionListener(this);
        
        fr.setLayout(new GridLayout(2, 1));
        fr.add(panel1);
        fr.add(panel2);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300, 200);
        fr.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnExit) {
            System.exit(0);
            return;
        }
        amount = Double.parseDouble(txt2.getText());
        if (e.getSource() == btnWith) {
            myAcc.withdraw(amount);
        } else if (e.getSource() == btnDep) {
            myAcc.deposit(amount);
        }
        txt1.setText(String.valueOf(myAcc.getBalance()));
        txt2.setText("");
    }
}
