package modelo.armamentista.disparo;

import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.OcupacionCuadrada;
import modelo.manejoEspacial.Orientacion;
import modelo.manejoEspacial.Posicion;

/**
 * Modela al disparo efectuado por los lanza cohetes.
 * @author Tomás
 *
 */
public class DisparoLanzaCohetes extends Disparo {
	
	public DisparoLanzaCohetes(Orientacion orientacion, Posicion punto) {
		super(orientacion,punto);
		danioNeto = 0;
		danioPorcentual = 50;
		Posicion posicionAuxiliar = obtenerPuntoMenorModuloDisparo(orientacion, punto, 1);
		ocupacion = new OcupacionCuadrada(posicionAuxiliar,1);
		velocidad = 4;
		Espacio.getInstancia().agregarDisparo(this);
	}

}
