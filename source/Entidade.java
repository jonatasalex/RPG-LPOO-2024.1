package source;

import source.classes.Curandeiro;
import source.classes.Guerreiro;
import source.classes.Ladino;
import source.classes.Mago;
import source.raças.Humano;
import source.raças.Orc;

public class Entidade {
    private Status status = new Status();
    private Posicao posicao = new Posicao();
    private int id;
    private String tipo;
    private String classe;
    private String nome;
    private String raca;

    public Entidade(String tipo, String classe, String nome, String raca, ControladorDeClasses control){
        
        definirRaca(raca, control);
        definirTipo(tipo, control);
        definirClasse(classe, control);
        definirNome(nome);
        
        
    }

    private void definirTipo(String tipo, ControladorDeClasses control){

        if(tipo.equals("Npc")){
            this.tipo = "Npc";
            status.alterarVidaTotal(control.getNpc().getNpcVidaTotal());
            status.setLevel(control.getNpc().getNpcLevel());
            status.alterarManaTotal(control.getNpc().getNpcManaTotal());
            status.alterarStaminaTotal(control.getNpc().getNpcStaminaTotal());

        }

        else if(tipo.equals("Player")){
            this.tipo = "Player";
            status.alterarVidaTotal(control.getPlayer().getPlayerVidaTotal());
            status.setLevel(control.getPlayer().getPlayerLevel());
            status.alterarManaTotal(control.getPlayer().getPlayerManaTotal());
            status.alterarStaminaTotal(control.getPlayer().getPlayerStaminaTotal());
        }

        else if(tipo.equals("Companion")){

        }


    }

    private void definirClasse(String classe, ControladorDeClasses control){

        if(classe.equals("Mago")){

            
            status.alterarVidaTotal(control.getMago().getVidaMagoTotal());
            status.alterarManaTotal(control.getMago().getManaMagoTotal());


        }

        else if(classe.equals("Guerreiro")){
            
            status.alterarVidaTotal(control.getGuerreiro().getVidaGuerreiroTotal());
            status.alterarStaminaTotal(control.getGuerreiro().getStaminaGuerreiroTotal());


        }

        else if(classe.equals("Ladino")){

            
            status.alterarVidaTotal(control.getLadino().getVidaLadinoTotal());
            status.alterarStaminaTotal(control.getLadino().getStaminaLadinoTotal());


        }

        else if(classe.equals("Curandeiro")){

            
            status.alterarVidaTotal(control.getCurandeiro().getVidaCurandeiroTotal());
            status.alterarManaTotal(control.getCurandeiro().getManaCurandeiroTotal());

        }

    }

    private void definirRaca(String raca, ControladorDeClasses control){
        this.raca = raca;

        if(raca.equals("Humano")){
           

            status.setVidaTotal(control.getHumano().getHumanoVidaTotal());
            status.setStaminaTotal(control.getHumano().getHumanoStaminaTotal());
            status.setManaTotal(control.getHumano().getHumanoManaTotal());
            

        }

        else if(raca.equals("Orc")){
            

            status.setVidaTotal(control.getOrc().getOrcVidaTotal());
            status.setStaminaTotal(control.getOrc().getOrcStaminaTotal());
            status.setManaTotal(control.getOrc().getOrcManaTotal());
            
            //colocar esses orcs, humanos, magos e etc em uma classe "pai" dessa classe depois, pra evitar que um novo objeto orc, humano e etc seja criado toda vez que esses respectivos métodos sejam chamados
            
        }

    }

    private void definirId(){

    }

    private void definirNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public Status getStatus(){
        return this.status;
    }
    
}
