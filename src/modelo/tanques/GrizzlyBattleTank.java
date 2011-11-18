package modelo.tanques;

import modelo.armamentista.arma.Ametralladora;
import modelo.estrategias.estrategiasMovimiento.AlcanzarObjetivo;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.Posicion;

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
