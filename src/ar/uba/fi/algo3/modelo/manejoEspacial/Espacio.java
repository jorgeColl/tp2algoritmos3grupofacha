package ar.uba.fi.algo3.modelo.manejoEspacial;

import ar.uba.fi.algo3.modelo.armamentista.disparo.Disparo;
import ar.uba.fi.algo3.modelo.clasesGeneralizadoras.ObjetoJuego;
import ar.uba.fi.algo3.modelo.excepciones.OcupacionCoincidenteConOtroObjetoJuego;
import ar.uba.fi.algo3.modelo.excepciones.OcupacionInvalidaAlAgregarObjeto;
import ar.uba.fi.algo3.modelo.objetosInanimados.CuartelArgentino;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import ar.uba.fi.algo3.modelo.tanques.TanqueEnemigo;
import ar.uba.fi.algo3.modelo.manejoEspacial.OcupacionCuadrada;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;

import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Modela al lugar fisico donde transcurre la accion del juego.
 * Utiliza el patron Singleton.
 * @author Sami
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
		if (getPotencialesObjetosJuegoEnContactoCon(cuartel).isEmpty())
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
		if (getPotencialesObjetosJuegoEnContactoCon(objeto).isEmpty())
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
		if (getPotencialesObjetosJuegoEnContactoCon(tanque).isEmpty())
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
		if (getPotencialesObjetosJuegoEnContactoCon(tanque).isEmpty())
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
		if (instancia == null)
			instancia = new Espacio();
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
        	vectorAuxiliar = this.getPotencialesObjetosJuegoEnContactoCon(objeto);
        	//COMO EL OBJETO SIEMPRE ESTa EN CONTACTO CON SI MISMO, LO SACAMOS DEL VECTOR.
        	vectorAuxiliar.remove(objeto);
        }
        return vectorAuxiliar;
    }
    
    /**
     * Método utilizado internamente a la hora de agregar una instancia de ObjetoJuego 
     * al espacio. Nos dice si la ocupación de dicho objeto coincide con la de algún 
     * otro ya agregado.
     * @param objeto instancia de la clase ObjetoJuego cuya ocupación queremos analizar 
     * si coincide con la de alguna otra instancia ya agregada al espacio 
     * @return true si la ocupación de objeto coincide con la de algún otro objeto ya 
     * agregado al espacio y false en el caso contrario
     */
    private Vector<ObjetoJuego> getPotencialesObjetosJuegoEnContactoCon(ObjetoJuego objeto) {
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
		if(cuartel != null)
			cuartel.setVivo(false);
		if(tanqueJugador != null)
			tanqueJugador.setVivo(false);
		if(disparos != null){
			Iterator<Disparo> iterator = disparos.iterator();
			while(iterator.hasNext()){
				ObjetoJuego d = (ObjetoJuego)iterator.next();
				d.setVivo(false);
			}
		}
		if(objetosInanimados != null){
			Iterator<ObjetoJuego> iterator = objetosInanimados.iterator();
			while(iterator.hasNext()){
				ObjetoJuego d = (ObjetoJuego)iterator.next();
				d.setVivo(false);
			}
		}
		instancia = new Espacio();
	}
	
	/**
	 * Devuelve verdadero en el caso en el que haya tanques enemigos vivos.
	 */
	public boolean hayTanquesEnemigos(){
		return tanquesEnemigos.size() != 0;
	}
	
	/**
	 * Encuentra al azar una ocupación cuadrada cuyo lado es pasado por parámetro 
	 * que no tiene coincidencia ocupacional con ninguna de las ocupaciones de los 
	 * objetos de este espacio y que se encuentra lo más arriba posible dentro del 
	 * espacio.
	 * @param lado entero correspondiente al lado que queremos que tenga la ocupación 
	 * cuadrada
	 * @return instancia de la clase OcupacionCuadrada que no tiene coincidencia 
	 * ocupacional con ninguna de las ocupaciones de los objetos del espacio
	 */
	public OcupacionCuadrada getOcupacionCuadradaVaciaAlAzarEnBordeSuperior(int lado) {
		int x;
		OcupacionCuadrada ocupacion = new OcupacionCuadrada(new Posicion(0,0),lado);
		Random random = new Random();
		boolean ocupacionEncontrada = false;
		while (!(ocupacionEncontrada)) {
			x = random.nextInt(limiteDerecho-lado+2);
			ocupacion = new OcupacionCuadrada(new Posicion(x,0),lado);
			ocupacionEncontrada = true;
			if (!(cuartel == null)) {
				if (ocupacion.coincidenciaOcupacionalCon(cuartel.getOcupacion()))
					ocupacionEncontrada = false;
			}
			if (ocupacionEncontrada) {
				if (!(tanqueJugador == null)) {
					if (ocupacion.coincidenciaOcupacionalCon(tanqueJugador.getOcupacion()))
						ocupacionEncontrada = false;
				}
				if (ocupacionEncontrada) {
					int contador = 0;
					while ((contador < disparos.size())&&(ocupacionEncontrada)) {
						if (ocupacion.coincidenciaOcupacionalCon(disparos.get(contador).getOcupacion()))
							ocupacionEncontrada = false;
						++contador;
					}
					if (ocupacionEncontrada) {
						contador = 0;
						while ((contador < objetosInanimados.size())&&(ocupacionEncontrada)) {
							if (ocupacion.coincidenciaOcupacionalCon(objetosInanimados.get(contador).getOcupacion()))
								ocupacionEncontrada = false;
							++contador;
						}
						if (ocupacionEncontrada) {
							contador = 0;
							while ((contador < tanquesEnemigos.size())&&(ocupacionEncontrada)) {
								if (ocupacion.coincidenciaOcupacionalCon(tanquesEnemigos.get(contador).getOcupacion()))
									ocupacionEncontrada = false;
								++contador;
							}
						}
					}
				}
			}
		}
		return ocupacion;
	}
	
	/**
	 * Encuentra al azar una ocupacion cuadrada cuyo lado es pasado por parametro que 
	 * no tiene coincidencia ocupacional con ninguna de las ocupaciones de los objetos 
	 * de este espacio.
	 * @param lado entero correspondiente al lado que queremos que tenga la ocupación 
	 * cuadrada
	 * @return instancia de la clase OcupacionCuadrada que no tiene coincidencia 
	 * ocupacional con ninguna de las ocupaciones de los objetos del espacio
	 */
	public OcupacionCuadrada getOcupacionCuadradaVaciaAlAzar(int lado) {
		int x;
		int y;
		OcupacionCuadrada ocupacion = new OcupacionCuadrada(new Posicion(0,0),lado);
		Random random = new Random();
		boolean ocupacionEncontrada = false;
		while (!(ocupacionEncontrada)) {
			x = random.nextInt(limiteDerecho-lado+2);
			y = random.nextInt(limiteInferior-lado+2);
			ocupacion = new OcupacionCuadrada(new Posicion(x,y),lado);
			ocupacionEncontrada = true;
			
			if (!(cuartel == null)) {
				if (ocupacion.coincidenciaOcupacionalCon(cuartel.getOcupacion()))
					ocupacionEncontrada = false;
			}
			if (ocupacionEncontrada) {
				if (!(tanqueJugador == null)) {
					if (ocupacion.coincidenciaOcupacionalCon(tanqueJugador.getOcupacion()))
						ocupacionEncontrada = false;
				}
				if (ocupacionEncontrada) {
					int contador = 0;
					while ((contador < disparos.size())&&(ocupacionEncontrada)) {
						if (ocupacion.coincidenciaOcupacionalCon(disparos.get(contador).getOcupacion()))
							ocupacionEncontrada = false;
						++contador;
					}
					if (ocupacionEncontrada) {
						contador = 0;
						while ((contador < objetosInanimados.size())&&(ocupacionEncontrada)) {
							if (ocupacion.coincidenciaOcupacionalCon(objetosInanimados.get(contador).getOcupacion()))
								ocupacionEncontrada = false;
							++contador;
						}
						if (ocupacionEncontrada) {
							contador = 0;
							while ((contador < tanquesEnemigos.size())&&(ocupacionEncontrada)) {
								if (ocupacion.coincidenciaOcupacionalCon(tanquesEnemigos.get(contador).getOcupacion()))
									ocupacionEncontrada = false;
								++contador;
							}
						}
					}
				}
			}
		}
		return ocupacion;
	}
	
	/**
	 * Delega a los elementos para que se persistan.
	 */
	public void persistir(Document documentoXML, Element raiz){
		Iterator<TanqueEnemigo> iterador1 = tanquesEnemigos.iterator();
		while(iterador1.hasNext()){
			iterador1.next().persistir(documentoXML, raiz);
		}
		
		Iterator<ObjetoJuego> iterador2 = objetosInanimados.iterator();
		while(iterador2.hasNext()){
			iterador2.next().persistir(documentoXML, raiz);
		}
		
		Iterator<Disparo> iterador3 = disparos.iterator();
		while(iterador3.hasNext()){
			iterador3.next().persistir(documentoXML, raiz);
		}
				
		tanqueJugador.persistir(documentoXML, raiz);
		cuartel.persistir(documentoXML, raiz);
	}
	
}
