package objetos.construções.materiais;

import objetos.construções.Construção;

public class QuinaSuperiorEsquerda extends Construção {
    
    public QuinaSuperiorEsquerda(){
        setSimbolo("┌");
        setBufferedImage("/res/tiles/","log.png");
        setColisor(true);
    }
    
    
}
