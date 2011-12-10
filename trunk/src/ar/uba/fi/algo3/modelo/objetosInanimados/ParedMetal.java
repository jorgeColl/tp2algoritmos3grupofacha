package ar.uba.fi.algo3.modelo.objetosInanimados;

import ar.uba.fi.algo3.vista.ConstructorVista;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;

/**
 * Modela una pared de metal, la cual al ser alcanzada por dos disparos desaparece.
 * @author Jorge
 *
 */
public class ParedMetal extends Pared {

	public ParedMetal(Posicion punto) {
		super(punto);
		impactosTolerados = 1;
		tipo = "metal";
		if (Espacio.getInstancia().incluyeA(this)){
			ConstructorVista.construirVista(this);
		}
	}

}
