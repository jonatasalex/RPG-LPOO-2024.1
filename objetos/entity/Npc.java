package objetos.entity;


import java.util.Random;
import main.ControladorDeClasses;
import main.GamePanel;
import objetos.Lugar;


public class Npc extends Entidade {


    public Npc(String classe, String nome, String raca, ControladorDeClasses control, GamePanel gp, Lugar currentLocation){
        definirRaca(raca, control);
        definirTipo("Npc", control);
        definirClasse(classe, control);
        definirNome(nome);
        setGp(gp);
        setCurrentLocation(currentLocation);
        colocarNpc();
        setImage("/res/npc");
        setDirection("down");
        getStatus().setStaminaAtual(getStatus().getStaminaTotal());
        getStatus().setVidaAtual(getStatus().getVidaTotal());
    }
    
    
    
    
    
    
    void colocarNpc() {
    	
    	Random gerador = new Random();
    	
    	int aleatorioX;
    	int aleatorioY;
    	
    	int columns = getCurrentLocation().getTamanhoX(); 
    	int rows = getCurrentLocation().getTamanhoY();
    	
    	while(true) {
    		
    		aleatorioX = 24 + gerador.nextInt((columns-25)-24+1);
        	aleatorioY = 14 + gerador.nextInt((rows-13)-14+1);
        	
        	
        	if(getCurrentLocation().getSuperficieObjetos().get(aleatorioY).get(aleatorioX).getColisor() == false) {
        		
        		setCoordinatesY(aleatorioY*40);
        		setCoordinatesX(aleatorioX*40);
        		getCurrentLocation().getSuperficie().get(aleatorioY).set(aleatorioX,this);
        		break;
        	}
        	
    		
    	}
    	
    	
    	
    	
    	
    }
    
    
    
    
    
}
