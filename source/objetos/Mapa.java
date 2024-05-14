package source.objetos;
import java.util.Random;
import java.util.ArrayList;
import source.objetos.construções.*;
import source.objetos.construções.buildings.Casa;
import source.objetos.construções.materiais.Grama;
import source.objetos.construções.materiais.Pedra;
import source.objetos.construções.materiais.QuinaInferiorDireita;
import source.objetos.construções.materiais.QuinaInferiorEsquerda;
import source.objetos.construções.materiais.QuinaSuperiorDireita;
import source.objetos.construções.materiais.QuinaSuperiorEsquerda;
import source.objetos.entity.Player;
import source.*;
import source.main.ControleDeEntidades;
import source.main.ControleDeObjetos;


public class Mapa extends Lugar {


    public Mapa(){
        criarMapa();
        todasAsLocalidades.add(this);
        
        
    }

    
    private ArrayList<Objeto> materiaisDoMapa = new ArrayList<>();
    private ControleDeObjetos todosObjetos = new ControleDeObjetos();
    private ControleDeEntidades todasEntidades = new ControleDeEntidades();
    private Pedreiro pedreiro = new Pedreiro();
    private ArrayList<Lugar> todasAsLocalidades = new ArrayList<>();
    private int ids = 0;

    
    
    // private String [][] superficie = new String[tamanhoY][tamanhoX];

    
    // private ArrayList<ArrayList<Objeto>> superficieObjetos = new ArrayList<>();

    void atualizarMapa(int input){

        int incremento = 50;
        String [][] novaSuperficie = new String[getTamanhoY()+incremento][getTamanhoX()+incremento];
        // this.getTamanhoX()+=incremento;
        // this.tamanhoY+=incremento;
        // int novoTamanhoX = this.tamanhoX;
        // int novoTamanhoY = this.tamanhoY;
        
        
        
        
        
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
        Grama grama = new Grama();
        Pedra pedra = new Pedra();

        QuinaInferiorDireita quinaInferiorDireita = new QuinaInferiorDireita();
        QuinaInferiorEsquerda quinaInferiorEsquerda = new QuinaInferiorEsquerda();

        QuinaSuperiorDireita quinaSuperiorDireita = new QuinaSuperiorDireita();
        QuinaSuperiorEsquerda quinaSuperiorEsquerda = new QuinaSuperiorEsquerda();

        while(i<100){
            materiaisDoMapa.add(grama);
            i++;
        }
        
        i = 0;
        
        // while(i<1){
        //     materiaisDoMapa.add(pedra);
        //     i++;
        // }


        setTamanhoX(48);
        setTamanhoY(27);

        while(a<getTamanhoY()){
            b=0;
            getSuperficieObjetos().add(new ArrayList<>());
            while(b<getTamanhoX()){
                aleatorio = gerador.nextInt(materiaisDoMapa.size());
                getSuperficieObjetos().get(a).add(materiaisDoMapa.get((int)aleatorio));
                b++;
            }
            a++;
        }
        

        

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

    public void criarNpc(String tipo, String classe, String nome, String raca){
        todasEntidades.criarNpc("Npc", "Guerreiro", "Carlão", "Orc");
    }

    public void mostrarNomeDasEntidades(){
        todasEntidades.mostrarNomeDasEntidades();
    }

    public void mostrarEntidades(){
        todasEntidades.mostrarEntidades();
    }


    void playerAndou(int x, int y){
        
        // getSuperficieObjetos()






        
    }

    public void construirOMapa(){
        int i = 0;
        int valor;

        while(i<5){
            // pedreiro.construirMercado(superficieObjetos);
            valor = pedreiro.construirCasa(getSuperficieObjetos());

            if(valor == 1){
                Casa novaCasa = new Casa();
                todasAsLocalidades.add(novaCasa);
                // todasEntidades.newNpc(novaCasa.getNpcs());
                //arquiteto.construirCasa(novaCasa.getSuperficieObjetos());
                ids++;
                novaCasa.setIndex(ids);
                novaCasa.setDestino(this);
            }

            i++;
        }
        
        
    }

    public ControleDeEntidades getControleDeEntidades(){

        return this.todasEntidades;
    }

    public Lugar getPlace(int id){
        return todasAsLocalidades.get(id);
    }


    


   
    // Object[][] materiasDeConstrução(){

    // }


   }

  




