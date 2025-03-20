package objetos.construções.materiais;

import objetos.construções.Construção;

public class ParedeVertical extends Construção {

    public ParedeVertical(){
        setSimbolo("|");
        setBufferedImage("/res/tiles/","wall.png");
        setColisor(true);
    }
    
}
