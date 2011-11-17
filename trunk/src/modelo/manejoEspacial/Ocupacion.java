package modelo.manejoEspacial;

/**
 * Modela al espacio que esta ocupando un objeto.
 * @author Tom�s
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
	 * Nos dice si la ocupaci�n esta mapeada dentro de los l�mites espaciales del espacio.
	 * @return true si la ocupacion es v�lida y false en el caso contrario
	 */
	public abstract boolean espacialmenteValida();
	
	/**
	 * M�todo usado para dar una ocupaci�n correcta a los disparos de los tanques.
	 * @param orientacion posici�n relativa a esta ocupaci�n en la que queremos que est� el punto devuelto
	 * @return instancia de la clase posici�n que est� centrada con respecto a esta ocupaci�n, 
	 * espacialmente pegada al per�metro de esta en la posici�n relativa dada por el par�metro
	 */
	public abstract Posicion getPosicionPerimetralCentradaEnOrientacion(Orientacion orientacion);
	
	/**
	 * PARA RESPETAR EL POLIMORFISMO Y EL ENCAPSULAMIENTO, ES NECESARIO QUE LAS OCUPACIONES SEPAN 
	 * COMPARARSE ENTRE ELLAS Y QUE DE AFUERA SE INVOQUE SENCILLAMENTE A coincidenciaOcupacionalCon(Ocupacion ocupacion).
	 * PARA ESTO ES NECESARIO QUE CADA OCUPACI�N DEFINA UN M�TODO QUE LA COMPARE CON ELLA MISMA Y CON CADA UNA 
	 * DE LAS OTRAS, QUE SER� INVOCADO INTERNAMENTE.
	 * EN PRINCIPIO TENEMOS S�LO UNA OCUPACI�N CUADRADA, POR LO TANTO S�LO ES NECESARIO UN M�TODO   
	 */
	
	/**
	 * Compara a este objeto con la ocupaci�n cuadrada pasada por par�metro.
	 */
	public boolean compararConOcupacionCuadrada(OcupacionCuadrada ocupacion);
	
	/**
	 * Devuelve la posici�n equivalente a esta movida unitariamente hacia abajo.
	 */
	public abstract Ocupacion getOcupacionMovidaAbajo();
	
	/**
	 * Devuelve la posici�n equivalente a esta movida unitariamente hacia arriba.
	 */
	public abstract Ocupacion getOcupacionMovidaArriba();
	
	/**
	 * Devuelve la posici�n equivalente a esta movida unitariamente hacia la derecha.
	 */
	public abstract Ocupacion getOcupacionMovidaDerecha();
	
	/**
	 * Devuelve la posici�n equivalente a esta movida unitariamente hacia la izquierda.
	 */
	public abstract Ocupacion getOcupacionMovidaIzquierda();
}
