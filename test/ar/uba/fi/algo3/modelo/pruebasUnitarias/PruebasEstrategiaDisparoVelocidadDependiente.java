package ar.uba.fi.algo3.modelo.pruebasUnitarias;

import ar.uba.fi.algo3.modelo.armamentista.arma.LanzaCohetes;
import ar.uba.fi.algo3.modelo.estrategias.estrategiasDisparo.EstrategiaDisparoVelocidadDependiente;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.MirageTank;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase EstrategiaDisparoAlgoTank.
 * @author Tomás
 *
 */
public class PruebasEstrategiaDisparoVelocidadDependiente extends TestCase {

	private MirageTank duenio;
	private EstrategiaDisparoVelocidadDependiente estrategia;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
		duenio = new MirageTank(new Posicion(250,250));
		estrategia = new EstrategiaDisparoVelocidadDependiente(duenio);
	}
	
	/**
	 * Chequeo que hasta que no transcurra el tiempo necesario el tanque no dispare.
	 * @throws Exception 
	 */
	public void testTiempoTranscurridoHastaPrimerDisparo() throws Exception {
		assertEquals(((LanzaCohetes)duenio.getArma()).getMunicion(),25);
		estrategia.informarTranscursoTiempo();
		estrategia.decidirDisparo();
		assertEquals(((LanzaCohetes)duenio.getArma()).getMunicion(),25);
		estrategia.informarTranscursoTiempo();
		estrategia.decidirDisparo();
		assertEquals(((LanzaCohetes)duenio.getArma()).getMunicion(),25);
		estrategia.informarTranscursoTiempo();
		estrategia.decidirDisparo();
		assertEquals(((LanzaCohetes)duenio.getArma()).getMunicion(),25);
		estrategia.informarTranscursoTiempo();
		estrategia.decidirDisparo();
		assertEquals(((LanzaCohetes)duenio.getArma()).getMunicion(),25);
		estrategia.informarTranscursoTiempo();
		estrategia.decidirDisparo();
		assertEquals(((LanzaCohetes)duenio.getArma()).getMunicion(),25);
		estrategia.informarTranscursoTiempo();
		estrategia.decidirDisparo();
		assertEquals(((LanzaCohetes)duenio.getArma()).getMunicion(),25);
		estrategia.informarTranscursoTiempo();
		estrategia.decidirDisparo();
		assertEquals(((LanzaCohetes)duenio.getArma()).getMunicion(),25);
		//A PARTIR DE AQUÍ YA PUEDE DISPARAR.
		estrategia.informarTranscursoTiempo();
		estrategia.decidirDisparo();
		assertEquals(((LanzaCohetes)duenio.getArma()).getMunicion(),24);
	}
	
}