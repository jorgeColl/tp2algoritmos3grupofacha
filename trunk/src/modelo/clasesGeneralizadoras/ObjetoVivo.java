package modelo.clasesGeneralizadoras;

/**
 * La implementan aquellas clases que modelan a objetos que tienen que tener la capacidad de realizar acciones no controladas por el usuario a medida que transcurre la lógica del juego, cosa que hacen con su método vivir.
 * @author Tomás
 *
 */
public interface ObjetoVivo {

	/**
	 * Hace que el objeto lleve a cabo aquello que realiza en una unidad temporal de la lógica del juego.
	 */
	public abstract void vivir();
	
}
