package modelo.estrategias.estrategiasDisparo;

import modelo.tanques.Tanque;

/**
 * Clase abstracta en la que los tanques enemigos delegan la desici�n de si disparar o no, y dependiendo del caso el qu� arma disparar.
 * Para esto tienen un contador de unidades temporales el cual se incrementa cada vez que al tanque due�o de las estrategias se le invoca el m�todo vivir.
 * Cuando se le pide a la estrategia que decida un disparo, si la cantidad de unidades temporales transcurridas es mayor que un atributo est�tico entero (REFERENCIA_DISPAROS) menos la velocidad de disparo del tanque due�o, entonces se efectiviza el disparo.
 * De esta manera, a mayor velocidad de disparo de un tanque, mayor es la frecuencia de disparos posibles.
 * @author Tom�s
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
	 * M�todo llamado por el tanque due�o de esta estrategia, que se encarga de invocarle o no alguno de sus m�todos de disparo.
	 */
	public abstract void decidirDisparo();

	/**
	 * 
	 * @return true si transcurri� el tiempo necesario que tiene que ocurrir entre disparos del tanque desde el �ltimo disparo, y false en el caso contrario
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
