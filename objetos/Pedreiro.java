package objetos;
import java.util.Random;
import java.util.ArrayList;
import objetos.construções.*;
import objetos.construções.materiais.*;


public class Pedreiro {

    private ParedeHorizontal paredeHorizontal;
    private ParedeVertical paredeVertical;
    private InteriorCasa interiorCasa;
    private InteriorMercado interiorMercado;
    private QuinaInferiorDireita quinaInferiorDireita;
    private QuinaInferiorEsquerda quinaInferiorEsquerda;
    private QuinaSuperiorDireita quinaSuperiorDireita;
    private QuinaSuperiorEsquerda quinaSuperiorEsquerda;
    private Porta porta;


    public Pedreiro(){
        paredeHorizontal = new ParedeHorizontal();
        paredeVertical = new ParedeVertical();
        interiorCasa = new InteriorCasa();
        interiorMercado = new InteriorMercado();
        quinaInferiorDireita = new QuinaInferiorDireita();
        quinaInferiorEsquerda = new QuinaInferiorEsquerda();
        quinaSuperiorDireita = new QuinaSuperiorDireita();
        quinaSuperiorEsquerda = new QuinaSuperiorEsquerda();
        porta = new Porta();

    }

    public void construirMercado(ArrayList<ArrayList<Objeto>> superficieObjetos){
        int[] lista = new int[3];
        int tamanhoX = 15;
        int tamanhoY = 10;
 
        int y = lista[1];
        int x = lista[2];
        int a = y;
        int b = x;

        try {
            
        
        if(lista[0] == 0){
            
            while(a<=tamanhoY+y-1){
                b = x;
                while(b<=tamanhoX+x-1){
                    if(b == x || b == (x + tamanhoX-1)){
                        superficieObjetos.get(a).set(b, paredeVertical);
                    }

                    

                    else if(a == y || a == (y+tamanhoY-1)){
                        superficieObjetos.get(a).set(b, paredeHorizontal);
                    }

                    else{
                        superficieObjetos.get(a).set(b, interiorMercado);

                    }
                    
                    b++;
                }
                
                a++;
            }
            

            superficieObjetos.get(y).set(x, quinaSuperiorEsquerda );
            superficieObjetos.get(y).set(x+tamanhoX-1, quinaSuperiorDireita );
            superficieObjetos.get(y+tamanhoY-1).set(x, quinaInferiorEsquerda );
            superficieObjetos.get(y+tamanhoY-1).set(x+tamanhoX-1, quinaInferiorDireita );

            }
        }
            catch (Exception e) {
                System.out.println(y);
                System.out.println(x);


                System.out.println(a);
                System.out.println(b);
            }
        }
        


    
       
        
    


   private int[] checarArea(int tamanhoX, int tamanhoY, ArrayList<ArrayList<Objeto>> superficieObjetos, int columns, int rows){
        int[] valores = new int[3];
        int i = 0;
        boolean checar = false;
        Random gerador = new Random();
        double aleatorioX;
        double aleatorioY; 
        double aleatorioDistancia = 0;
        int a;
        int b;
        

        aleatorioDistancia = gerador.nextInt(2) + 2;
        int intAleatorioDistancia = (int)aleatorioDistancia;

        
        
        aleatorioX = 24 + gerador.nextInt((columns-25-tamanhoX-1)-24+1);
        aleatorioY = 14 + gerador.nextInt((rows-13-tamanhoY-1)-14+1);
        


        while(i<10){
            int tamanhoYDoMapa = superficieObjetos.size();
            int tamanhoXDoMapa = (superficieObjetos.get(0)).size();


            aleatorioX = 24 + gerador.nextInt((columns-25-tamanhoX-1)-24+1);
            aleatorioY = 14 + gerador.nextInt((rows-13-tamanhoY-1)-14+1);


            a = ((int)aleatorioY);
            b = ((int)aleatorioX);
            checar = false;
            if(((a+(tamanhoY*intAleatorioDistancia)<=tamanhoYDoMapa-1) && 
    		(b+(tamanhoX*intAleatorioDistancia)<=tamanhoXDoMapa-1)) && 
    		((superficieObjetos.get(a).get(b).getSimbolo() == " ") && 
			(superficieObjetos.get(a).get(b+tamanhoX-1).getSimbolo() == " ") && 
			(superficieObjetos.get(a+tamanhoY-1).get(b).getSimbolo() == " ") && 
			(superficieObjetos.get(a+tamanhoY-1).get(b+tamanhoX-1).getSimbolo() == " ") &&
            				
            				
			(superficieObjetos.get(a-2).get(b).getSimbolo() == " ") && 
			(superficieObjetos.get(a).get(b+tamanhoX+1).getSimbolo() == " ") && 
			(superficieObjetos.get(a+tamanhoY+1).get(b).getSimbolo() == " ") && 
			(superficieObjetos.get(a).get(b-2).getSimbolo() == " "))){

            // }


            // try{
                while(a<aleatorioY+(tamanhoY*intAleatorioDistancia)-1){
                    b = (int)aleatorioX;
                    while(b<aleatorioX+(tamanhoX*intAleatorioDistancia)-1){
                        if((superficieObjetos.get(a).get(b).getSimbolo() == " ")){
                            
                        }
                        else{
                            
                            checar = true;
                            i++;
                            break;
                        }
                        b++;
                    }
                    a++;

                    if(checar == true){
                        break;
                    }
                }
                i++;
                if(checar == false){
                    break;
                }
            }


        }

        if(checar == false){
            valores[0] = 0;
            valores[1] = (int)aleatorioY+1;
            valores[2] = (int)aleatorioX+1;
            return valores;
        }

        else{
            valores[0] = 1;
            valores[1] = (int)aleatorioY+1;
            valores[2] = (int)aleatorioX+1;
            return valores;
        }
        
    }

    public int construirCasa(ArrayList<ArrayList<Objeto>> superficieObjetos, int columns, int rows){
        int[] lista = new int[3];
        int valor = 0;
        int tamanhoX = 14;
        int tamanhoY = 12;
        lista = checarArea(tamanhoX, tamanhoY, superficieObjetos, columns, rows);
        int y = lista[1];
        int x = lista[2];
        int a = y;
        int b = x;

      
            
        
        if(lista[0] == 0){

            valor = 1;
            
            while(a<=tamanhoY+y-1){
                b = x;
                while(b<=tamanhoX+x-1){
                    if(b == x || b == (x + tamanhoX-1)){
                        superficieObjetos.get(a).set(b, paredeVertical);
                    }
                    else if(a == y || a == (y+tamanhoY-1)){
                        superficieObjetos.get(a).set(b, paredeHorizontal);
                    }

                    else{
                        superficieObjetos.get(a).set(b, interiorCasa);

                    }

                    b++;
                }
                
                a++;
            }
            

            superficieObjetos.get(y).set(x, quinaSuperiorEsquerda );
            superficieObjetos.get(y).set(x+tamanhoX-1, quinaSuperiorDireita );
            superficieObjetos.get(y+tamanhoY-1).set(x, quinaInferiorEsquerda );
            superficieObjetos.get(y+tamanhoY-1).set(x+tamanhoX-1, quinaInferiorDireita );
            superficieObjetos.get(y+tamanhoY-1).set(((x+tamanhoX-1)-(tamanhoX-1)/2), porta);
            superficieObjetos.get(y+tamanhoY-1).set(((x+tamanhoX-1)-(tamanhoX-1)/2)-1, porta);

            }

            else{
                valor = 0;
            }


            return valor;
        }
    
}
