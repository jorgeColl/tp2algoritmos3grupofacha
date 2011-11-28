package ar.uba.fi.algo3.modelo.tanques;

import ar.uba.fi.algo3.modelo.armamentista.arma.Ametralladora;
import ar.uba.fi.algo3.modelo.estrategias.estrategiasMovimiento.AlcanzarObjetivo;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;

public class GrizzlyBattleTank extends TanqueEnemigo {

	public GrizzlyBattleTank(Posicion punto) {
		super(punto);
		arma = new Ametralladora(this);
		estrategiaMovimiento = new AlcanzarObjetivo(this,Espacio.getInstancia().getTanqueJugador());
		puntosPorDestruccion = 20;
		velocidad = 1;
		velocidadDisparo = 4;
	}

}
