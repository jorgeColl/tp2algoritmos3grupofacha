package modelo.tanques;

import java.util.Vector;

import modelo.armamentista.disparo.Disparo;
import modelo.clasesGeneralizadoras.ObjetoJuego;
import modelo.clasesGeneralizadoras.ObjetoMovil;
import modelo.clasesGeneralizadoras.ObjetoVivo;
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
public abstract class Tanque extends ObjetoMovil implements ObjetoVivo {

	protected EstrategiaDisparo estrategiaDisparo;
	protected int resistencia;
	protected int velocidadDisparo;
	
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
		resistencia = (resistencia - (resistencia*(disparo.getDanioPorcentual())/100) - 1);
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
	
	/**
	 * 
	 * @return resistencia del tanque
	 */
	public int getResistencia() {
		return resistencia;
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
	 * 
	 * @return velocidad de disparo del tanque
	 */
	public int getVelocidadDisparo() {
		return velocidadDisparo;
	}
	
	/**
	 * Indica al objeto que haga un movimiento unitario en una direcci�n contraria a la que trae.
	 * A pesar de este movimiento la orientaci�n del tanque sigue siendo la que ten�a anteriormente, dado que este m�todo se utiliza como un medio para que los tanques no se superpongan a otros objetos.
	 */
	public void moverEnDireccionContraria() {
		if (orientacion == Orientacion.i) {
			Ocupacion ocupacionProvisoria = ocupacion.getOcupacionMovidaIzquierda();
			chequearOcupacionValidaYColisiones(ocupacionProvisoria);
		}
		else {
			if (orientacion == Orientacion.iNegativo){
				Ocupacion ocupacionProvisoria = ocupacion.getOcupacionMovidaDerecha();
				chequearOcupacionValidaYColisiones(ocupacionProvisoria);
			}
			else {
				if (orientacion == Orientacion.j){
					Ocupacion ocupacionProvisoria = ocupacion.getOcupacionMovidaAbajo();
					chequearOcupacionValidaYColisiones(ocupacionProvisoria);
				}
				else {
					if (orientacion == Orientacion.jNegativo){
						Ocupacion ocupacionProvisoria = ocupacion.getOcupacionMovidaArriba();
						chequearOcupacionValidaYColisiones(ocupacionProvisoria);
					}
				}
			}
		}		
	}

	public void sumarResistencia(int resistencia) {
		this.resistencia += resistencia;
		
	}

	public void sumarVelocidad(double velocidad) {
		this.velocidad += velocidad;
		
	}

	public void sumarVelocidadDisparo(double velocidadDeDisparo) {
		this.velocidadDisparo += velocidadDeDisparo;
		
	}
	
}
