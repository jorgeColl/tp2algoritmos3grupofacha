package modelo.estrategias.estrategiasDisparo;

/**
 * Interfaz en la que los tanques enemigos delegan la desici�n de si disparar o no, y las instancias de AlgoTank delegan el decidir qu� arma disparar�n.
 * @author Tom�s
 *
 */
public interface EstrategiaDisparo {

	/**
	 * M�todo llamado por el tanque due�o de esta estrategia, que se encarga de invocarle o no alguno de sus m�todos de disparo.
	 */
	public abstract void decidirDisparo();
	
}
