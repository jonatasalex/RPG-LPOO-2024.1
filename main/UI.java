package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


import java.time.Instant;


import objetos.entity.Npc;
import objetos.entity.Player;

public class UI {

    private Player player;
    
    private Font hpFont;
    private Color backgroundColor;
   
    
    private boolean combate;
    private Npc oponente;
    private int selectedGolpeIndex;
    private KeyHandler keyH;
    private String[] golpes;
    private boolean turno;
    private Inventário inventario;
    private Instant lastEnemyAttackTime;
    private Instant currentTime;
    
    private Color textColor;
    private Font textFont;
    private boolean inv;
    

    public UI(Player player, KeyHandler keyH) {
        this.player = player;
        
        hpFont = new Font("Arial", Font.PLAIN, 22);
         
        combate = false;
        golpes = player.getGolpes();
        selectedGolpeIndex = 0;
        this.keyH = keyH;
        turno = true;
        this.inventario = player.getInventario();
        textColor = new Color(255, 255, 255); 
        textFont = new Font("Arial", Font.PLAIN, 22);
        inv = false;
        backgroundColor = new Color(0, 0, 0, 150); 
        
    }

    public void draw(Graphics2D g) {
        String hpText = "HP: " + player.getStatus().getVidaAtual() + "/" + player.getStatus().getVidaTotal();
        String stText = "Stamina: " + player.getStatus().getStaminaAtual() + "/" + player.getStatus().getStaminaTotal();
        
        int x = 10;
        int y = 20;
        
        int screenWidth = g.getClipBounds().width;
        int screenHeight = g.getClipBounds().height;
     
        int textWidth = g.getFontMetrics(hpFont).stringWidth(hpText);
        int textHeight = g.getFontMetrics(hpFont).getHeight();

        
        g.setColor(backgroundColor);
        g.fillRect(x - 5, y - textHeight + 5, textWidth + 10, textHeight);

       
        g.setColor(textColor);
        g.setFont(hpFont);
        g.drawString(hpText, x, y);
        
        
        
        
        x = 10;
        y = 20 + textHeight;
        
        textWidth = g.getFontMetrics(hpFont).stringWidth(stText);
        textHeight = g.getFontMetrics(hpFont).getHeight();
        
        
        g.setColor(backgroundColor);
        g.fillRect(x - 5, y - textHeight + 5, textWidth + 10, textHeight);

       
        g.setColor(textColor);
        g.setFont(hpFont);
        g.drawString(stText, x, y);
        
        if(keyH.isiPressed()) {
        	
        	if(inv == true) {
        		inv = false;
        	}
        	else {
        		inv = true;
        	}
        	
        	
        	
        }
        
        if(inv == true) {
    		
        	String pocaoText = "Poções: " + inventario.getQuantidadeDePocoes();

            
            
            int x2 = screenWidth / 2 - g.getFontMetrics(textFont).stringWidth(pocaoText) / 2;
            int y2 = screenHeight / 4;

            
            int textWidth2 = g.getFontMetrics(textFont).stringWidth(pocaoText);
            int textHeight2 = g.getFontMetrics(textFont).getHeight();

            
            g.setColor(backgroundColor);
            g.fillRect(x2 - 5, y2 - textHeight2 + 5, textWidth2 + 10, textHeight2);

           
            g.setColor(textColor);
            g.setFont(textFont);
            g.drawString(pocaoText, x2, y2);
            
            
       
    		
    	}
        
        
        
        if(combate) {
        	
        	String hpEnemyText = "HP: " + oponente.getStatus().getVidaAtual() + "/"  + oponente.getStatus().getVidaTotal();
        	String nomeEnemyText = oponente.getNome();
        	String stEnemy = "Stamina: " + oponente.getStatus().getStaminaAtual() + "/"  + oponente.getStatus().getStaminaTotal();
        	
        	int xEnemy = g.getClipBounds().width - textWidth - 20; 
            int yEnemy = 20;
            
           
            int textWidthEnemy = g.getFontMetrics(hpFont).stringWidth(hpEnemyText);
            int textHeightEnemy = g.getFontMetrics(hpFont).getHeight();
            
       
            g.setColor(backgroundColor);
            g.fillRect(xEnemy - 5, yEnemy - textHeightEnemy + 5, textWidthEnemy + 10, textHeightEnemy);
            
          
            g.setColor(textColor);
            g.setFont(hpFont);
            g.drawString(hpEnemyText, xEnemy, yEnemy);
            
            
            
            yEnemy = 20 + textHeightEnemy;
            
            textWidthEnemy = g.getFontMetrics(hpFont).stringWidth(stEnemy);
            textHeightEnemy = g.getFontMetrics(hpFont).getHeight();
            
            g.setColor(backgroundColor);
            g.fillRect(xEnemy - 5, yEnemy - textHeightEnemy + 5, textWidthEnemy + 10, textHeightEnemy);
            
          
            g.setColor(textColor);
            g.setFont(hpFont);
            g.drawString(stEnemy, xEnemy, yEnemy);
            
            
            
            
            
            
            

            
            int textWidthNomeEnemy = g.getFontMetrics(hpFont).stringWidth(nomeEnemyText);
            int textHeightNomeEnemy = g.getFontMetrics(hpFont).getHeight();

          
            g.setColor(backgroundColor);
            g.fillRect(xEnemy - 5, yEnemy + 5, textWidthNomeEnemy + 10, textHeightNomeEnemy);

      
            g.setColor(textColor);
            g.setFont(hpFont);
            g.drawString(nomeEnemyText, xEnemy, yEnemy + textHeightEnemy + 5);
            
            
           
            
            
            
     
            
            int golpesStartY = (3*screenHeight / 4) - (golpes.length * textHeight) / 2;

            for (int i = 0; i < golpes.length; i++) {
                String golpe = golpes[i];
                int golpeWidth = g.getFontMetrics(hpFont).stringWidth(golpe);
                int golpeX = screenWidth / 2 - golpeWidth / 2;
                int golpeY = golpesStartY + (i * textHeight);

             
                g.setColor(backgroundColor);
                g.fillRect(golpeX - 5, golpeY - textHeight + 5, golpeWidth + 10, textHeight);

                if (i == selectedGolpeIndex) {
                    g.setColor(Color.WHITE);
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
		                	if(player.getStatus().getStaminaAtual()-10>=0)
		                	player.bater(oponente, 15+(player.getStatus().getLevel() * 1), 10);
		                	else {
		                		turno = false;
		                		player.getStatus().setStaminaAtual(player.getStatus().getStaminaTotal());
		                		
		                	}
		                		
		                		
		                case 1:
		                	if(player.getStatus().getStaminaAtual()-12>=0)
		                	player.bater(oponente,25,12+(player.getStatus().getLevel() * 1));
		                	else {
		                		turno = false;
		                		player.getStatus().setStaminaAtual(player.getStatus().getStaminaTotal());
		                		
		                	}
		                		
		                case 2:
		                	if(player.getStatus().getStaminaAtual()-10>=0)
		                	player.bater(oponente,10,10+(player.getStatus().getLevel() * 1));
		                	else {
		                		turno = false;
		                		player.getStatus().setStaminaAtual(player.getStatus().getStaminaTotal());
		                		
		                	}
		                		
		                	
	                }
	                keyH.setEnterPressed(false);
	            }
	            
	            if(keyH.isiPressed()) {
	            	
	            	if(inv == true) {
	            		inv = false;
	            	}
	            	else {
	            		inv = true;
	            	}
	            	
	            	
	            	
	            }
	            
	            if(inv == true) {
            		
	            	String pocaoText = "Poções: " + inventario.getQuantidadeDePocoes();

	                
	                
	                int x2 = screenWidth / 2 - g.getFontMetrics(textFont).stringWidth(pocaoText) / 2;
	                int y2 = screenHeight / 4;

	                
	                int textWidth2 = g.getFontMetrics(textFont).stringWidth(pocaoText);
	                int textHeight2 = g.getFontMetrics(textFont).getHeight();

	                
	                g.setColor(backgroundColor);
	                g.fillRect(x2 - 5, y2 - textHeight2 + 5, textWidth2 + 10, textHeight2);

	               
	                g.setColor(textColor);
	                g.setFont(textFont);
	                g.drawString(pocaoText, x2, y2);
	                
	                if(keyH.isqPressed()== true) {
	                	
	                	if(player.getInventario().getQuantidadeDePocoes()>0 && player.getStatus().getVidaAtual()<player.getStatus().getVidaTotal()) {
	                		player.getInventario().usarPocao();
		                	player.getStatus().cansar(10);
		                	player.getStatus().curar(20);
	                		
	                	}
	                	
	                	
	                }
            		
            	}
            	
            }
	            
            if(turno == false) {
            	currentTime = Instant.now();
            	if (lastEnemyAttackTime == null || currentTime.minusSeconds(1).isAfter(lastEnemyAttackTime)) {
            		if(oponente.getStatus().getStaminaAtual()-10>=0) {
                    	oponente.bater(player, 30, 30);
            			lastEnemyAttackTime = currentTime;
            			
            				
            				
            			}
                    	else {
                    		turno = true;
                    		oponente.getStatus().setStaminaAtual(oponente.getStatus().getStaminaTotal());
                    	}
                    
                }
            	
            	
            	
            	
            	
            		
            }
            
            if(oponente.getStatus().getVidaAtual()==0) {
            	oponente.dead("/res/npc");
            	combate = false;
            	player.getStatus().setStaminaAtual(player.getStatus().getStaminaTotal());
            	player.getStatus().adicionarLevel();
            	while(player.getStatus().getVidaAtual()<player.getStatus().getVidaTotal() ) {
            		if(player.getInventario().getQuantidadeDePocoes()<=0)
            			break;
            		player.getInventario().usarPocao();
                	player.getStatus().curar(20);
            		
            		
            		
            	}
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
