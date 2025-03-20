package objetos;

import java.util.ArrayList;
import java.util.Random;


import main.GamePanel;
import objetos.construções.Portao;

import objetos.construções.materiais.Grama2;
import objetos.construções.materiais.Grama3;
import objetos.construções.materiais.Grama4;
import objetos.construções.materiais.Grama5;
import objetos.construções.materiais.Lama;
import objetos.construções.materiais.Pedra;
import objetos.construções.materiais.Potion;

import objetos.construções.materiais.Spawn;

public class Planicie extends Lugar {
	
	public Planicie(int x, int y, GamePanel gp) {
		
		
        criarMapa(x,y);
        setProporcao(x);
      
        getTodasEntidades().povoarMapa(gp, this);
		
		
	}
	
	
	void criarMapa(int x, int y){
        
        int i = 0;
        int a = 0;
        int b = 0;
        Random gerador = new Random();
        double aleatorio; 
        
        Grama2 grama2 = new Grama2();
        Grama3 grama3 = new Grama3();
        Grama4 grama4 = new Grama4();
        Grama5 grama5 = new Grama5();
        Lama lama = new Lama();
        Portao portao = new Portao();
        
        Potion potion = new Potion();
        
        
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
            i++;
        }
        getMateriaisDoMapa().add(lama);
        getMateriaisDoMapa().add(potion);
        
        i = 0;
        
    
   


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
	
	private void cercarMapa(Pedra pedra, Portao portaoBaixo  ) {
		
		int a = 0;
	    int b = 0;
	    Random gerador = new Random();
	    
	    addPortoes(portaoBaixo);
	    int aleatorio;
		
		
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
	
	            
	            
	            if((a == getTamanhoY() - 12 && (b == meioX1 || b == meioX2))){
	            	getSuperficieObjetos().get(a).set(b, portaoBaixo);
	            	
	            	
	            	
	   
	            }
	
	            b++;
	        }
	        a++;
	    }
	    
	   
	
	    
	
		
		
		
		
		
		
		
		
		
		
		
	}

}
