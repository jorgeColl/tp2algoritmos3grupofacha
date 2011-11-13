package pruebas;

import junit.framework.TestCase;
import modelo.Espacio;

public class EspacioTest extends TestCase {
	
	public void testSePuedeCrearUnaInstancia() {
		Espacio nuevo = Espacio.obtenerInstancia();
		assertNotNull(nuevo);		
	}
	
	public void testDosInstanciasCreadasSonIguales(){
		Espacio unEspacio = Espacio.obtenerInstancia();
		Espacio otroEspacio = Espacio.obtenerInstancia();
		assertEquals(unEspacio, otroEspacio);
	}
}
