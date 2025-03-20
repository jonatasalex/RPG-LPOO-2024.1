package objetos;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Objeto {

    private boolean colisor;
    private int id;
    private String tipo;
    private BufferedImage image;
    private String simbolo;


    public Objeto(){
        simbolo = new String();
        colisor = false;
    }
    
    
    
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

    public void setColisor(boolean colisor) {
        this.colisor = colisor;
    }
    
    public boolean getColisor(){
        return colisor;
    }

   
    
    
}
