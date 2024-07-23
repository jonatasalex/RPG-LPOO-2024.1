package objetos.construções.materiais;

import objetos.construções.Construção;

public class ParedeHorizontal extends Construção {

    public ParedeHorizontal(){
        setSimbolo("-");
        setBufferedImage("/res/tiles/","wall.png");
        setColisor(true);
    }
    
}
