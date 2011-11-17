package modelo.clasesGeneralizadoras;

import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.Ocupacion;
import modelo.manejoEspacial.Orientacion;

/**
 * Provee de estado y comportamiento común a los objetos que pueden moverse por el espacio.
 * @author Tomás
 *
 */
public abstract class ObjetoMovil extends ObjetoJuego {

	protected Orientacion orientacion;
	protected int velocidad;
	
	/**
	 * Analiza cuál de los bordes laterales está más cercano al objeto y lo mueve en dicha dirección.
	 */
	public void acercarseAlBordeLateralMasCercano() {
		if (ocupacion.getLimiteIzquierdo() < (Espacio.getInstancia().getLimiteDerecho()-ocupacion.getLimiteDerecho()))
			moverIzquierda();
		else
			moverDerecha();
	}
	
	/**
	 * Dirige al objeto al centro del espacio hasta que algún punto de su ocupación coincida con la recta que determina a este.
	 */
	public void acercarseAlCentroDelEspacio() {
		if (ocupacion.getLimiteIzquierdo() > (Espacio.getInstancia().getLimiteDerecho()/2))
			moverIzquierda();
		if (ocupacion.getLimiteDerecho() < (Espacio.getInstancia().getLimiteDerecho()/2))
			moverDerecha();
	}
	
	/**
	 * Método que utilizarán las subclases instanciables de esta internamente para chequear si su nueva ocupación es válida (tomando una desición si no lo es) y si han colisionado con otro.
	 * @param ocupacionProvisoria subinstancia de la clase Ocupacion que tiene provisoriamente el tanque
	 */
	protected abstract void chequearOcupacionValidaYColisiones(Ocupacion ocupacionProvisoria);

	/**
	 * 
	 * @return orientacion del objeto móvil
	 */
	public Orientacion getOrientacion() {
		return orientacion;
	}

	/**
	 * 
	 * @return velocidad del objeto móvil
	 */
	public int getVelocidad() {
		return velocidad;
	}
	
	/**
	 * Realizamos el movimiento y cambiamos la orientación del objeto.
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
