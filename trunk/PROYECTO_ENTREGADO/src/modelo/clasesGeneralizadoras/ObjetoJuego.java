package modelo.clasesGeneralizadoras;

import modelo.armamentista.disparo.Disparo;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.Ocupacion;
import modelo.tanques.Tanque;

/**
 * Provee el comportamiento y el estado común a todas las entidades del juego que pueden posicionarse en el espacio. 
 * El atributo ocupacion representa a la ocupación que tiene el objeto en el lugar en el que se desarrolla la acción del juego.
 * @author Jorge
 *
 */
public abstract class ObjetoJuego {
	
	protected Ocupacion ocupacion;
	
	/**
	 * Hacemos que el objeto sea impactado por un disparo.
	 * @param disparo instancia de una subclase de Disparo que chocará con este objeto
	 */
	public abstract void chocarCon(Disparo disparo);
	
	/**
	 * Hacemos que el objeto sea impactado por un tanque.
	 * @param tanque instancia de una subclase de Tanque que chocará con este objeto
	 */
	public abstract void chocarCon(Tanque tanque);

	/**
	 * Hacemos que el objeto desaparezca del espacio, delegando en la clase Espacio.
	 */
	public void desaparecer() {
		Espacio.getInstancia().desaparecerA(this);
	}
	
	/**
	 * Delega en la clase Ocupacion.
	 * @param objeto instancia de la clase ObjetoJuego cuya ocupación compararemos con la de esta
	 * @return true si los objetos comparados coinciden ocupacionalmente y false en el caso contrario
	 */
	public boolean estaEnContactoCon(ObjetoJuego objeto) {
		return (objeto.getOcupacion().coincidenciaOcupacionalCon(ocupacion));
	}
	
	/**
	 * 
	 * @return atributo ocupacion
	 */
	public Ocupacion getOcupacion() {
		return ocupacion;
	}

}
