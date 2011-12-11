/**
 * 
 */
package ar.uba.fi.algo3.titiritero.vista;

import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.titiritero.Posicionable;

/**
 * @author jc
 * Esta clase es para el uso de las vistas que necesiten un punto que no se mueva
 * y que no participe en el modelo del juego para mostrar desde esa posicion 
 * lo que quiera mostrar.
 */
public class UbicacionParaTexto implements Posicionable {

	protected boolean vivo;
	protected Posicion posicion;
	
	public UbicacionParaTexto(Posicion posicion){
		this.posicion = posicion;
		this.vivo = true;
	}
	@Override
	public int getX() {
		return this.posicion.getX();
	}

	@Override
	public int getY() {
		return this.posicion.getY();
	}

	@Override
	public boolean isVivo() {
		return vivo;
	}

	@Override
	public void setVivo(boolean vivo) {
		this.vivo=vivo;
		
	}

}
