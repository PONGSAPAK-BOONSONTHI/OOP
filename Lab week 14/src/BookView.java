import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class BookView implements ActionListener, WindowListener{
    private JFrame fr;
    private JPanel pm, pt, pb, pb1, pb2;
    private JLabel lName, lPrice, lType;
    private JTextField tName, tPrice, tIndex;
    private JComboBox comBo;
    private JButton btnAdd, btnUp, btnDel, btnL, btnR;
    
    private ArrayList<Book> list_book = new ArrayList<>();
    private int index = -1;
    
    public BookView() {
        load();
        fr = new JFrame();
        
        lName = new JLabel("Name");
        lPrice = new JLabel("Price");
        lType = new JLabel("Type");
        
        tName = new JTextField();
        tPrice = new JTextField();
        
        String[] list = {"General", "Computer", "Math&Sci", "Photo3"};
        comBo = new JComboBox(list);
        
        pt = new JPanel(new GridLayout(3, 3));
        pt.add(lName); pt.add(tName);
        pt.add(lPrice); pt.add(tPrice);
        pt.add(lType); pt.add(comBo);
        
        tIndex = new JTextField("0");
        
        btnAdd = new JButton("App");
        btnUp = new JButton("Update");
        btnDel = new JButton("Delete");
        btnL = new JButton("<<<");
        btnR = new JButton(">>>");
        btnAdd.addActionListener(this);
        btnUp.addActionListener(this);
        btnDel.addActionListener(this);
        btnL.addActionListener(this);
        btnR.addActionListener(this);
        
        pb1 = new JPanel(new FlowLayout());
        pb1.add(btnL); pb1.add(tIndex); pb1.add(btnR);
        
        pb2 = new JPanel(new FlowLayout());
        pb2.add(btnAdd); pb2.add(btnUp); pb2.add(btnDel);        
        
        pb = new JPanel(new GridLayout(2, 1));
        pb.add(pb1); pb.add(pb2);
   
        pm = new JPanel(new BorderLayout());
        pm.add(pt, BorderLayout.CENTER); pm.add(pb, BorderLayout.SOUTH);
        
        fr.add(pm);
        fr.setSize(300, 200);
        fr.addWindowListener(this);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        if (!list_book.isEmpty()) {
            index = 0;
            displayBook();
        }
        
        fr.setVisible(true);
    }
    
    
    public void displayBook() {
        if (index >= 0 && index < list_book.size()) {
            Book b = list_book.get(index);
            tName.setText(b.getName());
            tPrice.setText(String.valueOf(b.getPrice()));
            comBo.setSelectedItem(b.getType());
            tIndex.setText(String.valueOf(index));
        } else {
            tName.setText("");
            tPrice.setText("");
            tIndex.setText("0");
        }
    }
    
    public void addBook(Book b) {
        list_book.add(b);
        index = list_book.size() - 1;
        displayBook();
    }
    
    private void load() {
        File file = new File("Book.data");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                list_book = (ArrayList<Book>) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private void save() {
        if (list_book.isEmpty()) return;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Book.data"))) {
            oos.writeObject(list_book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        new BookView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            new BookAdd(this);
        } else if (e.getSource() == btnUp) {
            if (index >= 0) {
                Book b = list_book.get(index);
                b.setName(tName.getText());
                b.setPrice(Double.parseDouble(tPrice.getText()));
                b.setType((String) comBo.getSelectedItem());
                JOptionPane.showMessageDialog(fr, "Done it.", "Updae Command", JOptionPane.PLAIN_MESSAGE);            
                
            }
        } else if (e.getSource() == btnDel) {
            if (index >=0 ) {
                list_book.remove(index);
                index = list_book.isEmpty() ? -1 : Math.max(0, index - 1);
                displayBook();
                JOptionPane.showMessageDialog(fr, "Done it.", "Delete Command", JOptionPane.PLAIN_MESSAGE);                        
            }
        } else if (e.getSource() == btnL) {
            if (index > 0) {
                index--; displayBook();
            }
        } else if (e.getSource() == btnR) {
            if (index < list_book.size() - 1) {
                index++; displayBook();
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) { save(); }

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
