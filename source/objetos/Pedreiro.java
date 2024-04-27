package source.objetos;
import java.util.Random;
import java.util.ArrayList;
import source.objetos.construções.*;
import source.objetos.construções.interiores.InteriorCasa;
import source.objetos.construções.interiores.InteriorMercado;


public class Pedreiro {

    private ParedeHorizontal paredeHorizontal = new ParedeHorizontal();
    private ParedeVertical paredeVertical = new ParedeVertical();
    private InteriorCasa interiorCasa = new InteriorCasa();
    private InteriorMercado interiorMercado = new InteriorMercado();
    private QuinaInferiorDireita quinaInferiorDireita = new QuinaInferiorDireita();
    private QuinaInferiorEsquerda quinaInferiorEsquerda = new QuinaInferiorEsquerda();
    private QuinaSuperiorDireita quinaSuperiorDireita = new QuinaSuperiorDireita();
    private QuinaSuperiorEsquerda quinaSuperiorEsquerda = new QuinaSuperiorEsquerda();

    public void construirMercado(ArrayList<ArrayList<Objeto>> superficieObjetos){
        int[] lista = new int[3];
        int tamanhoX = 10;
        int tamanhoY = 10;
        lista = checarArea(tamanhoX, tamanhoY, superficieObjetos);
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
            
            // if(superficieObjetos.get(y).get(x).getSimbolo() == " "){

            // }
            // if(superficieObjetos.get(y).get(x+tamanhoX-1).getSimbolo() == " "){
                
            // }
            // if(superficieObjetos.get(y+tamanhoY-1).get(x).getSimbolo() == " "){
                
            // }
            // if(superficieObjetos.get(y+tamanhoY-1).get(x+tamanhoX-1).getSimbolo() == " "){
                
            // }
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
        


    
       
        
    


   int[] checarArea(int tamanhoX, int tamanhoY, ArrayList<ArrayList<Objeto>> superficieObjetos){
        int[] valores = new int[3];
        int i = 0;
        boolean checar = false;
        Random gerador = new Random();
        double aleatorioX;
        double aleatorioY; 
        int a;
        int b;
        Objeto c = new Objeto();

        aleatorioY =  gerador.nextInt(superficieObjetos.size()-1);
        aleatorioX = gerador.nextInt((superficieObjetos.get(0)).size()-1);

        while(i<10){
            int tamanhoYDoMapa = superficieObjetos.size();
            int tamanhoXDoMapa = (superficieObjetos.get(0)).size();

            aleatorioY =  gerador.nextInt(superficieObjetos.size()-1);
            aleatorioX = gerador.nextInt((superficieObjetos.get(0)).size()-1);
            a = ((int)aleatorioY);
            b = ((int)aleatorioX);
            checar = false;
            if(((a+tamanhoY<=tamanhoYDoMapa-1) && (b+tamanhoX<=tamanhoXDoMapa-1)) && ((superficieObjetos.get(a).get(b).getSimbolo() == " ") && (superficieObjetos.get(a).get(b+tamanhoX-1).getSimbolo() == " ") && (superficieObjetos.get(a+tamanhoY-1).get(b).getSimbolo() == " ") && (superficieObjetos.get(a+tamanhoY-1).get(b+tamanhoX-1).getSimbolo() == " "))){

            // }


            // try{
                while(a<aleatorioY+tamanhoY-1){
                    b = (int)aleatorioX;
                    while(b<aleatorioX+tamanhoX-1){
                        if((superficieObjetos.get(a).get(b).getSimbolo() == " ")){
                            c = superficieObjetos.get(a).get(b);
                        }
                        else{
                            c = superficieObjetos.get(a).get(b);
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

            // catch (Exception e) {
            //     i++;
            //     checar = true;
            //     valores[0] = 1;
                
            // }
        }

        if(checar == false){
            valores[0] = 0;
            valores[1] = (int)aleatorioY;
            valores[2] = (int)aleatorioX;
            return valores;
        }

        else{
            valores[0] = 1;
            valores[1] = (int)aleatorioY;
            valores[2] = (int)aleatorioX;
            return valores;
        }
        
    }

    public void construirCasa(ArrayList<ArrayList<Objeto>> superficieObjetos){
        int[] lista = new int[3];
        int tamanhoX = 4;
        int tamanhoY = 4;
        lista = checarArea(tamanhoX, tamanhoY, superficieObjetos);
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
                        superficieObjetos.get(a).set(b, interiorCasa);

                    }

                    b++;
                }
                
                a++;
            }
            
            // if(superficieObjetos.get(y).get(x).getSimbolo() == " "){

            // }
            // if(superficieObjetos.get(y).get(x+tamanhoX-1).getSimbolo() == " "){
                
            // }
            // if(superficieObjetos.get(y+tamanhoY-1).get(x).getSimbolo() == " "){
                
            // }
            // if(superficieObjetos.get(y+tamanhoY-1).get(x+tamanhoX-1).getSimbolo() == " "){
                
            // }
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
    
}
