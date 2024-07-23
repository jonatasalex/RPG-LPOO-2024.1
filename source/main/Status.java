package main;

public class Status {
    private int vidaTotal;
    private int vidaAtual;
    private int level;
    private int staminaTotal;
    private int staminaAtual;

    private int forca;
    private int agilidade;
    private int resistencia;
    private int sorte;

    private int velocidade;
    
    public Status() {
    	velocidade = 10;
    }
    


    public void setVidaTotal(int vida){
        this.vidaTotal = vida;
    }

    public void setVidaAtual(int vida){
        this.vidaAtual = vida;

    }

   

    public void setStaminaTotal(int stamina){
        this.staminaTotal = stamina;
    }

    public void setStaminaAtual(int stamina){
        this.staminaAtual = stamina;

    }


    public void setForca(int forca){
        this.forca = forca;
    }
    
    public void setAgilidade(int agilidade){
        this.agilidade = agilidade;
    }

    public void setResistencia(int resistencia){
        this.resistencia = resistencia;
    }

    public void setSorte(int sorte){
        this.sorte = sorte;
    }






    public void alterarVidaTotal(int vida){
        this.vidaTotal+=vida;

    }


    public void alterarVidaAtual(int vida){
        this.vidaAtual+=vida;

    }




    public void alterarStaminaTotal(int stamina){
        this.staminaTotal+=stamina;

    }



    public void alterarStaminaAtual(int stamina){
        this.staminaAtual+=stamina;

    }
    
    
    public void levarDano(int dano) {
    	if((vidaAtual - dano)>=0) {
    		vidaAtual = vidaAtual - dano;
    	}
    	else {
    		vidaAtual = 0;
    	}
    }
    
    public void cansar(int stamina) {
    	if((staminaAtual - stamina)>=0) {
    		staminaAtual = staminaAtual - stamina;
    	}
    	else {
    		staminaAtual = 0;
    	}
    }
    
    
    

    public void alterarForca(int forca){
        this.forca+=forca;

    }

    public void alterarAgilidade(int agilidade){
        this.agilidade+=agilidade;

    }

    public void alterarResistencia(int resistencia){
        this.resistencia+=resistencia;

    }

    public void alterarSorte(int sorte){
        this.sorte+=sorte;
    }



    public void setLevel(int level){
        this.level = level;
    }

    public int getVidaTotal(){
        return this.vidaTotal;
    }
    
    public int getVelocidade(){
        return this.velocidade;
    }
    
    public void setVelocidade(int v) {
    	this.velocidade = v;
    }
    
    public int getVidaAtual() {
    	return vidaAtual;
    }
    
    public int getStaminaAtual() {
		return staminaAtual;
	}
    public int getStaminaTotal() {
		return staminaTotal;
	}
}
