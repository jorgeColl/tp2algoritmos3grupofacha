package modelo.estrategias.estrategiasDisparo;

import modelo.tanques.Tanque;

/**
 * Clase abstracta en la que los tanques enemigos delegan la desición de si disparar o no, y dependiendo del caso el qué arma disparar.
 * Para esto tienen un contador de unidades temporales el cual se incrementa cada vez que al tanque dueño de las estrategias se le invoca el método vivir.
 * Cuando se le pide a la estrategia que decida un disparo, si la cantidad de unidades temporales transcurridas es mayor que un atributo estático entero (REFERENCIA_DISPAROS) menos la velocidad de disparo del tanque dueño, entonces se efectiviza el disparo.
 * De esta manera, a mayor velocidad de disparo de un tanque, mayor es la frecuencia de disparos posibles.
 * @author Tomás
 *
 */
public abstract class EstrategiaDisparo {

	protected static int REFERENCIA_DISPAROS = 20;
	
	protected Tanque duenio;
	protected int unidadesTemporalesTranscurridas;
	
	/**
	 * Constructor.
	 */
	public EstrategiaDisparo(Tanque duenio) {
		this.duenio = duenio;
		unidadesTemporalesTranscurridas = 0;
	}
	
	/**
	 * Método llamado por el tanque dueño de esta estrategia, que se encarga de invocarle o no alguno de sus métodos de disparo.
	 */
	public abstract void decidirDisparo();

	/**
	 * 
	 * @return true si transcurrió el tiempo necesario que tiene que ocurrir entre disparos del tanque desde el último disparo, y false en el caso contrario
	 */
	public boolean tiempoEntreDisparosTranscurrido() {
		return (unidadesTemporalesTranscurridas >= (REFERENCIA_DISPAROS - (duenio.getVelocidadDisparo())));
	}
	
	/**
	 * Le indicamos a la estrategia que ha transcurrido una unidad temporal.
	 */
	public void informarTranscursoTiempo() {
		++unidadesTemporalesTranscurridas;
	}
	
}
