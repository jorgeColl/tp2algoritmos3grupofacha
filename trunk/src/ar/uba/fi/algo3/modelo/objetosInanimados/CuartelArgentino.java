package ar.uba.fi.algo3.modelo.objetosInanimados;

import ar.uba.fi.algo3.modelo.armamentista.disparo.Disparo;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.Tanque;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.vista.VistaCuartelArgentino;

/**
 * Modela al cuartel del jugador, el cual al ser destruido hace que este pierda.
 * @author Jorge
 *
 */
public class CuartelArgentino extends ObjetoJuego {

	/**
	 * Constructor
	 * @param punto instancia de la clase Posicion con la que inicializaremos la ocupaci�n del cuartel
	 */
	public CuartelArgentino(Posicion punto) {
		ocupacion = new OcupacionCuadrada(punto,30);
		
		/* agrego la instancia en el Espacio */
		try {
			Espacio.getInstancia().agregarCuartelArgentino(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/* creo y agrego la vista al ControladorJuego */
		VistaCuartelArgentino vista = new VistaCuartelArgentino();
		vista.setPosicionable(this);
		ControladorJuego.getInstancia().agregarDibujable(vista);	
	}
	
	/**
	 * Al chocar con un disparo autom�ticamente desaparece.
	 */
	public void chocarCon(Disparo disparo) {
		disparo.desaparecer();
		this.desaparecer();
	}

	/**
	 * Al chocar ser chocado por un tanque, le indica que haga un movimiento unitario en la direcci�n contraria a la que trae para que no se superpongan espacialmente, dado que el cuartel bloquea su camino.
	 */
	public void chocarCon(Tanque tanque) {
		tanque.moverEnDireccionContraria();		
	}
	
}
