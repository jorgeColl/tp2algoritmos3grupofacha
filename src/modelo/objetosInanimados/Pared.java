package modelo.objetosInanimados;

import modelo.armamentista.disparo.Disparo;
import modelo.clasesGeneralizadoras.ObjetoJuego;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.OcupacionCuadrada;
import modelo.manejoEspacial.Posicion;
import modelo.tanques.Tanque;

public abstract class Pared extends ObjetoJuego {

	protected int impactosRecibidos;
	protected int impactosTolerados;
	
	/**
	 * Constructor.
	 * @param impactosTolerados cantidad máxima de disparos que puede recibir la pared antes de desaparecer
	 * @param puntoMenorModulo instancia de la clase Posicion con la que se inicializará la ocupación de la pared
	 */
	public Pared(Posicion puntoMenorModulo) {
		impactosRecibidos = 0;
		ocupacion = new OcupacionCuadrada(puntoMenorModulo,5);
		try {
			Espacio.getInstancia().agregarObjetoInanimado(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Se incrementa la cantidad de disparos recibidas. Si esta pasa a ser mayor que la tolerada, la pared desaparece.
	 */
	public void chocarConDisparo(Disparo disparo) {
		++impactosRecibidos;
		if (impactosRecibidos > impactosTolerados)
			desaparecer();
	}

	/**
	 * Cuando un tanque choca a la pared, se le indica a esta que se mueva unitariamente en la dirección contraria dado que el tanque lo obstaculiza.
	 */
	public void chocarConTanque(Tanque tanque) {
		tanque.moverEnDireccionContraria();
	}
	
}
