package ar.uba.fi.algo3.modelo.armamentista.disparo;

import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;

/**
 * Modela al disparo efectuado por las ametralladoras.
 * @author Federico
 *
 */
public class DisparoAmetralladora extends Disparo {
	
	public DisparoAmetralladora(Orientacion orientacion, Posicion punto) {
		super(orientacion,punto);
		danioNeto = 20;
		danioPorcentual = 0;
		ocupacion = OcupacionCuadrada.crearAPartirDePosicionPerimetralCentradaEnOrientacion(punto, 1, orientacion);
		velocidad = 4;
		Espacio.getInstancia().agregarDisparo(this);
	}

}
