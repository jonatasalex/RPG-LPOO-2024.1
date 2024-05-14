package source.objetos.entity;
import source.main.ControladorDeClasses;


import source.main.KeyHandler;
import java.lang.Math;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import source.main.GamePanel;









public class Player extends Entidade {



    private GamePanel gp;
    private KeyHandler keyH;
    
    
    
    public Player(String tipo, String classe, String nome, String raca, ControladorDeClasses control, GamePanel gp, KeyHandler keyH){
        definirRaca(raca, control);
        definirTipo(tipo, control);
        definirClasse(classe, control);
        definirNome(nome);
        setDirection("down");
        setSpriteCounter(1);
        setplaceId(0);
        this.gp = gp;
        this.keyH = keyH;
        setSimbolo("@");
        
        

        setImage("/source/res/player/");
        // getPlayerImage();

    }


    public void update(){
        double raizDeDois = Math.sqrt(2);

        
        
        int spriteNum = getSpriteNum();
        
        
        int x = getCoordinatesX();
        int y = getCoordinatesY();
        int speed = getSpeed();
        



        if(keyH.upPressed == true){
            setDirection("up");
            if(keyH.leftPressed == true){
                y-= speed/raizDeDois;
                x-= speed/raizDeDois;
                setCoordinatesX(x);
                setCoordinatesY(y);
            }

            else if(keyH.rightPressed == true){
                y-= speed/raizDeDois;
                x+= speed/raizDeDois;
                setCoordinatesX(x);
                setCoordinatesY(y);
            }
            else{
                y -=speed;
                setCoordinatesY(y);
            }
            
        }
        else if(keyH.dowPressed == true){
            setDirection("down");
            if(keyH.leftPressed == true){
                y+= speed/raizDeDois;
                x-= speed/raizDeDois;
                setCoordinatesX(x);
                setCoordinatesY(y);
            }

            else if(keyH.rightPressed == true){
                y+= speed/raizDeDois;
                x+= speed/raizDeDois;
                setCoordinatesX(x);
                setCoordinatesY(y);
            }

            else{
                y +=speed;
                setCoordinatesY(y);
            }
            
        }
        else if(keyH.leftPressed == true){
            setDirection("left");
            x -=speed;
            setCoordinatesX(x);
                
        }
        else if(keyH.rightPressed == true){
            setDirection("right");
            x +=speed;
            setCoordinatesX(x);
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


        // System.out.println(getDirection());

        

    }

    public void draw(Graphics2D g2){

        int x = getCoordinatesX();
        int y = getCoordinatesY();
        
        

        // g2.setColor(Color.white);

        // g2.fillRect(x,y, gp.tileSize, gp.tileSize);


        BufferedImage image = null;
        String direct = getDirection();
        // System.out.println(direct);


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

        
        // System.out.println(getSpriteNum());
        // imprimirPath();
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        // System.out.println("player:");
        // System.out.println(getCoordinatesX());
    }

    // public void getPlayerImage(){

    //     try {
    //         up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_1.png"));
    //         up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_2.png"));

    //         down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_1.png"));
    //         down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_2.png"));

    //         left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_1.png"));
    //         left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_2.png"));

    //         right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_1.png"));
    //         right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_2.png"));

            
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //     }
    // }



    void andar(){
        
    }
    
}
