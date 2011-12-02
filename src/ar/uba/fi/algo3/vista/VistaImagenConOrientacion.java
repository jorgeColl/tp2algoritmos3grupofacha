package ar.uba.fi.algo3.vista;

import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoMovil;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.tanques.TanqueEnemigo;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.ImagenDinamica;


public class VistaImagenConOrientacion extends ImagenDinamica{
	
	/* definiciones que se usan para el manejo de imagenes. */

	final static int DERECHA = 1;
	final static int IZQUIERDA = 2;
	final static int ARRIBA = 3;
	final static int ABAJO = 4;
	
	public VistaImagenConOrientacion(String imageni,String imageniNegativo,String imagenj,String imagenjNegativo){
		super();
		/* carga las imagenes en la clase de ImagenDinamica */
		this.agregarImagen(DERECHA, imageni);
		this.agregarImagen(IZQUIERDA, imageniNegativo);
		this.agregarImagen(ARRIBA, imagenj);
		this.agregarImagen(ABAJO, imagenjNegativo);
		
		/* setea por default que el tanque mire por defecto para arriba */
		this.cambiarAImagen(ARRIBA);
	}
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo){
		
		Orientacion orientacion = ((ObjetoMovil)this.posicionable).getOrientacion();
		if(orientacion == Orientacion.i)this.cambiarAImagen(DERECHA);
		if(orientacion == Orientacion.iNegativo)this.cambiarAImagen(IZQUIERDA);
		if(orientacion == Orientacion.j)this.cambiarAImagen(ARRIBA);
		if(orientacion == Orientacion.jNegativo)this.cambiarAImagen(ABAJO);
		
		super.dibujar(superficeDeDibujo);
		
		
		
	}
	
	
}
