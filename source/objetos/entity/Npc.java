package source.objetos.entity;

import source.main.ControladorDeClasses;

public class Npc extends Entidade {


    public Npc(String tipo, String classe, String nome, String raca, ControladorDeClasses control){
        definirRaca(raca, control);
        definirTipo(tipo, control);
        definirClasse(classe, control);
        definirNome(nome);
    }
    
}
