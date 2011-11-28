package modelo.armamentista.arma;

import modelo.tanques.Tanque;

/**
 * Modela un arma, la cual tiene un tanque que es su dueño y es capaz de disparar una munición cuando se lo solicita.
 * @author Tomás
 *
 */
public abstract class Arma {

	protected Tanque duenio;
	
	/**
	 * Constructor.
	 * @param duenio instancia de una sublcase de Tanque con la cual inicializaremos al atributo duenio
	 */
	public Arma(Tanque duenio) {
		this.duenio = duenio;
	}
	
	/**
	 * 
	 * @return instancia de una subclase de la clase Tanque que representa al duenio del arma
	 */
	public Tanque getDuenio() {
		return duenio;
	}
	
	/**
	 * Instancia un disparo propio del arma.
	 * La ocupación que tendrá este es la inmediatamente posterior al dueño en su orientación, centrado con respecto a este.
	 * Para obtener esa ocupación, delega en la clase Ocupacion.
	 */
	public abstract void disparar();
	
}
