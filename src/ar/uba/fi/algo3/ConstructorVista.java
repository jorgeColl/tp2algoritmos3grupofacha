/**
 * 
 */
package ar.uba.fi.algo3;

import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoAmetralladora;
import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoCanion;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVelocidad;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVida;
import ar.uba.fi.algo3.modelo.objetosInanimados.CuartelArgentino;
import ar.uba.fi.algo3.modelo.objetosInanimados.ParedConcreto;
import ar.uba.fi.algo3.modelo.objetosInanimados.ParedMetal;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.vista.VistaAlgoTank;
import ar.uba.fi.algo3.vista.VistaBonus;
import ar.uba.fi.algo3.vista.VistaCuartelArgentino;
import ar.uba.fi.algo3.vista.VistaDisparoAmetralladora;
import ar.uba.fi.algo3.vista.VistaDisparoCanion;
import ar.uba.fi.algo3.vista.VistaPared;

/**
 * @author jc
 * esta clase va a ayudar a crear a los elementos que esten en el juego
 */
public class ConstructorVista {
	
	private static void auxiliar (Dibujable vista, ObjetoJuego objeto){
		vista.setPosicionable(objeto);
		ControladorJuego.getInstancia().agregarDibujable(vista);
	}
	public static void construirVista(DisparoAmetralladora disparo){
		VistaDisparoAmetralladora vista = new VistaDisparoAmetralladora();
		auxiliar(vista,disparo);
	}
	public static void construirVista(DisparoCanion disparo){
		VistaDisparoCanion vista = new  VistaDisparoCanion();
		auxiliar(vista,disparo);
	}
	public static void construirVista(ParedConcreto pared){
		VistaPared vista = new VistaPared("img/ParedConcreto.JPG");
		auxiliar(vista,pared);
	}
	public static void construirVista(ParedMetal pared){
		VistaPared vista = new VistaPared("img/ParedMetal.JPG");
		auxiliar(vista,pared);
	}
	public static void construirVista(CuartelArgentino cuartel){
		VistaCuartelArgentino vista = new VistaCuartelArgentino();
		auxiliar(vista,cuartel);
	}
	
	public static void construirVista(AlgoTank tanque){
		VistaAlgoTank vista = new VistaAlgoTank();
		auxiliar(vista,tanque);
		ControladorJuego.getInstancia().agregarKeyPressObservador(vista);
	}
	
	public static void construirVista(BonusVelocidad bonus){
		VistaBonus vista = new VistaBonus("img/Bonus.JPG");
		auxiliar(vista,bonus);
	}
	public static void construirVista(BonusVida bonus){
		VistaBonus vista = new VistaBonus("img/BonusVida.JPG");
		auxiliar(vista,bonus);
	}
	
	public static void construirVista(ObjetoJuego objetoJuego) {
		// TODO Auto-generated method stub
		System.out.print("Vista Objeto Pedida Pero No Encontrada");
		
	}
	

	

}
