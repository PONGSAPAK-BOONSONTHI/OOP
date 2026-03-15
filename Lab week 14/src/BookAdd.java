import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BookAdd implements ActionListener {
    private JFrame fr;
    private JPanel pm, pt, pb;
    private JLabel lName, lPrice, lType;
    private JTextField tName, tPrice, tIndex;
    private JComboBox comBo;
    private JButton btnIn;
    private BookView bookView;
    
    private Book book;
    
    public BookAdd(BookView bookView) {
        this.bookView = bookView;
        fr = new JFrame();
        
        lName = new JLabel("Name");
        lPrice = new JLabel("Price");
        lType = new JLabel("Type");
        
        tName = new JTextField();
        tPrice = new JTextField();
        
        String[] list = {"General", "Computer", "Math&Sci", "Pho"};
        comBo = new JComboBox(list);
        
        pt = new JPanel(new GridLayout(3, 3));
        pt.add(lName); pt.add(tName);
        pt.add(lPrice); pt.add(tPrice);
        pt.add(lType); pt.add(comBo);
        
        btnIn = new JButton("Insert");
        btnIn.addActionListener(this);
        
        pb = new JPanel();
        pb.add(btnIn);
        
        pm = new JPanel(new BorderLayout());
        pm.add(pt, BorderLayout.CENTER); pm.add(pb, BorderLayout.SOUTH);
        
        fr.add(pm);
        fr.setSize(300, 150);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setVisible(true);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIn) {
            String name = tName.getText();
            double price = Double.parseDouble(tPrice.getText());
            String type = (String) comBo.getSelectedItem();

            Book newBook = new Book(name, price, type);
            bookView.addBook(newBook);

            JOptionPane.showMessageDialog(fr, "Done it.", "", JOptionPane.PLAIN_MESSAGE);  
            fr.dispose();
        }
    }
    
}
