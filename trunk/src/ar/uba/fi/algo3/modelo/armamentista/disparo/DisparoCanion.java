package modelo.armamentista.disparo;

import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.OcupacionCuadrada;
import modelo.manejoEspacial.Orientacion;
import modelo.manejoEspacial.Posicion;

/**
 * Modela al disparo efectuado por los cañones.
 * @author Tomás
 *
 */
public class DisparoCanion extends Disparo {

	public DisparoCanion(Orientacion orientacion, Posicion punto) {
		super(orientacion,punto);
		danioNeto = 30;
		danioPorcentual = 0;
		ocupacion = OcupacionCuadrada.crearAPartirDePosicionPerimetralCentradaEnOrientacion(punto, 1, orientacion);
		velocidad = 4;
		Espacio.getInstancia().agregarDisparo(this);
	}

}
