package modelo.armamentista.arma;

import modelo.tanques.Tanque;

/**
 * Modela un arma, la cual tiene un tanque que es su due�o y es capaz de disparar una munici�n cuando se lo solicita.
 * @author Tom�s
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
	 * La ocupaci�n que tendr� este es la inmediatamente posterior al due�o en su orientaci�n, centrado con respecto a este.
	 * Para obtener esa ocupaci�n, delega en la clase Ocupacion.
	 */
	public abstract void disparar();
	
}
