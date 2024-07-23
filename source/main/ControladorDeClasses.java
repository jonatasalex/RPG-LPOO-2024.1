package main;

import objetos.entity.raças.Humano;
import objetos.entity.raças.Orc;
import objetos.entity.status.NpcStatus;
import objetos.entity.status.PlayerStatus;

import objetos.entity.status.classes.Guerreiro;
import objetos.entity.status.classes.Ladino;







public class ControladorDeClasses {

    private NpcStatus npc;
    private PlayerStatus player;

    private Guerreiro guerreiro;
    private Ladino ladino;

    private Humano humano;
    private Orc orc;
    
    private String[] classes = {"Guerreiro","Ladino"};
    private String[] racas = {"Orc","Humano"};


    public ControladorDeClasses(){
        npc = new NpcStatus();
        player = new PlayerStatus();

        guerreiro = new Guerreiro();
        ladino = new Ladino();

        humano = new Humano();
        orc = new Orc();

    }


    public Orc getOrc(){
        return orc;
    }

    public Humano getHumano(){
        return humano;
    }



    public Ladino getLadino(){
        return ladino;
    }

    public Guerreiro getGuerreiro(){
        return guerreiro;
    }



    public PlayerStatus getPlayer(){
        return player;
    }

    public NpcStatus getNpc(){
        return npc;
    }
    
    public String[] getClasses() {
    	return classes;
    }
    
    public String[] getRacas() {
    	return racas;
    }
    
}