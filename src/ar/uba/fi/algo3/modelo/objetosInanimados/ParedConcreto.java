package ar.uba.fi.algo3.modelo.objetosInanimados;

import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;

/**
 * Modela una pared de concreto. La misma, al ser alcanzada por un disparo, ya desaparece.
 * @author Tomás
 *
 */
public class ParedConcreto extends Pared {

	public ParedConcreto(Posicion punto) {
		super(punto);
		impactosTolerados = 0;
	}
	
}
