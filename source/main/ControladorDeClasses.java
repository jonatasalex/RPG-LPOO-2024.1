package source.main;

import source.objetos.entity.NpcStatus;
import source.objetos.entity.PlayerStatus;
import source.objetos.entity.classes.Curandeiro;
import source.objetos.entity.classes.Guerreiro;
import source.objetos.entity.classes.Ladino;
import source.objetos.entity.classes.Mago;
import source.objetos.entity.raças.Humano;
import source.objetos.entity.raças.Orc;






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