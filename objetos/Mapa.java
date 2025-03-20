package objetos;
import java.util.Random;
import java.util.ArrayList;
import objetos.construções.*;
import objetos.construções.materiais.Flor1;
import objetos.construções.materiais.Flor2;
import objetos.construções.materiais.Flor3;
import objetos.construções.materiais.Flor4;
import objetos.construções.materiais.Flor5;
import objetos.construções.materiais.Flor6;
import objetos.construções.materiais.Flor7;
import objetos.construções.materiais.Flor8;


import objetos.construções.materiais.Grama2;
import objetos.construções.materiais.Grama3;
import objetos.construções.materiais.Grama4;
import objetos.construções.materiais.Grama5;
import objetos.construções.materiais.Lama;
import objetos.construções.materiais.Pedra;
import objetos.construções.materiais.Potion;

import objetos.construções.materiais.Spawn;


import main.GamePanel;


public class Mapa extends Lugar {


    public Mapa(int x, int y, GamePanel gp){
    	
        
    
        
        todasAsLocalidades = new ArrayList<>();
        criarMapa(x,y);
        todasAsLocalidades.add(this);
        setProporcao(x);
        construirOMapa();
        getTodasEntidades().povoarMapa(gp, this);

        
        
        
    }


    

    
    
    private ArrayList<Lugar> todasAsLocalidades;


    



  


    private void criarMapa(int x, int y){
        
        int i = 0;
        int a = 0;
        int b = 0;
        Random gerador = new Random();
        int aleatorio; 
      
        Grama2 grama2 = new Grama2();
        Grama3 grama3 = new Grama3();
        Grama4 grama4 = new Grama4();
        Grama5 grama5 = new Grama5();
        Flor1 flor1 = new Flor1();
        Flor2 flor2 = new Flor2();
        Flor3 flor3 = new Flor3();
        Flor4 flor4 = new Flor4();
        Flor5 flor5 = new Flor5();
        Flor6 flor6 = new Flor6();
        Flor7 flor7 = new Flor7();
        Flor8 flor8 = new Flor8();
        
        Potion potion = new Potion();
        
        Lama lama = new Lama();
        Portao portao = new Portao();
        
        
        Pedra pedra = new Pedra();
        Spawn spawn = new Spawn();



        while(i<20){
            
            getMateriaisDoMapa().add(grama2);
            getMateriaisDoMapa().add(grama2);
            getMateriaisDoMapa().add(grama3);
            getMateriaisDoMapa().add(grama3);
            getMateriaisDoMapa().add(grama4);
            getMateriaisDoMapa().add(grama4);
            getMateriaisDoMapa().add(grama5);
            getMateriaisDoMapa().add(grama5);
            
            getMateriaisDoMapa().add(grama2);
            getMateriaisDoMapa().add(grama2);
            getMateriaisDoMapa().add(grama3);
            getMateriaisDoMapa().add(grama3);
            getMateriaisDoMapa().add(grama4);
            getMateriaisDoMapa().add(grama4);
            getMateriaisDoMapa().add(grama5);
            getMateriaisDoMapa().add(grama5);
            
            getMateriaisDoMapa().add(grama2);
            getMateriaisDoMapa().add(grama2);
            getMateriaisDoMapa().add(grama3);
            getMateriaisDoMapa().add(grama3);
            getMateriaisDoMapa().add(grama4);
            getMateriaisDoMapa().add(grama4);
            getMateriaisDoMapa().add(grama5);
            getMateriaisDoMapa().add(grama5);
            
            getMateriaisDoMapa().add(grama2);
            getMateriaisDoMapa().add(grama2);
            getMateriaisDoMapa().add(grama3);
            getMateriaisDoMapa().add(grama3);
            getMateriaisDoMapa().add(grama4);
            getMateriaisDoMapa().add(grama4);
            getMateriaisDoMapa().add(grama5);
            getMateriaisDoMapa().add(grama5);
            
            
            
            getMateriaisDoMapa().add(flor1);
            getMateriaisDoMapa().add(flor2);
            getMateriaisDoMapa().add(flor3);
            getMateriaisDoMapa().add(flor4);
            getMateriaisDoMapa().add(flor5);
            getMateriaisDoMapa().add(flor6);
            getMateriaisDoMapa().add(flor7);
            getMateriaisDoMapa().add(flor8);
            i++;
        }
        getMateriaisDoMapa().add(lama);
        
        i = 0;
        
         while(i<4){
        	 getMateriaisDoMapa().add(potion);
             i++;
         }


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
        
        cercarMapa(pedra, portao);
        
        

        

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

            valor = getPedreiro().construirCasa(getSuperficieObjetos(), getTamanhoX(), getTamanhoY());



            i++;
        }
        
        
    }

    

    public Lugar getPlace(int id){
        return todasAsLocalidades.get(id);
    }


    private void cercarMapa(Pedra pedra, Portao portaoCima  ) {
    	int aleatorio;
    	int a = 0;
        int b = 0;
        Random gerador = new Random();
        
        addPortoes(portaoCima);
        
    	
    	
        while(a < getTamanhoY()){
            b = 0;

            while(b < getTamanhoX()){
            	aleatorio = gerador.nextInt(getMateriaisDoMapa().size());
                
            	if(
                        (a < 12) ||  
                        (a > getTamanhoY() - 12) ||  
                        (b < 22) ||  
                        (b > getTamanhoX() - 24)     
                    ) {
	            		if(getMateriaisDoMapa().get(aleatorio) instanceof Potion) {
	        				
	        			}
	        			else {
	        				getSuperficieObjetos().get(a).set(b, getMateriaisDoMapa().get(aleatorio));
	        				
	        			}
                    }

                if(
                    (a == 12 && b >= 22 && b <= getTamanhoX() - 24) || 
                    (a == getTamanhoY() - 12 && b >= 22 && b <= getTamanhoX() - 24) || 
                    (b == 22 && a >= 13 && a <= getTamanhoY() - 13) || 
                    (b == getTamanhoX() - 24 && a >= 13 && a <= getTamanhoY() - 13)
                ) {
                    getSuperficieObjetos().get(a).set(b, pedra);
                }
                
                int meioX1 = 22 + (getTamanhoX() - 24 - 22) / 3;  
                int meioX2 = 22 + 2 * (getTamanhoX() - 24 - 22) / 3;  

                if(
                    (a == 12 && (b == meioX1 || b == meioX2))  
                    
                ) {
                    getSuperficieObjetos().get(a).set(b, portaoCima);
                }
                
               

                b++;
            }
            a++;
        }
        
  	
    	
    }
    
    


   



   }

  




