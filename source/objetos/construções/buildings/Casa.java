package source.objetos.construções.buildings;

import source.objetos.Lugar;
import source.objetos.construções.Interior;
import source.objetos.construções.Porta;

public class Casa extends Interior {

    private Porta porta = new Porta();



    public void setDestino(Lugar lugar){
        porta.setDestino(lugar);
    }
    
}
