package modelo.excepciones;

/**
 * La lanzan las instancias de subclases de ObjetoJuego cuando se las trata de agregar al espacio sobre otra instancia, o cuando la ocupaci�n no es v�lida dentro del mapeo del espacio.
 * Los disparos no la lanzan porque cuando trata de agreg�rselos sobre otra directamente la impacta.
 * @author Tom�s
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
