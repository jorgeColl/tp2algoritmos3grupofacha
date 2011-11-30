/**
 * 
 */
package ar.uba.fi.algo3;


import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoAmetralladora;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.objetosInanimados.CuartelArgentino;
import ar.uba.fi.algo3.modelo.objetosInanimados.ParedConcreto;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVelocidad;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Ventana;
import ar.uba.fi.algo3.vista.VistaAlgoTank;
import ar.uba.fi.algo3.vista.VistaDisparo;
import ar.uba.fi.algo3.vista.VistaPared;
import ar.uba.fi.algo3.vista.VistaBonus;
import ar.uba.fi.algo3.vista.VistaCuartelArgentino;

/**
 * @author Fede
 *
 */
public class CorrerJuego {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* esto no sé que es, pero me lo pide el contructor del 
		ControladorJuego, así que para no harcodearlo lo inicializo
		acá: */
		ControladorJuego controlador = ControladorJuego.getInstancia();
		Ventana ventana = new Ventana(800, 600, controlador);
		ventana.setTitle("AlgoTank");
		
		/* líneas copiadas del ejemplo. */
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);		
		
		/* inicializamos objetos del juego */
		
		AlgoTank algoTank = new AlgoTank(new Posicion(400, 300));
		
		ParedConcreto paredC = new ParedConcreto(new Posicion(200, 100));
		VistaPared vistaPared = new VistaPared();
		
		BonusVelocidad bonusVel = new BonusVelocidad(new Posicion(30, 30));
		VistaBonus vistaBonusVel = new VistaBonus();
		
		CuartelArgentino cuartel = new CuartelArgentino(new Posicion(200, 300));
		
		vistaPared.setPosicionable(paredC);
		vistaBonusVel.setPosicionable(bonusVel);
		
		controlador.agregarDibujable(vistaPared);
		controlador.agregarDibujable(vistaBonusVel);
		
		controlador.setIntervaloSimulacion(50);
		controlador.comenzarJuego();

	}

}
