package modelo.estrategias.estrategiasDisparo;

import modelo.tanques.Tanque;

/**
 * Modela una estrategia de disparo que hace que el tanque dispare ni bien su velocidad de disparo se lo permite.
 * @author Tomás
 *
 */
public class EstrategiaDisparoVelocidadDependiente extends EstrategiaDisparo {

	/**
	 * Constructor.
	 * @param duenio instancia de la clase Tanque que será dueña de esta estrategia
	 */
	public EstrategiaDisparoVelocidadDependiente(Tanque duenio) {
		super(duenio);
	}
	
	/**
	 * Si ha transcurrido el tiempo necesario para realizar un nuevo disparo se lo realiza.
	 */
	public void decidirDisparo() {
		if (tiempoEntreDisparosTranscurrido()) {
			duenio.disparar();
			unidadesTemporalesTranscurridas = 0;
		}
	}

}
