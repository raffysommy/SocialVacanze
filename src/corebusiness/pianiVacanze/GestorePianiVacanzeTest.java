package corebusiness.pianiVacanze;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import corebusiness.pianiVacanze.exception.PortoNotFound;

public class GestorePianiVacanzeTest {
    static GestorePianiVacanze gestore;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gestore=new GestorePianiVacanze();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		gestore=null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void ricercaVacNull() {
		assertTrue(gestore.ricercaVacanza(null,null).size()==0);
	}
	@Test
	public final void ricercaVacOk() {
		assertFalse(gestore.ricercaVacanza(new java.sql.Date(2013-1900,1-1, 1),new Porto(1,"Ny-Alesund")).size()==0);
	}
	@Test
	public final void ricercaNonPresente(){
		assertTrue(gestore.ricercaVacanza(new java.sql.Date(2012-1900,1-1, 1),new Porto(1,"Ny-Alesund")).size()==0);
	}
	@Test
	public final void listaPortiPresente(){
		assertFalse(gestore.listaPorti().size()==0);
	}
	@Test
	public final void getPortoOk() throws PortoNotFound{
		assertEquals(gestore.getPorto(1),new Porto(1,"Ny-Alesund"));
	}
	@Test
	public final void getPortonotPresent() throws PortoNotFound{
		assertEquals(gestore.getPorto(0),null);
	}

}
