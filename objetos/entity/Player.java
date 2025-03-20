package objetos.entity;
import main.ControladorDeClasses;


import main.KeyHandler;
import objetos.Lugar;

import objetos.construções.Portao;
import objetos.construções.materiais.Potion;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;



import main.GamePanel;
import main.Inventário;









public class Player extends Entidade {



    
    private KeyHandler keyH;
    private boolean combate;
    private Npc oponente;
    private Inventário inventario;
    private String[] golpes = {"Soco","Chute","Empurrão"};
   
    
    
    
    public Player(String tipo, String classe, String nome, String raca, ControladorDeClasses control, GamePanel gp, KeyHandler keyH, Lugar currentLocation){
        definirRaca(raca, control);
        definirTipo(tipo, control);
        definirClasse(classe, control);
        definirNome(nome);
        setDirection("down");
        setSpriteCounter(1);
        getStatus().setStaminaAtual(getStatus().getStaminaTotal());
        getStatus().setVidaAtual(getStatus().getVidaTotal());
      
        setGp(gp);
        this.keyH = keyH;
        setSimbolo("@");
        setCurrentLocation(currentLocation);
        super.setCoordinatesX((920*currentLocation.getProporcao())-40);
        super.setCoordinatesY((520*2)-40);
        
        super.setiX((((920*currentLocation.getProporcao())-40)/40)+23);
        super.setiY((((520*2)-40)/40)+13);
        combate = false;
        inventario = new Inventário();
        

        
        

        setImage("/res/player");
    

    }


    public void update(){
      
    	
    	if(inventario.getQuantidadeDePocoes()>0 && getStatus().getVidaAtual()<getStatus().getVidaTotal() && combate == false ) {
    		inventario.usarPocao();
    		getStatus().curar(20);
    		
    	}

        
        
       
        
        
        int x = super.getCoordinatesX();
        int y = super.getCoordinatesY();
        int speed = getSpeed();

        

       
        

        if(combate == false) {
        	if(keyH.isUpPressed() == true){
                setDirection("up");
                if(getCurrentLocation().getSuperficieObjetos().get(((getiY()))).get(getiX()).getColisor() == false && getCurrentLocation().getSuperficieObjetos().get(((getiY()))).get(((x+39)/40)+23).getColisor() == false){
                    if(y-speed>=0){
                            y -=speed;
                            setCoordinatesY(y);
                            setiY((y/40)+13);
                    }
                }
            }
            else if(keyH.isDownPressed() == true){
                setDirection("down");

                if(getCurrentLocation().getSuperficieObjetos().get(((getiY())+1)).get(getiX()).getColisor() == false && 
                   getCurrentLocation().getSuperficieObjetos().get(((getiY())+1)).get(((x+39)/40)+23).getColisor() == false ){
                    
                    if(y+speed<=(((getCurrentLocation().getTamanhoY())*40))-26*40){
                        if(getCurrentLocation().getSuperficieObjetos().get(((getiY()+1))).get(getiX()).getColisor() == false){
                            
                                y +=speed;
                                setCoordinatesY(y);
                                setiY((y/40)+13);
                        }
 
                    }

                }
   
            }
            else if(keyH.isLeftPressed() == true){
                setDirection("left");

                if(getCurrentLocation().getSuperficieObjetos().get(((getiY()))).get(getiX()).getColisor() == false && 
                   getCurrentLocation().getSuperficieObjetos().get(((((y+39)/40)+13))).get(getiX()).getColisor() == false){
                	
                    if(x-speed>=0){
                        x -=speed;
                        setCoordinatesX(x);
                        setiX((x/40)+23);

                    }
                }
                
                    
            }
            else if(keyH.isRightPressed() == true){
                setDirection("right");

                if(getCurrentLocation().getSuperficieObjetos().get(((getiY()))).get(getiX()+1).getColisor() == false && 
                	getCurrentLocation().getSuperficieObjetos().get((((((y+39)/40)+13)))).get(getiX()+1).getColisor() == false){
                    
                	if(x+speed<=(getCurrentLocation().getTamanhoX()*40)-48*40){
                        x +=speed;
                        setCoordinatesX(x);
                        setiX((x/40)+23);

                    }
                }
                
            }
            
            
            
              
            if(keyH.isePressed() == true) {
            	
            	String direct = getDirection();
            	System.out.println(1);
            	
            	
            	if(direct.equals("up")) {
            		
            		
            		if(getCurrentLocation().getSuperficieObjetos().get(((getiY()-1))).get(getiX()) instanceof Portao) {
            			sai((Portao)(getCurrentLocation().getSuperficieObjetos().get(((getiY()-1))).get(getiX())));
            			
            		}
            			
            		else if(getCurrentLocation().getSuperficieObjetos().get(((getiY()-1))).get(((x+39)/40)+23) instanceof Portao) {
            			sai((Portao)getCurrentLocation().getSuperficieObjetos().get(((getiY()-1))).get(((x+39)/40)+23));
            			
            		}
            		
            		
            		if (getCurrentLocation().getSuperficie().get(getiY() - 1).get(getiX()) instanceof Npc) {
            		    oponente = (Npc) getCurrentLocation().getSuperficie().get(getiY() - 1).get(getiX());
            		    combate = true;
            		} else if (getCurrentLocation().getSuperficie().get(getiY() - 1).get(getiX() + 1) instanceof Npc) {
            		    oponente = (Npc) getCurrentLocation().getSuperficie().get(getiY() - 1).get(getiX() + 1);
            		    combate = true;
            		} else if (getCurrentLocation().getSuperficie().get(getiY() - 1).get(getiX() - 2) instanceof Npc) {
            		    oponente = (Npc) getCurrentLocation().getSuperficie().get(getiY() - 1).get(getiX() - 2);
            		    combate = true;
            		} else if (getCurrentLocation().getSuperficie().get(getiY() - 2).get(getiX()) instanceof Npc) {
            		    oponente = (Npc) getCurrentLocation().getSuperficie().get(getiY() - 2).get(getiX());
            		    combate = true;
            		} else if (getCurrentLocation().getSuperficie().get(getiY() - 2).get(getiX() + 1) instanceof Npc) {
            		    oponente = (Npc) getCurrentLocation().getSuperficie().get(getiY() - 2).get(getiX() + 1);
            		    combate = true;
            		} else if (getCurrentLocation().getSuperficie().get(getiY() - 2).get(getiX() - 1) instanceof Npc) {
            		    oponente = (Npc) getCurrentLocation().getSuperficie().get(getiY() - 2).get(getiX() - 1);
            		    combate = true;
            		}
            		
            		if(oponente != null) {
            			if(oponente.getStatus().getVidaAtual()==0) {
                			combate = false;
                		}
            			
            		}
            		

            		
            		

            		
            		
            		
            			
            		
            		
            	}
            	
            	else if(direct.equals("down")) {
        		
            		
            		if(getCurrentLocation().getSuperficieObjetos().get(((getiY()+1))).get(getiX()+1) instanceof Portao) {
            			sai((Portao)(getCurrentLocation().getSuperficieObjetos().get(((getiY()+1))).get(getiX()+1)));
            			
            		}
            			
            		else if(getCurrentLocation().getSuperficieObjetos().get((((((y+39)/40)+14)))).get(getiX()+1) instanceof Portao) {
            			sai((Portao)getCurrentLocation().getSuperficieObjetos().get((((((y+39)/40)+14)))).get(getiX()+1));
            			
            		}
            		
            	}
            	
     
            	

            	
            }
            
            if(getCurrentLocation().getSuperficieObjetos().get(((getiY()))).get(getiX()) instanceof Potion) {
            	
            	getCurrentLocation().getSuperficieObjetos().get(((getiY()))).set(getiX(), getCurrentLocation().getMateriaisDoMapa().get(0));
            	inventario.pegarPocao();
            }

            
            

            


            
        	
        }
        
        else {
        	
        	getGp().getUi().setCombate(combate, oponente);
        	
        	
        	
        	
        	
        	
        }
        
        increaseSpriteCounter();
        if(getSpriteCounter()>30){
            if(getSpriteNum() == 1){
                setSpriteNum(2);
            }
            else if(getSpriteNum() == 2){
                setSpriteNum(1);
            }
            setSpriteCounter(0);
        }

        

    }

