package ar.uba.fi.algo3.modelo.tanques;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ar.uba.fi.algo3.modelo.armamentista.arma.Arma;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.estrategias.estrategiasDisparo.EstrategiaDisparoVelocidadDependiente;
import ar.uba.fi.algo3.modelo.estrategias.estrategiasMovimiento.EstrategiaMovimiento;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;

/**
 * Provee el estado y el comportamiento común de los tanques enemigos.
 * @author Tomas
 *
 */
public abstract class TanqueEnemigo extends Tanque {
	
	protected Arma arma;
	protected EstrategiaMovimiento estrategiaMovimiento;
	protected int puntosPorDestruccion;
	protected String tipo;
	
	public TanqueEnemigo(Posicion punto) {
		super(punto);
		estrategiaDisparo = new EstrategiaDisparoVelocidadDependiente(this);
		orientacion = Orientacion.jNegativo;
		try {
			Espacio.getInstancia().agregarTanqueEnemigo(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Delega en su instancia de una subclase de Arma.
	 */
	public void disparar() {
		arma.disparar();
	}
	
	/**
	 * 
	 * @return arma del tanque
	 */
	public Arma getArma() {
		return arma;
	}

	/**
	 * 
	 * @return entero representante de los puntos que se obtienen al destruir al tanque
	 */
	public int getPuntosPorDestruccion() {
		return puntosPorDestruccion;
	}
	
	/**
	 * Le indicamos al tanque quien es su objetivo para alcanzar y destruir.
	 * @param objeto instancia de la clase ObjetoJuego a la cual el tanque 
	 * tratara de alcanzar y destruir
	 */
	public abstract void indicarObjetivo(ObjetoJuego objeto);
	
	/**
	 * Le indica al tanque que se mueva y dispare si es necesario, delegando en 
	 * las estrategias correspondientes.
	 */
	public void vivir() {
		estrategiaMovimiento.dedicirMovimiento();
		estrategiaDisparo.decidirDisparo();
		estrategiaDisparo.informarTranscursoTiempo();
	}
	
	/**
	 * Al comportamiento común a todos los objetos del juego, sumamos el aumentar 
	 * el puntaje del jugador.
	 */
	public void desaparecer() {
		super.desaparecer();
		if (Espacio.getInstancia().getTanqueJugador() != null)
			Espacio.getInstancia().getTanqueJugador().incrementarPuntaje(puntosPorDestruccion);
	}
	
	/**
	 * Persiste el estado del tanque.
	 */
	public void persistir(Document documentoXML, Element raiz){
		Element nodo = documentoXML.createElement("tanqueEnemigo");
		
		Attr atributoTipo = documentoXML.createAttribute("tipo");
		atributoTipo.setValue(tipo);
		nodo.setAttributeNode(atributoTipo);
		
		Attr atributoPosX = documentoXML.createAttribute("posX");
		atributoPosX.setValue(((Integer) this.getX()).toString());
		nodo.setAttributeNode(atributoPosX);

		Attr atributoPosY = documentoXML.createAttribute("posY");
		atributoPosY.setValue(((Integer) this.getY()).toString());
		nodo.setAttributeNode(atributoPosY);
		
		Attr atributoResistencia = documentoXML.createAttribute("resistencia");
		atributoResistencia.setValue(((Integer) resistencia).toString());
		nodo.setAttributeNode(atributoResistencia);
		
		raiz.appendChild(nodo);
	}

}
