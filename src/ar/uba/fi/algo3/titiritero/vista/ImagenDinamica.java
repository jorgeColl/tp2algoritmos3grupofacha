/**
 * 
 */
package ar.uba.fi.algo3.titiritero.vista;

import java.util.Hashtable;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Una de las extensiones hechas al Titiritero. Esta es una extensión de
 * la clase Imagen, y permite la carga de varias imagenes para representar
 * a un solo objeto. 
 * @author Fede
 */
public class ImagenDinamica extends Imagen {

	public ImagenDinamica() {
		super();
		imagenes = new Hashtable<Integer, BufferedImage>();
	}
	
	/* agrega cada imagen a un hash, para que la lectura de cada
	 * archivo del disco tenga que hacerse una sola vez y para tener
	 * acceso a las imagenes en tiempo constante.
	 */
	public void agregarImagen(int identificador, String nombreArchivoImagen){
		BufferedImage unaImagen = null;
		try{
			File u = new File(nombreArchivoImagen);
			unaImagen = ImageIO.read(u);
		} catch(Exception ex) {}
		if (unaImagen == null) System.out.println("ERROR: imagen es null.");
		
		imagenes.put(identificador, unaImagen);		
	}
	
	/* cambia la imagen a mostrar. */
	public void cambiarAImagen(int identificador){
		this.imagen = imagenes.get(identificador);	
	}	
	
	private Hashtable<Integer, BufferedImage> imagenes;

}
