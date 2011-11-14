/**
 * 
 */
package modelo;

/**
 * @author jc
 *
 */
public abstract class ObjetoJuego {
	Posicion posicion;
	/**
	 * @return posicion en la que se encuentra
	 */
	public Posicion devolverPosicion(){
		return this.posicion;
	}
}
