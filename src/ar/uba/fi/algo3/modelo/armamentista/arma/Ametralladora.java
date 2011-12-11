package ar.uba.fi.algo3.modelo.armamentista.arma;

import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoAmetralladora;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.Tanque;

/**
 * Modela una ametralladora, un arma que tiene munición ilimitada.
 * @author Fede
 *
 */
public class Ametralladora extends Arma {

	public Ametralladora(Tanque duenio) {
		super(duenio);
	}

	public void disparar() {
		Posicion posicionAuxiliar;
		posicionAuxiliar = duenio.getOcupacion().
				getPosicionPerimetralCentradaEnOrientacion(duenio.getOrientacion());
		new DisparoAmetralladora(duenio.getOrientacion(),posicionAuxiliar);
	}

}