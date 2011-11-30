package ar.uba.fi.algo3.modelo.armamentista.disparo;

import java.util.Vector;

import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoMovil;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Ocupacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.Tanque;

/**
 * Modela un disparo que se mueve por el escenario hasta salir de este o impactar con una instancia de ObjetoJuego, caus�ndole un da�o. 
 * @author Federico
 *
 */
public abstract class Disparo extends ObjetoMovil {
	
	protected int danioNeto;
	protected int danioPorcentual;
	
	/**
	 * Constructor.
	 * @param orientacion versor representante de la direcci�n del disparo
	 * @param punto posici�n de la ocupaci�n del disparo m�s cercana al tanque que lo ha disparado y centrada en la ocupaci�n de este, sobre su eje de movimiento
	 * @see getPosicionPerimetralCentradaEnOrientacion(Orientacion orientacion) en la clase Ocupacion.
	 */
	public Disparo(Orientacion orientacion, Posicion punto) {
		this.orientacion = orientacion;
	}
	
	/**
	 * @see chequearOcupacionValidaYColisiones() en la clase ObjetoMovil.
	 * Si la ocupaci�n no es v�lida, el disparo ha salido de los l�mites de la pantalla y por lo tanto desaparece.
	 */
	protected void chequearOcupacionValidaYColisiones(Ocupacion ocupacionProvisoria) {
		if ((ocupacionProvisoria.espacialmenteValida())) {
			ocupacion = ocupacionProvisoria;
			Vector<ObjetoJuego> objetos = Espacio.getInstancia().getObjetosJuegoEnContactoCon(this);
			int contador = 0;
			while (contador < objetos.size()) {
				objetos.get(contador).chocarCon(this);
				++contador;
			}
		}
		else
			desaparecer();
	}
	
	/**
	 * Cuando dos disparon chocan ambos desaparecen.
	 */
	public void chocarCon(Disparo disparo) {
		desaparecer();
		disparo.desaparecer();
	}
	
	/**
	 * Le indicamos al tanque que ha sido chocado por este disparo, y hacemos que este �ltimo desaparezca.
	 */
	public void chocarCon(Tanque tanque) {
		tanque.chocarCon(this);
		desaparecer();
	}
	
	/**
	 * 
	 * @return atributo danioNeto
	 */
	public int getDanioNeto() {
		return danioNeto;
	}
	
	/**
	 * 
	 * @return atributo danioPorcentual
	 */
	public int getDanioPorcentual() {
		return danioPorcentual;
	}
	
	public void vivir() {
		if (orientacion == Orientacion.i)
			moverDerecha();
		else {
			if (orientacion == Orientacion.iNegativo)
				moverIzquierda();
			else {
				if (orientacion == Orientacion.j)
					moverArriba();
				else {
					moverAbajo();
				}
			}
		}
	}
	
}
