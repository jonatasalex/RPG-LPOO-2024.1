package objetos;
import java.util.Random;
import java.util.ArrayList;
import objetos.construções.*;
//import objetos.construções.buildings.Casa;
import objetos.construções.materiais.Grama;
import objetos.construções.materiais.Grama2;
import objetos.construções.materiais.Grama3;
import objetos.construções.materiais.Grama4;
import objetos.construções.materiais.Grama5;
import objetos.construções.materiais.Lama;
import objetos.construções.materiais.Pedra;
import objetos.construções.materiais.QuinaInferiorDireita;
import objetos.construções.materiais.QuinaInferiorEsquerda;
import objetos.construções.materiais.QuinaSuperiorDireita;
import objetos.construções.materiais.QuinaSuperiorEsquerda;
import objetos.construções.materiais.Spawn;
import objetos.entity.Player;

import main.ControleDeEntidades;
import main.ControleDeObjetos;
import main.GamePanel;


public class Mapa extends Lugar {


    public Mapa(int x, int y, GamePanel gp){
    	
        
        todosObjetos = new ControleDeObjetos();
        
        todasAsLocalidades = new ArrayList<>();
        criarMapa(x,y);
        todasAsLocalidades.add(this);
        setProporcao(x);
        construirOMapa();
        getTodasEntidades().povoarMapa(gp, this);

        
        
        
    }

    // public Mapa(){
    //     materiaisDoMapa = new ArrayList<>();
    //     todosObjetos = new ControleDeObjetos();
    //     todasEntidades  = new ControleDeEntidades();
    //     pedreiro = new Pedreiro();
    //     todasAsLocalidades = new ArrayList<>();
    //     criarMapa();
    //     todasAsLocalidades.add(this);
        
        
        
    // }

    
    
    private ControleDeObjetos todosObjetos;
    
    
    private ArrayList<Lugar> todasAsLocalidades;
    private int ids = 0;

    
    
    // private String [][] superficie = new String[tamanhoY][tamanhoX];

    
    // private ArrayList<ArrayList<Objeto>> superficieObjetos = new ArrayList<>();

    


  


    void criarMapa(int x, int y){
        
        int i = 0;
        int a = 0;
        int b = 0;
        Random gerador = new Random();
        double aleatorio; 
        Grama grama = new Grama();
        Grama2 grama2 = new Grama2();
        Grama3 grama3 = new Grama3();
        Grama4 grama4 = new Grama4();
        Grama5 grama5 = new Grama5();
        Lama lama = new Lama();
        Portao portao = new Portao();
        
        
        Pedra pedra = new Pedra();
        Spawn spawn = new Spawn();

        QuinaInferiorDireita quinaInferiorDireita = new QuinaInferiorDireita();
        QuinaInferiorEsquerda quinaInferiorEsquerda = new QuinaInferiorEsquerda();

        QuinaSuperiorDireita quinaSuperiorDireita = new QuinaSuperiorDireita();
        QuinaSuperiorEsquerda quinaSuperiorEsquerda = new QuinaSuperiorEsquerda();

        while(i<20){
            
            getMateriaisDoMapa().add(grama2);
            getMateriaisDoMapa().add(grama2);
            getMateriaisDoMapa().add(grama3);
            getMateriaisDoMapa().add(grama3);
            getMateriaisDoMapa().add(grama4);
            getMateriaisDoMapa().add(grama4);
            getMateriaisDoMapa().add(grama5);
            getMateriaisDoMapa().add(grama5);
            i++;
        }
        getMateriaisDoMapa().add(lama);
        
        i = 0;
        
        // while(i<1){
        //     materiaisDoMapa.add(pedra);
        //     i++;
        // }


        setTamanhoX(x);
        setTamanhoY(y);

        while(a<getTamanhoY()){
            b=0;
            getSuperficieObjetos().add(new ArrayList<>());
            getSuperficie().add(new ArrayList<>());
            while(b<getTamanhoX()){
            	
            	if(b == (((920*4)-40)/40)+23 && a == (((520*2)-40)/40)+13 ) {
            		getSuperficieObjetos().get(a).add(spawn);
            		getSuperficie().get(a).add(spawn);
            		
            	}
            	else {
            		aleatorio = gerador.nextInt(getMateriaisDoMapa().size());
                    getSuperficieObjetos().get(a).add(getMateriaisDoMapa().get((int)aleatorio));
                    getSuperficie().get(a).add(getMateriaisDoMapa().get((int)aleatorio));
            	}
                
                b++;
            }
            a++;
        }
        
        cercarMapa(pedra, quinaInferiorDireita, portao, portao);
        
        

        

    }

