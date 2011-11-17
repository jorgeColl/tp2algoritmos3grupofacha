package modelo.objetosInanimados;

import modelo.manejoEspacial.Posicion;

/**
 * Modela una pared de metal, la cual al ser alcanzada por dos disparos desaparece.
 * @author Tomás
 *
 */
public class ParedMetal extends Pared {

	public ParedMetal(Posicion puntoMenorModulo) {
		super(puntoMenorModulo);
		impactosTolerados = 1;
	}

}
