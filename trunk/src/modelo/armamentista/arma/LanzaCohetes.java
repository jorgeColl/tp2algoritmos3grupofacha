package modelo.armamentista.arma;

import modelo.armamentista.disparo.DisparoLanzaCohetes;
import modelo.manejoEspacial.Posicion;
import modelo.tanques.Tanque;

/**
 * Modela un lanza cohetes, el cual es un arma que tiene una minución limitada.
 * @author Tomás
 *
 */
public class LanzaCohetes extends Arma {

	int municion;
	
	/**
	 * 
	 * @param municion entero correspondiente a la munición inicial del arma
	 */
	public LanzaCohetes(Tanque duenio, int municion) {
		super(duenio);
		this.municion = municion;
	}

	/**
	 * Si la munición es 0 no hacemos nada, si es mayor disparamos y la disminuímos.
	 */
	@Override
	public void disparar() {
		if (municion > 0) {
			Posicion posicionAuxiliar;
			posicionAuxiliar = duenio.getOcupacion().getPosicionPerimetralCentradaEnOrientacion(duenio.getOrientacion());
			new DisparoLanzaCohetes(duenio.getOrientacion(),posicionAuxiliar);
			municion = municion -1;;
		}
	}
	
	/**
	 * 
	 * @return munición del arma
	 */
	public int getMunicion() {
		return municion;
	}
	
	/**
	 * 
	 * @param incremento entero que sumaremos a la munición del arma
	 */
	public void incrementarMunicion(int incremento) {
		municion = municion + incremento;
	}

}
