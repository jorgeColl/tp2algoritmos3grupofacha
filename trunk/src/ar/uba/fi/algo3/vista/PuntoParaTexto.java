/**
 * 
 */
package ar.uba.fi.algo3.vista;

import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.titiritero.Posicionable;

/**
 * @author jc
 * Esta clase es para el uso de las vistas que necesiten un punto que no se mueva
 * y que no participe en el modelo del juego para mostrar desde esa posicion 
 * lo que quiera mostrar.
 */
public class PuntoParaTexto implements Posicionable {

	protected boolean vivo;
	protected Posicion posicion;
	
	public PuntoParaTexto(Posicion posicion){
		this.posicion=posicion;
	}
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.posicion.getX();
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.posicion.getY();
	}

	@Override
	public boolean isVivo() {
		// TODO Auto-generated method stub
		return vivo;
	}

	@Override
	public void setVivo(boolean vivo) {
		// TODO Auto-generated method stub
		this.vivo=vivo;
		
	}

}
