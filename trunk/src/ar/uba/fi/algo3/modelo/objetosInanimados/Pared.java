package ar.uba.fi.algo3.modelo.objetosInanimados;

import ar.uba.fi.algo3.modelo.armamentista.disparo.Disparo;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.Tanque;

/**
 * Clase abstracta que modela a las paredes del escenario.
 * Llevan una cuenta de los impactos que reciben, dado que resisten una cantidad limitada de los mismos antes de desaparecer.
 * @author Jorge
 *
 */
public abstract class Pared extends ObjetoJuego {

	protected int impactosRecibidos;
	protected int impactosTolerados;
	
	/**
	 * Constructor.
	 * @param impactosTolerados cantidad m�xima de disparos que puede recibir la pared antes de desaparecer
	 * @param punto instancia de la clase Posicion con la que se inicializar� la ocupaci�n de la pared
	 */
	public Pared(Posicion punto) {
		impactosRecibidos = 0;
		ocupacion = new OcupacionCuadrada(punto,43);
		
		/* agrego la instancia en el Espacio */
		try {
			Espacio.getInstancia().agregarObjetoInanimado(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Se incrementa la cantidad de disparos recibidas. Si esta pasa a ser mayor que la tolerada, la pared desaparece.
	 */
	public void chocarCon(Disparo disparo) {
		
		disparo.desaparecer();
		
		++impactosRecibidos;
		if (impactosRecibidos > impactosTolerados)
			desaparecer();
	}

	/**
	 * Cuando un tanque choca a la pared, se le indica a esta que se mueva unitariamente en la direcci�n contraria dado que lo obstaculiza.
	 */
	public void chocarCon(Tanque tanque) {
		tanque.moverEnDireccionContraria();
	}
	
}
