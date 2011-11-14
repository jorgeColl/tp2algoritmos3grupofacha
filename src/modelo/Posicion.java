package modelo;

/**
 * Modela a un vector que representa una posici�n en un plano.
 * @author Tom�s
 *
 */
public class Posicion extends Vector {

	public Posicion(int x, int y) {
		super(x,y);
	}
	
	/**
	 * Realiza la resta coordenada a coordenada entre el vector representado por este objeto y el representado por el par�metro.
	 * @param posicion instancia de la clase Posicion que restaremos a esta 
	 * @return instancia de la clase Posicion que representa la resta de esta instancia y la del par�metro
	 */
	public Posicion restar(Posicion posicion) {
		Posicion posicionAuxiliar = new Posicion(x - posicion.getX(),y - posicion.getY());
		return posicionAuxiliar;
	}
	
	public void moverEnI(){
		this.x++;
	}
	public void moverEnINegativo(){
		this.x--;
	}
	public void moverEnJ(){
		this.y++;
	}
	public void moverEnJNegativo(){
		this.y--;
	}
	

}