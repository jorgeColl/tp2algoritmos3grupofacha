package ar.uba.fi.algo3.modelo.tanques;

import java.util.Vector;

import ar.uba.fi.algo3.modelo.armamentista.disparo.Disparo;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoMovil;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoVivo;
import ar.uba.fi.algo3.modelo.estrategias.estrategiasDisparo.EstrategiaDisparo;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Ocupacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Orientacion;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;

/**
 * Provee el estado y el comportamiento común a todos los tanques del juego.
 * @author Tomás
 *
 */
public abstract class Tanque extends ObjetoMovil implements ObjetoVivo {

	protected EstrategiaDisparo estrategiaDisparo;
	protected int resistencia;
	protected int velocidadDisparo;
	
	/**
	 * Constructor.
	 * @param punto instancia de Posicion que servirá de referencia para la inicialización de la ocupación del tanque
	 */
	public Tanque(Posicion punto) {
		ocupacion = new OcupacionCuadrada(punto,5);
		resistencia = 100;
	}
	
	/**
	 * Cuando un tanque choca con un disparo es dañado por este. Si su resistencia es menor o igual que 0 entonces desaparece.
	 */
	public void chocarCon(Disparo disparo) {
		resistencia = resistencia - disparo.getDanioNeto();
		resistencia = (resistencia - (resistencia*(disparo.getDanioPorcentual())/100));
		if (resistencia <= 0)
			desaparecer();
	}
	
	/**
	 * Cuando un tanque choca a este, como este obstaculiza su camino, le indicamos al otro que haga un movimiento unitario en la orientación contraria a la que tiene.
	 */
	public void chocarCon(Tanque tanque) {
		tanque.moverEnDireccionContraria();
	}
	
	/**
	 * Método polimórfico que le indica a los tanque que disparen, independientemente de qué tanque sean.
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
	 * En este caso, si la ocupación no es válida, significa que un tanque ha tratado de moverse hacia fuera de un límite de la pantalla, y por lo tanto no se le setea su nueva ocupación para no permitírselo.
	 */
	protected void chequearOcupacionValidaYColisiones(Ocupacion ocupacionProvisoria) {
		if ((ocupacionProvisoria.espacialmenteValida())) {
			ocupacion = ocupacionProvisoria;
			Vector<ObjetoJuego> objetos = Espacio.getInstancia().getObjetosJuegoEnContactoCon(this);
			int contador = 0;
			while (contador < objetos.size()) {
				objetos.get(contador).chocarCon(this);
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
	 * Indica al objeto que haga un movimiento unitario en una dirección contraria a la que trae.
	 * A pesar de este movimiento la orientación del tanque sigue siendo la que tenía anteriormente, dado que este método se utiliza como un medio para que los tanques no se superpongan a otros objetos.
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

	/**
	 * 
	 * @param incremento entero que sumaremos a la resistencia del tanque
	 */
	public void sumarResistencia(int incremento) {
		resistencia = resistencia + incremento;
	}
	
	/**
	 * 
	 * @param incremento entero que sumaremos a la velocidad del tanque
	 */
	public void sumarVelocidad(int incremento) {
		velocidad = velocidad + incremento;
	}
	
	/**
	 * 
	 * @param incremento entero que sumaremos a la velocidad disparo del tanque
	 */
	public void sumarVelocidadDisparo(int incremento) {
		velocidadDisparo = velocidadDisparo + incremento;
	}
	
}
