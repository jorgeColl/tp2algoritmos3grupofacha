package ar.uba.fi.algo3.modelo.objetosInanimados;

import ar.uba.fi.algo3.vista.ConstructorVista;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;

/**
 * Modela una pared de concreto. La misma, al ser alcanzada por un disparo, ya desaparece.
 * @author Jorge
 *
 */
public class ParedConcreto extends Pared {

	public ParedConcreto(Posicion punto) {
		super(punto);
		impactosTolerados = 0;
		tipo = "concreto";
		if (Espacio.getInstancia().incluyeA(this)){
			ConstructorVista.construirVista(this);
		}
	}
}
