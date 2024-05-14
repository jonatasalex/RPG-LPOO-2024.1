package source.objetos;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import source.main.GamePanel;

import javax.imageio.ImageIO;



public class Pintor {
    GamePanel gp;

    public Pintor(GamePanel gp){
        this.gp = gp;
        // tile = new Tile[10];
        // getTileImage();
    }

    public void getTileImage(){

        // try {

        //     tile[0] = new Tile();
        //     tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/grass.png"));

        //     tile[1] = new Tile();
        //     tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/wall.png"));

        //     tile[2] = new Tile();
        //     tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/water.png"));
        
        // } catch (Exception e) {
        //     // TODO: handle exception
        // }

    }


    public void draw(Graphics2D g2, ArrayList<ArrayList<Objeto>> superficieObjetos){
        int[] lista = new int[3];
        int i = 0;
        int j = 0;

        int a = 0;
        int b = 0;

        lista = gp.getScreenSize();
        
        while(i<lista[0]){
            j=0;
            a=0;
            while(j<lista[1]){

                if(superficieObjetos.get(a).get(b).getTipo().equals("Construção")){
                    g2.drawImage(superficieObjetos.get(a).get(b).getBufferedImage(), i, j, gp.tileSize, gp.tileSize, null);
                }
                
                j+=lista[2];
                a++;
            }
            i+=lista[2];
            b++;

        }
        
    }
}
