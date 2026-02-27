import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login implements ActionListener {
    private JFrame frame;
    private JTextField txtIP, txtName;
    private JButton btnConnect;

    public Login() {
        frame = new JFrame("Login to Chat");
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);

        txtIP = new JTextField("127.0.0.1", 15);
        txtName = new JTextField("", 15);
        btnConnect = new JButton("Connect");
        btnConnect.addActionListener(this);

        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(new JLabel("Server IP:"), gbc);
        gbc.gridx = 1;
        frame.add(txtIP, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(new JLabel("Your Name:"), gbc);
        gbc.gridx = 1;
        frame.add(txtName, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        frame.add(btnConnect, gbc);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ip = txtIP.getText().trim();
        String name = txtName.getText().trim();
        
        if (!ip.isEmpty() && !name.isEmpty()) {
            frame.dispose();
            new ChatDemo(name, ip);
        } else {
            JOptionPane.showMessageDialog(frame, "Please fill in all fields!");
        }
    }
}
