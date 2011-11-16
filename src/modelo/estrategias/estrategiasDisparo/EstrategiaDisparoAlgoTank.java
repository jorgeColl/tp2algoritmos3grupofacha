package modelo.estrategias.estrategiasDisparo;

import modelo.tanques.AlgoTank;

public class EstrategiaDisparoAlgoTank implements EstrategiaDisparo {

	AlgoTank duenio;
	
	/**
	 * Constructor.
	 * @param tanque instancia de la clase AlgoTank dueña de esta estrategia
	 */
	public EstrategiaDisparoAlgoTank(AlgoTank tanque) {
		duenio = tanque;
	}
	
	@Override
	public void decidirDisparo() {
		if (duenio.getLanzaCohetes().getMunicion() > 0)
			duenio.dispararLanzaCohetes();
		else {
			if (duenio.getCanion().getMunicion() > 0)
				duenio.dispararCanion();
			else {
				duenio.dispararAmetralladora();
			}	
		}
	}

}
