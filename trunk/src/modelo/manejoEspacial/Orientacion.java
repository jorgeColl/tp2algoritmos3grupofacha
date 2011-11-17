package modelo.manejoEspacial;

/**
 * Modela a un vector que otorga una orientaci�n en un plano.
 * Dado que las orientaciones posibles son s�lo cuatro y que estas interesan s�lo desde su estado y no desde su comportamiento, mediante atributos de clase proveemos acceso global a estas.
 * @author Tom�s
 *
 */
public class Orientacion extends Vector {

	public static Orientacion i = new Orientacion(1,0);
	public static Orientacion iNegativo = new Orientacion(-1,0);
	public static Orientacion j = new Orientacion(0,1);
	public static Orientacion jNegativo = new Orientacion(0,-1);
	
	private Orientacion(int x, int y) {
		super(x, y);
	}

}
