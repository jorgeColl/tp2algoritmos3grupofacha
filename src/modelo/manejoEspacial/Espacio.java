package modelo.manejoEspacial;

import modelo.armamentista.disparo.Disparo;
import modelo.clasesGeneralizadoras.ObjetoJuego;
import modelo.tanques.AlgoTank;
import modelo.tanques.TanqueEnemigo;
import java.util.Vector;

/**
 * Modela al lugar físico donde transcurre la acción del juego.
 * Utiliza el patrón Singleton.
 * @author Tomás
 *
 */
public class Espacio {

	private static Espacio instancia;
	
	private int limiteDerecho;
	private int limiteInferior;
	
	private Vector<Disparo> disparos;
	private Vector<ObjetoJuego> objetosInanimados;
	private Vector<TanqueEnemigo> tanquesEnemigos;
	private AlgoTank tanqueJugador;
			
	/**
	 * Constructor privado.
	 */
	private Espacio() {
		disparos = new Vector<Disparo>();
		objetosInanimados = new Vector<ObjetoJuego>();
		tanqueJugador = null;
		tanquesEnemigos = new Vector<TanqueEnemigo>();
		limiteDerecho = 601;
		limiteInferior = 601;
	}

	/**
	 * Agregamos un disparo a los del escenario.
	 * @param disparo instancia de la clase Disparo que queremos agregar a las del escenario
	 */
	public void agregarDisparo(Disparo disparo) {
		if (getObjetosJuegoEnContactoCon(disparo).size() > 0) {
			int contador = 0;
			while (contador < disparos.size()) {
				disparos.get(contador).chocarConDisparo(disparo);
				++contador;
			}
		}
		if (disparo.getOcupacion().espacialmenteValida())
			disparos.add(disparo);
	}
	
	/**
	 * Agregamos al escenario un objeto de los que no realizan un comportamiento específico más allá del de estar situados en él e interactuar con otros cuando estos segundos entran en contacto con ellos.
	 * @param objeto instancia de la clase ObjetoJuego que queremos agregar al escenario
	 * @throws Exception cuando la ocupación en la que se quiere agregar al objeto no es válida o cuando esta coincide con la de otro anteriormente agregado
	 */
	public void agregarObjetoInanimado(ObjetoJuego objeto) throws Exception {
		if (!(objeto.getOcupacion().espacialmenteValida()))
			throw new Exception("Se trató de agregar un objeto inanimado en una posición inválida.");
		if ((getObjetosJuegoEnContactoCon(objeto)).size() == 0)
			objetosInanimados.add(objeto);
		else
			throw new Exception("Se trató de agregar un objeto inanimado en una posición ocupada por otro objeto del juego.");
	}
	
	/**
	 * Agrega un tanque enemigo al escenario.
	 * @param tanque instancia de una subclase de TanqueEnemigo que queremos agregar al escenario
	 * @throws Exception cuando la ocupación en la que se quiere agregar al objeto no es válida o cuando esta coincide con la de otro anteriormente agregado 
	 */
	public void agregarTanqueEnemigo(TanqueEnemigo tanque) throws Exception {
		if (!(tanque.getOcupacion().espacialmenteValida()))
			throw new Exception("Se trató de agregar un tanque enemigo en una posición inválida.");
		if ((getObjetosJuegoEnContactoCon(tanque)).size() == 0)
			tanquesEnemigos.add(tanque);
		else
			throw new Exception("Un tanque enemigo que se trató de agregar al escenario tiene una ocupación que coincide espacialmente con la de otro objeto ya agregado.");
	}
		
	/**
	 * Agregamos el tanque del jugador al escenario.
	 * @param tanque instancia de la clase AlgoTank que queremos que corresponda al tanque del jugador
	 * @throws Exception cuando la ocupación en la que se quiere agregar al objeto no es válida o cuando esta coincide con la de otro anteriormente agregado 
	 */
	public void agregarTanqueJugador(AlgoTank tanque) throws Exception {
		if (!(tanque.getOcupacion().espacialmenteValida()))
			throw new Exception("El tanque del jugador que se trató de agregar al escenario tiene una ocupación inválida.");
		if ((getObjetosJuegoEnContactoCon(tanque)).size() == 0)
			tanqueJugador = tanque;
		else
			throw new Exception("El tanque del jugador que se trató de agregar al escenario tiene una ocupación que coincide espacialmente con la de otro.");
	}

	
	public void correrLogica() {
		
	}
	
