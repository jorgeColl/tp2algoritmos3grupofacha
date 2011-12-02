package ar.uba.fi.algo3.modelo.armamentista.arma;

import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoLanzaCohetes;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.Tanque;

/**
 * Modela un lanza cohetes, el cual es un arma que tiene una minución limitada.
 * @author Fede
 *
 */
public class LanzaCohetes extends ArmaMunicionLimitada {

	/**
	 * 
	 * @param municion entero correspondiente a la munición inicial del arma
	 */
	public LanzaCohetes(Tanque duenio, int municion) {
		super(duenio,municion);
	}

	/**
	 * Si la munición es 0 no hacemos nada, si es mayor disparamos y la disminuímos.
	 */
	public void disparar() {
		if (municion > 0) {
			Posicion posicionAuxiliar;
			posicionAuxiliar = duenio.getOcupacion().getPosicionPerimetralCentradaEnOrientacion(duenio.getOrientacion());
			new DisparoLanzaCohetes(duenio.getOrientacion(),posicionAuxiliar);
			--municion;
		}
	}

}
