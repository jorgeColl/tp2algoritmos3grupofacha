package ar.uba.fi.algo3.vista;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Cuadrado;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

/**
 * Clase que genera la vista de CuartelArgentino.
 * @author Samanta
 *
 */

public class VistaCuartelArgentino extends Cuadrado {
	
	private Imagen imagen;
	
	public VistaCuartelArgentino(){
		super(50,50);
		//setColor(Color.ORANGE);
		imagen = new Imagen();
		imagen.setNombreArchivoImagen("C:\\cuartelArgentino.JPG");
		
		//Este metodo a partir del nombre genera la imagen 
		//y la guarda en un atributo de imagen	
	}
	
	public void dibujar(SuperficieDeDibujo superfice) {
		imagen.setPosicionable(this.getPosicionable());
		imagen.dibujar(superfice);
	}

}
