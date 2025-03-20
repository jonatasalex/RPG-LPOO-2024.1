package main;
import java.util.Random;
import java.awt.Graphics2D;
import java.util.ArrayList;

import objetos.Lugar;
import objetos.entity.Entidade;
import objetos.entity.Npc;
import objetos.entity.Player;

public class ControleDeEntidades {
    private int tamanhoDaLista = 50;
    private ArrayList<Entidade> listaDeEntidades;

    private int numeroDeEntidades = 0;
    private Player player;
    private String[] nomes = {
            "Aelar", "Baldur", "Cyril", "Daelis", "Eldon", "Fendrel", "Garrik", "Haldor", "Ithran", "Jorund",
            "Kaelin", "Lira", "Morgana", "Nyral", "Orin", "Pyrra", "Quintis", "Rylin", "Selene", "Thalor",
            "Ulrick", "Vanya", "Wyvern", "Xander", "Yara", "Zarek", "Arin", "Bran", "Caden", "Doran",
            "Elara", "Fenris", "Gwyneth", "Harken", "Ivara", "Jareth", "Kara", "Lorien", "Merrick", "Nyssa",
            "Orion", "Perrin", "Quinn", "Rhea", "Sorin", "Taryn", "Ulric", "Vesper", "Wynne", "Xan",
            "Yven", "Zara", "Adara", "Bryn", "Calder", "Daphne", "Eamon", "Faelan", "Galen", "Hadrian",
            "Isolde", "Jaxon", "Kelda", "Larkin", "Maris", "Nolan", "Oriana", "Phaedra", "Quillon", "Rowan",
            "Seraphine", "Thorne", "Ursa", "Valen", "Wren", "Xylia", "Ysolde", "Zephyr", "Alden", "Briala",
            "Cyrus", "Daria", "Elden", "Fiora", "Gideon", "Hollis", "Ilara", "Jensen", "Kieran", "Lyra",
            "Marius", "Nessa", "Orla", "Petra", "Quintin", "Roderick", "Sable", "Tobias", "Uriah", "Violet"
        };

    private ControladorDeClasses controlClasses;

    public ControleDeEntidades(){
        controlClasses = new ControladorDeClasses();
        listaDeEntidades = new ArrayList<>();
        

    }

    
    public Player criarPlayer(String tipo, String classe, String nome, String raca, GamePanel gp, KeyHandler keyH, Lugar currentLocation){
        Player novaEntidade = new Player(tipo, classe, nome, raca, controlClasses, gp, keyH, currentLocation);
        guardarEntidades(novaEntidade);
        player = novaEntidade;
        return novaEntidade;



    }

    public void criarNpc(String classe, String nome, String raca, GamePanel gp, Lugar currentLocation){
        Npc novaEntidade = new Npc(classe, nome, raca, controlClasses, gp, currentLocation);
        guardarEntidades(novaEntidade);



    }
    
    
    public void povoarMapa(GamePanel gp, Lugar currentLocation){
    	
    	Random gerador = new Random();
    	int aleatorioC;
    	int aleatorioN;
    	int aleatorioR;
    	
    	int i = 0;
    	
    	while(i<200) {
    		aleatorioC =  gerador.nextInt(2);
    		aleatorioN =  gerador.nextInt(100);
    		aleatorioR =  gerador.nextInt(2);
    		
    		criarNpc(controlClasses.getClasses()[aleatorioC], getNomes()[aleatorioN], controlClasses.getRacas()[aleatorioR], gp, currentLocation);
    		
    		i++;
    	}
    	
    	
        


    }
    
    
    

    private void guardarEntidades(Entidade entidade){


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
    
    public String[] getNomes() {
    	return nomes;
    }
    
    public void draw(Graphics2D g2, int x, int y) {
    	
    	for (Entidade entidade : listaDeEntidades) {
    		if(entidade.getTipo().equals("Npc")) {
    			entidade.draw(g2, x, y);
    		}
            
        }
    	
    }
    
    public void update() {
    	
    	for (Entidade entidade : listaDeEntidades) {
    		if(entidade.getTipo().equals("Npc")) {
    			entidade.update();
    		}
            
        }
    	
    }
    
}
