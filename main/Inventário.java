package main;

public class Inventário {

    private int quantidadeDePocoes;

    public Inventário() {
        quantidadeDePocoes = 0;
    }

    public void pegarPocao() {
        quantidadeDePocoes++;
    }

    public int getQuantidadeDePocoes() {
        return quantidadeDePocoes;
    }

    public void usarPocao() {
        if (quantidadeDePocoes > 0) {
            quantidadeDePocoes--;
        }
    }
    
    
}