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
		ocupacion = OcupacionCuadrada.crearAPartirDePosicionPerimetralCentradaEnOrientacion(punto, 1, orientacion);
		velocidad = 4;
		Espacio.getInstancia().agregarDisparo(this);
	}

}
