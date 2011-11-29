package ar.uba.fi.algo3.modelo.manejoEspacial;

/**
 * Modela a un vector que otorga una orientación en un plano.
 * Dado que las orientaciones posibles son sólo cuatro y que estas interesan sólo desde su estado y no desde su comportamiento, para ahorrar recursos del sistema garantizamos la existencia de sólo cuatro instancias mediante atributos de clase proveemos acceso global a estas.
 * @author Samanta
 *
 */
public class Orientacion extends Vector {

	public static Orientacion i = new Orientacion(1,0);
	public static Orientacion iNegativo = new Orientacion(-1,0);
	public static Orientacion j = new Orientacion(0,1);
	public static Orientacion jNegativo = new Orientacion(0,-1);
	
	public Orientacion(int x, int y) {
		super(x, y);
	}

}
