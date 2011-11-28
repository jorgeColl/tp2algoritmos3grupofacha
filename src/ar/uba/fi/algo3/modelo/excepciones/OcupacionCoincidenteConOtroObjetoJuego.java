package ar.uba.fi.algo3.modelo.excepciones;

/**
 * La lanzan las instancias de subclases de ObjetoJuego cuando trata de agreg�rselos al espacio con una ocupaci�n que coincide parcial o totalmente con la de otro objeto ya agregado all�.
 * Los disparos no la lanzan porque cuando trata de agreg�rselos en una ocupaci�n como la descripta directamente se hace que impacte al objeto estorbante. Esto cubre el caso de que un tanque dispare posicionado contra otra instancia de una subclase de ObjetoJuego, orientado hacia ella.
 * @author Federico
 *
 */
public class OcupacionCoincidenteConOtroObjetoJuego extends Exception {
	
	/**
	 * Constructor.
	 * @param mensaje describe al error
	 */
	
	/* agrego esto para que Java deje de tirar warnings.
	 * ver: http://c2.com/ppr/wiki/JavaIdioms/AlwaysDeclareSerialVersionUid.html
	 */
	private static final long serialVersionUID = 1;
	
	public OcupacionCoincidenteConOtroObjetoJuego(String mensaje) {
		super(mensaje);
	}

}
