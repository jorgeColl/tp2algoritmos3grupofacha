package modelo.objetosInanimados;

import modelo.manejoEspacial.Posicion;

/**
 * Modela una pared de concreto. La misma, al ser alcanzada por un disparo, ya desaparece.
 * @author Tomás
 *
 */
public class ParedConcreto extends Pared {

	public ParedConcreto(Posicion puntoMenorModulo) {
		super(puntoMenorModulo);
		impactosTolerados = 0;
	}
	
}
