package modelo.clasesGeneralizadoras;

/**
 * La implementan aquellas clases que modelan a objetos que tienen que tener la capacidad de realizar acciones no controladas por el usuario a medida que transcurre la l�gica del juego, cosa que hacen con su m�todo vivir.
 * @author Tom�s
 *
 */
public interface ObjetoVivo {

	/**
	 * Hace que el objeto lleve a cabo aquello que realiza en una unidad temporal de la l�gica del juego.
	 */
	public abstract void vivir();
	
}
