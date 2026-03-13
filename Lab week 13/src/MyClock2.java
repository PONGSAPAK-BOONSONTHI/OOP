
import java.awt.Font;
import java.util.Calendar;
import javax.swing.*;

public class MyClock2 extends JLabel implements Runnable {
    private int sec_run = 0;
    private boolean stop = false;

    public MyClock2() {
        this.setFont(new Font("Tahoma", Font.BOLD, 56));
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (this) {
                    while (stop) {
                        wait();
                    }
                }

                int hour = sec_run / 3600;
                int min = (sec_run % 3600) / 60;
                int sec = sec_run % 60;

                String timeText = String.format("%02d:%02d:%02d", hour, min, sec);

                this.setText(timeText);

                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            sec_run += 1;
        }
    }
    
    public synchronized void fn_stop() {
        stop = !stop;
        if (!stop) {
            notify();
        }
        
    }

}
