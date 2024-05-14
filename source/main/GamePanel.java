package source.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import source.objetos.*;
import source.objetos.entity.*;

// import entity.Player;



public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final int originalTileSize = 16; //16x16 tile

    final double scale = 2.5;

    final double tileSizeDouble = originalTileSize*scale; //40x40
    public final int tileSize = (int)tileSizeDouble;

    final int maxScreenCol = 48;
    final int maxScreenRow = 27;
    final int screenWidth = tileSize * maxScreenCol; // 1920 pixels
    final int screenHeight = tileSize * maxScreenRow; // 1080 pixels

    // FPS

    int FPS = 75;


    Pintor pintor = new Pintor(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    // Player player = new Player(this,keyH);
    Mapa mapa = new Mapa();
    Player player = mapa.getControleDeEntidades().criarPlayer("Player", "Guerreiro", "Silvio", "Humano", this, keyH);
    ArrayList<ArrayList<Objeto>> superficieObjetos = mapa.getSuperficieObjetos();
    
    Lugar currentLocation = mapa;
    
    // // Set player's default position

    // int playerX = 100;
    // int playerY = 100;
    // int playerSpeed = 5;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        // superficieObjetos.get(0).set(0, player);

    }

    public void startGameThread(){
        gameThread = new Thread(this);

        gameThread.start();
    }
    
    public void run(){
        
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread!= null){
            // System.out.println("The game loop is running");
            

            long currentTime = System.nanoTime();




            // 1 UPDATE: update information such as character positions

            // 2 DRAW: draw the screen with the updated information

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


        
       
        // currentLocation = mapa.getPlace(player.getPlaceId());
        // currentLocation.update();
        player.setCoordinatesX(currentLocation.getPlayerX());
        player.setCoordinatesY(currentLocation.getPlayerY());
        player.update();
        currentLocation.setPlayerX(player.getCoordinatesX());
        currentLocation.setPlayerY(player.getCoordinatesY());

        // System.out.println("current location:");
        // System.out.println(currentLocation.getPlayerX());


    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);

        // Esse g2 vai desenhar
        // Ele é como se fosse o pincel
        // Então a ideia é iterar pela matriz e usar esse g2 pra desenhar cada elemento de acordo com seu símbolo

        Graphics2D g2 = (Graphics2D)g;
        
        pintor.draw(g2,currentLocation.getSuperficieObjetos());
        player.draw(g2);


        //quero que cada objeto do mundo tenha seu draw, de forma que se eu quiser que apareça uma flor se movimentando com o vento, essa lógica de movimento esteja com o objeto flor, cada draw desse vai estar em tileM, provavelmente
        // é só fazer uma lógica de atualização a cada tantos frames, assim como acontece com as sprites do player
        
        

        

        g2.dispose();
    }



    public int[] getScreenSize(){

        int[] lista = new int[3];

        lista[0] = screenWidth;
        lista[1] = screenHeight;
        lista[2] = tileSize;

        

        return lista;



    }


    public void setCurrentLocation(Lugar currentLocation) {
        this.currentLocation = currentLocation;
    }
}
