package source;

import source.classes.Curandeiro;
import source.classes.Guerreiro;
import source.classes.Ladino;
import source.classes.Mago;
import source.objetos.NpcStatus;
import source.objetos.PlayerStatus;
import source.raças.Humano;
import source.raças.Orc;






public class ControladorDeClasses {

    private NpcStatus npc = new NpcStatus();
    private PlayerStatus player = new PlayerStatus();

    private Mago mago = new Mago();
    private Guerreiro guerreiro = new Guerreiro();
    private Ladino ladino = new Ladino();
    private Curandeiro curandeiro = new Curandeiro();
    private Humano humano = new Humano();
    private Orc orc = new Orc();


    public Orc getOrc(){
        return orc;
    }

    public Humano getHumano(){
        return humano;
    }

    public Curandeiro getCurandeiro(){
        return curandeiro;
    }

    public Ladino getLadino(){
        return ladino;
    }

    public Guerreiro getGuerreiro(){
        return guerreiro;
    }

    public Mago getMago(){
        return mago;
    }

    public PlayerStatus getPlayer(){
        return player;
    }

    public NpcStatus getNpc(){
        return npc;
    }
    
}