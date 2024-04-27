package source.objetos;

public class PlayerStatus {
    private int level = 1;
    private int vidaTotal = 0;
    private int manaTotal = 50;
    private int staminaTotal = 20;


    int getPlayerVidaTotal(){
        return this.vidaTotal;
    }

    int getPlayerLevel(){
        return this.level;
    }

    int getPlayerManaTotal(){
        return this.manaTotal;
    }

    int getPlayerStaminaTotal(){
        return this.staminaTotal;
    }
    
}
