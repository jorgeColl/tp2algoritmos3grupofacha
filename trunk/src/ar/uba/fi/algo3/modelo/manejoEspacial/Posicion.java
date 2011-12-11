package ar.uba.fi.algo3.modelo.manejoEspacial;


/**
 * Modela a un vector que representa una posicion en un plano.
 * @author Sami
 *
 */
public class Posicion extends Vector {

	public Posicion(int x, int y) {
		super(x,y);
	}
	
	/**
	 * Realiza la resta coordenada a coordenada entre el vector 
	 * representado por este objeto y el representado por el parametro.
	 * @param posicion instancia de la clase Posicion que restaremos 
	 * a esta 
	 * @return instancia de la clase Posicion que representa la resta 
	 * de esta instancia y la del parametro
	 */
	public Posicion restar(Posicion posicion) {
		Posicion posicionAuxiliar = 
				new Posicion(x - posicion.getX(),y - posicion.getY());
		return posicionAuxiliar;
	}

}