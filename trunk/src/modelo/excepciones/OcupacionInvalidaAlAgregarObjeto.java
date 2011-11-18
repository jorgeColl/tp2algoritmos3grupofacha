package modelo.excepciones;

/**
 * La lanzan las instancias de subclases de ObjetoJuego cuando se las trata de agregar al espacio sobre otra instancia, o cuando la ocupación no es válida dentro del mapeo del espacio.
 * Los disparos no la lanzan porque cuando trata de agregárselos sobre otra directamente la impacta.
 * @author Tomás
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

}
