package modelo.estrategias.estrategiasMovimiento;

import modelo.clasesGeneralizadoras.ObjetoJuego;
import modelo.clasesGeneralizadoras.ObjetoMovil;
import modelo.manejoEspacial.Orientacion;

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
	 * NOTA IMPORTANTE: Si los objetos tienen coincidencia ocupacional en sus proyecciones horizontales, entonces no realiza ning�n movimiento. 
	 */
	protected void indicarDuenioAcercarseHorizontalmenteAObjetivo() {
		if (duenio.getOcupacion().getLimiteDerecho() < objetivo.getOcupacion().getLimiteIzquierdo())
			duenio.moverDerecha();
		else {
			if (duenio.getOcupacion().getLimiteIzquierdo() > objetivo.getOcupacion().getLimiteDerecho())
				duenio.moverIzquierda();
		}
	}
	
	/**
	 * Le indica al objeto m�vil que se acerce verticalmente a su objetivo.
	 * NOTA IMPORTANTE: Si los objetos tienen coincidencia ocupacional en sus proyecciones verticales, entonces no realiza ning�n movimiento. 
	 */
	protected void indicarDuenioAcercarseVerticalmenteAObjetivo() {
		if (duenio.getOcupacion().getLimiteInferior() < objetivo.getOcupacion().getLimiteSuperior())
			duenio.moverAbajo();
		else {
			if (duenio.getOcupacion().getLimiteSuperior() > objetivo.getOcupacion().getLimiteInferior())
				duenio.moverArriba();
		}
	}

	/**
	 * M�todo en el que los objetos que tienen la capacidad de moverse delegan el que le indiquen hacia d�nde dirigirse.
	 */
	public abstract void dedicirMovimiento();
	
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
