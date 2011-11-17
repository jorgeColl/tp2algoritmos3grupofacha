package modelo.manejoEspacial;

/**
 * Modela al espacio que esta ocupando un objeto.
 * @author Tomás
 *
 */
public interface Ocupacion {

	/**
	 * 
	 * @param ocupacion objeto de la clase Ocupacion con respecto a la cual compararemos a esta instancia
	 * @return true si los objetos comparados coinciden espacialmente y false en el caso contrario
	 */
	public abstract boolean coincidenciaOcupacionalCon(Ocupacion ocupacion); 

	/**
	 * Nos dice si la ocupación esta mapeada dentro de los límites espaciales del espacio.
	 * @return true si la ocupacion es válida y false en el caso contrario
	 */
	public abstract boolean espacialmenteValida();
	
	/**
	 * Método usado para dar una ocupación correcta a los disparos de los tanques.
	 * @param orientacion posición relativa a esta ocupación en la que queremos que esté el punto devuelto
	 * @return instancia de la clase posición que esté centrada con respecto a esta ocupación, 
	 * espacialmente pegada al perímetro de esta en la posición relativa dada por el parámetro
	 */
	public abstract Posicion getPosicionPerimetralCentradaEnOrientacion(Orientacion orientacion);
	
	/**
	 * PARA RESPETAR EL POLIMORFISMO Y EL ENCAPSULAMIENTO, ES NECESARIO QUE LAS OCUPACIONES SEPAN 
	 * COMPARARSE ENTRE ELLAS Y QUE DE AFUERA SE INVOQUE SENCILLAMENTE A coincidenciaOcupacionalCon(Ocupacion ocupacion).
	 * PARA ESTO ES NECESARIO QUE CADA OCUPACIÓN DEFINA UN MÉTODO QUE LA COMPARE CON ELLA MISMA Y CON CADA UNA 
	 * DE LAS OTRAS, QUE SERÁ INVOCADO INTERNAMENTE.
	 * EN PRINCIPIO TENEMOS SÓLO UNA OCUPACIÓN CUADRADA, POR LO TANTO SÓLO ES NECESARIO UN MÉTODO   
	 */
	
	/**
	 * Compara a este objeto con la ocupación cuadrada pasada por parámetro.
	 */
	public boolean compararConOcupacionCuadrada(OcupacionCuadrada ocupacion);
	
	/**
	 * Devuelve la posición equivalente a esta movida unitariamente hacia abajo.
	 */
	public abstract Ocupacion getOcupacionMovidaAbajo();
	
	/**
	 * Devuelve la posición equivalente a esta movida unitariamente hacia arriba.
	 */
	public abstract Ocupacion getOcupacionMovidaArriba();
	
	/**
	 * Devuelve la posición equivalente a esta movida unitariamente hacia la derecha.
	 */
	public abstract Ocupacion getOcupacionMovidaDerecha();
	
	/**
	 * Devuelve la posición equivalente a esta movida unitariamente hacia la izquierda.
	 */
	public abstract Ocupacion getOcupacionMovidaIzquierda();
}
