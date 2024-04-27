import source.ControladorDeClasses;
import source.ControleDeEntidades;
import source.Mapa;
import source.classes.Guerreiro;
import source.objetos.Entidade;
import source.objetos.Player;

import java.util.Scanner;

public class Jogo {

    
    public static void main (String[] args){

        ControleDeEntidades todasEntidades = new ControleDeEntidades();
      
        
        // Player player = todasEntidades.criarPlayer("Player", "Guerreiro", "Silvio", "Humano");
        // todasEntidades.criarEntidade("Npc", "Guerreiro", "Carlão", "Orc");
        
        // new Entidade("Player", "Guerreiro", "Silvio", "Humano");

        

        todasEntidades.mostrarNomeDasEntidades();
        Mapa mapa = new Mapa();
        
        Player player = mapa.criarPlayer("Player", "Guerreiro", "Silvio", "Humano");
        mapa.criarEntidade("Npc", "Guerreiro", "Carlão", "Orc");
        System.out.println(player.getNome());
        System.out.println((player.getStatus()).getVidaTotal());
        mapa.mostrarNomeDasEntidades();
        mapa.mostrarEntidades();
        mapa.construirOMapa();
        mapa.imprimirMapa();


    }
    
}









