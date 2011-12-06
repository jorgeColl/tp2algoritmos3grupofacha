package ar.uba.fi.algo3.modelo.manejoEspacial;

import ar.uba.fi.algo3.modelo.armamentista.disparo.Disparo;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.excepciones.OcupacionCoincidenteConOtroObjetoJuego;
import ar.uba.fi.algo3.modelo.excepciones.OcupacionInvalidaAlAgregarObjeto;
import ar.uba.fi.algo3.modelo.objetosInanimados.CuartelArgentino;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.modelo.tanques.TanqueEnemigo;

import java.util.Iterator;
import java.util.Vector;
/**
 * Modela al lugar fisico donde transcurre la accion del juego.
 * Utiliza el patron Singleton.
 * @author Samanta
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
	 * @param cuartel instancia de la clase CuartelArgentino 
	 * que queremos agregar al espacio
	 * @throws Exception cuando la ocupacion en la que se quiere 
	 * agregar al objeto no es valida o cuando esta coincide con 
	 * la de otro anteriormente agregado
	 * NOTA IMPORTANTE: El cuartel argentino debe agregarse antes 
	 * que los tanques enemigos dado que cuando estos se inicializan 
	 * necesitan a esta para indicarle a su estrategia que es un 
	 * objetivo.
	 */
	public void agregarCuartelArgentino(CuartelArgentino cuartel) throws Exception {
		if (!(cuartel.getOcupacion().espacialmenteValida()))
			throw new OcupacionInvalidaAlAgregarObjeto("Se trato de agregar un cuartel argentino en una posicion invalida.");
		if (getObjetosJuegoEnContactoCon(cuartel).isEmpty())
			this.cuartel = cuartel;
		else
			throw new OcupacionCoincidenteConOtroObjetoJuego("Se trato de agregar un cuartel argentino en una posicion ocupada por otro objeto del juego.");
	}

	/**
	 * Agregamos un disparo a los del escenario.
	 * @param disparo instancia de la clase Disparo 
	 * que queremos agregar a las del escenario
	 */
	public void agregarDisparo(Disparo disparo) {
		if (disparo.getOcupacion().espacialmenteValida())
			disparos.add(disparo);
		Vector<ObjetoJuego> vectorAuxiliar = getObjetosJuegoEnContactoCon(disparo);
		
		Iterator<ObjetoJuego> iterador = vectorAuxiliar.iterator();
		while(iterador.hasNext()){
			iterador.next().chocarCon(disparo);
		}
	}
	
	/**
	 * Agregamos al escenario un objeto de los que no realizan un 
	 * comportamiento especifico mas alla del de estar situados en 
	 * el e interactuar con otros cuando estos segundos entran en 
	 * contacto con ellos.
	 * @param objeto instancia de la clase ObjetoJuego que queremos 
	 * agregar al escenario
	 * @throws Exception cuando la ocupacion en la que se quiere 
	 * agregar al objeto no es valida o cuando esta coincide con la 
	 * de otro anteriormente agregado
	 */
	public void agregarObjetoInanimado(ObjetoJuego objeto) throws Exception {
		if (!(objeto.getOcupacion().espacialmenteValida()))
			throw new Exception("Se trato de agregar un objeto inanimado en una posicion invalida.");
		if (getObjetosJuegoEnContactoCon(objeto).isEmpty())
			objetosInanimados.add(objeto);
		else
			throw new OcupacionCoincidenteConOtroObjetoJuego("Se trato de agregar un objeto inanimado en una posicion ocupada por otro objeto del juego.");
	}
	
	/**
	 * Agrega un tanque enemigo al escenario.
	 * @param tanque instancia de una subclase de TanqueEnemigo 
	 * que queremos agregar al escenario
	 * @throws Exception cuando la ocupacion en la que se quiere 
	 * agregar al objeto no es valida o cuando esta coincide con 
	 * la de otro anteriormente agregado 
	 */
	public void agregarTanqueEnemigo(TanqueEnemigo tanque) throws Exception {
		if (!(tanque.getOcupacion().espacialmenteValida()))
			throw new OcupacionInvalidaAlAgregarObjeto("Se trato de agregar un tanque enemigo en una posicion invalida.");
		if (getObjetosJuegoEnContactoCon(tanque).isEmpty())
			tanquesEnemigos.add(tanque);
		else
			throw new OcupacionCoincidenteConOtroObjetoJuego("Un tanque enemigo que se trato de agregar al escenario tiene una ocupacion que coincide espacialmente con la de otro objeto ya agregado.");
	}
		
	/**
	 * Agregamos el tanque del jugador al escenario.
	 * @param tanque instancia de la clase AlgoTank que queremos 
	 * que corresponda al tanque del jugador
	 * @throws Exception cuando la ocupacion en la que se quiere 
	 * agregar al objeto no es valida o cuando esta coincide con 
	 * la de otro anteriormente agregado
	 * NOTA IMPORTANTE: El tanque del jugador debe agregarse antes 
	 * que los tanques enemigos dado que cuando estos se inicializan 
	 * necesitan a esta para indicarle a su estrategia que es un objetivo. 
	 */
	public void agregarTanqueJugador(AlgoTank tanque) throws Exception {
		if (!(tanque.getOcupacion().espacialmenteValida()))
			throw new OcupacionInvalidaAlAgregarObjeto("El tanque del jugador que se trato de agregar al escenario tiene una ocupacion invalida.");
		if (getObjetosJuegoEnContactoCon(tanque).isEmpty())
			tanqueJugador = tanque;
		else
			throw new OcupacionCoincidenteConOtroObjetoJuego("El tanque del jugador que se trato de agregar al escenario tiene una ocupacion que coincide espacialmente con la de otro.");
	}

	/**
	 * Le indicamos a todos los objetos vivos que ha transcurrido 
	 * una unidad temporal y que por lo tanto vivan.
	 * NOTA IMPORTANTE: Se hace que los disparos se muevan antes 
	 * que los tanques para que no exista la chance de que un tanque 
	 * choque con un disparo que el mismo ha disparado.
	 */
	public void correrLogica() {
		int contador = 0;
        while (contador < disparos.size()) {
            disparos.get(contador).vivir();
            ++contador;
        }
        if (!(tanqueJugador == null)) 
            tanqueJugador.vivir();
        contador = 0;
        while (contador < tanquesEnemigos.size()) {
            if ((!(cuartel == null))&&(!(tanqueJugador == null)))
                tanquesEnemigos.get(contador).vivir();
            else
                break;
            ++contador;
        }	
	}
	
	/**
	 * 
	 * @param objeto instancia de la clase ObjetoJuego cuya referencia, 
	 * en caso de haberla, quitaremos del escenario
	 */
	public void desaparecerA(ObjetoJuego objeto) {
		if (objeto == cuartel)
			cuartel = null;
		if (objeto == tanqueJugador)
			tanqueJugador = null;
		
		disparos.remove(objeto);
		objetosInanimados.remove(objeto);
		tanquesEnemigos.remove(objeto);
	}
	
	/**
	 * 
	 * @param objeto instancia de una subclase de ObjetoJuego que 
	 * queremos ver si esta incluida en el espacio
	 * @return true si el objeto esta incluido en el espacio y false 
	 * en el caso contrario
	 */
	public boolean incluyeA(ObjetoJuego objeto) {
		if (objeto == cuartel)
			return true;
		if (objeto == tanqueJugador)
			return true;
		if(disparos.contains(objeto))
			return true;
		if(objetosInanimados.contains(objeto))
			return true;
		if(tanquesEnemigos.contains(objeto))
			return true;
		return false;
	}
	
	/**
	 * 
	 * @return unica instancia de esta clase
	 */
	public static Espacio getInstancia() {
		if (instancia == null){
			instancia = new Espacio();
			
		}
		return instancia;
	}

	/**
	 * 	
	 * @return mayor entero en el que se puede ubicar parte de la 
	 * ocupacion de un objeto del juego a derecha
	 */
	public int getLimiteDerecho() {
		return limiteDerecho;
	}

	/**
	 * 	
	 * @return mayor entero en el que se puede ubicar parte de la 
	 * ocupacion de un objeto del juego inferiormente
	 */
	public int getLimiteInferior() {
		return limiteInferior;
	}
	
	/**
	 * 
	 * @param objeto instancia de la clase ObjetoJuego con la que 
	 * queremos ver si hay algun objeto en contacto 
	 * @return vector de instancias de la clase ObjetoJuego en 
	 * contacto con la del parametro
	 */
    public Vector<ObjetoJuego> getObjetosJuegoEnContactoCon(ObjetoJuego objeto) {
        Vector<ObjetoJuego> vectorAuxiliar = new Vector<ObjetoJuego>();
        if (incluyeA(objeto)) {
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
                //COMO EL OBJETO SIEMPRE ESTa EN CONTACTO CON SI MISMO, LO SACAMOS DEL VECTOR.
                vectorAuxiliar.remove(objeto);
        }
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
	 * Reinicia el valor de todos los atributos que son instancias 
	 * de la clase Vector.
	 */
	public void reiniciar() {
		instancia = new Espacio();
	}
	
}
