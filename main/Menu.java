package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


public class Menu {

    private String[] options = {"Iniciar Jogo", "Sair"};
    private int currentOption = 0;
    private KeyHandler keyH;

    private Color titleColor;
    private Font titleFont;
    private Font optionFont;

    public Menu(KeyHandler keyH) {
        titleColor = new Color(255, 255, 255);
        titleFont = new Font("Arial", Font.BOLD, 72); 
        optionFont = new Font("Arial", Font.PLAIN, 36); 
        this.keyH = keyH;
    }

    public void draw(Graphics2D g) {
       
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, g.getClipBounds().width, g.getClipBounds().height);

       
        g.setColor(titleColor);
        g.setFont(titleFont);
        String title = "KAUA 2";
        int titleWidth = g.getFontMetrics(titleFont).stringWidth(title);
        int titleX = (g.getClipBounds().width - titleWidth) / 2;
        int titleY = g.getClipBounds().height / 4; 
        g.drawString(title, titleX, titleY);

       
        g.setFont(optionFont);
        int optionHeight = g.getFontMetrics(optionFont).getHeight();
        int optionsStartY = (g.getClipBounds().height / 2) - ((options.length * optionHeight) / 2);
        for (int i = 0; i < options.length; i++) {
            int optionWidth = g.getFontMetrics(optionFont).stringWidth(options[i]);
            int optionX = (g.getClipBounds().width - optionWidth) / 2;
            int optionY = optionsStartY + (i * (optionHeight + 20));

          
            if (i == currentOption) {
                g.setColor(new Color(0, 0, 0, 150));
                g.fillRoundRect(optionX - 10, optionY - optionHeight + 10, optionWidth + 20, optionHeight, 15, 15);
                g.setColor(Color.RED);
            } else {
                g.setColor(new Color(0, 0, 0, 100));
                g.fillRoundRect(optionX - 10, optionY - optionHeight + 10, optionWidth + 20, optionHeight, 15, 15);
                g.setColor(Color.WHITE);
            }

            g.drawString(options[i], optionX, optionY);
        }
    }

    public int selectOption() {
        int i = 15;
        switch (currentOption) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 1;
                System.exit(0);
                break;
            default:
                break;
        }
        return i;
    }

    public void moveUp() {
        currentOption--;
        if (currentOption < 0) {
            currentOption = options.length - 1;
        }
    }

    public void moveDown() {
        currentOption++;
        if (currentOption >= options.length) {
            currentOption = 0;
        }
    }

    public boolean update() {
        int i = 15;
        if (keyH.isUpPressed() == true) {
            moveUp();
            keyH.setUpPressed(false);
        }
        if (keyH.isDownPressed() == true) {
            moveDown();
            keyH.setDownPressed(false);
        }
        if (keyH.isEnterPressed() == true) {
            i = selectOption();
            if (i == 0) {
                keyH.setEnterPressed(false);
                return true;
            }
            keyH.setEnterPressed(false);
        }
        return false;
    }
}
