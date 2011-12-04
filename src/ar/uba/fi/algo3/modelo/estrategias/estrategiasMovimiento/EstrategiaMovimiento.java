package ar.uba.fi.algo3.modelo.estrategias.estrategiasMovimiento;

import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoMovil;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;

/**
 * Los objetos que tienen la capacidad de moverse delegan en las instancias de las subclases de esta clase el que les diga hacia d�nde dirigirse en funci�n de la estrategia que quiera adoptar.
 * @author Tom�s
 *
 */
public abstract class EstrategiaMovimiento {

	protected ObjetoMovil duenio;
	protected ObjetoJuego objetivo;
	
	/**
	 * Constructor.
	 * @param duenio instancia de una subclase de ObjetoMovil que delega en esta estrategia
	 * @param objetivo instancia de la clase ObjetoJuego a la cual el objeto m�vil trata de alcanzar
	 */
	public EstrategiaMovimiento(ObjetoMovil duenio, ObjetoJuego objetivo) {
		this.duenio = duenio;
		this.objetivo = objetivo;
	}
	
	/**
	 * Le indica al objeto m�vil que se acerce horizontalmente a su objetivo.
	 * NOTA IMPORTANTE: Si el centro geom�trico horizontal del objeto m�vil tiene coincidencia con la proyecci�n ortogonal horizontal del objetivo entonces el m�todo no hace nada.  
	 */
	protected void indicarDuenioAcercarseHorizontalmenteAObjetivo() {
		if ((duenio.getOcupacion().getLimiteIzquierdo()+((duenio.getOcupacion().getLimiteDerecho()-duenio.getOcupacion().getLimiteIzquierdo())/2)) < objetivo.getOcupacion().getLimiteIzquierdo()) 
			duenio.moverDerecha();
		else {
			if ((duenio.getOcupacion().getLimiteIzquierdo()+((duenio.getOcupacion().getLimiteDerecho()-duenio.getOcupacion().getLimiteIzquierdo())/2)) > objetivo.getOcupacion().getLimiteDerecho()) 
				duenio.moverDerecha();
		}
	}
	
	/**
	 * Le indica al objeto m�vil que se acerce verticalmente a su objetivo.
	 * NOTA IMPORTANTE: Si el centro geom�trico vertical del objeto m�vil tiene coincidencia con la proyecci�n ortogonal vertical del objetivo entonces el m�todo no hace nada. 
	 */
	protected void indicarDuenioAcercarseVerticalmenteAObjetivo() {
		if ((duenio.getOcupacion().getLimiteSuperior()+((duenio.getOcupacion().getLimiteInferior()-duenio.getOcupacion().getLimiteSuperior())/2)) < objetivo.getOcupacion().getLimiteSuperior()) 
			duenio.moverAbajo();
		else {
			if ((duenio.getOcupacion().getLimiteSuperior()+((duenio.getOcupacion().getLimiteInferior()-duenio.getOcupacion().getLimiteSuperior())/2)) > objetivo.getOcupacion().getLimiteInferior()) 
				duenio.moverArriba();
		}
	}

	/**
	 * M�todo en el que los objetos que tienen la capacidad de moverse delegan el que le indiquen hacia d�nde dirigirse.
	 */
	public abstract void dedicirMovimiento();
	
	/**
	 * 
	 * @return instancia de la clase ObjetoJuego que es el objetivo al que esta estrategia indica a su due�o que se acerque
	 */
	public ObjetoJuego getObjetivo() {
		return objetivo;
	}
	
	/**
	 * Le indicamos al objeto m�vil que se oriente horizontalmente hacia su objetivo.
	 * NOTA IMPORTANTE: Si los objetos tienen coincidencia en sus proyecciones horizontales, entonces no hace nada.
	 */
	protected void orientarDuenioHorizontalmenteHaciaObjetivo() {
		if ((duenio.getOcupacion().getLimiteDerecho() < objetivo.getOcupacion().getLimiteIzquierdo()))
			duenio.setOrientacion(Orientacion.i);
		if ((duenio.getOcupacion().getLimiteIzquierdo() > objetivo.getOcupacion().getLimiteDerecho()))
			duenio.setOrientacion(Orientacion.iNegativo);
	}
	
	/**
	 * Le indicamos al objeto m�vil que se oriente verticalmente hacia su objetivo.
	 * NOTA IMPORTANTE: Si los objetos tienen coincidencia en sus proyecciones verticales, entonces no hace nada.
	 */
	protected void orientarDuenioVerticalmenteHaciaObjetivo() {
		if ((duenio.getOcupacion().getLimiteInferior() < objetivo.getOcupacion().getLimiteSuperior()))
			duenio.setOrientacion(Orientacion.jNegativo);
		if ((duenio.getOcupacion().getLimiteSuperior() > objetivo.getOcupacion().getLimiteInferior()))
			duenio.setOrientacion(Orientacion.j);
	}
	
}
