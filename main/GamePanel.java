package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import objetos.*;
import objetos.entity.*;





public class GamePanel extends JPanel implements Runnable {

   
	private final int originalTileSize = 16; //16x16 tile

    private final double scale = 2.5;

    private final double tileSizeTimes = originalTileSize*scale; //40x40
    private final int tileSize = (int)tileSizeTimes;

    private final int maxScreenCol = 48;
    private final int maxScreenRow = 27;
    private final int screenWidth = tileSize * maxScreenCol; // 1920 pixels
    private final int screenHeight = tileSize * maxScreenRow; // 1080 pixels

    // FPS

    private int FPS = 60;

    private boolean jogoComecou;
    private UI ui; 
    private Pintor pintor;
    private KeyHandler keyH;
    private Thread gameThread;
  
    private Mapa mapa;
    private Player player;
    private Planicie planicie;
    private ArrayList<ArrayList<Objeto>> superficieObjetos;
    
    private Lugar currentLocation;
    
    private Menu menu;
    private EndScreen endScreen;
    private boolean endGame;


    public GamePanel(){

        
        keyH = new KeyHandler();
        jogoComecou = false;

        mapa = new Mapa(maxScreenCol*4,maxScreenRow*4, this);
        planicie = new Planicie(maxScreenCol*4,maxScreenRow*4, this);
        
        mapa.getPortoes().get(0).setDestino(planicie);
        planicie.getPortoes().get(0).setDestino(mapa);
        
        
        player = mapa.getControleDeEntidades().criarPlayer("Player", "Guerreiro", "Kaua", "Humano", this, keyH, mapa);
        superficieObjetos = mapa.getSuperficieObjetos();

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
      
        currentLocation = mapa;
        
        player.getCurrentLocation().setPlayerX(player.getCoordinatesX());
        player.getCurrentLocation().setPlayerY(player.getCoordinatesY());
        pintor = new Pintor(this, player);
        menu = new Menu(keyH);
        ui = new UI(player, keyH);
        endScreen = new EndScreen();
        endGame = false;

        

        

    }

    public int getScreenWidth(){
        return screenWidth;
    }

    public int getScreenHeight(){
        return screenHeight;

    }

    public void startGameThread(){
        gameThread = new Thread(this);

        gameThread.start();
    }
    
    public void run(){
        
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread!= null){
       
            

            long currentTime = System.nanoTime();




 

            update();
            repaint();

            

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime<0){
                    remainingTime = 0;
                }

                Thread.sleep((long)remainingTime);

                nextDrawTime +=drawInterval;
            } catch (InterruptedException e) {
              
                e.printStackTrace();
            }
        }
    }

    public void update(){
    	
    	if(!jogoComecou) {
    		jogoComecou = menu.update();
    		
    	}
    	
    	else {
    		if(player.getStatus().getVidaAtual()>0) {
    			player.getCurrentLocation().getControleDeEntidades().update();
                
     	       
    			 
                player.setCoordinatesX(player.getCurrentLocation().getPlayerX());
                player.setCoordinatesY(player.getCurrentLocation().getPlayerY());
                player.update();
                player.getCurrentLocation().setPlayerX(player.getCoordinatesX());
                player.getCurrentLocation().setPlayerY(player.getCoordinatesY());
    			
    		}
    		
    		else {
    			endGame = true;
    			
    			
    			
    			
    		}
    		

     
    		
    	}
    	
    	

    	
    	
    	


    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        

        // Esse g2 vai desenhar
        // Ele é como se fosse o pincel
        // Então a ideia é iterar pela matriz e usar esse g2 pra desenhar cada elemento de acordo com seu símbolo

        Graphics2D g2 = (Graphics2D)g;
        
        if(!jogoComecou) {
       	 menu.draw(g2);
       }
        else {
        	if(!endGame) {
        		pintor.draw(g2,player.getCurrentLocation().getSuperficieObjetos(),player.getCoordinatesX(),player.getCoordinatesY());
              	 
                
    	        player.getCurrentLocation().getControleDeEntidades().draw(g2,player.getCoordinatesX(),player.getCoordinatesY());
    	        player.draw(g2);
    	        ui.draw(g2);
        		
        	}
        	else {
        		endScreen.draw(g2, screenWidth, screenHeight);
        		
        	}
        	
       	 	
        	
        }
        
       
        
        
       


        //quero que cada objeto do mundo tenha seu draw, de forma que se eu quiser que apareça uma flor se movimentando com o vento, essa lógica de movimento esteja com o objeto flor, cada draw desse vai estar em tileM, provavelmente
        // é só fazer uma lógica de atualização a cada tantos frames, assim como acontece com as sprites do player
        
        

        

        g2.dispose();
    }



    public int[] getScreenSize(){

        int[] lista = new int[3];

        lista[0] = screenWidth * (mapa.getTamanhoX()/48);
        lista[1] = screenHeight * (mapa.getTamanhoY()/27);
        lista[2] = tileSize;

        

        return lista;



    }


    public void setCurrentLocation(Lugar currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getTileSize() {
        return tileSize;
    }
    
   public UI getUi() {
	return ui;
   }
    
    
}
