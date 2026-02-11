import javax.swing.*;
import java.awt.*;

public class CalculatorOneGUI {
    private JFrame fr;
    private JPanel panel1;
    private JTextField txt1, txt2, txt3;
    private JButton btnPlus, btnMinus, btnMul, btnDiv;

    public CalculatorOneGUI() {
        fr = new JFrame("Calculator");
        
        txt1 = new JTextField();
        txt2 = new JTextField();
        txt3 = new JTextField();
        
        btnPlus = new JButton("+");
        btnMinus = new JButton("-");
        btnMul = new JButton("*");
        btnDiv = new JButton("/");

        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel1.add(btnPlus);
        panel1.add(btnMinus);
        panel1.add(btnMul);
        panel1.add(btnDiv);
        
        fr.setLayout(new GridLayout(4, 1));
        fr.add(txt1);
        fr.add(txt2);
        fr.add(panel1);
        fr.add(txt3);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300, 200);
        fr.setVisible(true);
    }
}
