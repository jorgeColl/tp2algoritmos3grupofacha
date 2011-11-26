package modelo.armamentista.arma;

import modelo.armamentista.disparo.DisparoCanion;
import modelo.manejoEspacial.Posicion;
import modelo.tanques.Tanque;

/**
 * Modela un cañón, el cual es un arma que tiene una munición limitada.
 * @author Federico
 *
 */
public class Canion extends ArmaMunicionLimitada {

	/**
	 * 
	 * @param municion entero correspondiente a la munición inicial del arma
	 */
	public Canion(Tanque duenio, int municion) {
		super(duenio,municion);
	}

	/**
	 * Si la munición es 0 no hacemos nada, si es mayor disparamos y la disminuímos.
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
