package ar.uba.fi.algo3.modelo.tanques;

import java.util.Stack;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ar.uba.fi.algo3.ConstructorVista;
import ar.uba.fi.algo3.modelo.armamentista.arma.Ametralladora;
import ar.uba.fi.algo3.modelo.armamentista.arma.ArmaMunicionLimitada;
import ar.uba.fi.algo3.modelo.estrategias.estrategiasDisparo.EstrategiaDisparoAlgoTank;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;

/**
 * Modela al tanque manejado por el jugador.
 * @author Tomas
 *
 */
public class AlgoTank extends Tanque {

	private Ametralladora ametralladora;
	private Stack<ArmaMunicionLimitada> armasPrioritarias;
	private int puntaje;
	
	public AlgoTank(Posicion punto) {
		super(punto);
		ametralladora = new Ametralladora(this);
		armasPrioritarias = new Stack<ArmaMunicionLimitada>();
		estrategiaDisparo = new EstrategiaDisparoAlgoTank(this);
		orientacion = Orientacion.j;
		puntaje = 0;
		velocidad = 2;
		velocidadDisparo = 15;
		
		/* agrego la instancia en el Espacio */
		try {
			Espacio.getInstancia().agregarTanqueJugador(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (Espacio.getInstancia().incluyeA(this)){
			ConstructorVista.construirVista(this);
		}
	}
	
	/**
	 * Le pide a su estrategia de disparo que resuelva el que arma 
	 * disparar, siempre y cuando esto sea temporalmente posible.
	 */
	public void disparar() {
		estrategiaDisparo.decidirDisparo();
	}
	
	/**
	 * Cambiamos el duenio del arma y la agregamos a las del tanque, 
	 * siempre y cuando no tengan municion nula.
	 * @param arma instancia de una subclase de ArmaMunicionLimitada 
	 * que se sumara a las del tanque
	 */
	public void entregarArma(ArmaMunicionLimitada arma) {
		arma.setDuenio(this);
		if (arma.getMunicion() > 0)
			armasPrioritarias.push(arma);
	}

	/**
	 * 
	 * @return instancia de la clase Ametralladora perteneciente al tanque
	 */
	public Ametralladora getAmetralladora() {
		return ametralladora;
	}
	
	/**
	 * 
	 * @return atributo puntaje
	 */
	public int getPuntaje() {
		return puntaje;
	}
	
	/**
	 * 
	 * @return pila de las armas robadas por el tanque, en orden de prioridad
	 */
	public Stack<ArmaMunicionLimitada> getArmasPrioritarias() {
		return armasPrioritarias;
	}
	
	/**
	 * 
	 * @param incremento valor que sumaremos al puntaje del jugador
	 */
	public void incrementarPuntaje(int incremento) {
		puntaje = puntaje + incremento;
	}
	
	public void vivir() {
		estrategiaDisparo.informarTranscursoTiempo();
	}

	public void persistir(Document documentoXML, Element raiz){
		Element nodo = documentoXML.createElement("algoTank");
		
		Attr atributoPosX = documentoXML.createAttribute("posX");
		atributoPosX.setValue(((Integer) this.getX()).toString());
		nodo.setAttributeNode(atributoPosX);

		Attr atributoPosY = documentoXML.createAttribute("posY");
		atributoPosY.setValue(((Integer) this.getY()).toString());
		nodo.setAttributeNode(atributoPosY);
		
		Attr atributoResistencia = documentoXML.createAttribute("resistencia");
		atributoResistencia.setValue(((Integer) resistencia).toString());
		nodo.setAttributeNode(atributoResistencia);
		
		Attr atributoPuntaje = documentoXML.createAttribute("puntaje");
		atributoPuntaje.setValue(((Integer) resistencia).toString());
		nodo.setAttributeNode(atributoPuntaje);
		
		raiz.appendChild(nodo);
	}
	
}
