/**
 * 
 */
package ar.uba.fi.algo3;


import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVida;
import ar.uba.fi.algo3.modelo.objetosInanimados.CuartelArgentino;
import ar.uba.fi.algo3.modelo.objetosInanimados.ParedConcreto;
import ar.uba.fi.algo3.modelo.objetosInanimados.ParedMetal;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.modelo.tanques.GrizzlyBattleTank;
import ar.uba.fi.algo3.modelo.tanques.IFV;
import ar.uba.fi.algo3.modelo.tanques.MirageTank;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVelocidad;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

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
		ParedConcreto paredC = new ParedConcreto(new Posicion(200, 100));
		ParedMetal paredMetal = new ParedMetal(new Posicion(200, 150));

		BonusVelocidad bonusVel = new BonusVelocidad(new Posicion(30, 30));
		BonusVida bonusVida = new BonusVida(new Posicion(66, 66));
		
		CuartelArgentino cuartel = new CuartelArgentino(new Posicion(200, 300));
		
		GrizzlyBattleTank tanque = new GrizzlyBattleTank(new Posicion(300,240));
		MirageTank tanque2 = new MirageTank(new Posicion(300,550));
		IFV tanque3 =  new IFV(new Posicion(300,430));
		controlador.setIntervaloSimulacion(50);
		controlador.comenzarJuego();

	}

}