    public void draw(Graphics2D g2){

     
        
        

       


        BufferedImage image = null;
        String direct = getDirection();
     


        if(direct == "up"){
            if(getSpriteNum() == 1){
                image = getImagem("up1");
            }
            if(getSpriteNum() == 2){
                image = getImagem("up2");
            }
        }

        else if(direct == "down"){
            if(getSpriteNum() == 1){
                image = getImagem("down1");
            }
            if(getSpriteNum() == 2){
                image = getImagem("down2");
            }
        }

        else if(direct == "left"){
            if(getSpriteNum() == 1){
                image = getImagem("left1");
            }
            if(getSpriteNum() == 2){
                image = getImagem("left2");
            }

        }

        else if(direct == "right"){
            if(getSpriteNum() == 1){
                image = getImagem("right1");
            }

            if(getSpriteNum() == 2){
                image = getImagem("right2");
            }
            

        }

        
     
        g2.drawImage(image, 920, 520, getGp().getTileSize(), getGp().getTileSize(), null);
   
    }



    void sai(Portao portao){
    	
    	
    	getCurrentLocation().setPlayerX(getCoordinatesX());
    	getCurrentLocation().setPlayerY(getCoordinatesY());
    
    	getCurrentLocation().setPlayerIX(getiX());
    	getCurrentLocation().setPlayerIY(getiY());
    	
    	if(getCoordinatesY()<100) {
    		portao.getDestino().setPlayerY(3280);
    		portao.getDestino().setPlayerIY((3280/40)+13);
    		setCoordinatesY(3280);
    	}
    	
    	else {
    		portao.getDestino().setPlayerY(0);
    		portao.getDestino().setPlayerIY(13);
    		setCoordinatesY(0);
    	}
    	
    	portao.getDestino().setPlayerX(getCoordinatesX());
    	portao.getDestino().setPlayerIX(getiX());
    	
    	setCurrentLocation(portao.getDestino());
    	
    	
    	
 
    	
    
    	
    	
    	
    	
        
    }
    
    public boolean isCombate() {
		return combate;
	}
    
    public void setCombate(boolean combate) {
		this.combate = combate;
	}
    
    public String[] getGolpes() {
		return golpes;
	}
    
    public Inventário getInventario() {
		return inventario;
	}
}
