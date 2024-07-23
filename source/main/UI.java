package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.List;

import java.time.Instant;


import objetos.entity.Npc;
import objetos.entity.Player;

public class UI {

    private Player player;
    private Color hpColor;
    private Font hpFont;
    private Color backgroundColor;
    
    private boolean combate;
    private Npc oponente;
    private int selectedGolpeIndex;
    private KeyHandler keyH;
    private String[] golpes;
    private boolean turno;
    
    private Instant lastEnemyAttackTime;
    private Instant currentTime;

    public UI(Player player, KeyHandler keyH) {
        this.player = player;
        hpColor = new Color(255, 0, 0); 
        hpFont = new Font("Arial", Font.PLAIN, 22);
        backgroundColor = new Color(255, 255, 255); 
        combate = false;
        golpes = player.getGolpes();
        selectedGolpeIndex = 0;
        this.keyH = keyH;
        turno = true;
    }

    public void draw(Graphics2D g) {
        String hpText = "HP: " + player.getStatus().getVidaAtual() + "/" + player.getStatus().getVidaTotal();
        
     
        int x = 10;
        int y = 20;

     
        int textWidth = g.getFontMetrics(hpFont).stringWidth(hpText);
        int textHeight = g.getFontMetrics(hpFont).getHeight();

        
        g.setColor(backgroundColor);
        g.fillRect(x - 5, y - textHeight + 5, textWidth + 10, textHeight);

       
        g.setColor(hpColor);
        g.setFont(hpFont);
        g.drawString(hpText, x, y);
        
        if(combate) {
        	String hpEnemyText = "HP: " + oponente.getStatus().getVidaAtual() + "/"  + oponente.getStatus().getVidaTotal();
        	String nomeEnemyText = oponente.getNome();
        	
        	int xEnemy = g.getClipBounds().width - textWidth - 20; 
            int yEnemy = 20;
            
           
            int textWidthEnemy = g.getFontMetrics(hpFont).stringWidth(hpEnemyText);
            int textHeightEnemy = g.getFontMetrics(hpFont).getHeight();
            
       
            g.setColor(backgroundColor);
            g.fillRect(xEnemy - 5, yEnemy - textHeightEnemy + 5, textWidthEnemy + 10, textHeightEnemy);
            
          
            g.setColor(hpColor);
            g.setFont(hpFont);
            g.drawString(hpEnemyText, xEnemy, yEnemy);
            
            
            int textWidthNomeEnemy = g.getFontMetrics(hpFont).stringWidth(nomeEnemyText);
            int textHeightNomeEnemy = g.getFontMetrics(hpFont).getHeight();

          
            g.setColor(backgroundColor);
            g.fillRect(xEnemy - 5, yEnemy + 5, textWidthNomeEnemy + 10, textHeightNomeEnemy);

      
            g.setColor(hpColor);
            g.setFont(hpFont);
            g.drawString(nomeEnemyText, xEnemy, yEnemy + textHeightEnemy + 5);
            
            
           
            
            
            
     
            int screenWidth = g.getClipBounds().width;
            int screenHeight = g.getClipBounds().height;
            int golpesStartY = (3*screenHeight / 4) - (golpes.length * textHeight) / 2;

            for (int i = 0; i < golpes.length; i++) {
                String golpe = golpes[i];
                int golpeWidth = g.getFontMetrics(hpFont).stringWidth(golpe);
                int golpeX = screenWidth / 2 - golpeWidth / 2;
                int golpeY = golpesStartY + (i * textHeight);

             
                g.setColor(backgroundColor);
                g.fillRect(golpeX - 5, golpeY - textHeight + 5, golpeWidth + 10, textHeight);

                if (i == selectedGolpeIndex) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.RED);
                }

                g.setFont(hpFont);
                g.drawString(golpe, golpeX, golpeY);
            }
            
            if(turno == true) {
            	if (keyH.isUpPressed()) {
	                moveUp();
	                keyH.setUpPressed(false);
	            }
	            if (keyH.isDownPressed()) {
	                moveDown();
	                keyH.setDownPressed(false);
	            }
	            if (keyH.isEnterPressed()) {
	                switch(selectedGolpeIndex) {
		                case 0:
		                	if(player.getStatus().getStaminaAtual()-15>=0)
		                	player.bater(oponente, 15, 10);
		                	else {
		                		turno = false;
		                		player.getStatus().setStaminaAtual(player.getStatus().getStaminaTotal());
		                		
		                	}
		                		
		                		
		                case 1:
		                	if(player.getStatus().getStaminaAtual()-25>=0)
		                	player.bater(oponente,25,12);
		                	else {
		                		turno = false;
		                		player.getStatus().setStaminaAtual(player.getStatus().getStaminaTotal());
		                		
		                	}
		                		
		                case 2:
		                	if(player.getStatus().getStaminaAtual()-10>=0)
		                	player.bater(oponente,10,10);
		                	else {
		                		turno = false;
		                		player.getStatus().setStaminaAtual(player.getStatus().getStaminaTotal());
		                		
		                	}
		                		
		                	
	                }
	                keyH.setEnterPressed(false);
	            }
            	
            }
	            
            if(turno == false) {
            	currentTime = Instant.now();
            	if (lastEnemyAttackTime == null || currentTime.minusSeconds(1).isAfter(lastEnemyAttackTime)) {
            		if(oponente.getStatus().getStaminaAtual()-10>=0) {
                    	oponente.bater(player, 10, 30);
            			lastEnemyAttackTime = currentTime;
            			if(player.getStatus().getVidaAtual()==0)
            				System.exit(0);
            				
            			}
                    	else {
                    		turno = true;
                    		oponente.getStatus().setStaminaAtual(oponente.getStatus().getStaminaTotal());
                    	}
                    
                }
            	
            	
            	
            	
            	
            		
            }
            
            if(oponente.getStatus().getVidaAtual()==0) {
            	combate = false;
            	player.setCombate(combate);
            }
            
        	
        }
    }
    
    public void setCombate(boolean combate, Npc oponente) {
		this.combate = combate;
		this.oponente = oponente;
	}
    
    public void moveUp() {
        selectedGolpeIndex--;
        if (selectedGolpeIndex < 0) {
            selectedGolpeIndex = golpes.length - 1;
        }
    }

    public void moveDown() {
        selectedGolpeIndex++;
        if (selectedGolpeIndex >= golpes.length) {
            selectedGolpeIndex = 0;
        }
    }
}
