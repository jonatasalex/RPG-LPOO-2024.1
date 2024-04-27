package source;

import java.util.ArrayList;

import source.objetos.Entidade;
import source.objetos.Player;

public class ControleDeEntidades {
    private int tamanhoDaLista = 50;
    private ArrayList<Entidade> listaDeEntidades = new ArrayList<>();
    // private Entidade listaDeEntidades [] = new Entidade[tamanhoDaLista]; 
    private int numeroDeEntidades = 0;

    private ControladorDeClasses controlClasses = new ControladorDeClasses();

    
    
    public Player criarPlayer(String tipo, String classe, String nome, String raca){
        Player novaEntidade = new Player(tipo, classe, nome, raca, controlClasses);
        guardarEntidades(novaEntidade);
        return novaEntidade;
        // this.listaDeEntidades.append(novaEntidade);
        //novaEntidade.id = 124564856412;


    }

    public void criarEntidade(String tipo, String classe, String nome, String raca){
        Entidade novaEntidade = new Entidade(tipo, classe, nome, raca, controlClasses);
        guardarEntidades(novaEntidade);
        // this.listaDeEntidades.append(novaEntidade);
        //novaEntidade.id = 124564856412;


    }

    void guardarEntidades(Entidade entidade){

        // if(numeroDeEntidades<tamanhoDaLista){
        //     listaDeEntidades[numeroDeEntidades] = entidade;
        //     numeroDeEntidades++;

        // }

        // else{
        //     Entidade listaDeEntidadesReserva [] = new Entidade[tamanhoDaLista+(tamanhoDaLista/10)];
        //     int i = 0;
        //     while(i<tamanhoDaLista){
        //         listaDeEntidadesReserva[i] = listaDeEntidades[i];
        //     }
        //     listaDeEntidades = listaDeEntidadesReserva;
        //     listaDeEntidades[numeroDeEntidades] = entidade;
        //     numeroDeEntidades++;
        // }

        listaDeEntidades.add(entidade);
        numeroDeEntidades++;
        

    }

    public void mostrarEntidades(){
        int i = 0;
        try {
            while(i<tamanhoDaLista){
                System.out.println(listaDeEntidades.get(i));
                i++;
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

    public void mostrarNomeDasEntidades(){
        int i = 0;

        try {
            while(i<tamanhoDaLista){
                System.out.println((listaDeEntidades.get(i)).getNome());
                i++;
            
            } 
        }

        catch (Exception e) {
            // TODO: handle exception
        }

   
    }
    
}