	/**
	 * 
	 * @param objeto instancia de la clase ObjetoJuego cuya referencia, en caso de haberla, quitaremos del escenario
	 */
	public void desaparecerA(ObjetoJuego objeto) {
		if (objeto == tanqueJugador)
			tanqueJugador = null;
		int contador = 0;
		while (contador < disparos.size()) {
			if (objeto == disparos.get(contador))
				disparos.remove(contador);
			++contador;
		}
		contador = 0;
		while (contador < objetosInanimados.size()) {
			if (objeto == objetosInanimados.get(contador))
				objetosInanimados.remove(contador);
			++contador;
		}
		contador = 0;
		while (contador < tanquesEnemigos.size()) {
			if (objeto == tanquesEnemigos.get(contador))
				tanquesEnemigos.remove(contador);
			++contador;
		}
	}
	
	/**
	 * 
	 * @param objeto instancia de una subclase de ObjetoJuego que queremos ver si está incluída en el espacio
	 * @return true si el objeto está incluído en el espacio y false en el caso contrario
	 */
	public boolean incluyeA(ObjetoJuego objeto) {
		if (objeto == tanqueJugador)
			return true;
		int contador = 0;
		while (contador < disparos.size()) {
			if (objeto == disparos.get(contador))
				return true;
			++contador;
		}
		contador = 0;
		while (contador < objetosInanimados.size()) {
			if (objeto == objetosInanimados.get(contador))
				return true;
			++contador;
		}
		contador = 0;
		while (contador < tanquesEnemigos.size()) {
			if (objeto == tanquesEnemigos.get(contador))
				return true;
			++contador;
		}
		return false;
	}
	
	/**
	 * 
	 * @return única instancia de esta clase
	 */
	public static Espacio getInstancia() {
		if (instancia == null)
			instancia = new Espacio();
		return instancia;
	}

	/**
	 * 	
	 * @return mayor entero en el que se puede ubicar parte de la ocupación de un objeto del juego a derecha
	 */
	public int getLimiteDerecho() {
		return limiteDerecho;
	}

	/**
	 * 	
	 * @return mayor entero en el que se puede ubicar parte de la ocupación de un objeto del juego inferiormente
	 */
	public int getLimiteInferior() {
		return limiteInferior;
	}
	
	/**
	 * 
	 * @param objeto instancia de la clase ObjetoJuego con la que queremos ver si hay algún objeto en contacto 
	 * @return vector de instancias de la clase ObjetoJuego en contacto con la del parámetro
	 */
	public Vector<ObjetoJuego> getObjetosJuegoEnContactoCon(ObjetoJuego objeto) {
		Vector<ObjetoJuego> vectorAuxiliar = new Vector<ObjetoJuego>();
		if (!(tanqueJugador == null)) {
			if (objeto.estaEnContactoCon(tanqueJugador))
				vectorAuxiliar.add(tanqueJugador);
		}
		int contador = 0;
		while (contador < disparos.size()) {
			if (objeto.estaEnContactoCon(disparos.get(contador)))
				vectorAuxiliar.add(disparos.get(contador));
			++contador;
		}
		contador = 0;
		while (contador < objetosInanimados.size()) {
			if (objeto.estaEnContactoCon(objetosInanimados.get(contador)))
				vectorAuxiliar.add(objetosInanimados.get(contador));
			++contador;
		}
		contador = 0;
		while (contador < tanquesEnemigos.size()) {
			if (objeto.estaEnContactoCon(tanquesEnemigos.get(contador)))
				vectorAuxiliar.add(tanquesEnemigos.get(contador));
			++contador;
		}
		//COMO EL OBJETO SIEMPRE ESTÁ EN CONTACTO CON SI MISMO, LO SACAMOS DEL VECTOR.
		vectorAuxiliar.remove(objeto);
		return vectorAuxiliar;
	}
	
	/**
	 * 
	 * @return tanque del jugador
	 */
	public AlgoTank getTanqueJugador() {
		return tanqueJugador;
	}
	
	/**
	 * Reinicia el valor de todos los atributos que son instancias de la clase Vector.
	 */
	public void reiniciar() {
		instancia = new Espacio();
	}
	
}
