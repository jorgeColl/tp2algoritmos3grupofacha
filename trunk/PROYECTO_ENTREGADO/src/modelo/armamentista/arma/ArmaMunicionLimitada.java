package modelo.armamentista.arma;

import modelo.tanques.Tanque;

/**
 * Otorga comportamiento común a las clases que representan a armas con munición limitada.
 * @author Federico
 *
 */
public abstract class ArmaMunicionLimitada extends Arma {

	protected int municion;
	
	/**
	 * 
	 * @param municion entero correspondiente a la munición inicial del arma
	 */
	public ArmaMunicionLimitada(Tanque duenio, int municion) {
		super(duenio);
		this.municion = municion;
	}
	
	/**
	 * 
	 * @return entero correspondiente a la munición del arma
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