    public void imprimirMapa(){
        int a = 0;
        int b = 0;

        while(a<getTamanhoY()){
            b=0;
            while(b<getTamanhoX()){
                if(b == getTamanhoX()-1){
                    try{
                        System.out.println(( getSuperficieObjetos().get(a).get(b)).getSimbolo());

                    }

                    catch (Exception e) {
                        System.out.println("*");
                    }
                    
                }
                else{
                    try{
                        System.out.print(( getSuperficieObjetos().get(a).get(b)).getSimbolo());

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


    // public Player criarPlayer(String tipo, String classe, String nome, String raca){
    //     return todasEntidades.criarPlayer("Player", "Guerreiro", "Silvio", "Humano");
    // }

    public void criarNpc(String tipo, String classe, String nome, String raca, GamePanel gp, Lugar currentLocation){
        getTodasEntidades().criarNpc("Guerreiro", "Carlão", "Orc", gp, this);
    }

    public void mostrarNomeDasEntidades(){
        getTodasEntidades().mostrarNomeDasEntidades();
    }

    public void mostrarEntidades(){
        getTodasEntidades().mostrarEntidades();
    }


    

    public void construirOMapa(){
        int i = 0;
        int valor;

        while(i<50){
            // pedreiro.construirMercado(superficieObjetos);
            valor = getPedreiro().construirCasa(getSuperficieObjetos(), getTamanhoX(), getTamanhoY());

//            if(valor == 1){
////                Casa novaCasa = new Casa();
////                todasAsLocalidades.add(novaCasa);
//                // todasEntidades.newNpc(novaCasa.getNpcs());
//                //arquiteto.construirCasa(novaCasa.getSuperficieObjetos());
////                ids++;
////                novaCasa.setIndex(ids);
////                novaCasa.setDestino(this);
//            }

            i++;
        }
        
        
    }

    

    public Lugar getPlace(int id){
        return todasAsLocalidades.get(id);
    }


    private void cercarMapa(Pedra pedra, QuinaInferiorDireita quinaInferiorDireita, Portao portaoCima, Portao portaoBaixo  ) {
    	
    	int a = 0;
        int b = 0;
        
        addPortoes(portaoCima);
        addPortoes(portaoBaixo);
    	
    	
        while(a < getTamanhoY()){
            b = 0;
//            getSuperficieObjetos().add(new ArrayList<>());
            while(b < getTamanhoX()){
                
            	if(
                        (a < 12) ||  
                        (a > getTamanhoY() - 12) ||  
                        (b < 22) ||  
                        (b > getTamanhoX() - 24)     
                    ) {
                        getSuperficieObjetos().get(a).set(b, quinaInferiorDireita);
                    }

                if(
                    (a == 12 && b >= 22 && b <= getTamanhoX() - 24) || 
                    (a == getTamanhoY() - 12 && b >= 22 && b <= getTamanhoX() - 24) || 
                    (b == 22 && a >= 13 && a <= getTamanhoY() - 13) || 
                    (b == getTamanhoX() - 24 && a >= 13 && a <= getTamanhoY() - 13)
                ) {
                    getSuperficieObjetos().get(a).set(b, pedra);
                }
                
                int meioX1 = 22 + (getTamanhoX() - 24 - 22) / 3;  // Primeira posição de portão
                int meioX2 = 22 + 2 * (getTamanhoX() - 24 - 22) / 3;  // Segunda posição de portão

                if(
                    (a == 12 && (b == meioX1 || b == meioX2))  // Portões superiores
                    
                ) {
                    getSuperficieObjetos().get(a).set(b, portaoCima);
                }
                
                if((a == getTamanhoY() - 12 && (b == meioX1 || b == meioX2))){
                	getSuperficieObjetos().get(a).set(b, portaoBaixo);
                	// Portões inferiores)
                }

                b++;
            }
            a++;
        }
        
       

        

    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }


   
    // Object[][] materiasDeConstrução(){

    // }


   }

  




