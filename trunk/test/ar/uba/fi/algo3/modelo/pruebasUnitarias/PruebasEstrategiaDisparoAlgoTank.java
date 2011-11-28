package ar.uba.fi.algo3.modelo.pruebasUnitarias;

import ar.uba.fi.algo3.modelo.armamentista.arma.Canion;
import ar.uba.fi.algo3.modelo.armamentista.arma.LanzaCohetes;
import ar.uba.fi.algo3.modelo.estrategias.estrategiasDisparo.EstrategiaDisparoAlgoTank;
import ar.uba.fi.algo3.modelo.manejoEspacial.Espacio;
import ar.uba.fi.algo3.modelo.manejoEspacial.Posicion;
import ar.uba.fi.algo3.modelo.tanques.AlgoTank;
import junit.framework.TestCase;

/**
 * Llevo a cabo las pruebas unitarias de la clase EstrategiaDisparoAlgoTank.
 * @author Tom�s
 *
 */
public class PruebasEstrategiaDisparoAlgoTank extends TestCase {

	private AlgoTank duenio;
	private EstrategiaDisparoAlgoTank estrategia;
	
	protected void setUp() throws Exception {
		super.setUp();
		Espacio.getInstancia().reiniciar();
		duenio = new AlgoTank(new Posicion(250,250));
		estrategia = new EstrategiaDisparoAlgoTank(duenio);
	}
	
	/**
	 * Otorgo al tanque un LanzaCohetes y chequeo que dispare prioritariamente a esta arma, cuando su velocidad de disparo se lo permita, y que cunado las municiones del arma se acaben que ya no la tenga m�s.
	 */
	public void testDisparoLanzaCohetes() {
		duenio.entregarArma(new LanzaCohetes(duenio,2));
		estrategia.decidirDisparo();
		assertEquals(duenio.getArmasPrioritarias().peek().getMunicion(),2);
		estrategia.informarTranscursoTiempo();
		estrategia.decidirDisparo();
		assertEquals(duenio.getArmasPrioritarias().peek().getMunicion(),2);
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		//A PARTIR DE AQU� YA PODR�A DISPARAR.
		estrategia.decidirDisparo();
		assertEquals(duenio.getArmasPrioritarias().peek().getMunicion(),1);
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		//A PARTIR DE AQU� YA PODR�A DISPARAR.
		estrategia.decidirDisparo();
		assertTrue(duenio.getArmasPrioritarias().isEmpty());
	}
	
	/**
	 * Otorgo al tanque un Canion y chequeo que dispare prioritariamente a esta arma, cuando su velocidad de disparo se lo permita, y que cunado las municiones del arma se acaben que ya no la tenga m�s.
	 */
	public void testDisparoLanzaCanion() {
		duenio.entregarArma(new Canion(duenio,2));
		estrategia.decidirDisparo();
		assertEquals(duenio.getArmasPrioritarias().peek().getMunicion(),2);
		estrategia.informarTranscursoTiempo();
		estrategia.decidirDisparo();
		assertEquals(duenio.getArmasPrioritarias().peek().getMunicion(),2);
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		//A PARTIR DE AQU� YA PODR�A DISPARAR.
		estrategia.decidirDisparo();
		assertEquals(duenio.getArmasPrioritarias().peek().getMunicion(),1);
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		estrategia.informarTranscursoTiempo();
		//A PARTIR DE AQU� YA PODR�A DISPARAR.
		estrategia.decidirDisparo();
		assertTrue(duenio.getArmasPrioritarias().isEmpty());
	}
	
}
