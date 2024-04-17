import source.ControladorDeClasses;
import source.ControleDeEntidades;
import source.Entidade;
import source.classes.Guerreiro;

public class Jogo {

    
    public static void main (String[] args){

        ControleDeEntidades todasEntidades = new ControleDeEntidades();
      
        
        Entidade player = todasEntidades.criarPlayer("Player", "Guerreiro", "Silvio", "Humano");
        todasEntidades.criarEntidade("Npc", "Guerreiro", "Carlão", "Orc");
        
        // new Entidade("Player", "Guerreiro", "Silvio", "Humano");

        System.out.println(player.getNome());
        System.out.println((player.getStatus()).getVidaTotal());

        todasEntidades.mostrarNomeDasEntidades();


    }
    
}









