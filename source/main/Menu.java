package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Menu {

    // Define as opções do menu
    private String[] options = {"Iniciar Jogo", "Carregar Jogo", "Opções", "Sair"};
    private int currentOption = 0;
    private KeyHandler keyH;
    private Image[] backgroundImages;

    // Define as cores e fontes para o menu
    private Color titleColor;
    private Font titleFont;
    private Font optionFont;

    public Menu(KeyHandler keyH) {
        // Inicializa as cores e fontes
        titleColor = new Color(128, 0, 0);
        titleFont = new Font("Arial", Font.PLAIN, 28);
        optionFont = new Font("Arial", Font.PLAIN, 22);
        this.keyH = keyH;
        
        backgroundImages = new Image[1296];
        loadBackgroundImages();
        
    }
    
    private void loadBackgroundImages() {
    	try {
            for (int i = 1; i <= 1296; i++) {
                String fileName;
                if (i < 10) {
                    fileName = String.format("/res/menu/images/000_0%d.png", i);
                } else if (i < 100) {
                    fileName = String.format("/res/menu/images/000_%02d.png", i);
                } else if (i < 1000) {
                    fileName = String.format("/res/menu/images/000_%03d.png", i);
                } else {
                    fileName = String.format("/res/menu/images/000_%d.png", i);
                }
                backgroundImages[i - 1] = ImageIO.read(new File(fileName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g) {
    	
    	
    	
    	int tileSize = 16; // Assumindo 40x40 pixels por imagem, ajuste conforme necessário
        for (int i = 0; i < 1296; i++) {
            int x = (i % 48) * tileSize;
            int y = (i / 48) * tileSize;
            g.drawImage(backgroundImages[i], x, y, tileSize, tileSize, null);
        }
        // Desenha o título
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("Meu Jogo de RPG", 100, 100);

        // Desenha as opções do menu
        g.setFont(optionFont);
        for (int i = 0; i < options.length; i++) {
            if (i == currentOption) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLACK);
            }
            g.drawString(options[i], 100, 140 + i * 30);
        }
    }

    public int selectOption() {
    	int i = 15;
        switch (currentOption) {
            case 0:
                // Iniciar Jogo
            	i = 0;
                break;
            case 1:
            	i = 1;
                // Carregar Jogo
                break;
            case 2:
            	i = 2;
                // Opções
                break;
            case 3:
                // Sair
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
            if(i == 0) {
            	keyH.setEnterPressed(false);
            	return true;
            }
            keyH.setEnterPressed(false);
            
        }
//        System.out.println(currentOption);
        return false;
        
        
    	
    }
}
