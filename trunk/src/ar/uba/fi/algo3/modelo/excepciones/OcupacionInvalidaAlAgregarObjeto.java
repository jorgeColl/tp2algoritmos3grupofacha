package ar.uba.fi.algo3.modelo.excepciones;

/**
 * La lanzan las instancias de las subclases de ObjetoJuego cuando se las trata de agregar al espacio con una ocupación que no es válida dentro del mapeo del espacio.
 * Los disparos no la lanzan porque cuando trata de agregárselos en una ocupación invalida directamente no se lo hace. Esto cubre el caso de que un tanque dispare posicionado sobre un borde, orientado hacia él.
 * @author Federico
 *
 */
public class OcupacionInvalidaAlAgregarObjeto extends Exception {
		
	/**
	 * Constructor.
	 * @param mensaje describe al error
	 */
	public OcupacionInvalidaAlAgregarObjeto(String mensaje) {
		super(mensaje);
	}
	
	/**
	 * @see OcupacionCoincidenteconOtroObjetoJuego
	 */
	private static final long serialVersionUID = 1;
	

}
