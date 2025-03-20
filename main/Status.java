package main;

public class Status {
    private int vidaTotal;
    private int vidaAtual;
    private int level;
    private int staminaTotal;
    private int staminaAtual;

 

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
    
    
    
    public void curar(int cura) {
    	if(cura + vidaAtual<=vidaTotal) {
    		vidaAtual = cura + vidaAtual;
    	}
    	else {
    		vidaAtual = vidaTotal;
    	}
    }



    public void setLevel(int level){
        this.level = level;
    }
    
    public void adicionarLevel() {
    	level = level + 1;
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
    
    public int getLevel() {
		return level;
	}
}
