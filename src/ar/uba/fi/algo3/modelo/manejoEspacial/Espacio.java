package ar.uba.fi.algo3.modelo.manejoEspacial;

import ar.uba.fi.algo3.modelo.armamentista.disparo.Disparo;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.excepciones.OcupacionInvalidaAlAgregarObjeto;
import ar.uba.fi.algo3.modelo.objetosInanimados.CuartelArgentino;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.modelo.tanques.TanqueEnemigo;
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

	private CuartelArgentino cuartel;
	private Vector<Disparo> disparos;
	private Vector<ObjetoJuego> objetosInanimados;
	private Vector<TanqueEnemigo> tanquesEnemigos;
	private AlgoTank tanqueJugador;
			
	/**
	 * Constructor privado.
	 */
	private Espacio() {
		cuartel = null;
		disparos = new Vector<Disparo>();
		objetosInanimados = new Vector<ObjetoJuego>();
		tanqueJugador = null;
		tanquesEnemigos = new Vector<TanqueEnemigo>();
		limiteDerecho = 601;
		limiteInferior = 601;
	}
	
	/**
	 * 
	 * @param cuartel instancia de la clase CuartelArgentino que queremos agregar al espacio
	 * @throws OcupacionInvalidaAlAgregarObjeto cuando la ocupación en la que se quiere agregar al objeto no es válida o cuando esta coincide con la de otro anteriormente agregado
	 * NOTA IMPORTANTE: El cuartel argentino debe agregarse antes que los tanques enemigos dado que cuando estos se inicializan necesitan a esta para indicarle a su estrategia que es un objetivo.
	 */
	public void agregarCuartelArgentino(CuartelArgentino cuartel) throws OcupacionInvalidaAlAgregarObjeto {
		if (!(cuartel.getOcupacion().espacialmenteValida()))
			throw new OcupacionInvalidaAlAgregarObjeto("Se trató de agregar un cuartel argentino en una posición inválida.");
		if ((getObjetosJuegoEnContactoCon(cuartel)).size() == 0)
			this.cuartel = cuartel;
		else
			throw new OcupacionInvalidaAlAgregarObjeto("Se trató de agregar un cuartel argentino en una posición ocupada por otro objeto del juego.");
	}

	/**
	 * Agregamos un disparo a los del escenario.
	 * @param disparo instancia de la clase Disparo que queremos agregar a las del escenario
	 */
	public void agregarDisparo(Disparo disparo) {
		Vector<ObjetoJuego> vectorAuxiliar = getObjetosJuegoEnContactoCon(disparo);
		if (vectorAuxiliar.size() > 0) {
			int contador = 0;
			while (contador < vectorAuxiliar.size()) {
				vectorAuxiliar.get(contador).chocarCon(disparo);
				++contador;
			}
		}
		if (disparo.getOcupacion().espacialmenteValida())
			disparos.add(disparo);
	}
	
	/**
	 * Agregamos al escenario un objeto de los que no realizan un comportamiento específico más allá del de estar situados en él e interactuar con otros cuando estos segundos entran en contacto con ellos.
	 * @param objeto instancia de la clase ObjetoJuego que queremos agregar al escenario
	 * @throws OcupacionInvalidaAlAgregarObjeto cuando la ocupación en la que se quiere agregar al objeto no es válida o cuando esta coincide con la de otro anteriormente agregado
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
	 * @throws OcupacionInvalidaAlAgregarObjeto cuando la ocupación en la que se quiere agregar al objeto no es válida o cuando esta coincide con la de otro anteriormente agregado 
	 */
	public void agregarTanqueEnemigo(TanqueEnemigo tanque) throws OcupacionInvalidaAlAgregarObjeto {
		if (!(tanque.getOcupacion().espacialmenteValida()))
			throw new OcupacionInvalidaAlAgregarObjeto("Se trató de agregar un tanque enemigo en una posición inválida.");
		if ((getObjetosJuegoEnContactoCon(tanque)).size() == 0)
			tanquesEnemigos.add(tanque);
		else
			throw new OcupacionInvalidaAlAgregarObjeto("Un tanque enemigo que se trató de agregar al escenario tiene una ocupación que coincide espacialmente con la de otro objeto ya agregado.");
	}
		
	/**
	 * Agregamos el tanque del jugador al escenario.
	 * @param tanque instancia de la clase AlgoTank que queremos que corresponda al tanque del jugador
	 * @throws OcupacionInvalidaAlAgregarObjeto cuando la ocupación en la que se quiere agregar al objeto no es válida o cuando esta coincide con la de otro anteriormente agregado
	 * NOTA IMPORTANTE: El tanque del jugador debe agregarse antes que los tanques enemigos dado que cuando estos se inicializan necesitan a esta para indicarle a su estrategia que es un objetivo. 
	 */
	public void agregarTanqueJugador(AlgoTank tanque) throws OcupacionInvalidaAlAgregarObjeto {
		if (!(tanque.getOcupacion().espacialmenteValida()))
			throw new OcupacionInvalidaAlAgregarObjeto("El tanque del jugador que se trató de agregar al escenario tiene una ocupación inválida.");
		if ((getObjetosJuegoEnContactoCon(tanque)).size() == 0)
			tanqueJugador = tanque;
		else
			throw new OcupacionInvalidaAlAgregarObjeto("El tanque del jugador que se trató de agregar al escenario tiene una ocupación que coincide espacialmente con la de otro.");
	}

	/**
	 * Le indicamos a todos los objetos vivos que ha transcurrido una unidad temporal y que por lo tanto vivan.
	 * NOTA IMPORTANTE: Se hace que los disparos se muevan antes que los tanques para que no exista la chance de que un tanque choque con un disparo que el mismo ha disparado.
	 */
	public void correrLogica() {
		int contador = 0;
		while (contador < disparos.size()) {
			disparos.get(contador).vivir();
			++contador;
		}
		contador = 0;
		tanqueJugador.vivir();
		while (contador < tanquesEnemigos.size()) {
			tanquesEnemigos.get(contador).vivir();
			++contador;
		}
	}
	
	/**
	 * 
	 * @param objeto instancia de la clase ObjetoJuego cuya referencia, en caso de haberla, quitaremos del escenario
	 */
	public void desaparecerA(ObjetoJuego objeto) {
		if (objeto == cuartel)
			cuartel = null;
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
		if (objeto == cuartel)
			return true;
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
		if (!(cuartel == null)) {
			if (objeto.estaEnContactoCon(cuartel))
				vectorAuxiliar.add(cuartel);
		}
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
	 * @return cuartel perteneciente al jugador
	 */
	public CuartelArgentino getCuartelArgentino() {
		return cuartel;
	}
	
	/**
	 * 
	 * @return tanque del jugador
	 */
	public AlgoTank getTanqueJugador() {
		return tanqueJugador;
	}
	
	/**
	 * Cuando el cuartel argentino es destruído, entonces se perdió el juego.
	 * @return true si se perdió el juego y false en el caso contrario
	 */
	public boolean juegoPerdido() {
		return (cuartel == null);
	}
	
	/**
	 * Reinicia el valor de todos los atributos que son instancias de la clase Vector.
	 */
	public void reiniciar() {
		instancia = new Espacio();
	}
	
}
