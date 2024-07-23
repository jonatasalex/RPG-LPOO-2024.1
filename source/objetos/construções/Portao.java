package objetos.construções;

import objetos.Lugar;

public class Portao extends Construção {
	private Lugar destino;

	public Portao(){
        setSimbolo("Z");
        setBufferedImage("/res/tiles/","gate_wall.png");
        setColisor(true);
    }
	public void setDestino(Lugar destino) {
      this.destino = destino;
  }
	public Lugar getDestino() {
		return destino;
	}
	
	

}	
