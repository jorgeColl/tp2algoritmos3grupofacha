package ar.uba.fi.algo3.modelo.objetosInanimados;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ar.uba.fi.algo3.vista.ConstructorVista;
import ar.uba.fi.algo3.modelo.armamentista.disparo.Disparo;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.Tanque;

/**
 * Modela al cuartel del jugador, el cual al ser destruido hace que este pierda.
 * @author Jorge
 *
 */
public class CuartelArgentino extends ObjetoJuego {

	/**
	 * Constructor
	 * @param punto instancia de la clase Posicion con la que inicializaremos 
	 * la ocupacion del cuartel
	 */
	public CuartelArgentino(Posicion punto) {
		ocupacion = new OcupacionCuadrada(punto,43);
		
		/* agrego la instancia en el Espacio */
		try {
			Espacio.getInstancia().agregarCuartelArgentino(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (Espacio.getInstancia().incluyeA(this)){
			ConstructorVista.construirVista(this);
		}
		/* creo y agrego la vista al ControladorJuego */
			
	}
	
	/**
	 * Al chocar con un disparo automaticamente desaparece.
	 */
	public void chocarCon(Disparo disparo) {
		disparo.desaparecer();
		this.desaparecer();
	}

	/**
	 * Al chocar ser chocado por un tanque, le indica que haga
	 *  un movimiento unitario en la direccion contraria a la 
	 *  que trae para que no se superpongan espacialmente, dado
	 *  que el cuartel bloquea su camino.
	 */
	public void chocarCon(Tanque tanque) {
		tanque.moverEnDireccionContraria();		
	}
	
	public void persistir(Document documentoXML, Element raiz){
		
	}
	
}
