package objetos.entity.status;

public class PlayerStatus {
    private int level = 1;
    private int vidaTotal = 0;

    private int staminaTotal = 20;


    public int getPlayerVidaTotal(){
        return this.vidaTotal;
    }

    public int getPlayerLevel(){
        return this.level;
    }



    public int getPlayerStaminaTotal(){
        return this.staminaTotal;
    }
    
}
