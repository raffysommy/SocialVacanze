/**
 * 
 */
package ui;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Raffaele
 *
 */
public class UiUtenteRegistratoTest {
	UIUtenteRegistrato ui=new UIUtenteRegistrato();
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.setIn(System.in);
	}

	@Test
	public final void SelezionePortoErrata() {
		assertEquals(ui.SelezionaPorto(3),null);
	}
	@Test
	public final void ImmettiStringaoptintero() {
		ByteArrayInputStream in = new ByteArrayInputStream("Proviamo con una stringa".getBytes());
		System.setIn(in);
		assertEquals(ui.getFormattedInteger(),null);
	}
	@Test
	public final void Immettiintero() {
		ByteArrayInputStream in = new ByteArrayInputStream("42".getBytes());
		System.setIn(in);
		assertEquals(ui.getFormattedInteger(),new Integer(42));
	}
	@Test
	public final void Immettiinteromax() {
		ByteArrayInputStream in = new ByteArrayInputStream(String.valueOf(Integer.MAX_VALUE).getBytes());
		System.setIn(in);
		assertEquals(ui.getFormattedInteger(),new Integer(Integer.MAX_VALUE));
	}
	@Test
	public final void Immettiinteromin() {
		ByteArrayInputStream in = new ByteArrayInputStream(String.valueOf(Integer.MIN_VALUE).getBytes());
		System.setIn(in);
		assertEquals(ui.getFormattedInteger(),new Integer(Integer.MIN_VALUE));
	}
	@Test
	public final void Immettioltreinteromin() {
		ByteArrayInputStream in = new ByteArrayInputStream("21474836470".getBytes());
		System.setIn(in);
		assertEquals(ui.getFormattedInteger().toString(),"21474836470");
	}
	
	
	@Test
	public final void FormatoDataOk() {
		assertEquals(ui.FormattaData(2013, 1, 1).toString(),"2013-01-01");
	}
	@Test
	public final void DataOutofRange() {
		assertEquals(ui.FormattaData(0, 0, 0),null);
	}
	@Test
	public final void DataOutofRangeforMonth() {
		assertEquals(ui.FormattaData(2013, 2, 31).toString(),"2013-02-31");
	}

}
