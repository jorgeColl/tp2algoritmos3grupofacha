/**
 * 
 */
package ar.uba.fi.algo3;

import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoAmetralladora;
import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoCanion;
import ar.uba.fi.algo3.modelo.armamentista.disparo.DisparoLanzaCohetes;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVelocidad;
import ar.uba.fi.algo3.modelo.objetosInanimados.BonusVida;
import ar.uba.fi.algo3.modelo.objetosInanimados.CuartelArgentino;
import ar.uba.fi.algo3.modelo.objetosInanimados.ParedConcreto;
import ar.uba.fi.algo3.modelo.objetosInanimados.ParedMetal;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.modelo.tanques.GrizzlyBattleTank;
import ar.uba.fi.algo3.modelo.tanques.IFV;
import ar.uba.fi.algo3.modelo.tanques.MirageTank;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.vista.VistaAlgoTank;
import ar.uba.fi.algo3.vista.VistaBonus;
import ar.uba.fi.algo3.vista.VistaCuartelArgentino;
import ar.uba.fi.algo3.vista.VistaDeFinDeJuego;
import ar.uba.fi.algo3.vista.VistaDisparoAmetralladora;
import ar.uba.fi.algo3.vista.VistaDisparoCanion;
import ar.uba.fi.algo3.vista.VistaDisparoLanzaCohetes;
import ar.uba.fi.algo3.vista.VistaParaImagen;
import ar.uba.fi.algo3.vista.VistaImagenConOrientacion;

/**
 * @author jc
 * esta clase va a ayudar a crear a las vistas de los elementos que esten en el juego y 
 * quieran ser visualizados
 */
public class ConstructorVista {
	
	//solo evita dos lineas de repeticion de codigo
	private static void auxiliar (Dibujable vista, ObjetoJuego objeto){
		vista.setPosicionable(objeto);
		ControladorJuego.getInstancia().agregarDibujable(vista);
	}
	public static void construirVista(DisparoAmetralladora disparo){
		VistaDisparoAmetralladora vista = new VistaDisparoAmetralladora();
		auxiliar(vista,disparo);
	}
	public static void construirVista(DisparoCanion disparo){
		VistaImagenConOrientacion vista = new  VistaImagenConOrientacion(
				"img/DisparoCanion_i.JPG","img/DisparoCanion_iNegativo.JPG",
				"img/DisparoCanion_j.JPG","img/DisparoCanion_jNegativo.JPG");
		auxiliar(vista,disparo);
	}
	public static void construirVista(DisparoLanzaCohetes disparo){
		VistaImagenConOrientacion vista = new  VistaImagenConOrientacion(
				"img/DisparoLanzaCohetes_i.JPG","img/DisparoLanzaCohetes_iNegativo.JPG",
				"img/DisparoLanzaCohetes_j.JPG","img/DisparoLanzaCohetes_jNegativo.JPG");
		auxiliar(vista,disparo);
	}
	public static void construirVista(ParedConcreto pared){
		VistaParaImagen vista = new VistaParaImagen("img/ParedConcreto.JPG");
		auxiliar(vista,pared);
	}
	public static void construirVista(ParedMetal pared){
		VistaParaImagen vista = new VistaParaImagen("img/ParedMetal.JPG");
		auxiliar(vista,pared);
	}
	public static void construirVista(CuartelArgentino cuartel){
		VistaParaImagen vista = new VistaParaImagen("img/cuartelArgentino.GIF");
		auxiliar(vista,cuartel);
		
		VistaDeFinDeJuego.getInstancia().agregarElementoQueProvocaPerderElJuego(cuartel);
	}
	
	public static void construirVista(AlgoTank tanque){
		VistaAlgoTank vista = new VistaAlgoTank();
		auxiliar(vista,tanque);
		ControladorJuego.getInstancia().agregarKeyPressObservador(vista);
		
		VistaDeFinDeJuego.getInstancia().agregarElementoQueProvocaPerderElJuego(tanque);
		ControladorJuego.getInstancia().agregarDibujable(VistaDeFinDeJuego.getInstancia());
	}
	
	public static void construirVista(BonusVelocidad bonus){
		VistaBonus vista = new VistaBonus("img/Bonus.JPG");
		auxiliar(vista,bonus);
	}
	public static void construirVista(BonusVida bonus){
		VistaBonus vista = new VistaBonus("img/BonusVida.JPG");
		auxiliar(vista,bonus);
	}
	
	public static void construirVista(GrizzlyBattleTank tanque){
		VistaImagenConOrientacion vista = new VistaImagenConOrientacion(
				"img/GrizzlyBattleTank_i.JPG","img/GrizzlyBattleTank_iNegativo.JPG",
				"img/GrizzlyBattleTank_j.JPG", "img/GrizzlyBattleTank_jNegativo.JPG");
		auxiliar(vista,tanque);
	}
	
	public static void construirVista(IFV tanque){
		VistaImagenConOrientacion vista = new VistaImagenConOrientacion(
				"img/IFV_i.JPG","img/IFV_iNegativo.JPG",
				"img/IFV_j.JPG", "img/IFV_jNegativo.JPG");
		auxiliar(vista,tanque);
	}
	public static void construirVista(MirageTank tanque){
		VistaImagenConOrientacion vista = new VistaImagenConOrientacion(
				"img/MirageTank_i.JPG","img/MirageTank_iNegativo.JPG",
				"img/MirageTank_j.JPG", "img/MirageTank_jNegativo.JPG");
		auxiliar(vista,tanque);
	}
	
	
	public static void construirVista(ObjetoJuego objetoJuego) {
		// TODO Auto-generated method stub
		System.out.print("Vista Objeto Pedida Pero No Encontrada");
		
	}
	

	

}
