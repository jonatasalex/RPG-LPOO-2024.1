package objetos.entity.status;
public class NpcStatus {
    private int level = 1;
    private int vidaTotal = 15;
    private int manaTotal = 50;
    private int staminaTotal = 20;


    public int getNpcVidaTotal(){
        return this.vidaTotal;
    }
    public int getNpcLevel(){
        return this.level;
    }

    public int getNpcManaTotal(){
        return this.manaTotal;
    }

    public int getNpcStaminaTotal(){
        return this.staminaTotal;
    }
    

}
