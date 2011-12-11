package ar.uba.fi.algo3.modelo.manejoEspacial;

/**
 * Modela a un vector que otorga una orientacion en un plano.
 * Dado que las orientaciones posibles son solo cuatro y que estas interesan 
 * solo desde su estado y no desde su comportamiento, para ahorrar recursos 
 * del sistema garantizamos la existencia de solo cuatro instancias mediante 
 * atributos de clase proveemos acceso global a estas.
 * @author Sami
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
