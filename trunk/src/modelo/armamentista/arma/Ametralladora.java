package modelo.armamentista.arma;

import modelo.armamentista.disparo.DisparoAmetralladora;
import modelo.manejoEspacial.Posicion;
import modelo.tanques.Tanque;

/**
 * Modela una ametralladora, la cual es un arma que tiene munición ilimitada.
 * @author Tomás
 *
 */
public class Ametralladora extends Arma {

	public Ametralladora(Tanque duenio) {
		super(duenio);
	}

	public void disparar() {
		Posicion posicionAuxiliar;
		posicionAuxiliar = duenio.getOcupacion().getPosicionPerimetralCentradaEnOrientacion(duenio.getOrientacion());
		new DisparoAmetralladora(duenio.getOrientacion(),posicionAuxiliar);
	}

}