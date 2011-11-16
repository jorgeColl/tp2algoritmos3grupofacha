package modelo.estrategias.estrategiasDisparo;

/**
 * Interfaz en la que los tanques enemigos delegan la desición de si disparar o no, y las instancias de AlgoTank delegan el decidir qué arma dispararán.
 * @author Tomás
 *
 */
public interface EstrategiaDisparo {

	/**
	 * Método llamado por el tanque dueño de esta estrategia, que se encarga de invocarle o no alguno de sus métodos de disparo.
	 */
	public abstract void decidirDisparo();
	
}
