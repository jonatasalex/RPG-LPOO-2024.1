package objetos.construções.materiais;

import objetos.construções.Construção;

public class QuinaInferiorDireita extends Construção {

    public QuinaInferiorDireita(){
        setSimbolo("┘");
        setBufferedImage("/res/tiles/","log.png");
        setColisor(true);
    }
    
    
}
