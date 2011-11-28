package modelo.manejoEspacial;

/**
 * Modela un vector bidimensional con coordenadas cartesianas.
 * @author Samanta
 *
 */
public abstract class Vector {

	protected int x;
	protected int y;

	/**
	 * Constructor.
	 * @param x valor con el que se inicializar� la coordenada x
	 * @param y valor con el que se inicializar� la coordenada y
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
	 * @return m�dulo del vector representado por esta instancia
	 */
	public double modulo() {
		return Math.sqrt(x*x+y*y);
	}
		
}
