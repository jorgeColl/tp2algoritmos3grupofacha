package ar.uba.fi.algo3.modelo.estrategias.estrategiasDisparo;

import ar.uba.fi.algo3.modelo.tanques.AlgoTank;

/**
 * Representa a la estrategia de disparo de AlgoTank.
 * Esta estrategia tiene un doble propósito:
 * 1) Lleva una cuenta de unidades temporales transcurridas desde el inicio del juego. Una instancia de AlgoTank puede disparar cuando el valor de dichas unidades es mayor que el valor de una referencia estática menos su velocidad de disparo (de esta manera, a mayor velocidad de disparo mayor frecuencia de los mismos). Cada vez que dispara el número de unidades vuelve a anularse y comienza la cuenta nuevamente.
 * 2) Indicarle a AlgoTank cuál de sus armas debe disparar.
 * @author Tomás
 *
 */
public class EstrategiaDisparoAlgoTank extends EstrategiaDisparo {

	/**
	 * Constructor.
	 * @param tanque instancia de la clase AlgoTank dueña de esta estrategia
	 */
	public EstrategiaDisparoAlgoTank(AlgoTank duenio) {
		super(duenio);
	}
	
	/**
	 * Dado que el constructor sólo permite que se le pase como parámetro una instancia de AlgoTank para inicializar al dueño de la estrategia, realizar un casteo es type-safe.
	 * Si transcurrió el tiempo necesario para realizar un disparo desde el último, se lo realiza y se anula el atributo unidadesTemporalesTranscurridas.
	 */
	public void decidirDisparo() {
		AlgoTank duenioAuxiliar = (AlgoTank)duenio;
		if (tiempoEntreDisparosTranscurrido()) {
			if (duenioAuxiliar.getLanzaCohetes().getMunicion() > 0)
				duenioAuxiliar.dispararLanzaCohetes();
			else {
				if (duenioAuxiliar.getCanion().getMunicion() > 0)
					duenioAuxiliar.dispararCanion();
				else {
					duenioAuxiliar.dispararAmetralladora();
				}	
			}
			unidadesTemporalesTranscurridas = 0;
		}
	}

}
