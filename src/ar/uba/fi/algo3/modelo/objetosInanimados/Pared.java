package ar.uba.fi.algo3.modelo.objetosInanimados;


import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ar.uba.fi.algo3.modelo.armamentista.disparo.Disparo;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.Tanque;

/**
 * Clase abstracta que modela a las paredes del escenario.
 * Llevan una cuenta de los impactos que reciben, dado que resisten 
 * una cantidad limitada de los mismos antes de desaparecer.
 * @author jc
 *
 */
public abstract class Pared extends ObjetoJuego {

	protected int impactosRecibidos;
	protected int impactosTolerados;
	protected String tipo;
	
	/**
	 * Constructor.
	 * @param impactosTolerados cantidad maxima de disparos que puede recibir 
	 * la pared antes de desaparecer
	 * @param punto instancia de la clase Posicion con la que se inicializara 
	 * la ocupacion de la pared
	 */
	public Pared(Posicion punto) {
		impactosRecibidos = 0;
		ocupacion = new OcupacionCuadrada(punto,43);
		
		/* agrego la instancia en el Espacio */
		try {
			Espacio.getInstancia().agregarObjetoInanimado(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Se incrementa la cantidad de disparos recibidas. Si esta pasa a 
	 * ser mayor que la tolerada, la pared desaparece.
	 */
	public void chocarCon(Disparo disparo) {
		
		disparo.desaparecer();
		
		++impactosRecibidos;
		if (impactosRecibidos > impactosTolerados)
			desaparecer();
	}

	/**
	 * Cuando un tanque choca a la pared, se le indica a esta que se mueva 
	 * unitariamente en la direccion contraria dado que lo obstaculiza.
	 */
	public void chocarCon(Tanque tanque) {
		tanque.moverEnDireccionContraria();
	}
	
	/**
	 * Persiste la pared en el documentoXML especificado, bajo la raiz indicada.
	 */
	public void persistir(Document documentoXML, Element raiz){
		Element nodo = documentoXML.createElement("disparo");
		
		Attr atributoTipo = documentoXML.createAttribute("tipo");
		atributoTipo.setValue(tipo);
		nodo.setAttributeNode(atributoTipo);
		
		Attr atributoPosX = documentoXML.createAttribute("posX");
		atributoPosX.setValue(((Integer) this.getX()).toString());
		nodo.setAttributeNode(atributoPosX);

		Attr atributoPosY = documentoXML.createAttribute("posY");
		atributoPosY.setValue(((Integer) this.getY()).toString());
		nodo.setAttributeNode(atributoPosY);
		
		Attr atributoImpactosRecibidos = documentoXML.createAttribute("impactosRecibidos");
		atributoImpactosRecibidos.setValue(((Integer) this.impactosRecibidos).toString());
		nodo.setAttributeNode(atributoImpactosRecibidos);
		
		raiz.appendChild(nodo);
	}
	
	/**
	 * Metodo que le asigna una cantidad de impactos recibidos por el tanque,
	 * utilizado por los metodos relativos con la persistencia.
	 * @param unaCantidad
	 */
	public void setImpactosRecibidos(int unaCantidad){
		impactosRecibidos = unaCantidad;
	}
	
}
