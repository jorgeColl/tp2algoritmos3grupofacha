package ar.uba.fi.algo3.modelo.tanques;

import ar.uba.fi.algo3.ConstructorVista;
import ar.uba.fi.algo3.modelo.armamentista.arma.ArmaMunicionLimitada;
import ar.uba.fi.algo3.modelo.armamentista.arma.Canion;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.estrategias.estrategiasMovimiento.AlcanzarObjetivoBordes;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;

public class IFV extends TanqueEnemigo {

	public IFV(Posicion punto) {
		super(punto);
		arma = new Canion(this,25);
		if (!(Espacio.getInstancia().getCuartelArgentino() == null))
			indicarObjetivo(Espacio.getInstancia().getCuartelArgentino());
		puntosPorDestruccion = 30;
		velocidad = 3;
		velocidadDisparo = 8;
		tipo = "ifv";
		
		if (Espacio.getInstancia().incluyeA(this)){
			ConstructorVista.construirVista(this);
		}
	}
	
	public void indicarObjetivo(ObjetoJuego objeto) {
		estrategiaMovimiento = new AlcanzarObjetivoBordes(this,objeto);
	}
	
	/**
	 * Al comportamiento de la clase ancestro, sumamos el otorgar las armas a la instancia de AlgoTank del espacio.
	 * Es casteo es type-safe porque el arma es siempre una instancia de Canion.
	 */
	public void desaparecer() {
		super.desaparecer();
		if (!(Espacio.getInstancia().getTanqueJugador() == null))
			Espacio.getInstancia().getTanqueJugador().entregarArma((ArmaMunicionLimitada)arma);
	}
	
}