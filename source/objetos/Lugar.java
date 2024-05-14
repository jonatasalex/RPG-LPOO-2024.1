package source.objetos;

import java.util.ArrayList;

public class Lugar {

    private ArrayList<ArrayList<Objeto>> superficieObjetos = new ArrayList<>();
    private ArrayList<ArrayList<Objeto>> superficie = new ArrayList<>();
    private int tamanhoX;
    private int tamanhoY;
    private int index;
    
    private int playerX;
    private int playerY;






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


    
}
