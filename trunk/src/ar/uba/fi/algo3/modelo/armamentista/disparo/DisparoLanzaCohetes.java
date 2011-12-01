package ar.uba.fi.algo3.modelo.armamentista.disparo;

import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;

/**
 * Modela al disparo efectuado por los lanza cohetes.
 * @author Federico
 *
 */
public class DisparoLanzaCohetes extends Disparo {
	
	public DisparoLanzaCohetes(Orientacion orientacion, Posicion punto) {
		super(orientacion,punto);
		danioNeto = 0;
		danioPorcentual = 50;
		ocupacion = OcupacionCuadrada.crearAPartirDePosicionPerimetralCentradaEnOrientacion(punto, 1, orientacion);
		velocidad = 4;
		Espacio.getInstancia().agregarDisparo(this);
	}

}