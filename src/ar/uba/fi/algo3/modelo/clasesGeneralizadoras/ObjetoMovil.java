package ar.uba.fi.algo3.modelo.clasesGeneralizadoras;

import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Ocupacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;

/**
 * provee de estado y comportamiento comun a los objetos que pueden 
 * moverse por el espacio.
 * @author jc
 *
 */
public abstract class ObjetoMovil extends ObjetoJuego {

	protected Orientacion orientacion;
	protected int velocidad;
	
	/**
	 * analiza cual de los bordes laterales esta mas cercano al objeto 
	 * y lo mueve en dicha direccion.
	 * por defecto elije el derecho.
	 */
	public void acercarseAlBordeLateralMasCercano() {
		if (ocupacion.getLimiteIzquierdo() < 
				(Espacio.getInstancia().getLimiteDerecho() - ocupacion.getLimiteDerecho()))
			moverIzquierda();
		else
			moverDerecha();
	}
	
	/**
	 * dirige al objeto al centro del espacio hasta que algun punto de 
	 * su ocupacion coincida con la recta que determina a este.
	 */
	public void acercarseAlCentroHorizontalDelEspacio() {
		if (ocupacion.getLimiteIzquierdo() > (Espacio.getInstancia().getLimiteDerecho()/2))
			moverIzquierda();
		if (ocupacion.getLimiteDerecho() < (Espacio.getInstancia().getLimiteDerecho()/2))
			moverDerecha();
	}
	
	/**
	 * metodo que utilizaran las subclases instanciables de esta internamente 
	 * para chequear si su nueva ocupacion es valida (tomando una desicion si 
	 * no lo es dependiente de la subclase) y si han colisionado con otro.
	 * @param ocupacionProvisoria instancia de una subclase de Ocupacion que 
	 * tiene provisoriamente el tanque
	 */
	protected abstract void chequearOcupacionValidaYColisiones(Ocupacion ocupacionProvisoria);

	/**
	 * 
	 * @return orientacion del objeto movil
	 */
	public Orientacion getOrientacion() {
		return orientacion;
	}

	/**
	 * 
	 * @return velocidad del objeto movil
	 */
	public int getVelocidad() {
		return velocidad;
	}
	
	/**
	 * 
	 * @return true si moviendose en forma recta en cualquier orientacion 
	 * impactaran al objeto representado por el parametro en caso de que 
	 * este no se mueva y false en el caso contrario
	 */
	public boolean impactaraA(ObjetoJuego objeto) {
		int coordenadaAuxiliar = ocupacion.getLimiteSuperior()+
				(ocupacion.getLimiteInferior()-ocupacion.getLimiteSuperior())/2;
		if (coordenadaAuxiliar > objeto.getOcupacion().getLimiteSuperior()) {
			if (coordenadaAuxiliar < objeto.getOcupacion().getLimiteInferior())
				return true;
		}
		coordenadaAuxiliar = ocupacion.getLimiteIzquierdo()+
				(ocupacion.getLimiteDerecho()-ocupacion.getLimiteIzquierdo())/2;
		if (coordenadaAuxiliar > objeto.getOcupacion().getLimiteIzquierdo()) {
			if (coordenadaAuxiliar < objeto.getOcupacion().getLimiteDerecho())
				return true;
		}
		return false;
	}
	
	
	/**
	 * realizamos el movimiento y cambiamos la orientacion del objeto.
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
