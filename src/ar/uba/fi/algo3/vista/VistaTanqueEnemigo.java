package ar.uba.fi.algo3.vista;

import ar.uba.fi.algo3.titiritero.vista.ImagenDinamica;


public class VistaTanqueEnemigo extends ImagenDinamica{
	
	/* definiciones que se usan para el manejo de imagenes. */

	final static int DERECHA = 1;
	final static int IZQUIERDA = 2;
	final static int ARRIBA = 3;
	final static int ABAJO = 4;
	
	public VistaTanqueEnemigo(){
		super();
		/* carga las imagenes en la clase de ImagenDinamica */
		this.agregarImagen(DERECHA, "img/GrizzlyBattleTank_i.JPG");
		this.agregarImagen(IZQUIERDA, "img/GrizzlyBattleTank_iNegativo.JPG");
		this.agregarImagen(ARRIBA, "img/GrizzlyBattleTank_j.JPG");
		this.agregarImagen(ABAJO, "img/GrizzlyBattleTank_jNegativo.JPG");
		
		/* setea por default que el tanque mire por defecto para arriba */
		this.cambiarAImagen(ARRIBA);
	}
	
	
}
