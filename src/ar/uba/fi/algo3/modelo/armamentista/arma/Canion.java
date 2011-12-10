package ar.uba.fi.algo3.modelo.armamentista.arma;

import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoCanion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.Tanque;

/**
 * Modela un ca��n, el cual es un arma que tiene una munici�n limitada.
 * @author Fede
 *
 */
public class Canion extends ArmaMunicionLimitada {

	/**
	 * 
	 * @param municion entero correspondiente a la munici�n inicial del arma
	 */
	public Canion(Tanque duenio, int municion) {
		super(duenio,municion);
		tipo = "canion";
	}

	/**
	 * Si la munici�n es 0 no hacemos nada, si es mayor disparamos y la disminu�mos.
	 */
	public void disparar() {
		if (municion > 0) {
			Posicion posicionAuxiliar;
			posicionAuxiliar = duenio.getOcupacion().getPosicionPerimetralCentradaEnOrientacion(duenio.getOrientacion());
			new DisparoCanion(duenio.getOrientacion(),posicionAuxiliar);
			--municion;
		}
	}

}
