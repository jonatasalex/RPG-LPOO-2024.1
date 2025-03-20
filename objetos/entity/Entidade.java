package objetos.entity;



import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.util.Random;

import javax.imageio.ImageIO;

import main.ControladorDeClasses;
import main.GamePanel;

import main.Status;
import objetos.Lugar;
import objetos.Objeto;


public abstract class Entidade extends Objeto {
    private Status status;
    private String classe;
    private String nome;
    private String raca;
    private int x, y;
    private int iX, iY;

    private Lugar currentLocation;

    


    private BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    private String direction;
    
    


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
    
    
    private GamePanel gp;









    public Entidade(String tipo, String classe, String nome, String raca, ControladorDeClasses control){
        
        definirRaca(raca, control);
        definirTipo(tipo, control);
        definirClasse(classe, control);
        definirNome(nome);
        definirId();
        
        
        
        
    }

    public Entidade(){
        direction = new String();
        status = new Status();
        
        

    }

    public void definirTipo(String tipo, ControladorDeClasses control){

        if(tipo.equals("Npc")){
            setTipo("Npc");
            status.alterarVidaTotal(control.getNpc().getNpcVidaTotal());
            status.setLevel(control.getNpc().getNpcLevel());
            
            status.alterarStaminaTotal(control.getNpc().getNpcStaminaTotal());

        }

        else if(tipo.equals("Player")){
            setTipo("Player");
            status.alterarVidaTotal(control.getPlayer().getPlayerVidaTotal());
            status.setLevel(control.getPlayer().getPlayerLevel());
           
            status.alterarStaminaTotal(control.getPlayer().getPlayerStaminaTotal());
        }

        


    }

    public void definirClasse(String classe, ControladorDeClasses control){



        if(classe.equals("Guerreiro")){
            
            this.classe = "Guerreiro";
            status.alterarVidaTotal(control.getGuerreiro().getVidaGuerreiroTotal());
            status.alterarVidaAtual(control.getGuerreiro().getVidaGuerreiroTotal());
            status.alterarStaminaTotal(control.getGuerreiro().getStaminaGuerreiroTotal());
            status.alterarStaminaAtual(control.getGuerreiro().getStaminaGuerreiroTotal());


        }

        else if(classe.equals("Ladino")){

            this.classe = "Ladino";
            status.alterarVidaTotal(control.getLadino().getVidaLadinoTotal());
            status.alterarVidaAtual(control.getLadino().getVidaLadinoTotal());
            status.alterarStaminaTotal(control.getLadino().getStaminaLadinoTotal());
            status.alterarStaminaAtual(control.getLadino().getStaminaLadinoTotal());


        }


    }

    public void definirRaca(String raca, ControladorDeClasses control){
        this.raca = raca;

        if(raca.equals("Humano")){
           

            status.setVidaTotal(control.getHumano().getHumanoVidaTotal());
            status.setVidaAtual(control.getHumano().getHumanoVidaTotal());
            status.setStaminaTotal(control.getHumano().getHumanoStaminaTotal());
            status.setStaminaAtual(control.getHumano().getHumanoStaminaTotal());
           
            

        }

        else if(raca.equals("Orc")){
            


        	status.setVidaTotal(control.getOrc().getOrcVidaTotal());
            status.setVidaAtual(control.getOrc().getOrcVidaTotal());
            status.setStaminaTotal(control.getOrc().getOrcStaminaTotal());
            status.setStaminaAtual(control.getOrc().getOrcStaminaTotal());
            
            
            
            
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

    
    
    public void dead(String path) {
    	try {
    		down1 = ImageIO.read(getClass().getResourceAsStream(path+"/dead.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream(path+"/dead.png"));
    		
    	}
    	catch(Exception e){
    		
    	}
    	
    	
    }

    public void setImage(String path){
    	Random gerador = new Random();
    	int aleatorio = gerador.nextInt(2) + 1;
    	if(this instanceof Npc) {
    		
            
            
            path = path + "/" + this.getRaca()+String.valueOf(aleatorio);
            
    		
    	}
    	aleatorio = 2;
    	

        try {
            
            caminhoUp1 = path+"/up_1.png";
            caminhoUp2 = path+"/up_2.png";


            caminhoDown1 = path+"/down_1.png";
            caminhoDown2 = path+"/down_2.png";

            caminhoLeft1 = path+"/left_1.png";
            caminhoLeft2 = path+"/left_2.png";

            caminhoRight1 = path+"/right_1.png";
            caminhoRight2 = path+"/right_2.png";
            
            up1 = ImageIO.read(getClass().getResourceAsStream(path+"/up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream(path+"/up_2.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream(path+"/down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream(path+"/down_2.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream(path+"/left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream(path+"/left_2.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream(path+"/right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream(path+"/right_2.png"));

            
        } catch (Exception e) {
            
        }
    
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
    
    public void setSpeed(int v) {
    	status.setVelocidade(v);
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

  

    public void setCurrentLocation(Lugar location){
        currentLocation = location;
    }

    public Lugar getCurrentLocation(){
        return currentLocation;
    }

    public void setiX(int a){
        iX = a;

    }

    public int getiX(){
        return iX;
    }

    public void setiY(int a){
        iY = a;

    }

    public int getiY(){
        return iY;
    }
    
    public void setGp(GamePanel gp) {
    	this.gp = gp;
    }
    
    public GamePanel getGp() {
    	return gp;
    }
    
    public void draw(Graphics2D g2, int x, int y){
    	
    	BufferedImage image = null;
        String direct = getDirection();
    


        if(direct == "up"){
            if(getSpriteNum() == 1){
                image = getImagem("up1");
            }
            if(getSpriteNum() == 2){
                image = getImagem("up2");
            }
        }

        else if(direct == "down"){
            if(getSpriteNum() == 1){
                image = getImagem("down1");
            }
            if(getSpriteNum() == 2){
                image = getImagem("down2");
            }
        }

        else if(direct == "left"){
            if(getSpriteNum() == 1){
                image = getImagem("left1");
            }
            if(getSpriteNum() == 2){
                image = getImagem("left2");
            }

        }

        else if(direct == "right"){
            if(getSpriteNum() == 1){
                image = getImagem("right1");
            }

            if(getSpriteNum() == 2){
                image = getImagem("right2");
            }
            

        }
        
        if((((getCoordinatesX())>= x-(920+40)) || ((getCoordinatesX())<= x+(1000+40))) && ((((getCoordinatesY())>= y-(520+40))) || ((getCoordinatesY())<= y+(560+40))) ) {
        	g2.drawImage(image, -x+(getCoordinatesX()+40)-getGp().getTileSize(), -y+(getCoordinatesY()+40)-getGp().getTileSize(), getGp().getTileSize(), getGp().getTileSize(), null);
        	
        }
        
                 
    }
    
    
    
    public void update(){
        

        increaseSpriteCounter();
        if(getSpriteCounter()>30){
            if(getSpriteNum() == 1){
                setSpriteNum(2);
            }
            else if(getSpriteNum() == 2){
                setSpriteNum(1);
            }
            setSpriteCounter(0);
        }




        

    }
    
    public void bater (Entidade inimigo, int dano, int staminaUsada) {
    	
    	getStatus().cansar(staminaUsada);
    	inimigo.getStatus().levarDano(dano);
    	
    }
    
    public String getRaca() {
		return raca;
	}
    

}
