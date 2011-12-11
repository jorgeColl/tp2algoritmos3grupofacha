/**
 * 
 */
package ar.uba.fi.algo3;

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
 *
 */
public class Fabricador {

	public Fabricador(){
		super();
	}
	/**
	 * M�todo que agrega cuatro tanques enemigos cuyas clases y posiciones son elegidas al azar.
	 * Los tanques son agregados siempre lo m�s al norte posible del espacio. 
	 */
	public void decidirAgregarTanqueEnemigo() {
		if (Espacio.getInstancia().hayTanquesEnemigos()) return;
		int contador = 0;
		while (contador < 4) {
			int numero = (int)(Math.random()*3);
			OcupacionCuadrada ocupacionAuxiliar = 
					Espacio.getInstancia().getOcupacionCuadradaVaciaAlAzarEnBordeSuperior(43);
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
	 * M�todo que agrega al azar bonus de vida o de velocidad, en posiciones tambi�n al azar. 
	 */
	public void decidirAgregarBonus() {
		int numero = (int)(Math.random()*666);
		OcupacionCuadrada ocupacionAuxiliar = 
				Espacio.getInstancia().getOcupacionCuadradaVaciaAlAzar(43);
		Posicion posicionAuxiliar = 
				new Posicion(ocupacionAuxiliar.getPuntoMenorModulo().getX(),
						     ocupacionAuxiliar.getPuntoMenorModulo().getY());
		switch (numero) {
			case 222: new BonusVida(posicionAuxiliar); break;
			case 444: new BonusVelocidad(posicionAuxiliar); break;
		}
	}
	
}
