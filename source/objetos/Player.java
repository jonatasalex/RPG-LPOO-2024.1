package source.objetos;
import source.ControladorDeClasses;
public class Player extends Entidade {

    public Player(String tipo, String classe, String nome, String raca, ControladorDeClasses control){
        definirRaca(raca, control);
        definirTipo(tipo, control);
        definirClasse(classe, control);
        definirNome(nome);

    }



    void andar(){
        
    }
    
}
