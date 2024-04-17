package source;
import java.util.Random;


public class Mapa {

    private int tamanhoX;
    private int tamanhoY;
    private Random gerador = new Random();
    private double aleatorio = gerador.nextInt(24);
    
    private String [][] superficie = new String[tamanhoY][tamanhoX];

    void atualizarMapa(int input){

        int incremento = 50;
        String [][] novaSuperficie = new String[tamanhoY+incremento][tamanhoX+incremento];
        this.tamanhoX+=incremento;
        this.tamanhoY+=incremento;
        int novoTamanhoX = this.tamanhoX;
        int novoTamanhoY = this.tamanhoY;
        
        
        
        
        
        int i = 0;
        int j = 0;
        // int tamanho = 0;
        // int b = 0;
        // String checkLinha = new String();
        // String checkColuna = new String();

        double aaaa = Math.random();

        

        while(i<tamanhoY-incremento){
            while(j<tamanhoX-incremento){
                novaSuperficie[i][j] = superficie[i][j];
                j++;
            }
            i++;
        }


        // try {
        //     while(true) {
        //         checkLinha = superficie[j][i];
        //         try {
        //             i = 0;
        //             while(true){
        //                 checkColuna = superficie[j][i];
        //             }
        //         } 
        //         catch (Exception e) {
        //             j++;
                    
        //         }
                
        //     }
        // } 
        
        // catch (Exception e) {
            
        // }

        


    }


    void movimentou(String mapaAntigo[][]){


    }


    void criarMapa(){

    }
    
}
