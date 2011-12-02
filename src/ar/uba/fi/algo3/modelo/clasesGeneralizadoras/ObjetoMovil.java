package ar.uba.fi.algo3.modelo.clasesGeneralizadoras;

import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Ocupacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;

/**
 * Provee de estado y comportamiento com�n a los objetos que pueden moverse por el espacio.
 * @author Jorge
 *
 */
public abstract class ObjetoMovil extends ObjetoJuego {

	protected Orientacion orientacion;
	protected int velocidad;
	
	
	/**
	 * Analiza cu�l de los bordes laterales est� m�s cercano al objeto y lo mueve en dicha direcci�n.
	 * Por defecto elije el derecho.
	 */
	public void acercarseAlBordeLateralMasCercano() {
		if (ocupacion.getLimiteIzquierdo() < (Espacio.getInstancia().getLimiteDerecho()-ocupacion.getLimiteDerecho()))
			moverIzquierda();
		else
			moverDerecha();
	}
	
	/**
	 * Dirige al objeto al centro del espacio hasta que alg�n punto de su ocupaci�n coincida con la recta que determina a este.
	 */
	public void acercarseAlCentroHorizontalDelEspacio() {
		if (ocupacion.getLimiteIzquierdo() > (Espacio.getInstancia().getLimiteDerecho()/2))
			moverIzquierda();
		if (ocupacion.getLimiteDerecho() < (Espacio.getInstancia().getLimiteDerecho()/2))
			moverDerecha();
	}
	
	/**
	 * M�todo que utilizar�n las subclases instanciables de esta internamente para chequear si su nueva ocupaci�n es v�lida (tomando una desici�n si no lo es dependiente de la subclase) y si han colisionado con otro.
	 * @param ocupacionProvisoria instancia de una subclase de Ocupacion que tiene provisoriamente el tanque
	 */
	protected abstract void chequearOcupacionValidaYColisiones(Ocupacion ocupacionProvisoria);

	/**
	 * 
	 * @return orientacion del objeto m�vil
	 */
	public Orientacion getOrientacion() {
		return orientacion;
	}

	/**
	 * 
	 * @return velocidad del objeto m�vil
	 */
	public int getVelocidad() {
		return velocidad;
	}
	
	/**
	 * Realizamos el movimiento y cambiamos la orientaci�n del objeto.
	 */
	public void moverAbajo() {
		int contador = 0;
		while (contador < velocidad) {
			Ocupacion ocupacionProvisoria = ocupacion.getOcupacionMovidaAbajo();
			orientacion = Orientacion.jNegativo;
			chequearOcupacionValidaYColisiones(ocupacionProvisoria);
			++contador;
		}
	}
	
	/**
	 * @see moverAbajo()
	 */
	public void moverArriba() {
		int contador = 0;
		while (contador < velocidad) {
			Ocupacion ocupacionProvisoria = ocupacion.getOcupacionMovidaArriba();
			orientacion = Orientacion.j;
			chequearOcupacionValidaYColisiones(ocupacionProvisoria);
			++contador;
		}
	}
	
	/**
	 * @see moverAbajo()
	 */
	public void moverDerecha() {
		int contador = 0;
		while (contador < velocidad) {
			Ocupacion ocupacionProvisoria = ocupacion.getOcupacionMovidaDerecha();
			orientacion = Orientacion.i;
			chequearOcupacionValidaYColisiones(ocupacionProvisoria);
			++contador;
		}
	}
	
	/**
	 * @see moverAbajo()
	 */
	public void moverIzquierda() {
		int contador = 0;
		while (contador < velocidad) {
			Ocupacion ocupacionProvisoria = ocupacion.getOcupacionMovidaIzquierda();
			orientacion = Orientacion.iNegativo;
			chequearOcupacionValidaYColisiones(ocupacionProvisoria);
			++contador;
		}
	}
	
	/**
	 * 
	 * @param orientacion objeto que asignaremos al atributo orientacion
	 */
	public void setOrientacion(Orientacion orientacion) {
		this.orientacion = orientacion;
	}
		
}
