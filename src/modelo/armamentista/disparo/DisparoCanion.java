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
		Posicion posicionAuxiliar = obtenerPuntoMenorModuloDisparo(orientacion, punto, 1);
		ocupacion = new OcupacionCuadrada(posicionAuxiliar, 1);
		velocidad = 4;
		Espacio.getInstancia().agregarDisparo(this);
	}

}
