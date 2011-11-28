package ar.uba.fi.algo3.modelo.objetosInanimados;

import ar.uba.fi.algo3.modelo.armamentista.disparo.Disparo;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.Tanque;

/**
 * Clase que otorga el comportamiento com�n a los bonus que mejoran las habilidades del tanque cuando entra en contacto con ellos.
 * @author Jorge
 *
 */
public abstract class Bonus extends ObjetoJuego {
	
	/**
	 * Constructor.
	 * @param posicion instancia de la clase Posicion que servir� como referencia para inicializar la ocupaci�n del bonus
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
	 * Le efect�a los cambios correspondientes al tanque.
	 */
	public void chocarCon(Tanque tanque) {
		this.efectuarCambiosDeBonus(tanque);
		this.desaparecer();
	}
	/**
	 * M�todo que ser� redefinido por las subclases.
	 * @param tanque instancia de una subclase de Tanque que ser� mejorada
	 */
	protected abstract void efectuarCambiosDeBonus(Tanque tanque);
	
}
