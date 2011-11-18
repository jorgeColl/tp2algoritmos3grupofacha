package modelo.objetosInanimados;

import modelo.armamentista.disparo.Disparo;
import modelo.clasesGeneralizadoras.ObjetoJuego;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.OcupacionCuadrada;
import modelo.manejoEspacial.Posicion;
import modelo.tanques.Tanque;

/**
 * Modela al cuartel del jugador, el cual al ser destru�do hace que este pierda.
 * @author Tom�s
 *
 */
public class CuartelArgentino extends ObjetoJuego {

	/**
	 * Constructor
	 * @param punto instancia de la clase Posicion con la que inicializaremos la ocupaci�n del cuartel
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
	 * Al chocar con un disparo autom�ticamente desaparece.
	 */
	public void chocarCon(Disparo disparo) {
		this.desaparecer();
	}

	/**
	 * Al chocar ser chocado por un tanque, le indica que haga un movimiento unitario en la direcci�n contraria a la que trae para que no se superpongan espacialmente, dado que el cuartel bloquea su camino.
	 */
	public void chocarCon(Tanque tanque) {
		tanque.moverEnDireccionContraria();		
	}

}
