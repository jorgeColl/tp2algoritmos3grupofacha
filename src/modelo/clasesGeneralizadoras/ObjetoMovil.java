package modelo.clasesGeneralizadoras;

import modelo.manejoEspacial.Ocupacion;
import modelo.manejoEspacial.Orientacion;

/**
 * Provee de estado y comportamiento com�n a los objetos que pueden moverse por el espacio.
 * @author Tom�s
 *
 */
public abstract class ObjetoMovil extends ObjetoJuego {

	protected Orientacion orientacion;
	protected int velocidad;
	
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
	 * M�todo que utilizar�n las subclases instanciables de esta internamente para chequear si su nueva ocupaci�n es v�lida (tomando una desici�n si no lo es) y si han colisionado con otro.
	 * @param ocupacionProvisoria subinstancia de la clase Ocupacion que tiene provisoriamente el tanque
	 */
	protected abstract void chequearOcupacionValidaYColisiones(Ocupacion ocupacionProvisoria);
	
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
		
}
