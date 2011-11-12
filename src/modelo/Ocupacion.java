package modelo;

/**
 * Modela al espacio que esta ocupando un objeto.
 * @author Tomás
 *
 */
public interface Ocupacion {

	/**
	 * 
	 * @param ocupacion objeto de la clase OcupacionCuadrada con respecto a la cual compararemos a esta instancia
	 * @return true si los objetos comparados coinciden espacialmente y false en el caso contrario
	 */
	public abstract boolean coincidenciaOcupacionalCon(OcupacionCuadrada ocupacion);
	
}
