package modelo.armamentista.arma;

import modelo.armamentista.disparo.DisparoLanzaCohetes;
import modelo.manejoEspacial.Posicion;
import modelo.tanques.Tanque;

/**
 * Modela un lanza cohetes, el cual es un arma que tiene una minuci�n limitada.
 * @author Tom�s
 *
 */
public class LanzaCohetes extends Arma {

	int municion;
	
	/**
	 * 
	 * @param municion entero correspondiente a la munici�n inicial del arma
	 */
	public LanzaCohetes(Tanque duenio, int municion) {
		super(duenio);
		this.municion = municion;
	}

	/**
	 * Si la munici�n es 0 no hacemos nada, si es mayor disparamos y la disminu�mos.
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
	 * @return munici�n del arma
	 */
	public int getMunicion() {
		return municion;
	}
	
	/**
	 * 
	 * @param incremento entero que sumaremos a la munici�n del arma
	 */
	public void incrementarMunicion(int incremento) {
		municion = municion + incremento;
	}

}
