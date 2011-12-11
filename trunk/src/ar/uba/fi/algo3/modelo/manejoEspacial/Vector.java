package ar.uba.fi.algo3.modelo.manejoEspacial;

/**
 * Modela un vector bidimensional con coordenadas cartesianas.
 * @author Sami
 *
 */
public abstract class Vector {

	protected int x;
	protected int y;

	/**
	 * Constructor.
	 * @param x valor con el que se inicializara la coordenada x
	 * @param y valor con el que se inicializara la coordenada y
	 */
	public Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 * @return coordenada x del vector representado por este objeto
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @return coordenada y del vector representado por este objeto
	 */
	public int getY() {
		return y;
	}

	/**
	 * 
	 * @return modulo del vector representado por esta instancia
	 */
	public double modulo() {
		return Math.sqrt(x*x+y*y);
	}
		
}
