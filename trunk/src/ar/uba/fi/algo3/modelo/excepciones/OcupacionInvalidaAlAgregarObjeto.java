package ar.uba.fi.algo3.modelo.excepciones;

/**
 * La lanzan las instancias de las subclases de ObjetoJuego cuando 
 * se las trata de agregar al espacio con una ocupacion que no es 
 * valida dentro del mapeo del espacio.
 * Los disparos no la lanzan porque cuando trata de agregarselos en 
 * una ocupacion invalida directamente no se lo hace. Esto cubre el 
 * caso de que un tanque dispare posicionado sobre un borde, orientado 
 * hacia el.
 * @author Fede
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
