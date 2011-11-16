package modelo.tanques;

import modelo.armamentista.arma.Ametralladora;
import modelo.manejoEspacial.Posicion;

public class GrizzlyBattleTank extends TanqueEnemigo {

	public GrizzlyBattleTank(Posicion puntoMenorModulo) {
		super(puntoMenorModulo);
		arma = new Ametralladora(this);
		puntosPorDestruccion = 20;
		velocidad = 1;
	}

}
