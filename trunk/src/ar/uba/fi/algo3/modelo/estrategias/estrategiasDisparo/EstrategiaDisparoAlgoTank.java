package ar.uba.fi.algo3.modelo.estrategias.estrategiasDisparo;

import ar.uba.fi.algo3.modelo.armamentista.arma.ArmaMunicionLimitada;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;

/**
 * Representa a la estrategia de disparo de AlgoTank.
 * Esta estrategia tiene un doble proposito:
 * 1) Lleva una cuenta de unidades temporales transcurridas desde 
 * el inicio del juego. Una instancia de AlgoTank puede disparar 
 * cuando el valor de dichas unidades es mayor que el valor de una 
 * referencia estatica menos su velocidad de disparo (de esta manera, 
 * a mayor velocidad de disparo mayor frecuencia de los mismos). 
 * Cada vez que dispara el numero de unidades vuelve a anularse 
 * y comienza la cuenta nuevamente.
 * 2) Indicarle a AlgoTank cual de sus armas debe disparar.
 * @author Tomas
 *
 */
public class EstrategiaDisparoAlgoTank extends EstrategiaDisparo {

	/**
	 * Constructor.
	 * @param tanque instancia de la clase AlgoTank duenia de esta estrategia
	 */
	public EstrategiaDisparoAlgoTank(AlgoTank duenio) {
		super(duenio);
	}
	
	/**
	 * Dado que el constructor solo permite que se le pase como parametro
	 * una instancia de AlgoTank para inicializar al duenio de la estrategia, 
	 * realizar un casteo de dicho atributo a AlgoTank es type-safe.
	 * Si transcurrio el tiempo necesario para realizar un nuevo disparo 
	 * desde el ultimo, se lo realiza y se anula el atributo 
	 * unidadesTemporalesTranscurridas.
	 */
	public void decidirDisparo() {
		AlgoTank duenioAuxiliar = (AlgoTank)duenio;
		if (tiempoEntreDisparosTranscurrido()) { 
			if (!(duenioAuxiliar.getArmasPrioritarias().isEmpty())) {
				ArmaMunicionLimitada armaAuxiliar = duenioAuxiliar.getArmasPrioritarias().peek();
				armaAuxiliar.disparar();
				if (armaAuxiliar.getMunicion() == 0)
					duenioAuxiliar.getArmasPrioritarias().pop();
			}
			else
				duenioAuxiliar.getAmetralladora().disparar();
			unidadesTemporalesTranscurridas = 0;
		}
	}

}
