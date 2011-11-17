package modelo.tanques;

import modelo.armamentista.arma.LanzaCohetes;
import modelo.estrategias.estrategiasMovimiento.AlcanzarObjetivoCentro;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.Posicion;

public class MirageTank extends TanqueEnemigo {

	public MirageTank(Posicion puntoMenorModulo) {
		super(puntoMenorModulo);
		arma = new LanzaCohetes(this,25);
		estrategiaMovimiento = new AlcanzarObjetivoCentro(this,Espacio.getInstancia().getTanqueJugador());
		puntosPorDestruccion = 50;
		velocidad = 2;
		velocidadDisparo = 12;
	}

}
