package ar.uba.fi.algo3.modelo.estrategias.estrategiasDisparo;

import ar.uba.fi.algo3.modelo.tanques.AlgoTank;

/**
 * Representa a la estrategia de disparo de AlgoTank.
 * Esta estrategia tiene un doble prop�sito:
 * 1) Lleva una cuenta de unidades temporales transcurridas desde el inicio del juego. Una instancia de AlgoTank puede disparar cuando el valor de dichas unidades es mayor que el valor de una referencia est�tica menos su velocidad de disparo (de esta manera, a mayor velocidad de disparo mayor frecuencia de los mismos). Cada vez que dispara el n�mero de unidades vuelve a anularse y comienza la cuenta nuevamente.
 * 2) Indicarle a AlgoTank cu�l de sus armas debe disparar.
 * @author Tom�s
 *
 */
public class EstrategiaDisparoAlgoTank extends EstrategiaDisparo {

	/**
	 * Constructor.
	 * @param tanque instancia de la clase AlgoTank due�a de esta estrategia
	 */
	public EstrategiaDisparoAlgoTank(AlgoTank duenio) {
		super(duenio);
	}
	
	/**
	 * Dado que el constructor s�lo permite que se le pase como par�metro una instancia de AlgoTank para inicializar al due�o de la estrategia, realizar un casteo es type-safe.
	 * Si transcurri� el tiempo necesario para realizar un disparo desde el �ltimo, se lo realiza y se anula el atributo unidadesTemporalesTranscurridas.
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
