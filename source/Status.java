package source;

public class Status {
    private int vidaTotal;
    private int vidaAtual;
    private int manaTotal;
    private int manaAtual;
    private int level;
    private int staminaTotal;
    private int staminaAtual;

    private int forca;
    private int agilidade;
    private int resistencia;
    private int sorte;
    private int inteligencia;
    


    public void setVidaTotal(int vida){
        this.vidaTotal = vida;
    }

    public void setVidaAtual(int vida){
        this.vidaAtual = vida;

    }

    public void setManaTotal(int mana){
        this.manaTotal = mana;

    }

    public void setManaAtual(int mana){
        this.manaAtual = mana;
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

    public void setInteligencia(int inteligencia){
        this.inteligencia = inteligencia;

    }




    public void alterarVidaTotal(int vida){
        this.vidaTotal+=vida;

    }


    public void alterarVidaAtual(int vida){
        this.vidaAtual+=vida;

    }


    public void alterarManaTotal(int mana){
        this.manaTotal+=mana;
    }

    public void alterarStaminaTotal(int stamina){
        this.staminaTotal+=stamina;

    }

    public void alterarManaAtual(int mana){
        this.manaAtual+=mana;

    }

    public void alterarStaminaAtual(int stamina){
        this.staminaAtual+=stamina;

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

    public void alterarInteligencia(int inteligencia){
        this.inteligencia+=inteligencia;

    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getVidaTotal(){
        return this.vidaTotal;
    }
    
}
