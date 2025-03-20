package objetos;

import java.awt.Graphics2D;

import java.util.ArrayList;

import main.GamePanel;
import objetos.entity.Player;





public class Pintor {
    GamePanel gp;
    private Player player;

    public Pintor(GamePanel gp, Player player){
        this.gp = gp;
        this.player = player;
    }

    
    public void draw(Graphics2D g2, ArrayList<ArrayList<Objeto>> superficieObjetos, int x, int y){
        int[] lista = new int[3];

        int i = x;
        int j = y;

        int a = 0;
        int b = 0;

        lista = gp.getScreenSize();
        
        while(i<lista[0]+x){
            j=y;
            a=0;
            while(j<lista[1]+y){
            	
            	if((((b*40)>= player.getCoordinatesX()-(920+40)) || ((b*40)<= player.getCoordinatesX()+(1000+40))) && ((((a*40)>= player.getCoordinatesY()-(520+40))) || ((a*40)<= player.getCoordinatesY()+(560+40))) ) {
            		if(superficieObjetos.get(a).get(b).getTipo().equals("Construção")){
                        g2.drawImage(superficieObjetos.get(a).get(b).getBufferedImage(), -x+((b+1)*40)-gp.getTileSize(), -y+((a+1)*40)-gp.getTileSize(), gp.getTileSize(), gp.getTileSize(), null);
                    }
            		
            	}

                j+=lista[2];
                a++;
            }
            i+=lista[2];
            b++;

        }
        
    }
}
