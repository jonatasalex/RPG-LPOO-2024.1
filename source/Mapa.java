package source;
import java.util.Random;

import source.objetos.Objeto;

import java.util.ArrayList;
import source.objetos.construções.*;
import source.*;
import source.objetos.*;


public class Mapa {


    public Mapa(){
        criarMapa();
    }

    private int tamanhoX;
    private int tamanhoY;
    private ArrayList<Objeto> materiaisDoMapa = new ArrayList<>();
    private ControleDeObjetos todosObjetos = new ControleDeObjetos();
    private ControleDeEntidades todasEntidades = new ControleDeEntidades();
    private Pedreiro pedreiro = new Pedreiro();
    
    
    // private String [][] superficie = new String[tamanhoY][tamanhoX];

    private ArrayList<ArrayList<String>> superficie = new ArrayList<>();
    private ArrayList<ArrayList<Objeto>> superficieObjetos = new ArrayList<>();

    void atualizarMapa(int input){

        int incremento = 50;
        String [][] novaSuperficie = new String[tamanhoY+incremento][tamanhoX+incremento];
        this.tamanhoX+=incremento;
        this.tamanhoY+=incremento;
        int novoTamanhoX = this.tamanhoX;
        int novoTamanhoY = this.tamanhoY;
        
        
        
        
        
        int i = 0;
        int j = 0;
        // int tamanho = 0;
        // int b = 0;
        // String checkLinha = new String();
        // String checkColuna = new String();

        double aaaa = Math.random();

        

        // while(i<tamanhoY-incremento){
        //     while(j<tamanhoX-incremento){
        //         novaSuperficie[i][j] = superficie[i][j];
        //         j++;
        //     }
        //     i++;
        // }


        // try {
        //     while(true) {
        //         checkLinha = superficie[j][i];
        //         try {
        //             i = 0;
        //             while(true){
        //                 checkColuna = superficie[j][i];
        //             }
        //         } 
        //         catch (Exception e) {
        //             j++;
                    
        //         }
                
        //     }
        // } 
        
        // catch (Exception e) {
            
        // }

        


    }


    void movimentou(String mapaAntigo[][]){


    }


    void criarMapa(){
        
        int i = 0;
        int a = 0;
        int b = 0;
        Random gerador = new Random();
        double aleatorio; 
        Nada nada = new Nada();
        Pedra pedra = new Pedra();

        QuinaInferiorDireita quinaInferiorDireita = new QuinaInferiorDireita();
        QuinaInferiorEsquerda quinaInferiorEsquerda = new QuinaInferiorEsquerda();

        QuinaSuperiorDireita quinaSuperiorDireita = new QuinaSuperiorDireita();
        QuinaSuperiorEsquerda quinaSuperiorEsquerda = new QuinaSuperiorEsquerda();

        while(i<100){
            materiaisDoMapa.add(nada);
            i++;
        }
        
        i = 0;
        
        // while(i<1){
        //     materiaisDoMapa.add(pedra);
        //     i++;
        // }


        tamanhoX = 50;
        tamanhoY = 500;

        while(a<tamanhoY){
            b=0;
            superficieObjetos.add(new ArrayList<>());
            while(b<tamanhoX){
                aleatorio = gerador.nextInt(materiaisDoMapa.size());
                superficieObjetos.get(a).add(materiaisDoMapa.get((int)aleatorio));
                b++;
            }
            a++;
        }

        

    }

    public void imprimirMapa(){
        int a = 0;
        int b = 0;

        while(a<tamanhoY){
            b=0;
            while(b<tamanhoX){
                if(b == tamanhoX-1){
                    try{
                        System.out.println((superficieObjetos.get(a).get(b)).getSimbolo());

                    }

                    catch (Exception e) {
                        System.out.println("*");
                    }
                    
                }
                else{
                    try{
                        System.out.print((superficieObjetos.get(a).get(b)).getSimbolo());

                    }

                    catch (Exception e) {
                        System.out.print("*");
                    }
                }
                b++;
            }
            a++;
        }

    }


    public Player criarPlayer(String tipo, String classe, String nome, String raca){
        return todasEntidades.criarPlayer("Player", "Guerreiro", "Silvio", "Humano");
    }

    public void criarEntidade(String tipo, String classe, String nome, String raca){
        todasEntidades.criarEntidade("Npc", "Guerreiro", "Carlão", "Orc");
    }

    public void mostrarNomeDasEntidades(){
        todasEntidades.mostrarNomeDasEntidades();
    }

    public void mostrarEntidades(){
        todasEntidades.mostrarEntidades();
    }


    void playerAndou(){
        
    }

    public void construirOMapa(){
        int i = 0;

        while(i<5){
            pedreiro.construirMercado(superficieObjetos);
            pedreiro.construirCasa(superficieObjetos);
            i++;
        }
        
        
    }


   
    // Object[][] materiasDeConstrução(){

    // }


   }

  




