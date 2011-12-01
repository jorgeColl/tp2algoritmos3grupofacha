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
import ar.uba.fi.algo3.modelo.tanques.GrizzlyBattleTank;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVelocidad;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Ventana;
import ar.uba.fi.algo3.vista.VistaAlgoTank;
import ar.uba.fi.algo3.vista.VistaDisparo;
import ar.uba.fi.algo3.vista.VistaPared;
import ar.uba.fi.algo3.vista.VistaBonus;
import ar.uba.fi.algo3.vista.VistaCuartelArgentino;
import ar.uba.fi.algo3.vista.VistaTanqueEnemigo;

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
		
		/* esto no s� que es, pero me lo pide el contructor del 
		ControladorJuego, as� que para no harcodearlo lo inicializo
		ac�: */
		ControladorJuego controlador = ControladorJuego.getInstancia();
		Ventana ventana = new Ventana(601, 601, controlador);
		ventana.setTitle("AlgoTank");
		
		/* l�neas copiadas del ejemplo. */
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);		
		
		/* inicializamos objetos del juego */
		
		AlgoTank algoTank = new AlgoTank(new Posicion(400, 300));
		VistaAlgoTank vistaAlgoTank = new VistaAlgoTank();
		
		
		ParedConcreto paredC = new ParedConcreto(new Posicion(200, 100));
		VistaPared vistaPared = new VistaPared();
		
		BonusVelocidad bonusVel = new BonusVelocidad(new Posicion(30, 30));
		VistaBonus vistaBonusVel = new VistaBonus();
		
		CuartelArgentino cuartel = new CuartelArgentino(new Posicion(200, 300));
		VistaCuartelArgentino vistaCuartel = new VistaCuartelArgentino();
		
		
		GrizzlyBattleTank tanque = new GrizzlyBattleTank(new Posicion(300,250));
		VistaTanqueEnemigo vistaTanque = new VistaTanqueEnemigo();
		
		
		
		
		
		
		vistaTanque.setPosicionable(tanque);
		vistaPared.setPosicionable(paredC);
		vistaBonusVel.setPosicionable(bonusVel);
		vistaCuartel.setPosicionable(cuartel);
		vistaAlgoTank.setPosicionable(algoTank);
		
		controlador.agregarDibujable(vistaPared);
		controlador.agregarDibujable(vistaBonusVel);
		controlador.agregarDibujable(vistaTanque);
		ControladorJuego.getInstancia().agregarDibujable(vistaCuartel);
		ControladorJuego.getInstancia().agregarDibujable(vistaAlgoTank);	
		ControladorJuego.getInstancia().agregarKeyPressObservador(vistaAlgoTank);
		
		controlador.setIntervaloSimulacion(50);
		controlador.comenzarJuego();

	}

}
