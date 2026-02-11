import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorSample implements ActionListener{
    private JFrame fr;
    private JPanel panel1;
    private JTextField txt1;
    private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPlus, btnMinus, btnMul, btnDiv, btnEqual, btnC;
    private String command;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;    
    
    public CalculatorSample() {
        fr = new JFrame("My Calculator");
        
        txt1 = new JTextField();
        txt1.setEditable(false);
        
        btn0 = new JButton("0");        
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btnPlus = new JButton("+");
        btnMinus = new JButton("-");
        btnMul = new JButton("X");
        btnDiv = new JButton("/");
        btnEqual = new JButton("=");
        btnC = new JButton("C");
        
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4, 4));
        panel1.add(btn7);
        panel1.add(btn8);
        panel1.add(btn9);
        panel1.add(btnPlus);
        panel1.add(btn4);
        panel1.add(btn5);
        panel1.add(btn6);
        panel1.add(btnMinus);
        panel1.add(btn1);
        panel1.add(btn2);
        panel1.add(btn3);
        panel1.add(btnMul);  
        panel1.add(btn0);
        panel1.add(btnC);
        panel1.add(btnEqual);
        panel1.add(btnDiv);
        
        // addActionListener
        btn0.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btnPlus.addActionListener(this);
        btnMinus.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);
        btnEqual.addActionListener(this);
        btnC.addActionListener(this);
                    
        fr.setLayout(new BorderLayout());
        fr.add(txt1, BorderLayout.NORTH);
        fr.add(panel1, BorderLayout.CENTER);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300, 300);
        fr.setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        command = e.getActionCommand();
        if ((command.charAt(0) >= '0') && (command.charAt(0) <= '9')) {
            txt1.setText(txt1.getText() + command);
        } else if (command.equals("C")) {
            txt1.setText("");
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(txt1.getText());
            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case 'X' -> result = num1 * num2;
                case '/' -> {
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        txt1.setText("Error");
                        return;
                    }
                }
            }
            txt1.setText(String.valueOf(result));
            num1 = result;
        } else {
            num1 = Double.parseDouble(txt1.getText());
            operator = command.charAt(0);
            txt1.setText("");
        }
    }
}
