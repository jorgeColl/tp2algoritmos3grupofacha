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
	 * Nos dice si la ocupación esta mapeada dentro de los límites espaciales del espacio.
	 * @return true si la ocupacion es válida y false en el caso contrario
	 */
	public abstract boolean espacialmenteValida();

	/**
	 * 
	 * @return true si la ocupación está en alguno de los bordes del espacio y false en el caso contrario
	 */
	public abstract boolean estaEnBorde();
	
	/**
	 * 
	 * @return true si la ocupación está en alguno de los bordes horizontales del espacio y false en el caso contrario
	 */
	public abstract boolean estaEnBordeHorizontal();
	
	/**
	 * 
	 * @return true si la ocupación está en alguno de los bordes del espacio y false en el caso contrario
	 */
	public abstract boolean estaEnBordeVertical();

	/**
	 * 
	 * @return true si alguna de las posiciones de la ocupación coincide con alguna de las posiciones de la recta imaginaria que atraviesa el espacio verticalmente por su mitad, y false en el caso contrario
	 */
	public abstract boolean estaEnCentroHorizontal();
	
	/**
	 * 
	 * @return posicion de la ocupación de mayor coordenada horizontal
	 */
	public abstract int getLimiteDerecho();
	
	/**
	 * 
	 * @return posicion de la ocupación de mayor coordenada vertical
	 */
	public abstract int getLimiteInferior();
	
	/**
	 * 
	 * @return posicion de la ocupación de menor coordenada horizontal
	 */
	public abstract int getLimiteIzquierdo();
	
	/**
	 * 
	 * @return posicion de la ocupación de menor coordenada vertical
	 */
	public abstract int getLimiteSuperior();
	
	/**
	 * PARA RESPETAR EL POLIMORFISMO Y EL ENCAPSULAMIENTO, ES NECESARIO QUE LAS OCUPACIONES SEPAN COMPARARSE ENTRE ELLAS Y QUE DE AFUERA SE INVOQUE SENCILLAMENTE A coincidenciaOcupacionalCon(Ocupacion ocupacion).
	 * PARA ESTO ES NECESARIO QUE CADA OCUPACIÓN DEFINA UN MÉTODO QUE LA COMPARE CON ELLA MISMA Y CON CADA UNA DE LAS OTRAS, QUE SERÁ INVOCADO INTERNAMENTE.
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
	
	/**
	 * Devuelve una instancia de la clase posición que esté centrada con respecto a esta ocupación, espacialmente pegada a su perímetro, en la posición relativa dada por el parámetro
	 * @param orientacion posición relativa a esta ocupación en la que queremos que esté el punto devuelto
	 * @return instancia de la clase posición que esté centrada con respecto a esta ocupación, espacialmente pegada a su perímetro, en la posición relativa dada por el parámetro
	 */
	public abstract Posicion getPosicionPerimetralCentradaEnOrientacion(Orientacion orientacion);
	
}
