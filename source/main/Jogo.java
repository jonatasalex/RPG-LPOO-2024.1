package main;
import objetos.entity.Entidade;
import objetos.entity.Player;
import objetos.entity.status.classes.Guerreiro;

import java.util.Scanner;

import javax.swing.JFrame;

public class Jogo {

    
    public static void main (String[] args){

        // ControleDeEntidades todasEntidades = new ControleDeEntidades();
      
        
        // // Player player = todasEntidades.criarPlayer("Player", "Guerreiro", "Silvio", "Humano");
        // // todasEntidades.criarEntidade("Npc", "Guerreiro", "Carlão", "Orc");
        
        // // new Entidade("Player", "Guerreiro", "Silvio", "Humano");

        

        // todasEntidades.mostrarNomeDasEntidades();
        // Mapa mapa = new Mapa();
        
        // Player player = mapa.criarPlayer("Player", "Guerreiro", "Silvio", "Humano");
        // mapa.criarNpc("Npc", "Guerreiro", "Carlão", "Orc");
        // System.out.println(player.getNome());
        // System.out.println((player.getStatus()).getVidaTotal());

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");

        GamePanel gamePanel = new GamePanel();


        // gamePanel.mapa.criarMapa();
//        gamePanel.mapa.mostrarNomeDasEntidades();
//        gamePanel.mapa.mostrarEntidades();
        //gamePanel.mapa.imprimirMapa();



        window.add(gamePanel);


        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();


        
        


    }
    
}









