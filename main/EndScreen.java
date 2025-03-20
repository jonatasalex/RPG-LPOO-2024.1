package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndScreen {

    private String message;
    private Font messageFont;
    private boolean timerStarted;

    public EndScreen() {
        this.message = "Era tudo um sonho, acorde!";
        this.messageFont = new Font("Arial", Font.BOLD, 50);
        this.timerStarted = false;
    }

    public void draw(Graphics2D g2, int screenWidth, int screenHeight) {
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, screenWidth, screenHeight);

        g2.setColor(Color.WHITE);
        g2.setFont(messageFont);
        int messageWidth = g2.getFontMetrics().stringWidth(message);
        int messageHeight = g2.getFontMetrics().getHeight();

        int x = (screenWidth - messageWidth) / 2;
        int y = (screenHeight - messageHeight) / 2;

        g2.drawString(message, x, y);

        if (!timerStarted) {
            startTimer();
            timerStarted = true;
        }
    }

    private void startTimer() {
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        timer.setRepeats(false); 
        timer.start();
    }
}
