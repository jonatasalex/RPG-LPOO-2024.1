package source.objetos.entity;
public class NpcStatus {
    private int level = 1;
    private int vidaTotal = 15;
    private int manaTotal = 50;
    private int staminaTotal = 20;


    int getNpcVidaTotal(){
        return this.vidaTotal;
    }
    int getNpcLevel(){
        return this.level;
    }

    int getNpcManaTotal(){
        return this.manaTotal;
    }

    int getNpcStaminaTotal(){
        return this.staminaTotal;
    }
    

}
