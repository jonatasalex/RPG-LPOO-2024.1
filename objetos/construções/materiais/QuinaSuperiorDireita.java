package objetos.construções.materiais;

import objetos.construções.Construção;

public class QuinaSuperiorDireita extends Construção {

    public QuinaSuperiorDireita(){
        setSimbolo("┐");
        setBufferedImage("/res/tiles/","log.png");
        setColisor(true);
    }
    
}
