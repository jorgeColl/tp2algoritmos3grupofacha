/**
 * 
 */
package ar.uba.fi.algo3;

import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.objetosInanimados.CuartelArgentino;
import ar.uba.fi.algo3.modelo.objetosInanimados.ParedConcreto;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVelocidad;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Ventana;
import ar.uba.fi.algo3.vista.VistaTanque;
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
		boolean activarReproductor = true;
		
		ControladorJuego controlador = new ControladorJuego(activarReproductor);
		Ventana ventana = new Ventana(800, 600, controlador);
		
		/* líneas copiadas del ejemplo. */
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);		
		
		/* inicializamos objetos del juego */
		
		AlgoTank algoTank = new AlgoTank(new Posicion(400,300));
		VistaTanque vistaTanque = new VistaTanque();
		
		ParedConcreto paredC = new ParedConcreto(new Posicion(200,100));
		VistaPared vistaPared = new VistaPared();
		
		BonusVelocidad bonusVel = new BonusVelocidad(new Posicion(30,30));
		VistaBonus vistaBonusVel = new VistaBonus();
		
		CuartelArgentino cuartel = new CuartelArgentino(new Posicion(100,400));
		VistaCuartelArgentino vistaCuartel = new VistaCuartelArgentino();
		
		vistaPared.setPosicionable(paredC);
		vistaTanque.setPosicionable(algoTank);
		vistaBonusVel.setPosicionable(bonusVel);
		vistaCuartel.setPosicionable(cuartel);
		
		controlador.agregarObjetoVivo(algoTank);
		controlador.agregarDibujable(vistaTanque);		
		controlador.agregarDibujable(vistaPared);
		controlador.agregarDibujable(vistaBonusVel);
		controlador.agregarDibujable(vistaCuartel);
		
		controlador.agregarKeyPressObservador(vistaTanque);
		
		controlador.setIntervaloSimulacion(50);
		controlador.comenzarJuego();

	}

}
