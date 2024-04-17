package source;



public class ControleDeEntidades {
    private int tamanhoDaLista = 50;
    private Entidade listaDeEntidades [] = new Entidade[tamanhoDaLista]; 
    private int numeroDeEntidades = 0;

    private ControladorDeClasses controlClasses = new ControladorDeClasses();

    
    
    public Entidade criarPlayer(String tipo, String classe, String nome, String raca){
        Entidade novaEntidade = new Entidade(tipo, classe, nome, raca, controlClasses);
        checarNumeroDeEntidades(novaEntidade);
        return novaEntidade;
        // this.listaDeEntidades.append(novaEntidade);
        //novaEntidade.id = 124564856412;


    }

    public void criarEntidade(String tipo, String classe, String nome, String raca){
        Entidade novaEntidade = new Entidade(tipo, classe, nome, raca, controlClasses);
        checarNumeroDeEntidades(novaEntidade);
        // this.listaDeEntidades.append(novaEntidade);
        //novaEntidade.id = 124564856412;


    }

    void checarNumeroDeEntidades(Entidade entidade){

        if(numeroDeEntidades<tamanhoDaLista){
            listaDeEntidades[numeroDeEntidades] = entidade;
            numeroDeEntidades++;

        }

        else{
            Entidade listaDeEntidadesReserva [] = new Entidade[tamanhoDaLista+(tamanhoDaLista/10)];
            int i = 0;
            while(i<tamanhoDaLista){
                listaDeEntidadesReserva[i] = listaDeEntidades[i];
            }
            listaDeEntidades = listaDeEntidadesReserva;
            listaDeEntidades[numeroDeEntidades] = entidade;
            numeroDeEntidades++;
        }
        

    }

    public void mostrarEntidades(){
        int i = 0;

        while(i<tamanhoDaLista){
            System.out.println(listaDeEntidades[i]);
            i++;
        }
    }

    public void mostrarNomeDasEntidades(){
        int i = 0;

        try {
            while(i<tamanhoDaLista){
                System.out.println((listaDeEntidades[i]).getNome());
                i++;
            
            } 
        }

        catch (Exception e) {
            // TODO: handle exception
        }

   
    }
    
}
