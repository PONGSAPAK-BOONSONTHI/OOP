import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

public class ChatDemo implements ActionListener {
    private JFrame fr;
    private JPanel panelMain, panalbtn;
    private JTextArea textArea;
    private JTextField textField;
    private JButton btnSub;
    private PrintWriter out;
    private String username, serverIP;

    public ChatDemo(String username, String ip) {
        this.username = username;
        this.serverIP = ip;
        
        fr = new JFrame("Chat - " + username);
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        textField = new JTextField();
        textField.addActionListener(this);
        
        btnSub = new JButton("Submit");
        btnSub.addActionListener(this);
        
        panalbtn = new JPanel(new BorderLayout());
        panalbtn.add(btnSub, BorderLayout.SOUTH);
        
        panelMain = new JPanel(new GridLayout(2, 1));
        panelMain.add(textField);
        panelMain.add(panalbtn);
        
        fr.setLayout(new BorderLayout());
        fr.add(scrollPane, BorderLayout.CENTER);
        fr.add(panelMain, BorderLayout.SOUTH);
        
        fr.setSize(500, 400);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);

        connectToServer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = textField.getText().trim();
        if (!msg.isEmpty() && out != null) {
            out.println(msg);
            textField.setText("");
        }
    }

    private void connectToServer() {
        new Thread(() -> {
            try {
                Socket socket = new Socket(serverIP, 8888);
                out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                out.println(username);

                String msg;
                while ((msg = in.readLine()) != null) {
                    if (msg.startsWith("COMMAND_RESET")) {
                        textArea.setText("");
                    } else {
                        textArea.append(msg + "\n");
                        textArea.setCaretPosition(textArea.getDocument().getLength());
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Connection Lost!");
                System.exit(0);
            }
        }).start();
    }
}
