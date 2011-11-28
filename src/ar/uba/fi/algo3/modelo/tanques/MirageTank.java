package ar.uba.fi.algo3.modelo.tanques;

import ar.uba.fi.algo3.modelo.armamentista.arma.LanzaCohetes;
import ar.uba.fi.algo3.modelo.estrategias.estrategiasMovimiento.AlcanzarObjetivoCentro;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;

public class MirageTank extends TanqueEnemigo {

	public MirageTank(Posicion punto) {
		super(punto);
		arma = new LanzaCohetes(this,25);
		estrategiaMovimiento = new AlcanzarObjetivoCentro(this,Espacio.getInstancia().getTanqueJugador());
		puntosPorDestruccion = 50;
		velocidad = 2;
		velocidadDisparo = 12;
	}

	/**
	 * Al comportamiento de la clase ancestro, sumamos el otorgar las armas a la instancia de AlgoTank del espacio.
	 */
	public void desaparecer() {
		super.desaparecer();
		if (!(Espacio.getInstancia().getTanqueJugador() == null))
			Espacio.getInstancia().getTanqueJugador().incrementarMunicionLanzaCohetes(((LanzaCohetes)arma).getMunicion());
	}
	
}
