import javax.swing.*;
import java.awt.*;

public class CalculatorTwoGUI {
    private JFrame fr;
    private JPanel panel1;
    private JTextField txt1;
    private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPlus, btnMinus, btnMul, btnDiv, btnEqual, btnC;
    
    public CalculatorTwoGUI() {
        fr = new JFrame("My Calculator");
        
        txt1 = new JTextField();
        
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
                    
        fr.setLayout(new BorderLayout());
        fr.add(txt1, BorderLayout.NORTH);
        fr.add(panel1, BorderLayout.CENTER);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300, 300);
        fr.setVisible(true);
        
        
    }
}
