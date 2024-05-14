package source.objetos;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Objeto {

    private boolean colisor = false;
    private int id;
    private String tipo;
    private BufferedImage image;
    private String simbolo = new String();
    
    
    
    public BufferedImage getBufferedImage(){
        return image;
    }

    public void setBufferedImage(String path, String name){

        try {
            this.image = ImageIO.read(getClass().getResourceAsStream(path+name));
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

    public String getSimbolo(){
        return this.simbolo;
    }

    public void setSimbolo(String simbol){
        this.simbolo = simbol;
    }

    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

   
    
    
}
