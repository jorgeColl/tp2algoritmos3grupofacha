package ar.uba.fi.algo3.modelo.tanques;

import ar.uba.fi.algo3.modelo.armamentista.arma.ArmaMunicionLimitada;
import ar.uba.fi.algo3.modelo.armamentista.arma.LanzaCohetes;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.estrategias.estrategiasMovimiento.AlcanzarObjetivoCentro;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;

public class MirageTank extends TanqueEnemigo {

	public MirageTank(Posicion punto) {
		super(punto);
		arma = new LanzaCohetes(this,25);
		if (!(Espacio.getInstancia().getCuartelArgentino() == null))
			indicarObjetivo(Espacio.getInstancia().getCuartelArgentino());
		puntosPorDestruccion = 50;
		velocidad = 2;
		velocidadDisparo = 12;
	}
	
	public void indicarObjetivo(ObjetoJuego objeto) {
		estrategiaMovimiento = new AlcanzarObjetivoCentro(this,objeto);
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
