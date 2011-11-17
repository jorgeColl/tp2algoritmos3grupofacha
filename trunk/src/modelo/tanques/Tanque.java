package modelo.tanques;

import java.util.Vector;

import modelo.armamentista.disparo.Disparo;
import modelo.clasesGeneralizadoras.ObjetoJuego;
import modelo.clasesGeneralizadoras.ObjetoMovil;
import modelo.estrategias.estrategiasDisparo.EstrategiaDisparo;
import modelo.manejoEspacial.Espacio;
import modelo.manejoEspacial.Ocupacion;
import modelo.manejoEspacial.OcupacionCuadrada;
import modelo.manejoEspacial.Orientacion;
import modelo.manejoEspacial.Posicion;

/**
 * Provee el estado y el comportamiento com�n a todos los tanques del juego.
 * @author Tom�s
 *
 */
public abstract class Tanque extends ObjetoMovil {

	protected EstrategiaDisparo estrategiaDisparo;
	protected int resistencia;
	
	/**
	 * Constructor.
	 * @param puntoMenorModulo punto de menor m�dulo de la ocupaci�n del tanque
	 */
	public Tanque(Posicion puntoMenorModulo) {
		ocupacion = new OcupacionCuadrada(puntoMenorModulo,5);
		resistencia = 100;
	}
	
	/**
	 * Cuando un tanque choca con un disparo es da�ado por este. Si su resistencia es menor o igual que 0 entonces desaparece.
	 */
	public void chocarConDisparo(Disparo disparo) {
		resistencia = resistencia - disparo.getDanioNeto();
		resistencia = Math.round(resistencia - (resistencia*(disparo.getDanioPorcentual())/100));
		if (resistencia <= 0)
			desaparecer();
	}
	
	/**
	 * Cuando un tanque choca a este, como este obstaculiza su camino, le indicamos al otro que haga un movimiento unitario en la orientaci�n contraria a la que tiene.
	 */
	public void chocarConTanque(Tanque tanque) {
		tanque.moverEnDireccionContraria();
	}
	
	/**
	 * Delega en la clase Arma.
	 */
	public abstract void disparar();
	
	public boolean estaEnContactoCon(ObjetoJuego objeto) {
		return (objeto.getOcupacion().coincidenciaOcupacionalCon(ocupacion));
	}
	
	/**
	 * 
	 * @return resistencia del tanque
	 */
	public int getResistencia() {
		return resistencia;
	}
	
	
	public void sumarResistencia(int resistenciaASumar){
		resistencia += resistenciaASumar;
	}
	
	/**
	 * En este caso, si la ocupaci�n no es v�lida, significa que un tanque ha tratado de moverse hacia fuera de un l�mite de la pantalla, y por lo tanto no se le setea su nueva ocupaci�n para no permit�rselo.
	 */
	protected void chequearOcupacionValidaYColisiones(Ocupacion ocupacionProvisoria) {
		if ((ocupacionProvisoria.espacialmenteValida())) {
			ocupacion = ocupacionProvisoria;
			Vector<ObjetoJuego> objetos = Espacio.getInstancia().getObjetosJuegoEnContactoCon(this);
			int contador = 0;
			while (contador < objetos.size()) {
				objetos.get(contador).chocarConTanque(this);
				++contador;
			}
		}
	}
	
	/**
	 * Indica al objeto que haga un movimiento unitario en una direcci�n contraria a la que trae.
	 */
	public void moverEnDireccionContraria() {
		if (orientacion == Orientacion.i)
			moverIzquierda();
		else {
			if (orientacion == Orientacion.iNegativo)
				moverDerecha();
			else {
				if (orientacion == Orientacion.j)
					moverAbajo();
				else {
					if (orientacion == Orientacion.jNegativo)
						moverArriba();
				}
			}
		}		
	}
	
}
