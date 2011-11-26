package modelo.objetosInanimados;

import modelo.armamentista.disparo.Disparo;
import modelo.clasesGeneralizadoras.ObjetoJuego;
import modelo.manejoEspacial.OcupacionCuadrada;
import modelo.manejoEspacial.Posicion;
import modelo.tanques.Tanque;

/**
 * Clase que otorga el comportamiento común a los bonus que mejoran las habilidades del tanque cuando entra en contacto con ellos.
 * @author Jorge
 *
 */
public abstract class Bonus extends ObjetoJuego {
	
	/**
	 * Constructor.
	 * @param posicion instancia de la clase Posicion que servirá como referencia para inicializar la ocupación del bonus
	 */
	public Bonus(Posicion posicion){
		ocupacion = new OcupacionCuadrada(posicion,5);
	}
	
	/**
	 * No hace nada si choca con un disparo.
	 */
	public void chocarCon(Disparo disparo){
		
	}
	
	/**
	 * Le efectúa los cambios correspondientes al tanque.
	 */
	public void chocarCon(Tanque tanque) {
		this.efectuarCambiosDeBonus(tanque);
		this.desaparecer();
	}
	/**
	 * Método que será redefinido por las subclases.
	 * @param tanque instancia de una subclase de Tanque que será mejorada
	 */
	protected abstract void efectuarCambiosDeBonus(Tanque tanque);
	
}
