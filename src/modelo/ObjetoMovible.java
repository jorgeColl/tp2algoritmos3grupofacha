
package modelo;

/**
 * @author jc
 *
 */
public abstract class ObjetoMovible extends ObjetoJuego {
	
	private Orientacion orientacion;
	private int velocidad;
	
	
	public ObjetoMovible (int velocidadRecibida,Posicion posicionRecibida){
		/*por defecto se orienta en i */
		this.orientacion = Orientacion.i;
		this.velocidad = velocidadRecibida;
		this.posicion = posicionRecibida;
		
	}
	
	public Orientacion devolverOrientacion(){
		return this.orientacion;
	}
	
	public void moverEnI(){
		this.orientacion.orientarEni();
		for(int i=0; i<this.velocidad ; i++){
			this.posicion.moverEnI();
		}
	}
	public void moverEnINegativo(){
		this.orientacion.orientarEnINegativo();
		for(int i=0; i<this.velocidad ; i++){
			this.posicion.moverEnINegativo();
		}
	}
	public void moverEnJ(){
		this.orientacion.orientarEnJ();
		for(int i=0; i<this.velocidad ; i++){
			this.posicion.moverEnJ();
		}
	}
	public void moverEnJNegativo(){
		this.orientacion.orientarEnJNegativo();
		for(int i=0; i<this.velocidad ; i++){
			this.posicion.moverEnJNegativo();
		}
	}
	
	
	
}
