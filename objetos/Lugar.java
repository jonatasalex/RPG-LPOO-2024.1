package objetos;

import java.util.ArrayList;

import main.ControleDeEntidades;
import objetos.construções.Portao;

public class Lugar {

    private ArrayList<ArrayList<Objeto>> superficieObjetos;
    private ArrayList<ArrayList<Objeto>> superficie;
    private int tamanhoX;
    private int tamanhoY;
    private int proporcao;
    private int index;
    private ControleDeEntidades todasEntidades;

    public Lugar(){
    	todasEntidades = new ControleDeEntidades();
        superficieObjetos = new ArrayList<>();
        superficie = new ArrayList<>();
        pedreiro = new Pedreiro();
        materiaisDoMapa = new ArrayList<>();
        portoes = new ArrayList<>();
    }
    
    
    
    private int playerX;
    private int playerY;
    private int playerIX;
    private int playerIY;
    private Pedreiro pedreiro;
    private ArrayList<Objeto> materiaisDoMapa;
    private ArrayList<Portao> portoes;





    public ArrayList<ArrayList<Objeto>> getSuperficieObjetos() {
        return superficieObjetos;
    }


    public ArrayList<ArrayList<Objeto>> getSuperficie() {
        return superficie;
    }

    public int getTamanhoX() {
        return tamanhoX;
    }

    public int getTamanhoY() {
        return tamanhoY;
    }

    public void setTamanhoX(int tamanhoX) {
        this.tamanhoX = tamanhoX;
    }

    public void setTamanhoY(int tamanhoY) {
        this.tamanhoY = tamanhoY;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public int getPlayerX() {
        return playerX;
    }
    public int getPlayerY() {
        return playerY;
    }

    public int getProporcao(){
        return proporcao;
    }
    
    public void setProporcao(int x){
        this.proporcao = x/48;
    }
    
    public ControleDeEntidades getControleDeEntidades(){

        return this.todasEntidades;
    }
    
    public ControleDeEntidades getTodasEntidades() {
		return todasEntidades;
	}
    
    public void setTodasEntidades(ControleDeEntidades todasEntidades) {
		this.todasEntidades = todasEntidades;
	}
    
    public Pedreiro getPedreiro() {
		return pedreiro;
	}

    
    public  ArrayList<Objeto> getMateriaisDoMapa(){
    	return materiaisDoMapa;
   }
  
    public ArrayList<Portao> getPortoes() {
    	return portoes;
   }

    public void setPortoes(ArrayList<Portao> portoes) {
    	this.portoes = portoes;
   }
    
   public void addPortoes(Portao portao) {
	   portoes.add(portao);
   }
   
   public int getPlayerIX() {
	return playerIX;
   }
   public int getPlayerIY() {
	return playerIY;
   }
   
   public void setPlayerIX(int playerIX) {
	this.playerIX = playerIX;
   }
   public void setPlayerIY(int playerIY) {
	this.playerIY = playerIY;
   }
   
   


    
}
