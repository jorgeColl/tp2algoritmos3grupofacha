package modelo.armamentista.arma;

import modelo.armamentista.disparo.DisparoCanion;
import modelo.manejoEspacial.Posicion;
import modelo.tanques.Tanque;

/**
 * Modela un ca��n, el cual es un arma que tiene una munici�n limitada.
 * @author Federico
 *
 */
public class Canion extends ArmaMunicionLimitada {

	/**
	 * 
	 * @param municion entero correspondiente a la munici�n inicial del arma
	 */
	public Canion(Tanque duenio, int municion) {
		super(duenio,municion);
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
