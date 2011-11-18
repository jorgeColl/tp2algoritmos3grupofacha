package modelo.armamentista.disparo;

import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.OcupacionCuadrada;
import modelo.manejoEspacial.Orientacion;
import modelo.manejoEspacial.Posicion;

/**
 * Modela al disparo efectuado por las ametralladoras.
 * @author Tomás
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
