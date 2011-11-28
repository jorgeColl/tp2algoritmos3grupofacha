package ar.uba.fi.algo3.modelo.objetosInanimados;

import ar.uba.fi.algo3.modelo.armamentista.disparo.Disparo;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.Tanque;

/**
 * Modela al cuartel del jugador, el cual al ser destruído hace que este pierda.
 * @author Tomás
 *
 */
public class CuartelArgentino extends ObjetoJuego {

	/**
	 * Constructor
	 * @param punto instancia de la clase Posicion con la que inicializaremos la ocupación del cuartel
	 */
	public CuartelArgentino(Posicion punto) {
		ocupacion = new OcupacionCuadrada(punto,5);
		try {
			Espacio.getInstancia().agregarCuartelArgentino(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Al chocar con un disparo automáticamente desaparece.
	 */
	public void chocarCon(Disparo disparo) {
		this.desaparecer();
	}

	/**
	 * Al chocar ser chocado por un tanque, le indica que haga un movimiento unitario en la dirección contraria a la que trae para que no se superpongan espacialmente, dado que el cuartel bloquea su camino.
	 */
	public void chocarCon(Tanque tanque) {
		tanque.moverEnDireccionContraria();		
	}

}
