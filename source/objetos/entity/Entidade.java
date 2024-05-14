package source.objetos.entity;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import source.main.ControladorDeClasses;
import source.main.Inventário;
import source.main.Status;
import source.objetos.Objeto;


public abstract class Entidade extends Objeto {
    private Status status = new Status();
    private int id;
    private String classe;
    private String nome;
    private String raca;
    private Inventário inventario = new Inventário();
    private int x, y;
    private int placeId;

    private String[] colisores = new String[5];


    private BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    private String direction = new String();
    
    


    private int spriteCounter = 0;
    private int spriteNum = 1;

    private String caminhoUp1;
    private String caminhoUp2;

    private String caminhoDown1;
    private String caminhoDown2;

    private String caminhoLeft1;
    private String caminhoLeft2;

    private String caminhoRight1;
    private String caminhoRight2;









    public Entidade(String tipo, String classe, String nome, String raca, ControladorDeClasses control){
        
        definirRaca(raca, control);
        definirTipo(tipo, control);
        definirClasse(classe, control);
        definirNome(nome);
        definirId();
        
        
    }

    public Entidade(){

    }

    public void definirTipo(String tipo, ControladorDeClasses control){

        if(tipo.equals("Npc")){
            setTipo("Npc");
            status.alterarVidaTotal(control.getNpc().getNpcVidaTotal());
            status.setLevel(control.getNpc().getNpcLevel());
            status.alterarManaTotal(control.getNpc().getNpcManaTotal());
            status.alterarStaminaTotal(control.getNpc().getNpcStaminaTotal());

        }

        else if(tipo.equals("Player")){
            setTipo("Player");
            status.alterarVidaTotal(control.getPlayer().getPlayerVidaTotal());
            status.setLevel(control.getPlayer().getPlayerLevel());
            status.alterarManaTotal(control.getPlayer().getPlayerManaTotal());
            status.alterarStaminaTotal(control.getPlayer().getPlayerStaminaTotal());
        }

        else if(tipo.equals("Companion")){

        }


    }

    public void definirClasse(String classe, ControladorDeClasses control){

        if(classe.equals("Mago")){

            this.classe = "Mago";
            status.alterarVidaTotal(control.getMago().getVidaMagoTotal());
            status.alterarManaTotal(control.getMago().getManaMagoTotal());


        }

        else if(classe.equals("Guerreiro")){
            
            this.classe = "Guerreiro";
            status.alterarVidaTotal(control.getGuerreiro().getVidaGuerreiroTotal());
            status.alterarStaminaTotal(control.getGuerreiro().getStaminaGuerreiroTotal());


        }

        else if(classe.equals("Ladino")){

            this.classe = "Ladino";
            status.alterarVidaTotal(control.getLadino().getVidaLadinoTotal());
            status.alterarStaminaTotal(control.getLadino().getStaminaLadinoTotal());


        }

        else if(classe.equals("Curandeiro")){

            this.classe = "Curandeiro";
            status.alterarVidaTotal(control.getCurandeiro().getVidaCurandeiroTotal());
            status.alterarManaTotal(control.getCurandeiro().getManaCurandeiroTotal());

        }

    }

    public void definirRaca(String raca, ControladorDeClasses control){
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

    public void definirNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public Status getStatus(){
        return this.status;
    }



    public void setImage(String path){
        

        try {
            up1 = ImageIO.read(getClass().getResourceAsStream(path+"/up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream(path+"/up_2.png"));
            caminhoUp1 = path+"/up_1.png";
            caminhoUp2 = path+"/up_2.png";


            caminhoDown1 = path+"/down_1.png";
            caminhoDown2 = path+"/down_2.png";

            caminhoLeft1 = path+"/left_1.png";
            caminhoLeft2 = path+"/left_2.png";

            caminhoRight1 = path+"/right_1.png";
            caminhoRight2 = path+"/right_2.png";

            down1 = ImageIO.read(getClass().getResourceAsStream(path+"/down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream(path+"/down_2.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream(path+"/left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream(path+"/left_2.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream(path+"/right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream(path+"/right_2.png"));

            
        } catch (Exception e) {
            // TODO: handle exception
        }
    
    }

    public void imprimirPath(){

        // System.out.println(caminhoUp1);
        // System.out.println(caminhoUp2);

        // System.out.println(caminhoDown1);
        // System.out.println(caminhoDown2);

        // System.out.println(caminhoLeft1);
        // System.out.println(caminhoLeft2);

        // System.out.println(caminhoRight1);
        // System.out.println(caminhoRight2);
    }


    public BufferedImage retornarImagem(){
        return down2;
    }


    public int getCoordinatesX(){
        int x = this.x;
        return x;
    }

    public int getCoordinatesY(){
        int y = this.y;
        return y;
    }

    public String getDirection(){
        return this.direction;
    }

    public int getSpeed(){
        return status.getVelocidade();
    }

    public int getSpriteCounter(){
        return spriteCounter;
    }

    public int getSpriteNum(){
        return spriteNum;
    }

    public void setSpriteNum(int n){
        spriteNum = n;
    }


    public void setCoordinatesX(int x){
        this.x = x;

    }

    public void setCoordinatesY(int y){
        this.y = y;
    }

    public void setDirection(String direction){
        this.direction = direction;
    }


    public void setSpriteCounter(int n){
        this.spriteCounter = n;
    }

    public void increaseSpriteCounter(){
        this.spriteCounter++;
    }


    public BufferedImage getImagem(String nome){
        switch (nome) {
            case "up1":
                return up1;
            case "up2":
                return up2;
            case "down1":
                return down1;
            case "down2":
                return down2;
            case "left1":
                return left1;
            case "left2":
                return left2;
            case "right1":
                return right1;
            case "right2":
                return right2;
            default:
                return up1;
        }
    }

    public void setplaceId(int i){
        this.placeId = i;

    }

}
