package ar.uba.fi.algo3.modelo.estrategias.estrategiasDisparo;

import ar.uba.fi.algo3.modelo.tanques.Tanque;

/**
 * Clase abstracta en la que los tanques enemigos delegan la desicion de si 
 * disparar o no, y dependiendo del caso el que arma disparar.
 * Para esto tienen un contador de unidades temporales el cual se incrementa 
 * cada vez que al tanque duenio de las estrategias se le invoca el metodo vivir.
 * Cuando se le pide a la estrategia que decida un disparo, si la cantidad 
 * de unidades temporales transcurridas es mayor que un atributo estatico 
 * entero (REFERENCIA_DISPAROS) menos la velocidad de disparo del tanque duenio, 
 * entonces se efectiviza el disparo.
 * De esta manera, a mayor velocidad de disparo de un tanque, mayor es la 
 * frecuencia de disparos posibles.
 * @author Tomas
 *
 */
public abstract class EstrategiaDisparo {

	protected static int REFERENCIA_DISPAROS = 35;
	
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
	 * Metodo llamado por el tanque duenio de esta estrategia, que se encarga 
	 * de invocarle o no alguno de sus metodos de disparo.
	 */
	public abstract void decidirDisparo();

	/**
	 * 
	 * @return true si transcurrio el tiempo necesario que tiene que ocurrir 
	 * entre disparos del tanque desde el ultimo disparo, y false en el caso 
	 * contrario
	 */
	public boolean tiempoEntreDisparosTranscurrido() {
		return (unidadesTemporalesTranscurridas >= 
				(REFERENCIA_DISPAROS - (duenio.getVelocidadDisparo())));
	}
	
	/**
	 * Le indicamos a la estrategia que ha transcurrido una unidad temporal.
	 */
	public void informarTranscursoTiempo() {
		++unidadesTemporalesTranscurridas;
	}
	
}
