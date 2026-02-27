import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import javax.swing.*;

public class TurnBasedServer implements ActionListener {
    private static final List<Handler> clients = new CopyOnWriteArrayList<>();
    private static int currentTurnIndex = 0; 
    private static final String HISTORY_FILE = "ChatHistory.dat";

    private JFrame fr;
    private JButton btnRe;

    public TurnBasedServer() {
        fr = new JFrame("TurnBasedServer Control");
        btnRe = new JButton("RESET CHAT");
        btnRe.addActionListener(this);
        fr.add(btnRe, BorderLayout.CENTER);
        fr.setSize(300, 150);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Port ");
        int post = input.nextInt();

        new TurnBasedServer();
        System.out.println("Server Started on Port " + post);
        ServerSocket listener = new ServerSocket(post);

        try {
            while (true) {
                Socket socket = listener.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } finally {
            listener.close();
        }
    }

    private static synchronized void broadcast(String message) {
        for (Handler h : clients) {
            h.out.println(message);
        }
        if (!message.contains("TURN:")) {
            saveToFile(message);
        }
    }

    private static void saveToFile(String message) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(HISTORY_FILE, true))) {
            pw.println(message);
        } catch (IOException e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRe) {
            resetChat();
        }
    }

    private void resetChat() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(HISTORY_FILE, false))) {
            pw.print("");
        } catch (IOException e) {}
        broadcast("COMMAND_RESET");
        broadcast("SYSTEM: Chat history reset by Server.");
    }

    private static class Handler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private String clientName;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                this.clientName = in.readLine();
                clients.add(this);
                
                sendHistoryToClient(out);
                broadcast("SYSTEM: " + clientName + " joined the chat.");
                System.out.println(clientName + " joined the chat.");
                updateTurnInfo();
                
                String message;
                while ((message = in.readLine()) != null) {
                    if (clients.indexOf(this) == currentTurnIndex) {
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
                        String time = dtf.format(LocalDateTime.now());
                        
                        broadcast("[" + time + "] " + clientName + ": " + message);
                        
                        currentTurnIndex = (currentTurnIndex + 1) % clients.size();
                        updateTurnInfo();
                    } else {
                        out.println("SYSTEM: Wait for your turn!");
                    }
                }
            } catch (IOException e) {
                System.out.println(clientName + " disconnected.");
            } finally {
                clients.remove(this);
                if (clients.size() > 0) {
                    currentTurnIndex %= clients.size();
                }
                updateTurnInfo();
                broadcast("SYSTEM: " + clientName + " left.");
            }
        }

        private void updateTurnInfo() {
            if (!clients.isEmpty()) {
                String currentName = clients.get(currentTurnIndex).clientName;
                broadcast("Current Turn: " + currentName);
            }
        }

        private void sendHistoryToClient(PrintWriter clientOut) {
            File file = new File(HISTORY_FILE);
            if (file.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        clientOut.println(line);
                    }
                } catch (IOException e) {}
            }
        }
    }
}
