package ar.uba.fi.algo3.modelo.armamentista.disparo;

import ar.uba.fi.algo3.ConstructorVista;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;

/**
 * Modela al disparo efectuado por los lanza cohetes.
 * @author Fede
 *
 */
public class DisparoLanzaCohetes extends Disparo {
	
	public DisparoLanzaCohetes(Orientacion orientacion, Posicion punto) {
		super(orientacion,punto);
		danioNeto = 0;
		danioPorcentual = 50;
		ocupacion = OcupacionCuadrada.crearAPartirDePosicionPerimetralCentradaEnOrientacion(punto, 15, orientacion);
		velocidad = 4;
		tipo = "lanzaCohetes";
		
		Espacio.getInstancia().agregarDisparo(this);
		
		if (Espacio.getInstancia().incluyeA(this)){
			ConstructorVista.construirVista(this);
		}
	}

}
