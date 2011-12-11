/**
 * 
 */
package ar.uba.fi.algo3.controlador;

import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVelocidad;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVida;
import ar.uba.fi.algo3.modelo.tanques.GrizzlyBattleTank;
import ar.uba.fi.algo3.modelo.tanques.IFV;
import ar.uba.fi.algo3.modelo.tanques.MirageTank;

/**
 * @author jc
 * Clase para fabricar tanques enemigos y bonuses durante el desarrollo del juego.
 */
public class Fabricador {
	
	final static int ALTO_TANQUE = 43;

	public Fabricador(){
		super();
	}
	
	/**
	 * Metodo que agrega cuatro tanques enemigos cuyas clases y posiciones son elegidas al azar.
	 * Los tanques son agregados siempre lo mas al norte posible del espacio. 
	 */
	public void decidirAgregarTanqueEnemigo() {
		if (Espacio.getInstancia().hayTanquesEnemigos()) return;
		int contador = 0;
		while (contador < 4) {
			int numero = (int)(Math.random()*3);
			OcupacionCuadrada ocupacionAuxiliar = 
					Espacio.getInstancia().getOcupacionCuadradaVaciaAlAzarEnBordeSuperior(ALTO_TANQUE);
			Posicion posicionAuxiliar = 
					new Posicion(ocupacionAuxiliar.getPuntoMenorModulo().getX(),
							     ocupacionAuxiliar.getPuntoMenorModulo().getY());
			switch (numero) {
				case 0: new GrizzlyBattleTank(posicionAuxiliar); break;
				case 1: new IFV(posicionAuxiliar); break;
				case 2: new MirageTank(posicionAuxiliar); break;
			}
			++contador;
		}	
	}
	
	/**
	 * Metodo que agrega al azar bonus de vida o de velocidad, en posiciones tambien al azar. 
	 */
	public void decidirAgregarBonus() {
		int numero = (int)(Math.random()*666);
		OcupacionCuadrada ocupacionAuxiliar = 
				Espacio.getInstancia().getOcupacionCuadradaVaciaAlAzar(ALTO_TANQUE);
		Posicion posicionAuxiliar = 
				new Posicion(ocupacionAuxiliar.getPuntoMenorModulo().getX(),
						     ocupacionAuxiliar.getPuntoMenorModulo().getY());
		switch (numero) {
			case 222: new BonusVida(posicionAuxiliar); break;
			case 444: new BonusVelocidad(posicionAuxiliar); break;
		}
	}
	
}
