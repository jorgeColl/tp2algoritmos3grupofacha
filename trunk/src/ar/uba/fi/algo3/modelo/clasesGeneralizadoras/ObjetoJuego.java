package ar.uba.fi.algo3.modelo.clasesGeneralizadoras;

import ar.uba.fi.algo3.modelo.armamentista.disparo.Disparo;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Ocupacion;
import ar.uba.fi.algo3.modelo.tanques.Tanque;
import ar.uba.fi.algo3.titiritero.Posicionable;

/**
 * Provee el comportamiento y el estado com�n a todas las entidades del juego que pueden posicionarse en el espacio. 
 * El atributo ocupacion representa a la ocupaci�n que tiene el objeto en el lugar en el que se desarrolla la acci�n del juego.
 * @author Jorge
 *
 */
public abstract class ObjetoJuego implements Posicionable {
	
	protected Ocupacion ocupacion;
	private boolean vivo = true;
	
	/**
	 * Hacemos que el objeto sea impactado por un disparo.
	 * @param disparo instancia de una subclase de Disparo que chocar� con este objeto
	 */
	public abstract void chocarCon(Disparo disparo);
	
	/**
	 * Hacemos que el objeto sea impactado por un tanque.
	 * @param tanque instancia de una subclase de Tanque que chocar� con este objeto
	 */
	public abstract void chocarCon(Tanque tanque);

	/**
	 * Hacemos que el objeto desaparezca del espacio, delegando en la clase Espacio.
	 */
	public void desaparecer() {
		Espacio.getInstancia().desaparecerA(this);
		this.setVivo(false);
	}
	
	/**
	 * Delega en la clase Ocupacion.
	 * @param objeto instancia de la clase ObjetoJuego cuya ocupaci�n compararemos con la de esta
	 * @return true si los objetos comparados coinciden ocupacionalmente y false en el caso contrario
	 */
	public boolean estaEnContactoCon(ObjetoJuego objeto) {
		return (objeto.getOcupacion().coincidenciaOcupacionalCon(ocupacion));
	}
	
	/**
	 * 
	 * @return atributo ocupacion
	 */
	public Ocupacion getOcupacion() {
		return ocupacion;
	}
	
	public int getX(){
		return ocupacion.getLimiteDerecho();		
	}
	
	public int getY(){
		return ocupacion.getLimiteInferior();
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	public boolean isVivo() {
		return vivo;
	}

}
