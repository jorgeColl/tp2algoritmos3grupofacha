package modelo.manejoEspacial;

/**
 * Modela al espacio que esta ocupando un objeto.
 * @author Samanta
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
	 * 
	 * @param ocupacion objeto de la clase Ocupacion con respecto a la cual compararemos a esta instancia
	 * @return true si los objetos tiene coincidencia ocupacional en sus respectivas proyecciones en el eje x
	 */
	public abstract boolean coincidenciaProyeccionHorizontalCon(Ocupacion ocupacion);
	
	/**
	 * 
	 * @param ocupacion objeto de la clase Ocupacion con respecto a la cual compararemos a esta instancia
	 * @return true si los objetos tiene coincidencia ocupacional en sus respectivas proyecciones en el eje y
	 */
	public abstract boolean coincidenciaProyeccionVerticalCon(Ocupacion ocupacion);
	
	/**
	 * Nos dice si la ocupaci�n esta mapeada dentro de los l�mites espaciales del espacio.
	 * @return true si la ocupacion es v�lida y false en el caso contrario
	 */
	public abstract boolean espacialmenteValida();

	/**
	 * 
	 * @return true si la ocupaci�n est� en alguno de los bordes del espacio y false en el caso contrario
	 */
	public abstract boolean estaEnBorde();
	
	/**
	 * 
	 * @return true si la ocupaci�n est� en alguno de los bordes horizontales del espacio y false en el caso contrario
	 */
	public abstract boolean estaEnBordeHorizontal();
	
	/**
	 * 
	 * @return true si la ocupaci�n est� en alguno de los bordes del espacio y false en el caso contrario
	 */
	public abstract boolean estaEnBordeVertical();

	/**
	 * 
	 * @return true si alguna de las posiciones de la ocupaci�n coincide con alguna de las posiciones de la recta imaginaria que atraviesa el espacio verticalmente por su mitad, y false en el caso contrario
	 */
	public abstract boolean estaEnCentroHorizontal();
	
	/**
	 * 
	 * @return posicion de la ocupaci�n de mayor coordenada horizontal
	 */
	public abstract int getLimiteDerecho();
	
	/**
	 * 
	 * @return posicion de la ocupaci�n de mayor coordenada vertical
	 */
	public abstract int getLimiteInferior();
	
	/**
	 * 
	 * @return posicion de la ocupaci�n de menor coordenada horizontal
	 */
	public abstract int getLimiteIzquierdo();
	
	/**
	 * 
	 * @return posicion de la ocupaci�n de menor coordenada vertical
	 */
	public abstract int getLimiteSuperior();
	
	/**
	 * PARA RESPETAR EL POLIMORFISMO Y EL ENCAPSULAMIENTO, ES NECESARIO QUE LAS OCUPACIONES SEPAN COMPARARSE ENTRE ELLAS Y QUE DE AFUERA SE INVOQUE SENCILLAMENTE A coincidenciaOcupacionalCon(Ocupacion ocupacion).
	 * PARA ESTO ES NECESARIO QUE CADA OCUPACI�N DEFINA UN M�TODO QUE LA COMPARE CON ELLA MISMA Y CON CADA UNA DE LAS OTRAS, QUE SER� INVOCADO INTERNAMENTE.
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
	
	/**
	 * Devuelve una instancia de la clase posici�n que est� centrada con respecto a esta ocupaci�n, espacialmente pegada a su per�metro, en la posici�n relativa dada por el par�metro
	 * @param orientacion posici�n relativa a esta ocupaci�n en la que queremos que est� el punto devuelto
	 * @return instancia de la clase posici�n que est� centrada con respecto a esta ocupaci�n, espacialmente pegada a su per�metro, en la posici�n relativa dada por el par�metro
	 */
	public abstract Posicion getPosicionPerimetralCentradaEnOrientacion(Orientacion orientacion);
	
}
