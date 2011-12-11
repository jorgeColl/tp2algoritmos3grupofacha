package ar.uba.fi.algo3.modelo.armamentista.disparo;

import ar.uba.fi.algo3.vista.ConstructorVista;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;

/**
 * Modela al disparo efectuado por las ametralladoras.
 * @author Fede
 *
 */
public class DisparoAmetralladora extends Disparo {
	
	public DisparoAmetralladora(Orientacion orientacion, Posicion punto) {
		super(orientacion, punto);
		danioNeto = 20;
		danioPorcentual = 0;
		ocupacion = OcupacionCuadrada.
			crearAPartirDePosicionPerimetralCentradaEnOrientacion(punto, 15, orientacion);
		velocidad = 4;
		tipo = "ametralladora";
		
		/* agrego la instancia en el Espacio */
		Espacio.getInstancia().agregarDisparo(this);
		if (Espacio.getInstancia().incluyeA(this)){
			ConstructorVista.construirVista(this);
		}
	}

}
