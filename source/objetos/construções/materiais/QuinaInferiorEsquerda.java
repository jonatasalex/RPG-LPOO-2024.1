package objetos.construções.materiais;

import objetos.construções.Construção;

public class QuinaInferiorEsquerda extends Construção {

    public QuinaInferiorEsquerda(){
        
        setSimbolo("└");
        setBufferedImage("/res/tiles/","log.png");
        setColisor(true);
    }
    
}
