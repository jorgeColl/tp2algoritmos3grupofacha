package ar.uba.fi.algo3.modelo.clasesGeneralizadoras;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ar.uba.fi.algo3.modelo.armamentista.disparo.Disparo;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Ocupacion;
import ar.uba.fi.algo3.modelo.tanques.Tanque;
import ar.uba.fi.algo3.titiritero.Posicionable;

/**
 * Provee el comportamiento y el estado comun a todas las entidades del juego que 
 * pueden posicionarse en el espacio. 
 * El atributo ocupacion representa a la ocupacion que tiene el objeto en el lugar 
 * en el que se desarrolla la accion del juego.
 * @author Jorge
 *
 */
public abstract class ObjetoJuego implements Posicionable {
	
	protected Ocupacion ocupacion;
	private boolean vivo = true;
	
	/* aca trato de que herede el comportamiento de crease una vista
	protected ObjetoJuego(){
		ConstructorVista.construirVista(this);
	}
	*/
	/**
	 * Hacemos que el objeto sea impactado por un disparo.
	 * @param disparo instancia de una subclase de Disparo que chocara con este objeto
	 */
	public abstract void chocarCon(Disparo disparo);
	
	/**
	 * Hacemos que el objeto sea impactado por un tanque.
	 * @param tanque instancia de una subclase de Tanque que chocara con este objeto
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
	 * @param objeto instancia de la clase ObjetoJuego cuya ocupacion compararemos 
	 * con la de esta
	 * @return true si los objetos comparados coinciden ocupacionalmente y false 
	 * en el caso contrario
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
		return ocupacion.getLimiteIzquierdo();		
	}
	
	public int getY(){
		return ocupacion.getLimiteSuperior();
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	public boolean isVivo() {
		return vivo;
	}
	
	public abstract void persistir(Document documentoXML, Element raiz);
	
}
