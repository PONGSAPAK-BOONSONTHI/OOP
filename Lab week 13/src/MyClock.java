
import java.awt.Font;
import java.util.Calendar;
import javax.swing.*;

public class MyClock extends JLabel implements Runnable {

    public MyClock() {
        this.setFont(new Font("Tahoma", Font.BOLD, 56));
    }

    @Override
    public void run() {
        while (true) {
            try {
                Calendar c = Calendar.getInstance();
                int sec = c.get(Calendar.SECOND);
                int min = c.get(Calendar.MINUTE);
                int hour = c.get(Calendar.HOUR_OF_DAY);

                String timeText = String.format("%02d:%02d:%02d", hour, min, sec);

                this.setText(timeText);

                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

}
